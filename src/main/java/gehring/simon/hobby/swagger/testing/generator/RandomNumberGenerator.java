package gehring.simon.hobby.swagger.testing.generator;

import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator {

	private Random random;

	public RandomNumberGenerator(long seed) {
		this(new Random(seed));
	}

	public RandomNumberGenerator(Random r) {
		random = r;
	}

	@Override
	public boolean nextBoolean() {
		return random.nextBoolean();
	}

	@Override
	public byte nextByte(byte low, byte high) {
		Integer result = random.nextInt() % (high - low) + low;
		return result.byteValue();
	}

	@Override
	public double nextDouble(double low, double high) {
		return random.nextDouble() % (high - low) + low;
	}

	@Override
	public float nextFloat(float low, float high) {
		return random.nextFloat() % (high - low) + low;
	}

	@Override
	public int nextInt(int low, int high) {
		return random.nextInt() % (high - low) + low;
	}

	@Override
	public long nextLong(long low, long high) {
		return random.nextLong() % (high - low) + low;
	}

	@Override
	public short nextShort(short low, short high) {
		Integer result = random.nextInt() % (high - low) + low;
		return result.shortValue();
	}

}
