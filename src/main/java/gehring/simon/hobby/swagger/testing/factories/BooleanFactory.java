package gehring.simon.hobby.swagger.testing.factories;

import java.util.logging.Logger;

import gehring.simon.hobby.swagger.model.v3.Schema;

public class BooleanFactory extends Factory {
	@SuppressWarnings("unused")
	private static final Logger LOGGER = Logger.getLogger(BooleanFactory.class.toString());
	private final GlobalSettings settings;

	protected BooleanFactory(GlobalSettings settings) {
		this.settings = settings;
	}

	protected Boolean buildCustomExampleBooleanBySchema(Schema schema) {
		// I don't think there are any limitations of booleans.
		// TODO: Review.
		return settings.getRandom().nextBoolean();
	}

}
