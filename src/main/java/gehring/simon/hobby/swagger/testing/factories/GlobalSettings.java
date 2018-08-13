package gehring.simon.hobby.swagger.testing.factories;

import gehring.simon.hobby.swagger.testing.generator.NumberGenerator;
import gehring.simon.hobby.swagger.testing.generator.RandomAlphanumericStringGenerator;
import gehring.simon.hobby.swagger.testing.generator.RandomNumberGenerator;
import gehring.simon.hobby.swagger.testing.generator.StringGenerator;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GlobalSettings implements Serializable {

    private static final long serialVersionUID = -5457271249256993408L;

    private static GlobalSettings defaultSettings;

    protected static final Logger LOGGER = LogManager.getLogger(GlobalSettings.class.toString());

    private static GlobalSettings generateDefaults() {
        GlobalSettings result = new GlobalSettings();
        result.setRandom(new Random(0L));
        result.setNumberGenerator(new RandomNumberGenerator(result.getRandom()));
        result.setStringGenerator(new RandomAlphanumericStringGenerator(result.getRandom()));
        result.setStringMaxLength(20);

        result.setAdditionalPropertyFactory(new AdditionalPropertyFactory(result));
        result.setExampleFactory(new ExampleFactory(result));
        result.setFloatFactory(new FloatFactory(result));
        result.setIntegerFactory(new IntegerFactory(result));
        result.setObjectFactory(new ObjectFactory(result));
        result.setStringFactory(new StringFactory(result));
        result.setBooleanFactory(new BooleanFactory(result));

        return result;
    }

    public static final synchronized GlobalSettings getDefaultSettings() {
        return defaultSettings == null ? defaultSettings = generateDefaults() : defaultSettings;
    }

    private AdditionalPropertyFactory propertyFactory;
    private StackTraceElement[]       propertyFactoryUsed = null;

    private BooleanFactory      booleanFactory;
    private StackTraceElement[] booleanFactoryUsed = null;

    private ExampleFactory      exampleFactory;
    private StackTraceElement[] exampleFactoryUsed = null;

    private FloatFactory        floatFactory;
    private StackTraceElement[] floatFactoryUsed = null;

    private IntegerFactory      integerFactory;
    private StackTraceElement[] integerFactoryUsed = null;

    private NumberGenerator numberGenerator;

    private ObjectFactory       objectFactory;
    private StackTraceElement[] objectFactoryUsed = null;

    private Random random;

    private StringFactory       stringFactory;
    private StackTraceElement[] stringFactoryUsed = null;

    private StringGenerator stringGenerator;

    private int stringMaxLength;
    private int stringMinLength       = 0;
    private int propertyNameMaxLength;
    private int propertyNameMinLength = 0;

    public BooleanFactory getBooleanFactory() {
        if (booleanFactoryUsed == null) {
            booleanFactoryUsed = Thread.currentThread().getStackTrace();
        }
        if (booleanFactory == null) {
            booleanFactory = new BooleanFactory(this);
        }
        return booleanFactory;
    }

    public ExampleFactory getExampleFactory() {
        if (exampleFactoryUsed == null) {
            exampleFactoryUsed = Thread.currentThread().getStackTrace();
        }
        if (exampleFactory == null) {
            exampleFactory = new ExampleFactory(this);
        }
        return exampleFactory;
    }

    public FloatFactory getFloatFactory() {
        if (floatFactoryUsed == null) {
            floatFactoryUsed = Thread.currentThread().getStackTrace();
        }
        if (floatFactory == null) {
            floatFactory = new FloatFactory(this);
        }
        return floatFactory;
    }

    public IntegerFactory getIntegerFactory() {
        if (integerFactoryUsed == null) {
            integerFactoryUsed = Thread.currentThread().getStackTrace();
        }
        if (integerFactory == null) {
            integerFactory = new IntegerFactory(this);
        }
        return integerFactory;
    }

    public NumberGenerator getNumberGenerator() {
        return numberGenerator;
    }

    public ObjectFactory getObjectFactory() {
        if (objectFactoryUsed == null) {
            objectFactoryUsed = Thread.currentThread().getStackTrace();
        }
        if (objectFactory == null) {
            objectFactory = new ObjectFactory(this);
        }
        return objectFactory;
    }

    public Random getRandom() {
        return random;
    }

    public StringFactory getStringFactory() {
        if (stringFactoryUsed == null) {
            stringFactoryUsed = Thread.currentThread().getStackTrace();
        }
        if (stringFactory == null) {
            stringFactory = new StringFactory(this);
        }
        return stringFactory;
    }

    public StringGenerator getStringGenerator() {
        return stringGenerator;
    }

    public int getStringMaxLength() {
        return stringMaxLength;
    }

    public int getStringMinLength() {
        return stringMinLength;
    }

    public void setBooleanFactory(final BooleanFactory booleanFactory) {
        if (booleanFactoryUsed != null) {
            String msg = "You're trying to change the boolean factory, that was already used. This may lead to inconsistencies.\n";
            msg += "First usage of the boolean factory was:\n";
            msg += Arrays.toString(booleanFactoryUsed);
            LOGGER.warn(msg);
        }
        this.booleanFactory = booleanFactory;
    }

    public void setExampleFactory(final ExampleFactory exampleFactory) {
        if (exampleFactoryUsed != null) {
            String msg = "You're trying to change the example factory, that was already used. This may lead to inconsistencies.\n";
            msg += "First usage of the example factory was:\n";
            msg += Arrays.toString(exampleFactoryUsed);
            LOGGER.warn(msg);
        }
        this.exampleFactory = exampleFactory;
    }

    public void setFloatFactory(final FloatFactory floatFactory) {
        if (floatFactoryUsed != null) {
            String msg = "You're trying to change the float factory, that was already used. This may lead to inconsistencies.\n";
            msg += "First usage of the float factory was:\n";
            msg += Arrays.toString(floatFactoryUsed);
            LOGGER.warn(msg);
        }
        this.floatFactory = floatFactory;
    }

    public void setIntegerFactory(final IntegerFactory integerFactory) {
        if (integerFactoryUsed != null) {
            String msg = "You're trying to change the integer factory, that was already used. This may lead to inconsistencies.\n";
            msg += "First usage of the integer factory was:\n";
            msg += Arrays.toString(integerFactoryUsed);
            LOGGER.warn(msg);
        }
        this.integerFactory = integerFactory;
    }

    public void setNumberGenerator(final NumberGenerator generator) {
        this.numberGenerator = generator;
    }

    public void setObjectFactory(final ObjectFactory objectFactory) {
        if (objectFactoryUsed != null) {
            String msg = "You're trying to change the object factory, that was already used. This may lead to inconsistencies.\n";
            msg += "First usage of the object factory was:\n";
            msg += Arrays.toString(objectFactoryUsed);
            LOGGER.warn(msg);
        }
        this.objectFactory = objectFactory;
    }

    public void setRandom(final Random random) {
        this.random = random;
    }

    public void setStringFactory(final StringFactory stringFactory) {
        if (stringFactoryUsed != null) {
            String msg = "You're trying to change the string factory, that was already used. This may lead to inconsistencies.\n";
            msg += "First usage of the string factory was:\n";
            msg += Arrays.toString(stringFactoryUsed);
            LOGGER.warn(msg);
        }
        this.stringFactory = stringFactory;
    }

    public void setStringGenerator(final StringGenerator strGenerator) {
        this.stringGenerator = strGenerator;
    }

    public void setStringMaxLength(final int stringMaxLength) {
        this.stringMaxLength = stringMaxLength;
    }

    public void setStringMinLength(final int stringMinLength) {
        this.stringMinLength = stringMinLength;
    }

    public int getPropertyNameMaxLength() {
        return propertyNameMaxLength;
    }

    public void setPropertyNameMaxLength(final int propertyNameMaxLength) {
        this.propertyNameMaxLength = propertyNameMaxLength;
    }

    public int getPropertyNameMinLength() {
        return propertyNameMinLength;
    }

    public void setPropertyNameMinLength(final int propertyNameMinLength) {
        this.propertyNameMinLength = propertyNameMinLength;
    }

    public AdditionalPropertyFactory getAdditionalPropertyFactory() {
        if (propertyFactoryUsed == null) {
            propertyFactoryUsed = Thread.currentThread().getStackTrace();
        }
        if (propertyFactory == null) {
            propertyFactory = new AdditionalPropertyFactory(this);
        }
        return propertyFactory;
    }

    public void setAdditionalPropertyFactory(final AdditionalPropertyFactory propertyFactory) {
        if (propertyFactoryUsed != null) {
            String msg = "You're trying to change the property factory, that was already used. This may lead to inconsistencies.\n";
            msg += "First usage of the property factory was:\n";
            msg += Arrays.toString(propertyFactoryUsed);
            LOGGER.warn(msg);
        }
        this.propertyFactory = propertyFactory;
    }

}
