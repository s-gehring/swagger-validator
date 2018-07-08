package gehring.simon.hobby.swagger.testing.factories;

import gehring.simon.hobby.swagger.model.v3.Schema;
import gehring.simon.hobby.swagger.testing.GlobalSettings;

public class StringFactory {

	private final GlobalSettings settings;

	public StringFactory(GlobalSettings settings) {
		this.settings = settings;
	}

	protected String buildCustomExampleStringBySchema(Schema schema) {
		int maxLength = schema.getMaxLength() != null ? schema.getMaxLength() : settings.getStringMaxLength();
		int minLength = schema.getMinItems() != null ? schema.getMinLength() : settings.getStringMinLength();
		return settings.nextString(minLength, maxLength);
	}

}
