/*
 *
 */

package gehring.simon.hobby.swagger.testing;

import gehring.simon.hobby.swagger.model.v3.PathItem;
import gehring.simon.hobby.swagger.model.v3.Server;
import gehring.simon.hobby.swagger.testing.http.Method;
import gehring.simon.hobby.swagger.testing.results.TestResult;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * The Class PathTestResult.
 */
public class PathTestResult extends TestResultCollection<MethodTestResult> implements TestResult {

    private static final long   serialVersionUID = 732412230675395191L;
    /** The Constant LOGGER. */
    private static final Logger LOGGER           = LogManager
            .getLogger(PathTestResult.class.getName());

    /**
     * Instantiates a new path test result.
     *
     * @param path
     *            the path
     * @param pathOptions
     *            the path options
     * @param server
     *            the server
     */
    public PathTestResult(final String path, final PathItem pathOptions, final Server server) {
        super();
        MethodTestResult result;
        LOGGER.info("Testing path '" + path + "'.");
        // GET, POST, DELETE, OPTIONS, HEAD, PATCH, TRACE, PUT
        if (pathOptions.getGet() != null) {
            result = new MethodTestResult(Method.GET, path, pathOptions.getGet(), server);

            this.add(result);
        }
        if (pathOptions.getPost() != null) {
            result = new MethodTestResult(Method.POST, path, pathOptions.getPost(), server);

            this.add(result);
        }
        if (pathOptions.getDelete() != null) {
            result = new MethodTestResult(Method.DELETE, path, pathOptions.getDelete(), server);

            this.add(result);
        }
        if (pathOptions.getOptions() != null) {
            result = new MethodTestResult(Method.OPTIONS, path, pathOptions.getOptions(), server);

            this.add(result);
        }
        if (pathOptions.getHead() != null) {
            result = new MethodTestResult(Method.HEAD, path, pathOptions.getHead(), server);

            this.add(result);
        }
        if (pathOptions.getPatch() != null) {
            result = new MethodTestResult(Method.PATCH, path, pathOptions.getPatch(), server);

            this.add(result);
        }
        if (pathOptions.getTrace() != null) {
            result = new MethodTestResult(Method.TRACE, path, pathOptions.getTrace(), server);

            this.add(result);
        }
        if (pathOptions.getPut() != null) {
            result = new MethodTestResult(Method.PUT, path, pathOptions.getPut(), server);

            this.add(result);
        }

    }

}
