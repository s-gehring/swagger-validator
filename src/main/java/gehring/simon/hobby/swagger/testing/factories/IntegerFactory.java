package gehring.simon.hobby.swagger.testing.factories;

import gehring.simon.hobby.swagger.model.v3.Schema;
import gehring.simon.hobby.swagger.testing.MalformedSwaggerYamlException;

import java.util.logging.Logger;

public class IntegerFactory implements Factory {

    private static final long    serialVersionUID = 6942834033298355712L;
    @SuppressWarnings("unused")
    private static final Logger  LOGGER           = Logger
            .getLogger(IntegerFactory.class.toString());
    private final GlobalSettings settings;

    protected IntegerFactory(final GlobalSettings settings) {
        this.settings = settings;
    }

    protected Integer buildCustomExampleIntegerBySchema(final Schema schema) {
        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;
        if (schema.getMaximum() != null) {
            Double maxFractional = Math.floor(schema.getMaximum());
            max = maxFractional.intValue();
            if (schema.getExclusiveMaximum() != null && !schema.getExclusiveMaximum()) {
                max++;
            }
        }
        if (schema.getMinimum() != null) {
            Double minFractional = Math.ceil(schema.getMinimum());
            min = minFractional.intValue();
            if (schema.getExclusiveMinimum() != null && schema.getExclusiveMinimum()) {
                min++;
            }
        }
        if (max <= min) {
            throw new MalformedSwaggerYamlException(
                    "'" + schema.getType() + "' maximum (" + max + ") is lower than its minimum ("
                            + min + ").");
        }

        return settings.getNumberGenerator().nextInt(min, max);
    }

    protected Long buildCustomExampleLongBySchema(final Schema schema) {
        long min = Long.MIN_VALUE;
        long max = Long.MAX_VALUE;
        if (schema.getMaximum() != null) {
            Double maxFractional = Math.floor(schema.getMaximum());
            max = maxFractional.longValue();
            if (schema.getExclusiveMaximum() != null && !schema.getExclusiveMaximum()) {
                max++;
            }
        }
        if (schema.getMinimum() != null) {
            Double minFractional = Math.ceil(schema.getMinimum());
            min = minFractional.intValue();
            if (schema.getExclusiveMinimum() != null && schema.getExclusiveMinimum()) {
                min++;
            }
        }
        if (max <= min) {
            throw new MalformedSwaggerYamlException(
                    "'" + schema.getType() + "' maximum (" + max + ") is lower than its minimum ("
                            + min + ").");
        }

        return settings.getNumberGenerator().nextLong(min, max);
    }

    @Override
    public String getFactoryDescription() {
        return "A factory to create random integer numbers.";
    }

}
