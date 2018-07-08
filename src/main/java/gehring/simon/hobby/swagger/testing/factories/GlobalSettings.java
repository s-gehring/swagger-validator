package gehring.simon.hobby.swagger.testing.factories;

import java.util.Random;

import gehring.simon.hobby.swagger.testing.generator.NumberGenerator;
import gehring.simon.hobby.swagger.testing.generator.RandomAlphanumericStringGenerator;
import gehring.simon.hobby.swagger.testing.generator.RandomNumberGenerator;
import gehring.simon.hobby.swagger.testing.generator.StringGenerator;

public class GlobalSettings {
	private int stringMaxLength;
	private int stringMinLength = 0;
	private StringGenerator stringGenerator;

	private NumberGenerator numberGenerator;

	private Random random;

	private ExampleFactory exampleFactory;
	private FloatFactory floatFactory;
	private IntegerFactory integerFactory;
	private ObjectFactory objectFactory;
	private StringFactory stringFactory;
	private BooleanFactory booleanFactory;

	private static GlobalSettings DEFAULT_SETTINGS;

	private static GlobalSettings generateDefaults() {
		GlobalSettings result = new GlobalSettings();
		result.setRandom(new Random(0L));
		result.setNumberGenerator(new RandomNumberGenerator(result.getRandom()));
		result.setStringGenerator(new RandomAlphanumericStringGenerator(result.getRandom()));
		result.setStringMaxLength(20);

		result.setExampleFactory(new ExampleFactory(result));
		result.setFloatFactory(new FloatFactory(result));
		result.setIntegerFactory(new IntegerFactory(result));
		result.setObjectFactory(new ObjectFactory(result));
		result.setStringFactory(new StringFactory(result));

		return null;
	}

	public synchronized static final GlobalSettings getDefaultSettings() {
		return DEFAULT_SETTINGS == null ? DEFAULT_SETTINGS = generateDefaults() : DEFAULT_SETTINGS;
	}

	public int getStringMaxLength() {
		return stringMaxLength;
	}

	public void setStringMaxLength(int stringMaxLength) {
		this.stringMaxLength = stringMaxLength;
	}

	public int getStringMinLength() {
		return stringMinLength;
	}

	public void setStringMinLength(int stringMinLength) {
		this.stringMinLength = stringMinLength;
	}

	public NumberGenerator getNumberGenerator() {
		return numberGenerator;
	}

	public void setNumberGenerator(NumberGenerator generator) {
		this.numberGenerator = generator;
	}

	public Random getRandom() {
		return random;
	}

	public void setRandom(Random random) {
		this.random = random;
	}

	public StringGenerator getStringGenerator() {
		return stringGenerator;
	}

	public void setStringGenerator(StringGenerator strGenerator) {
		this.stringGenerator = strGenerator;
	}

	public ExampleFactory getExampleFactory() {
		return exampleFactory;
	}

	public void setExampleFactory(ExampleFactory exampleFactory) {
		this.exampleFactory = exampleFactory;
	}

	public FloatFactory getFloatFactory() {
		return floatFactory;
	}

	public void setFloatFactory(FloatFactory floatFactory) {
		this.floatFactory = floatFactory;
	}

	public IntegerFactory getIntegerFactory() {
		return integerFactory;
	}

	public void setIntegerFactory(IntegerFactory integerFactory) {
		this.integerFactory = integerFactory;
	}

	public ObjectFactory getObjectFactory() {
		return objectFactory;
	}

	public void setObjectFactory(ObjectFactory objectFactory) {
		this.objectFactory = objectFactory;
	}

	public StringFactory getStringFactory() {
		return stringFactory;
	}

	public void setStringFactory(StringFactory stringFactory) {
		this.stringFactory = stringFactory;
	}

	public BooleanFactory getBooleanFactory() {
		return booleanFactory;
	}

	public void setBooleanFactory(BooleanFactory booleanFactory) {
		this.booleanFactory = booleanFactory;
	}

}
