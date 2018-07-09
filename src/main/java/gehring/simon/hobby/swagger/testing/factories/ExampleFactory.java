/*
 *
 */

package gehring.simon.hobby.swagger.testing.factories;

import java.util.logging.Logger;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import gehring.simon.hobby.swagger.model.v3.Example;
import gehring.simon.hobby.swagger.model.v3.Parameter;
import gehring.simon.hobby.swagger.model.v3.Schema;
import gehring.simon.hobby.swagger.testing.MalformedSwaggerYamlException;

/**
 * A factory for creating Example objects.
 */
public class ExampleFactory extends Factory {

	private static final Logger LOGGER = Logger.getLogger(ExampleFactory.class.toString());

	private GlobalSettings settings;

	public ExampleFactory() {
		this(GlobalSettings.getDefaultSettings());
	}

	public ExampleFactory(GlobalSettings settings) {
		this.settings = settings;
	}

	public String buildCustomExample(final Parameter para) {
		/*
		 * Either schema or content is set. Not both.
		 */
		if (para.getSchema() == null && para.getContent() == null)
			throw new MalformedSwaggerYamlException("Parameter '" + para.getName() + "' with description '"
					+ para.getDescription() + "' has neither a schema nor a content definition.");

		if (para.getContent() != null && para.getSchema() != null)
			throw new MalformedSwaggerYamlException("Parameter '" + para.getName() + "' with description '"
					+ para.getDescription() + "' has a schema and a content definition. Cannot have both.");

		if (para.getSchema() != null) {
			return buildCustomStringifiedExampleBySchema(para.getSchema());
		} else {
			// para.getContent != null
		}
		return null;
	}

	protected Object buildCustomExampleBySchema(Schema schema) {
		// object, array, string, number, boolean, or null
		switch (schema.getType()) {
		case "string":
			return settings.getStringFactory().buildCustomExampleStringBySchema(schema);
		case "boolean":
			return settings.getBooleanFactory().buildCustomExampleBooleanBySchema(schema);
		case "null":
			return null;
		case "object":
			return settings.getObjectFactory().buildCustomExampleObjectBySchema(schema);

		case "array":
			throw new UnsupportedOperationException("Not implemented yet");
		case "number":
			if (schema.getFormat() == null) {
				LOGGER.warning("Found type '" + schema.getType()
						+ "', without a format attribute. Assuming 'double'. If possible, you should try to define a proper format.");
				return settings.getFloatFactory().buildCustomExampleDoubleBySchema(schema);
			}
			switch (schema.getFormat()) {
			case "int32":
			case "integer":
			case "int":
				return settings.getIntegerFactory().buildCustomExampleIntegerBySchema(schema);
			case "int64":
			case "long":
				return settings.getIntegerFactory().buildCustomExampleLongBySchema(schema);
			default:
				LOGGER.warning("Found type '" + schema.getType() + "', but don't understand format '"
						+ schema.getFormat() + "'. Assuming 'double'.");
			case "double":
				return settings.getFloatFactory().buildCustomExampleDoubleBySchema(schema);
			case "float":
				return settings.getFloatFactory().buildCustomExampleFloatBySchema(schema);
			}
		case "integer":
			LOGGER.warning("Using type 'integer', which is not specified in JSON but fine by OpenAPI 3.0.");
			LOGGER.warning(
					"Compare 'https://swagger.io/specification/#dataTypeFormat' to 'http://json-schema.org/' (and in extension 'http://json-schema.org/latest/json-schema-core.html#rfc.section.4.2.1').");
			String format = schema.getFormat();
			if (format == null) {
				format = "int32";
			}
			switch (format) {
			case "int32":
			case "integer":
			case "int":
				return settings.getIntegerFactory().buildCustomExampleIntegerBySchema(schema);
			case "int64":
			case "long":
				return settings.getIntegerFactory().buildCustomExampleLongBySchema(schema);
			default:
				throw new MalformedSwaggerYamlException("Got format '" + schema.getFormat() + "' for type '"
						+ schema.getType() + "'. Don't know how to handle this.");
			}

		}
		throw new MalformedSwaggerYamlException("Don't recognize type '" + schema.getType() + "' in a given schema.");
	}

	public String buildCustomStringifiedExampleBySchema(Schema schema) {
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
			throw new RuntimeException(e);
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

}
