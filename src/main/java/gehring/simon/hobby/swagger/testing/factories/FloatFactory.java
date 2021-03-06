package gehring.simon.hobby.swagger.testing.factories;

import gehring.simon.hobby.swagger.model.v3.Schema;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FloatFactory implements Factory {

    private static final long    serialVersionUID = 7318313207125503767L;
    private static final Logger  LOGGER           = LogManager
            .getLogger(FloatFactory.class.toString());
    private final GlobalSettings settings;

    protected FloatFactory(final GlobalSettings settings) {
        this.settings = settings;
    }

    private Float getMinFloat(final Schema schema) {
        Float min = Float.MIN_VALUE;
        if (schema.getMinimum() != null)
            min = schema.getMinimum().floatValue();

        if (schema.getExclusiveMinimum() != null && schema.getExclusiveMinimum())
            min += Math.ulp(min);
        return min;
    }

    private Float getMaxFloat(final Schema schema) {
        Float max = Float.MAX_VALUE;
        if (schema.getMaximum() != null)
            max = schema.getMaximum().floatValue();
        if (schema.getExclusiveMaximum() != null && !schema.getExclusiveMaximum())
            max += Math.ulp(max);
        return max;
    }

    private Double getMinDouble(final Schema schema) {
        double min = Double.MIN_VALUE;
        if (schema.getMinimum() != null)
            min = schema.getMinimum();

        if (schema.getExclusiveMinimum() != null && schema.getExclusiveMinimum())
            min += Math.ulp(min);
        return min;
    }

    private Double getMaxDouble(final Schema schema) {
        double max = Double.MAX_VALUE;
        if (schema.getMaximum() != null)
            max = schema.getMaximum();
        if (schema.getExclusiveMaximum() != null && !schema.getExclusiveMaximum())
            max += Math.ulp(max);
        return max;
    }

    protected Double buildCustomExampleDoubleBySchema(final Schema schema) {
        if (schema.getMultipleOf() != null) {

            Double min = getMinDouble(schema);
            Double max = getMaxDouble(schema);

            long resultFactor;
            long minFactor = getMinFactor(schema, min);
            long maxFactor = getMaxFactor(schema, max);
            if (minFactor == maxFactor) {
                LOGGER.warn(
                        "The combination of min={}" + min + ", max=" + max + ", multipleOf="
                                + schema.getMultipleOf()
                                + " leaves only one possible answer="
                                + (minFactor * schema.getMultipleOf()) + ".");
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

    protected Float buildCustomExampleFloatBySchema(final Schema schema) {
        if (schema.getMultipleOf() != null) {
            float min = getMinFloat(schema);
            float max = getMaxFloat(schema);
            long resultFactor;
            long minFactor = getMinFactor(schema, min);
            long maxFactor = getMaxFactor(schema, max);
            if (minFactor == maxFactor) {
                LOGGER.warn(
                        "The combination of min=" + min + ", max=" + max + ", multipleOf="
                                + schema.getMultipleOf()
                                + " leaves only one possible answer="
                                + (minFactor * schema.getMultipleOf()) + ".");
                resultFactor = minFactor;
            } else {
                resultFactor = settings.getNumberGenerator().nextLong(minFactor, maxFactor + 1);
            }
            Double doubleResult = schema.getMultipleOf() * resultFactor;
            return doubleResult.floatValue();

        }
        Float min = schema.getMinimum() == null ? Float.MIN_VALUE
                : schema.getMinimum().floatValue();
        Float max = schema.getMaximum() == null ? Float.MAX_VALUE
                : schema.getMaximum().floatValue();

        return settings.getNumberGenerator().nextFloat(min, max);
    }

    private long getMaxFactor(final Schema schema, final double max) {
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
    private long getMinFactor(final Schema schema, final double min) {
        Double minFactorFraction = min / schema.getMultipleOf();
        minFactorFraction = Math.ceil(minFactorFraction);
        return minFactorFraction.longValue();
    }

    @Override
    public String getFactoryDescription() {
        return "A factory to create random floating point numbers.";
    }
}
