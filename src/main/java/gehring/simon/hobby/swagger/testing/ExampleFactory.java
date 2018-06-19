/*
 *
 */

package gehring.simon.hobby.swagger.testing;

import java.util.Random;
import java.util.logging.Logger;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import gehring.simon.hobby.swagger.model.v3.Example;
import gehring.simon.hobby.swagger.model.v3.Parameter;
import gehring.simon.hobby.swagger.model.v3.Schema;

// TODO: Auto-generated Javadoc
/**
 * A factory for creating Example objects.
 */
public class ExampleFactory {

	private static final Logger LOGGER = Logger.getLogger(ExampleFactory.class.toString());
	private Random random;

	private String buildCustomExampleStringBySchema(Schema schema) {
		// TODO: implement this
		return null;
	}

	private String buildCustomExampleNumberBySchema(Schema schema) {
		// TODO: implement this
		return "0";
	}

	private Long nextLong(Long range) {
		if (range <= 0)
			throw new IllegalArgumentException("Range must be positive");

		Integer firstDigits = random.nextInt();
		Integer lastDigits = random.nextInt();

		String bitString = Integer.toBinaryString(firstDigits) + Integer.toBinaryString(lastDigits);

		Long result = Long.parseLong(bitString.substring(1), 2);
		if (firstDigits < 0)
			result = -result;

		return result % range;
	}

	private String buildCustomExampleIntegerBySchema(Schema schema) {
		Long minimum;
		if (schema.getMinimum() == null) {
			if (schema.getFormat() != null) {
				switch (schema.getFormat()) {
				case "int32":
					minimum = new Long(Integer.MIN_VALUE);
					break;
				case "int64":
					minimum = Long.MIN_VALUE;
					break;

				default:
					throw new MalformedSwaggerYamlException(
							"Got format '" + schema.getFormat() + "' for type integer. Don't know how to handle this.");
				}
			} else {
				LOGGER.warning("Have to guess a minimum limit for schema '" + schema.toString()
						+ "'. I'd rather have a valid minimum or at least a proper format.");
				minimum = new Long(Integer.MIN_VALUE);
			}
		} else {
			minimum = schema.getMinimum();
		}

		Long maximum;
		if (schema.getMaximum() == null) {
			if (schema.getFormat() != null) {
				switch (schema.getFormat()) {
				case "int32":
					maximum = new Long(Integer.MAX_VALUE);
					break;
				case "int64":
					maximum = Long.MAX_VALUE;
					break;
				default:
					throw new MalformedSwaggerYamlException(
							"Got format '" + schema.getFormat() + "' for type integer. Don't know how to handle this.");
				}
			} else {
				LOGGER.warning("Have to guess a maximum limit for schema '" + schema.toString()
						+ "'. I'd rather have a valid maximum or at least a proper format.");
				maximum = new Long(Integer.MAX_VALUE);
			}

		} else {
			maximum = schema.getMaximum();
		}

		if (schema.getExclusiveMinimum() != null && schema.getExclusiveMinimum() == true) {
			minimum++;
		}
		if (schema.getExclusiveMaximum() != null && schema.getExclusiveMaximum() == false) {
			maximum++;
		}

		// TODO: multipleOf
		long range = maximum - minimum;
		return "" + (nextLong(range) + minimum);
	}

	private String buildCustomExampleNullBySchema(Schema schema) {
		return "null";
	}

	private String buildCustomExampleBooleanBySchema(Schema schema) {
		return "true";
	}

	public String buildCustomExampleBySchema(Schema schema) {
		// object, array, string, number, boolean, or null
		switch (schema.getType()) {
		case "string":
			return buildCustomExampleStringBySchema(schema);
		case "number":
			return buildCustomExampleNumberBySchema(schema);
		case "boolean":
			return buildCustomExampleBooleanBySchema(schema);
		case "null":
			// lol
			return buildCustomExampleNullBySchema(schema);
		case "object":
			throw new UnsupportedOperationException("Not implemented yet");
		case "array":
			throw new UnsupportedOperationException("Not implemented yet");
		case "integer":
			LOGGER.warning(
					"Using type 'integer', which is not specified in JSON but fine by OpenAPI 3.0. Use type=number in combination with the format argument instead.");
			LOGGER.warning(
					"Compare 'https://swagger.io/specification/#dataTypeFormat' to 'http://json-schema.org/' (and in extension 'http://json-schema.org/latest/json-schema-core.html#rfc.section.4.2.1').");
			return buildCustomExampleIntegerBySchema(schema);
		}
		throw new MalformedSwaggerYamlException("Don't recognize type '" + schema.getType() + "' in a given schema.");
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
			return buildCustomExampleBySchema(para.getSchema());
		} else {
			// para.getContent != null
		}
		return null;
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
			if (parameter.getExample() == null || parameter.getExamples().isEmpty()) {
				return buildCustomExample(parameter);
			}
			return buildExampleFromExample(parameter.getExamples().values().iterator().next());
		}
		return buildExampleFromExample(parameter.getExample());
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

	public ExampleFactory() {
		Random seedGenerator = new Random();
		long seed = seedGenerator.nextLong();
		LOGGER.info("No seed specified. Using randomly chosen '" + seed + "'.");
		random = new Random(seed);
	}

	public ExampleFactory(Random r) {
		random = r;
	}

	public ExampleFactory(Long seed) {
		random = new Random(seed);
	}

}
