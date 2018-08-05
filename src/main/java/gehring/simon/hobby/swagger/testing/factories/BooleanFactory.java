package gehring.simon.hobby.swagger.testing.factories;

import java.util.logging.Logger;

import gehring.simon.hobby.swagger.model.v3.Schema;

public class BooleanFactory implements Factory {
	@SuppressWarnings("unused")
	private static final Logger LOGGER = Logger.getLogger(BooleanFactory.class.toString());
	private final GlobalSettings settings;

	protected BooleanFactory(GlobalSettings settings) {
		this.settings = settings;
	}

	protected Boolean buildCustomExampleBooleanBySchema(Schema schema) {
		return settings.getRandom().nextBoolean();
	}

	@Override
	public String getFactoryDescription() {
		return "A factory creating random booleans with a chance of 0.5 each.";
	}

}
