package gehring.simon.hobby.swagger.testing.results;

import java.util.ArrayList;
import java.util.StringJoiner;

public abstract class TestResultCollection<T extends TestResult> extends ArrayList<T> {

	@Override
	public boolean add(T e) {
		if (e == null)
			throw new IllegalArgumentException("Null is not a valid test result.");
		return super.add(e);
	}

	@Override
	public void add(int index, T element) {
		if (element == null)
			throw new IllegalArgumentException("Null is not a valid test result.");
		super.add(index, element);
	}

	public String getResultName() {
		return this.getClass().getSimpleName();
	}

	protected static final String INDENTATION = "\t";

	public boolean hasErrors() {
		for (TestResult result : this) {
			if (result.isErroreous())
				return true;
		}
		return false;
	}

	protected String toLongStringIndented(final int indentation) {
		StringBuilder indentBuilder = new StringBuilder();
		for (int i = 0; i < indentation; ++i) {
			indentBuilder.append(INDENTATION);
		}
		String indent = indentBuilder.toString();
		indentBuilder = null;

		StringJoiner builder = new StringJoiner("\n" + INDENTATION + indent,
				this.getResultName() + ":\n" + INDENTATION + indent, "");

		if (this.size() == 0) {
			builder.add("<no test results>");
		} else {
			for (TestResult result : this) {
				if (result instanceof TestResultCollection) {
					builder.add(((TestResultCollection<?>) result).toLongStringIndented(indentation + 1));
				} else {
					builder.add(result.toLongString());
				}
			}
		}

		return builder.toString();
	}

	@Override
	public String toString() {
		return toLongStringIndented(0);
	}

}
