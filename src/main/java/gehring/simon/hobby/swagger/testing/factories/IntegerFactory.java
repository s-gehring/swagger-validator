package gehring.simon.hobby.swagger.testing.factories;

import java.util.logging.Logger;

import gehring.simon.hobby.swagger.model.v3.Schema;
import gehring.simon.hobby.swagger.testing.MalformedSwaggerYamlException;

public class IntegerFactory {
	private final GlobalSettings settings;
	@SuppressWarnings("unused")
	private static final Logger LOGGER = Logger.getLogger(IntegerFactory.class.toString());

	protected IntegerFactory(GlobalSettings settings) {
		this.settings = settings;
	}

	protected Long buildCustomExampleLongBySchema(Schema schema) {
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

		return settings.getNumberGenerator().nextLong(min, max);
	}

	protected Integer buildCustomExampleIntegerBySchema(Schema schema) {
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

		return settings.getNumberGenerator().nextInt(min, max);
	}

}
