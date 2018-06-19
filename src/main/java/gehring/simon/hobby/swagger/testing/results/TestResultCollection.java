/*
 *
 */

package gehring.simon.hobby.swagger.testing.results;

import java.util.ArrayList;
import java.util.StringJoiner;

/**
 * The Class TestResult.
 */
public abstract class TestResultCollection extends ArrayList<AbstractTestResult>
    implements AbstractTestResult {

  @Override
  public String toString() {
    StringJoiner builder = new StringJoiner(",", "{", "}");
    for (AbstractTestResult res : this) {
      builder.add(res.toString());
    }
    return builder.toString();
  }
}
