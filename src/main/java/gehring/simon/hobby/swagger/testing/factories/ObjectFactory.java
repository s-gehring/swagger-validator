package gehring.simon.hobby.swagger.testing.factories;

import gehring.simon.hobby.swagger.model.v3.Schema;
import gehring.simon.hobby.swagger.model.v3.SchemaOrBoolean;
import gehring.simon.hobby.swagger.testing.MalformedSwaggerYamlException;

import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ObjectFactory implements Factory {

    private static final long    serialVersionUID = -2723536975186903895L;
    private static final Logger  LOGGER           = LogManager
            .getLogger(ObjectFactory.class.toString());
    private final GlobalSettings settings;

    protected ObjectFactory(final GlobalSettings settings) {
        this.settings = settings;
    }

    protected JsonObject buildCustomExampleObjectBySchema(final Schema schema) {
        JsonObject result = new JsonObject();

        int min = schema.getMinProperties() != null ? schema.getMinProperties() : 0;

        Map<String, Schema> properties = schema.getProperties();
        // First, fill required properties.
        if (schema.getRequired() != null) {
            for (String reqPropertyKey : schema.getRequired()) {
                Schema reqPropertySchema = properties.get(reqPropertyKey);
                if (reqPropertySchema == null) {
                    throw new MalformedSwaggerYamlException(
                            "Property '" + reqPropertyKey
                                    + "' required, but not provided in schema.");
                }
                try {
                    result.put(reqPropertyKey,
                            settings.getExampleFactory()
                                    .buildCustomExampleBySchema(reqPropertySchema));
                } catch (MalformedSwaggerYamlException e) {
                    throw new MalformedSwaggerYamlException(
                            "Error in property '" + reqPropertyKey + "'.", e);
                }
            }
            if (min > 0 && min < schema.getRequired().size()) {
                LOGGER.warn("Minimum number of properties (" + min
                        + ") is redundant, because the 'required'-array already contains "
                        + schema.getRequired().size()
                        + " attributes.");
            }
        }

        // TODO: Some more properties. Not additional ones and not required ones. Just
        // defined ones.

        SchemaOrBoolean additionalProperties = schema.getAdditionalProperties();
        if (additionalProperties != null) {
            if (additionalProperties.getType() == SchemaOrBoolean.Type.BOOLEAN) {
                Boolean areAdditionalPropertiesAllowed = additionalProperties.getBoolean();
                if (areAdditionalPropertiesAllowed) {
                    // Nice, we can fill the remaining needed properties.
                    for (int i = properties.size(); i < min; ++i) {
                        AdditionalProperty nextProperty = settings.getAdditionalPropertyFactory()
                                .produceAdditionalProperty(schema);
                        result.put(nextProperty.getKey(), nextProperty.getValue());
                    }

                } else {
                    // Fuck. At this point this doesn't make a difference, but once we have less
                    // than min properties, we need to inform the user of his error.
                }
            } else {
                // additionalProperties.getType() == SchemaOrBoolean.Type.Schema
            }
        }

        return result;
    }

    @Override
    public String getFactoryDescription() {
        return "A factory creating example JSON objects. This will most likely recursively call itself or other factories.";
    }
}
