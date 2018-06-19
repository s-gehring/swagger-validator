/*
 *
 */

package gehring.simon.hobby.swagger.testing;

import gehring.simon.hobby.swagger.model.v3.PathItem;
import gehring.simon.hobby.swagger.model.v3.Server;
import gehring.simon.hobby.swagger.testing.http.Method;
import gehring.simon.hobby.swagger.testing.results.AbstractTestResult;
import gehring.simon.hobby.swagger.testing.results.TestResultCollection;

import java.util.logging.Logger;

// TODO: Auto-generated Javadoc
/**
 * The Class PathTestResult.
 */
public class PathTestResult extends TestResultCollection {

  private boolean containsErrors = false;

  /** The Constant LOGGER. */
  private static final Logger LOGGER = Logger.getLogger(PathTestResult.class.getName());

  /**
   * Instantiates a new path test result.
   *
   * @param path
   *          the path
   * @param pathOptions
   *          the path options
   * @param server
   *          the server
   */
  public PathTestResult(final String path, final PathItem pathOptions, final Server server) {
    super();
    AbstractTestResult result;
    LOGGER.info("Testing path '" + path + "'.");
    // GET, POST, DELETE, OPTIONS, HEAD, PATCH, TRACE, PUT
    if (pathOptions.getGet() != null) {
      result = new MethodTestResult(Method.GET, path, pathOptions.getGet(), server);
      if (result.hasErrors()) {
        containsErrors = true;
      }
      this.add(result);
    }
    if (pathOptions.getPost() != null) {
      result = new MethodTestResult(Method.POST, path, pathOptions.getPost(), server);
      if (result.hasErrors()) {
        containsErrors = true;
      }
      this.add(result);
    }
    if (pathOptions.getDelete() != null) {
      result = new MethodTestResult(Method.DELETE, path, pathOptions.getDelete(), server);
      if (result.hasErrors()) {
        containsErrors = true;
      }
      this.add(result);
    }
    if (pathOptions.getOptions() != null) {
      result = new MethodTestResult(Method.OPTIONS, path, pathOptions.getOptions(), server);
      if (result.hasErrors()) {
        containsErrors = true;
      }
      this.add(result);
    }
    if (pathOptions.getHead() != null) {
      result = new MethodTestResult(Method.HEAD, path, pathOptions.getHead(), server);
      if (result.hasErrors()) {
        containsErrors = true;
      }
      this.add(result);
    }
    if (pathOptions.getPatch() != null) {
      result = new MethodTestResult(Method.PATCH, path, pathOptions.getPatch(), server);
      if (result.hasErrors()) {
        containsErrors = true;
      }
      this.add(result);
    }
    if (pathOptions.getTrace() != null) {
      result = new MethodTestResult(Method.TRACE, path, pathOptions.getTrace(), server);
      if (result.hasErrors()) {
        containsErrors = true;
      }
      this.add(result);
    }
    if (pathOptions.getPut() != null) {
      result = new MethodTestResult(Method.PUT, path, pathOptions.getPut(), server);
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
