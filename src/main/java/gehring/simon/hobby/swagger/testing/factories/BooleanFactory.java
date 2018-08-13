package gehring.simon.hobby.swagger.testing.factories;

import gehring.simon.hobby.swagger.model.v3.Schema;

import java.util.logging.Logger;

public class BooleanFactory implements Factory {

    private static final long    serialVersionUID = -2040615117549868062L;
    @SuppressWarnings("unused")
    private static final Logger  LOGGER           = Logger
            .getLogger(BooleanFactory.class.toString());
    private final GlobalSettings settings;

    protected BooleanFactory(final GlobalSettings settings) {
        this.settings = settings;
    }

    protected Boolean buildCustomExampleBooleanBySchema(final Schema schema) {
        return settings.getRandom().nextBoolean();
    }

    @Override
    public String getFactoryDescription() {
        return "A factory creating random booleans with a chance of 0.5 each.";
    }

}
