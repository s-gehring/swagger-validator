package gehring.simon.hobby.swagger.testing.generator;

import java.util.Random;

public class RandomAlphanumericStringGenerator implements StringGenerator {

	private static final String alphanumericCharacters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
	private Random random;

	@Override
	public String nextString(int minLength, int maxLength) {
		int length = random.nextInt(maxLength - minLength) + minLength;
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < length; ++i) {
			result.append(alphanumericCharacters.charAt(random.nextInt(alphanumericCharacters.length())));
		}
		return result.toString();
	}

	public RandomAlphanumericStringGenerator(Random r) {
		random = r;
	}

	public RandomAlphanumericStringGenerator(long seed) {
		this(new Random(seed));
	}

}
