/*
 *
 */

package gehring.simon.hobby.swagger.testing;

import gehring.simon.hobby.swagger.model.v3.PathItem;
import gehring.simon.hobby.swagger.model.v3.Server;
import gehring.simon.hobby.swagger.testing.results.TestResult;

import java.util.Map;
import java.util.Map.Entry;

/**
 * The Class ServerTestResult.
 */
public class ServerTestResult extends TestResultCollection<PathTestResult> implements TestResult {

    private static final long serialVersionUID = 1494858434386678691L;

    /**
     * Instantiates a new server test result.
     *
     * @param server
     *            the server
     * @param paths
     *            the paths
     */
    public ServerTestResult(final Server server, final Map<String, PathItem> paths) {
        PathTestResult result;
        for (final Entry<String, PathItem> pathEntries : paths.entrySet()) {
            result = new PathTestResult(pathEntries.getKey(), pathEntries.getValue(), server);

            this.add(result);
        }

    }

}
