package gehring.simon.hobby.swagger.testing.factories;

import java.util.logging.Logger;

import gehring.simon.hobby.swagger.model.v3.Schema;

public class FloatFactory extends Factory {

	private static final Logger LOGGER = Logger.getLogger(FloatFactory.class.toString());
	private final GlobalSettings settings;

	protected FloatFactory(GlobalSettings settings) {
		this.settings = settings;
	}

	protected Double buildCustomExampleDoubleBySchema(Schema schema) {
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
				resultFactor = settings.getNumberGenerator().nextLong(minFactor, maxFactor + 1);
			}
			return schema.getMultipleOf() * resultFactor;

		}
		Double min = schema.getMinimum() == null ? Double.MIN_VALUE : schema.getMinimum();
		Double max = schema.getMaximum() == null ? Double.MAX_VALUE : schema.getMaximum();

		return settings.getNumberGenerator().nextDouble(min, max);
	}

	protected Float buildCustomExampleFloatBySchema(Schema schema) {
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
				resultFactor = settings.getNumberGenerator().nextLong(minFactor, maxFactor + 1);
			}
			Double doubleResult = schema.getMultipleOf() * resultFactor;
			return doubleResult.floatValue();

		}
		Float min = schema.getMinimum() == null ? Float.MIN_VALUE : schema.getMinimum().floatValue();
		Float max = schema.getMaximum() == null ? Float.MAX_VALUE : schema.getMaximum().floatValue();

		return settings.getNumberGenerator().nextFloat(min, max);
	}

	private long getMaxFactor(Schema schema, double min, double max) {
		Double maxFactorFraction = max / schema.getMultipleOf();
		maxFactorFraction = Math.floor(maxFactorFraction);
		return maxFactorFraction.longValue();
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
}
