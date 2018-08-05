package gehring.simon.hobby.swagger.testing.factories;

import java.util.logging.Logger;

import gehring.simon.hobby.swagger.model.v3.Schema;

public class AdditionalPropertyFactory {

	@SuppressWarnings("unused")
	private static final Logger LOGGER = Logger.getLogger(BooleanFactory.class.toString());
	private final GlobalSettings settings;

	protected AdditionalPropertyFactory(GlobalSettings settings) {
		this.settings = settings;
	}

	protected AdditionalProperty produceAdditionalProperty(Schema parentSchema) {

		// @formatter:off
		return new AdditionalProperty(
				settings.getStringGenerator().nextString(settings.getPropertyNameMinLength(), settings.getPropertyNameMinLength()), 
				settings.getStringGenerator().nextString(settings.getStringMinLength(), settings.getStringMaxLength())
				);
		// @formatter:on
	}

}
