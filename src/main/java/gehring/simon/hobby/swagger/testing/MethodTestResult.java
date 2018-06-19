/*
 *
 */

package gehring.simon.hobby.swagger.testing;

import gehring.simon.hobby.swagger.model.v3.Operation;
import gehring.simon.hobby.swagger.model.v3.Parameter;
import gehring.simon.hobby.swagger.model.v3.Server;
import gehring.simon.hobby.swagger.testing.http.HttpHandler;
import gehring.simon.hobby.swagger.testing.http.Method;
import gehring.simon.hobby.swagger.testing.results.AbstractTestResult;
import gehring.simon.hobby.swagger.testing.results.HttpTestResult;
import gehring.simon.hobby.swagger.testing.results.TestResultCollection;
import gehring.simon.hobby.swagger.testing.results.TimeoutTestResult;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

// TODO: Auto-generated Javadoc
/**
 * The Class MethodTestResult.
 */
public class MethodTestResult extends TestResultCollection {

  private boolean containsErrors = false;

  /**
   * Execute connection.
   *
   * @param con
   *          the con
   */
  private void executeConnection(final HttpURLConnection con) {
    AbstractTestResult result;

    try {
      con.connect();
      result = new HttpTestResult(con);
    } catch (IOException e) {
      result = new TimeoutTestResult(con);
    }
    if (result.hasErrors()) {
      containsErrors = true;
    }

    this.add(result);
  }

  /**
   * Instantiates a new method test result.
   *
   * @param how
   *          the how
   * @param path
   *          the path
   * @param pathOperation
   *          the path operation
   * @param target
   *          the target
   */
  public MethodTestResult(final Method how, String path, final Operation pathOperation,
      final Server target) {

    // Add parameters
    final List<String> queryParameters = new ArrayList<>();
    final Map<String, String> requestHeaders = new HashMap<>();

    if (pathOperation == null) {
      System.out.println("path:" + path);
    }
    if (pathOperation.getParameters() != null) {
      for (final Parameter para : pathOperation.getParameters()) {
        switch (para.getIn()) {
          case "query":
            queryParameters.add(HttpHandler.encodeQueryParameter(para.getName(),
                ExampleFactory.getExampleObject(para)));
            break;
          case "header":
            requestHeaders.put(para.getName(), ExampleFactory.getExampleObject(para));
            break;
          case "cookie":
            requestHeaders.put("Cookie",
                para.getName() + "=" + ExampleFactory.getExampleObject(para));
            break;
          case "path":
            path = path.replace("{" + para.getName() + "}", ExampleFactory.getExampleObject(para));
            break;
          default:
            throw new MalformedSwaggerYamlException("Unknown parameter type '" + para.getIn()
                + "' found in " + pathOperation.getOperationId() + ". (Parameter is called '"
                + para.getName() + "')");
        }
      }
    }
    // TODO: Refactor!
    final URL serverUrl = HttpHandler.getFinalServerUrl(target, path);
    final HttpURLConnection con = HttpHandler.getHttpConnection(serverUrl, how);

    for (final Entry<String, String> header : requestHeaders.entrySet()) {
      con.addRequestProperty(header.getKey(), header.getValue());
    }

    // Will fail on GET.
    con.setDoOutput(true);
    try {
      // TODO: Build example from RequestBody
      final OutputStream contentStream = con.getOutputStream();
      // pathOperation.getRequestBody()
      contentStream.write(0);
      contentStream.close();
    } catch (final IOException e) {
      throw new RuntimeException("Something bad happened with my IO.", e);
    }

    executeConnection(con);
  }

  @Override
  public boolean hasErrors() {
    return containsErrors;
  }

}
