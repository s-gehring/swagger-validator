/*
 *
 */

package gehring.simon.hobby.swagger.testing;

import gehring.simon.hobby.swagger.model.v3.PathItem;
import gehring.simon.hobby.swagger.model.v3.Server;
import gehring.simon.hobby.swagger.testing.results.AbstractTestResult;
import gehring.simon.hobby.swagger.testing.results.TestResultCollection;

import java.util.Map;
import java.util.Map.Entry;

/**
 * The Class ServerTestResult.
 */
public class ServerTestResult extends TestResultCollection {

  private boolean containsErrors = false;

  /**
   * Instantiates a new server test result.
   *
   * @param server
   *          the server
   * @param paths
   *          the paths
   */
  public ServerTestResult(final Server server, final Map<String, PathItem> paths) {
    super();
    AbstractTestResult result;
    for (final Entry<String, PathItem> pathEntries : paths.entrySet()) {
      result = new PathTestResult(pathEntries.getKey(), pathEntries.getValue(), server);
      if (result.hasErrors()) {
        containsErrors = true;
      }
      this.add(result);
    }

  }

  @Override
  public boolean hasErrors() {
    return containsErrors;
  }

}
