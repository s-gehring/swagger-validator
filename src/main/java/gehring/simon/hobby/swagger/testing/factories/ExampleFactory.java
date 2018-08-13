/*
 *
 */

package gehring.simon.hobby.swagger.testing.factories;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import gehring.simon.hobby.swagger.model.v3.Example;
import gehring.simon.hobby.swagger.model.v3.Parameter;
import gehring.simon.hobby.swagger.model.v3.Schema;
import gehring.simon.hobby.swagger.testing.MalformedSwaggerYamlException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * A factory for creating Example objects.
 */
public class ExampleFactory implements Factory {

    private static final long   serialVersionUID = -145772584605093390L;
    private static final Logger LOGGER           = LogManager
            .getLogger(ExampleFactory.class.toString());

    private enum Type {
        INT64("int64"), INT32("int32"), INTEGER("integer"), INT("int"), STRING("string"), LONG(
                "long"), BOOLEAN(
                        "boolean"), NULL(
                                "null"), OBJECT("object"), ARRAY("array"), NUMBER(
                                        "number"), DOUBLE("double"), FLOAT("float");

        private String name;

        Type(final String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name;
        }

    }

    private GlobalSettings settings;

    public ExampleFactory() {
        this(GlobalSettings.getDefaultSettings());

    }

    public ExampleFactory(final GlobalSettings settings) {
        this.settings = settings;
    }

    public String buildCustomExample(final Parameter para) {
        /*
         * Either schema or content is set. Not both.
         */
        if (para.getSchema() == null && para.getContent() == null)
            throw new MalformedSwaggerYamlException("Parameter '" + para.getName()
                    + "' with description '"
                    + para.getDescription() + "' has neither a schema nor a content definition.");

        if (para.getContent() != null && para.getSchema() != null)
            throw new MalformedSwaggerYamlException(
                    "Parameter '" + para.getName() + "' with description '"
                            + para.getDescription()
                            + "' has a schema and a content definition. Cannot have both.");

        if (para.getSchema() != null) {
            return buildCustomStringifiedExampleBySchema(para.getSchema());
        } else {
            // para.getContent != null
        }
        return null;
    }

    protected Object buildCustomExampleBySchema(final Schema schema) {
        // object, array, string, number, boolean, or null
        final String TYPE = schema.getType();
        final String FORMAT = schema.getFormat();
        if (TYPE == null) {
            throw new MalformedSwaggerYamlException("Can't handle null type in schema.");
        }
        if (TYPE.equals(Type.STRING.toString()))
            return settings.getStringFactory().buildCustomExampleStringBySchema(schema);
        if (TYPE.equals(Type.BOOLEAN.toString()))
            return settings.getBooleanFactory().buildCustomExampleBooleanBySchema(schema);
        if (TYPE.equals(Type.NULL.toString()))
            return null;
        if (TYPE.equals(Type.OBJECT.toString()))
            return settings.getObjectFactory().buildCustomExampleObjectBySchema(schema);
        if (TYPE.equals(Type.ARRAY.toString()))
            throw new UnsupportedOperationException("Not implemented yet");
        if (TYPE.equals(Type.NUMBER.toString())) {
            if (schema.getFormat() == null) {
                LOGGER.warn("Found type '" + schema.getType()
                        + "', without a format attribute. Assuming 'double'. If possible, you should try to define a proper format.");
                return settings.getFloatFactory().buildCustomExampleDoubleBySchema(schema);
            }

            if (FORMAT.equals(Type.INT32.toString()) || FORMAT.equals(Type.INTEGER.toString())
                    || FORMAT.equals(Type.INT.toString()))
                return settings.getIntegerFactory().buildCustomExampleIntegerBySchema(schema);
            if (FORMAT.equals(Type.INT64.toString()) || FORMAT.equals(Type.LONG.toString()))
                return settings.getIntegerFactory().buildCustomExampleLongBySchema(schema);
            if (FORMAT.equals(Type.DOUBLE.toString()))
                return settings.getFloatFactory().buildCustomExampleDoubleBySchema(schema);
            if (FORMAT.equals(Type.FLOAT.toString())) {
                return settings.getFloatFactory().buildCustomExampleFloatBySchema(schema);
            }

            LOGGER.warn("Found type '" + schema.getType() + "', but don't understand format '"
                    + schema.getFormat()
                    + "'. Assuming 'double'.");
            return settings.getFloatFactory().buildCustomExampleDoubleBySchema(schema);
        }
        if (TYPE.equals(Type.INTEGER.toString())) {

            LOGGER.warn(
                    "Using type 'integer', which is not specified in JSON but fine by OpenAPI 3.0.");
            LOGGER.warn(
                    "Compare 'https://swagger.io/specification/#dataTypeFormat' to 'http://json-schema.org/' (and in extension 'http://json-schema.org/latest/json-schema-core.html#rfc.section.4.2.1').");

            if (FORMAT.equals(Type.INT.toString()) || FORMAT.equals(Type.INT32.toString())
                    || FORMAT.equals(Type.INTEGER.toString()))
                return settings.getIntegerFactory().buildCustomExampleIntegerBySchema(schema);
            if (FORMAT.equals(Type.INT64.toString()) || FORMAT.equals(Type.LONG.toString()))
                return settings.getIntegerFactory().buildCustomExampleLongBySchema(schema);

            throw new MalformedSwaggerYamlException(
                    "Got format '" + schema.getFormat() + "' for type '"
                            + schema.getType() + "'. Don't know how to handle this.");

        }
        throw new MalformedSwaggerYamlException("Don't know how to handle type '" + TYPE + "'.");

    }

    public String buildCustomStringifiedExampleBySchema(final Schema schema) {
        return buildCustomExampleBySchema(schema).toString();
    }

    /**
     * Builds the example from example.
     *
     * @param paraExample
     *            the para example
     * @return the string
     */
    public String buildExampleFromExample(final Example paraExample) {

        // TODO: global variable?
        final ObjectMapper m = new ObjectMapper();
        try {
            return m.writeValueAsString(paraExample);
        } catch (final JsonProcessingException e) {
            throw new RuntimeException("Failed to process example into JSON.", e);
        }
    }

    /**
     * Gets the example object.
     *
     * @param parameter
     *            the parameter
     * @return the example object
     */
    // TODO: Evtl. mehrere examples benutzen?
    public String getExampleObject(final Parameter parameter) {
        if (parameter.getExample() == null) {
            if (parameter.getExamples() == null || parameter.getExamples().isEmpty()) {
                return buildCustomExample(parameter);
            }
            return buildExampleFromExample(parameter.getExamples().values().iterator().next());
        }
        return buildExampleFromExample(parameter.getExample());
    }

    @Override
    public String getFactoryDescription() {
        return "The main example factory that delegates the example creation to the more specific factories.";
    }

}
