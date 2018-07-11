/*
 *
 */

package gehring.simon.hobby.swagger.testing.results;

import java.util.ArrayList;
import java.util.StringJoiner;

/**
 * The Class TestResult.
 */
public abstract class TestResultCollection extends ArrayList<AbstractTestResult> implements AbstractTestResult {

	@Override
	public String toString() {
		StringJoiner joiner = new StringJoiner("}\n\t{", "[\n", "\n]");
		for (AbstractTestResult result : this) {
			joiner.add(result.toString());
		}
		return joiner.toString();
	}

	@Override
	public String getShortDescription() {
		if (this.size() == 0) {
			return "<no result>";
		}
		if (this.size() == 1) {
			return this.get(0).getShortDescription();
		}
		StringJoiner joiner = new StringJoiner(",\n\t", "[\n\t", "\n]");
		for (AbstractTestResult result : this) {
			joiner.add(result.getShortDescription());
		}
		return joiner.toString();
	}

	@Override
	public String getDescription() {
		StringJoiner joiner = new StringJoiner("\n", "-- Test Results ----\n", "\n--------------------");
		for (AbstractTestResult result : this) {
			joiner.add("Premise: " + result.getPremise() + "\nResult: " + result.getShortDescription());
		}

		return joiner.toString();
	}
}
