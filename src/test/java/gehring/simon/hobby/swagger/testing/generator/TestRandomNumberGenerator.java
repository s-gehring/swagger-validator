package gehring.simon.hobby.swagger.testing.generator;

import static org.junit.Assert.fail;

import java.math.BigInteger;

import org.junit.Before;
import org.junit.Test;

public class TestRandomNumberGenerator {
	private RandomNumberGenerator gen;

	private int MAX_STEPS_PER_TEST = 1000000;

	@Before
	public void setUp() {
		gen = new RandomNumberGenerator(0L);
	}

	private Long getStep(long min, long max) {
		BigInteger minBig = BigInteger.valueOf(min), maxBig = BigInteger.valueOf(max);
		BigInteger maxStepsBig = BigInteger.valueOf(MAX_STEPS_PER_TEST);

		BigInteger difference = maxBig.subtract(minBig);
		if (difference.compareTo(maxStepsBig) == -1) {
			// That means that (max - min) < MAX_STEPS_PER_TEST
			return 1L;
		}
		long result = difference.divide(maxStepsBig).longValue();
		// System.out.println("[" + min + ";" + max + "] results in steps of size " +
		// result + ".");

		return result;
	}

	@Test
	public void testNextByteBoundary() {
		Byte step = getStep(Byte.MIN_VALUE, Byte.MAX_VALUE).byteValue();
		byte curNum = Byte.MIN_VALUE;
		for (int i = 0; i < MAX_STEPS_PER_TEST; ++i) {

			byte result = gen.nextByte(curNum, (byte) (curNum + 1));
			if (result != curNum) {
				fail("RandomByte between " + curNum + " (inkl) and " + (byte) (curNum + 1)
						+ " (exkl) should be exactly " + curNum + ", but is actually " + result + ".");
			}
			curNum = (byte) (curNum + step);
			if (curNum == Byte.MAX_VALUE)
				return;

		}
	}

	@Test
	public void testNextShortBoundary() {
		Short step = getStep(Short.MIN_VALUE, Short.MAX_VALUE).shortValue();
		short curNum = Short.MIN_VALUE;
		for (int i = 0; i < MAX_STEPS_PER_TEST; ++i) {
			short result = gen.nextShort(curNum, (short) (curNum + 1));
			if (result != curNum) {
				fail("RandomInt between " + curNum + " (inkl) and " + (curNum + 1) + " (exkl) should be exactly "
						+ curNum + ", but is actually " + result + ".");
			}
			curNum = (short) (curNum + step);
			if (curNum == Short.MAX_VALUE)
				return;
		}
	}

	@Test
	public void testNextIntBoundary() {
		Integer step = getStep(Integer.MIN_VALUE, Integer.MAX_VALUE).intValue();
		int curNum = Integer.MIN_VALUE;
		for (int i = 0; i < MAX_STEPS_PER_TEST; ++i) {
			int result = gen.nextInt(curNum, (curNum + 1));
			if (result != curNum) {
				fail("RandomInt between " + curNum + " (inkl) and " + (curNum + 1) + " (exkl) should be exactly "
						+ curNum + ", but is actually " + result + ".");
			}
			curNum = curNum + step;
			if (curNum == Integer.MAX_VALUE)
				return;
		}

	}

	@Test
	public void testNextLongBoundary() {
		Long step = getStep(Long.MIN_VALUE, Long.MAX_VALUE);
		long curNum = Long.MIN_VALUE;
		for (int i = 0; i < MAX_STEPS_PER_TEST; ++i) {
			long result = gen.nextLong(curNum, (curNum + 1));
			if (result != curNum) {
				fail("RandomLong between " + curNum + " (inkl) and " + (curNum + 1) + " (exkl) should be exactly "
						+ curNum + ", but is actually " + result + ".");
			}
			curNum = curNum + step;
		}

	}

}
