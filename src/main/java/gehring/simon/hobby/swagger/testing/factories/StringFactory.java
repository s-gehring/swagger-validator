package gehring.simon.hobby.swagger.testing.factories;

import gehring.simon.hobby.swagger.model.v3.Schema;

public class StringFactory implements Factory {

    private static final long    serialVersionUID = -4802211840451476322L;
    private final GlobalSettings settings;

    public StringFactory(final GlobalSettings settings) {
        this.settings = settings;
    }

    protected String buildCustomExampleStringBySchema(final Schema schema) {
        int maxLength = schema.getMaxLength() != null ? schema.getMaxLength()
                : settings.getStringMaxLength();
        int minLength = schema.getMinItems() != null ? schema.getMinLength()
                : settings.getStringMinLength();
        return settings.getStringGenerator().nextString(minLength, maxLength);
    }

    @Override
    public String getFactoryDescription() {
        return "A factory to create random strings.";
    }

}
