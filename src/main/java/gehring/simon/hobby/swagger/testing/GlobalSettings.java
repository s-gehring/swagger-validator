package gehring.simon.hobby.swagger.testing;

import java.util.Random;

import gehring.simon.hobby.swagger.testing.generator.NumberGenerator;
import gehring.simon.hobby.swagger.testing.generator.RandomAlphanumericStringGenerator;
import gehring.simon.hobby.swagger.testing.generator.RandomNumberGenerator;
import gehring.simon.hobby.swagger.testing.generator.StringGenerator;

public class GlobalSettings implements NumberGenerator, StringGenerator {
	private int stringMaxLength;
	private int stringMinLength = 0;
	private NumberGenerator generator;
	private StringGenerator strGenerator;
	private Random random;

	private static GlobalSettings DEFAULT_SETTINGS;

	private static GlobalSettings generateDefaults() {
		GlobalSettings result = new GlobalSettings();
		result.setRandom(new Random(0L));
		result.setGenerator(new RandomNumberGenerator(result.getRandom()));
		result.setStringGenerator(new RandomAlphanumericStringGenerator(result.getRandom()));
		result.setStringMaxLength(20);
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

	public NumberGenerator getGenerator() {
		return generator;
	}

	public void setGenerator(NumberGenerator generator) {
		this.generator = generator;
	}

	public Random getRandom() {
		return random;
	}

	public void setRandom(Random random) {
		this.random = random;
	}

	@Override
	public long nextLong(long low, long high) {
		return getGenerator().nextLong(low, high);
	}

	@Override
	public int nextInt(int low, int high) {
		return getGenerator().nextInt(low, high);
	}

	@Override
	public double nextDouble(double low, double high) {
		return getGenerator().nextDouble(low, high);
	}

	@Override
	public float nextFloat(float low, float high) {
		return getGenerator().nextFloat(low, high);
	}

	@Override
	public short nextShort(short low, short high) {
		return getGenerator().nextShort(low, high);
	}

	@Override
	public byte nextByte(byte low, byte high) {
		return getGenerator().nextByte(low, high);
	}

	@Override
	public boolean nextBoolean() {
		return getGenerator().nextBoolean();
	}

	@Override
	public String nextString(int minLength, int maxLength) {
		return strGenerator.nextString(minLength, maxLength);
	}

	public StringGenerator getStringGenerator() {
		return strGenerator;
	}

	public void setStringGenerator(StringGenerator strGenerator) {
		this.strGenerator = strGenerator;
	}

}
