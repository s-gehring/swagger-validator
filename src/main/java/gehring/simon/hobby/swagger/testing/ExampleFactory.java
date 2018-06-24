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
import gehring.simon.hobby.swagger.testing.generator.NumberGenerator;
import gehring.simon.hobby.swagger.testing.generator.RandomNumberGenerator;

/**
 * A factory for creating Example objects.
 */
public class ExampleFactory {

	private static final Logger LOGGER = Logger.getLogger(ExampleFactory.class.toString());
	private NumberGenerator generator;

	private String buildCustomExampleStringBySchema(Schema schema) {
		// TODO: implement this
		return null;
	}

	/*
	 * Given schema.getMaximum(), .getMinimum() (and .getExclusiveMaximum() and
	 * -Minimum()), and schema.multipleOf(), this function decides what the real
	 * minimum factor is (i. e. the first integer(!) X for which .multipleOf() * X >
	 * getMinimum() (or >= for inclusive minimums)).
	 */
	private long getMinFactor(Schema schema, double min, double max) {
		Double minFactorFraction = min / schema.getMultipleOf();
		minFactorFraction = Math.ceil(minFactorFraction);
		return minFactorFraction.longValue();
	}

	private long getMaxFactor(Schema schema, double min, double max) {
		Double maxFactorFraction = max / schema.getMultipleOf();
		maxFactorFraction = Math.floor(maxFactorFraction);
		return maxFactorFraction.longValue();
	}

	private Float buildCustomExampleFloatBySchema(Schema schema) {
		if (schema.getMultipleOf() != null) {
			float min = Float.MIN_VALUE, max = Float.MAX_VALUE;
			if (schema.getMinimum() != null)
				min = schema.getMinimum().floatValue();
			if (schema.getMaximum() != null)
				max = schema.getMaximum().floatValue();
			if (schema.getExclusiveMaximum() != null && schema.getExclusiveMaximum() == false)
				max += Math.ulp(max);
			if (schema.getExclusiveMinimum() != null && schema.getExclusiveMinimum() == true)
				min += Math.ulp(min);
			long resultFactor;
			long minFactor = getMinFactor(schema, min, max);
			long maxFactor = getMaxFactor(schema, min, max);
			if (minFactor == maxFactor) {
				LOGGER.warning(
						"The combination of min=" + min + ", max=" + max + ", multipleOf=" + schema.getMultipleOf()
								+ " leaves only one possible answer=" + (minFactor * schema.getMultipleOf()) + ".");
				resultFactor = minFactor;
			} else {
				resultFactor = generator.nextLong(minFactor, maxFactor + 1);
			}
			Double doubleResult = schema.getMultipleOf() * resultFactor;
			return doubleResult.floatValue();

		}
		Float min = schema.getMinimum() == null ? Float.MIN_VALUE : schema.getMinimum().floatValue();
		Float max = schema.getMaximum() == null ? Float.MAX_VALUE : schema.getMaximum().floatValue();

		return generator.nextFloat(min, max);
	}

	private Double buildCustomExampleDoubleBySchema(Schema schema) {
		if (schema.getMultipleOf() != null) {
			double min = Double.MIN_VALUE, max = Double.MAX_VALUE;
			if (schema.getMinimum() != null)
				min = schema.getMinimum();
			if (schema.getMaximum() != null)
				max = schema.getMaximum();
			if (schema.getExclusiveMaximum() != null && schema.getExclusiveMaximum() == false)
				max += Math.ulp(max);
			if (schema.getExclusiveMinimum() != null && schema.getExclusiveMinimum() == true)
				min += Math.ulp(min);

			long resultFactor;
			long minFactor = getMinFactor(schema, min, max);
			long maxFactor = getMaxFactor(schema, min, max);
			if (minFactor == maxFactor) {
				LOGGER.warning(
						"The combination of min=" + min + ", max=" + max + ", multipleOf=" + schema.getMultipleOf()
								+ " leaves only one possible answer=" + (minFactor * schema.getMultipleOf()) + ".");
				resultFactor = minFactor;
			} else {
				resultFactor = generator.nextLong(minFactor, maxFactor + 1);
			}
			return schema.getMultipleOf() * resultFactor;

		}
		Double min = schema.getMinimum() == null ? Double.MIN_VALUE : schema.getMinimum();
		Double max = schema.getMaximum() == null ? Double.MAX_VALUE : schema.getMaximum();

		return generator.nextDouble(min, max);
	}

	private Long buildCustomExampleLongBySchema(Schema schema) {
		long min = Long.MIN_VALUE, max = Long.MAX_VALUE;
		if (schema.getMaximum() != null) {
			Double maxFractional = Math.floor(schema.getMaximum());
			max = maxFractional.longValue();
			if (schema.getExclusiveMaximum() != null && schema.getExclusiveMaximum() == false) {
				max++;
			}
		}
		if (schema.getMinimum() != null) {
			Double minFractional = Math.ceil(schema.getMinimum());
			min = minFractional.intValue();
			if (schema.getExclusiveMinimum() != null && schema.getExclusiveMinimum() == true) {
				min++;
			}
		}
		if (max <= min) {
			throw new MalformedSwaggerYamlException(
					"'" + schema.getType() + "' maximum (" + max + ") is lower than its minimum (" + min + ").");
		}

		return generator.nextLong(min, max);
	}

	private Integer buildCustomExampleIntegerBySchema(Schema schema) {
		int min = Integer.MIN_VALUE, max = Integer.MAX_VALUE;
		if (schema.getMaximum() != null) {
			Double maxFractional = Math.floor(schema.getMaximum());
			max = maxFractional.intValue();
			if (schema.getExclusiveMaximum() != null && schema.getExclusiveMaximum() == false) {
				max++;
			}
		}
		if (schema.getMinimum() != null) {
			Double minFractional = Math.ceil(schema.getMinimum());
			min = minFractional.intValue();
			if (schema.getExclusiveMinimum() != null && schema.getExclusiveMinimum() == true) {
				min++;
			}
		}
		if (max <= min) {
			throw new MalformedSwaggerYamlException(
					"'" + schema.getType() + "' maximum (" + max + ") is lower than its minimum (" + min + ").");
		}

		return generator.nextInt(min, max);
	}

	private Boolean buildCustomExampleBooleanBySchema(Schema schema) {
		// I don't think there are any limitations of booleans.
		// TODO: Review.
		return generator.nextBoolean();
	}

	public String buildCustomExampleBySchema(Schema schema) {
		return buildCustomExampleObjectBySchema(schema).toString();
	}

	private Object buildCustomExampleObjectBySchema(Schema schema) {
		// object, array, string, number, boolean, or null
		switch (schema.getType()) {
		case "string":
			return buildCustomExampleStringBySchema(schema);
		case "boolean":
			return buildCustomExampleBooleanBySchema(schema);
		case "null":
			return "null";
		case "object":
			throw new UnsupportedOperationException("Not implemented yet");
		case "array":
			throw new UnsupportedOperationException("Not implemented yet");
		case "number":
			if (schema.getFormat() == null) {
				LOGGER.warning("Found type '" + schema.getType()
						+ "', without a format attribute. Assuming 'double'. If possible, you should try to define a proper format.");
				return buildCustomExampleDoubleBySchema(schema);
			}
			switch (schema.getFormat()) {
			case "int32":
			case "integer":
			case "int":
				return buildCustomExampleIntegerBySchema(schema);
			case "int64":
			case "long":
				return buildCustomExampleLongBySchema(schema);
			default:
				LOGGER.warning("Found type '" + schema.getType() + "', but don't understand format '"
						+ schema.getFormat() + "'. Assuming 'double'.");
			case "double":
				return buildCustomExampleDoubleBySchema(schema);
			case "float":
				return buildCustomExampleFloatBySchema(schema);
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
				return buildCustomExampleIntegerBySchema(schema);
			case "int64":
			case "long":
				return buildCustomExampleLongBySchema(schema);
			default:
				throw new MalformedSwaggerYamlException("Got format '" + schema.getFormat() + "' for type '"
						+ schema.getType() + "'. Don't know how to handle this.");
			}

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
		generator = new RandomNumberGenerator(seed);
	}

	public ExampleFactory(NumberGenerator r) {
		generator = r;
	}

	public ExampleFactory(Long seed) {
		generator = new RandomNumberGenerator(seed);
	}

}
