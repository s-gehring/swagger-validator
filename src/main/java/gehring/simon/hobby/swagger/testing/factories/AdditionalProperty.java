package gehring.simon.hobby.swagger.testing.factories;

public class AdditionalProperty {
	private final String property;
	private final String value;

	// TODO: Rework. this has to work with any type, not only string values.
	public AdditionalProperty(String property, String value) {
		this.property = property;
		this.value = value;
	}

	public String getKey() {
		return property;
	}

	public String getValue() {
		return value;
	}
}
