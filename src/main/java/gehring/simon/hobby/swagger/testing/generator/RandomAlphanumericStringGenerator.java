package gehring.simon.hobby.swagger.testing.generator;

import java.util.Random;

public class RandomAlphanumericStringGenerator implements StringGenerator {

	private static final String ALPHANUMERIC_CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
	private Random random;

	public RandomAlphanumericStringGenerator(long seed) {
		this(new Random(seed));
	}

	public RandomAlphanumericStringGenerator(Random r) {
		random = r;
	}

	@Override
	public String nextString(int minLength, int maxLength) {
		int length = random.nextInt(maxLength - minLength) + minLength;
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < length; ++i) {
			result.append(ALPHANUMERIC_CHARACTERS.charAt(random.nextInt(ALPHANUMERIC_CHARACTERS.length())));
		}
		return result.toString();
	}

}
