package gehring.simon.hobby.swagger.testing.factories;

import java.util.Map;
import java.util.logging.Logger;

import gehring.simon.hobby.swagger.model.v3.Schema;
import gehring.simon.hobby.swagger.model.v3.SchemaOrBoolean;
import gehring.simon.hobby.swagger.testing.GlobalSettings;
import gehring.simon.hobby.swagger.testing.MalformedSwaggerYamlException;

public class ObjectFactory {
	private final GlobalSettings settings;
	@SuppressWarnings("unused")
	private static final Logger LOGGER = Logger.getLogger(ObjectFactory.class.toString());

	protected ObjectFactory(GlobalSettings settings) {
		this.settings = settings;
	}

	protected JsonObject buildCustomExampleObjectBySchema(Schema schema) {
		JsonObject result = new JsonObject();

		int min = schema.getMinProperties() != null ? schema.getMinProperties() : 0;

		Map<String, Schema> properties = schema.getProperties();
		// First, fill required properties.
		if (schema.getRequired() != null) {
			for (String reqPropertyKey : schema.getRequired()) {
				Schema reqPropertySchema = properties.get(reqPropertyKey);
				if (reqPropertySchema == null) {
					throw new MalformedSwaggerYamlException(
							"Property '" + reqPropertyKey + "' required, but not provided in schema.");
				}
				try {
					result.put(reqPropertyKey, buildCustomExampleBySchema(reqPropertySchema));
				} catch (MalformedSwaggerYamlException e) {
					throw new MalformedSwaggerYamlException("Error in property '" + reqPropertyKey + "'.", e);
				}
			}
			if (min > 0 && min < schema.getRequired().size()) {
				LOGGER.warning("Minimum number of properties (" + min
						+ ") is redundant, because the 'required'-array already contains " + schema.getRequired().size()
						+ " attributes.");
			}
		}

		// Todo: Some more properties. Not additional ones and not required ones. Just
		// defined ones.

		SchemaOrBoolean additionalProperties = schema.getAdditionalProperties();
		if (additionalProperties != null) {
			if (additionalProperties.getType() == SchemaOrBoolean.Type.Boolean) {
				Boolean areAdditionalPropertiesAllowed = additionalProperties.getBoolean();
				if (areAdditionalPropertiesAllowed) {
					// Nice, we can fill the remaining needed properties.
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
}
