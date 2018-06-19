package gehring.simon.hobby.swagger.testing;

import static org.junit.Assert.fail;

import java.lang.reflect.Method;

import org.junit.jupiter.api.Test;

public class ExampleFactoryTest {

	@Test
	public void generatesZero() throws Exception {
		/*
		 * Must get by reflection, since it's private.
		 */
		Method longGeneration = ExampleFactory.class.getDeclaredMethod("nextLong", Long.class);
		longGeneration.setAccessible(true);
		ExampleFactory factory = new ExampleFactory(0L);
		Long result = (Long) longGeneration.invoke(factory, 1L);
		if (result == null || !result.equals(0L)) {
			fail("Method returned '" + result + "' which is not 0.");
		}
	}

	@Test
	public void generateMultipleZeroes() throws Exception {
		int LIMIT = 10000;
		for (int i = 0; i < LIMIT; i++) {
			generatesZero();
		}
	}

	private long curRandomSeed = 0;

	@Test
	public void generateHighNumber() throws Exception {
		Method longGeneration = ExampleFactory.class.getDeclaredMethod("nextLong", Long.class);
		longGeneration.setAccessible(true);
		ExampleFactory factory = new ExampleFactory(curRandomSeed);
		Long result = (Long) longGeneration.invoke(factory, Long.MAX_VALUE);

		if (result < Integer.MAX_VALUE && result > Integer.MIN_VALUE) {
			fail("Got a random long of " + result
					+ " which is in the range of integers. This is not a realistic result.");
		}
	}

	@Test
	public void generateMultipleHighNumbers() throws Exception {

		int LIMIT = 10000;
		for (int i = 0; i < LIMIT; i++) {
			curRandomSeed = i;
			generateHighNumber();
		}
	}

}
