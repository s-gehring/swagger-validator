/*
 *
 */

package gehring.simon.hobby.swagger.testing;

import gehring.simon.hobby.swagger.model.v3.Operation;
import gehring.simon.hobby.swagger.model.v3.Parameter;
import gehring.simon.hobby.swagger.model.v3.Server;
import gehring.simon.hobby.swagger.testing.factories.ExampleFactory;
import gehring.simon.hobby.swagger.testing.http.HttpUtils;
import gehring.simon.hobby.swagger.testing.http.Method;
import gehring.simon.hobby.swagger.testing.results.AtomicTestResult;
import gehring.simon.hobby.swagger.testing.results.HttpTestResult;
import gehring.simon.hobby.swagger.testing.results.TestResult;
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

/**
 * The Class MethodTestResult.
 */
public class MethodTestResult implements TestResult {

    private static final long serialVersionUID = 7877212444555929400L;
    private AtomicTestResult  result;

    public AtomicTestResult getResult() {
        if (result == null) {
            throw new NullPointerException(
                    "No test result available, since tests haven't been run.");
        }
        return result;
    }

    /**
     * Executes connection and stores the result as a {@link AtomicTestResult}.
     *
     * @param httpConnection
     *            The connection to execute.
     */
    private void executeConnection(final HttpURLConnection httpConnection) {
        try {
            httpConnection.connect();
            result = new HttpTestResult(httpConnection);
        } catch (IOException timeoutException) {
            result = new TimeoutTestResult(timeoutException, httpConnection);
        }

    }

    /**
     * Instantiates a new method test result.
     *
     * @param how
     *            The HTTP {@link Method} to use.
     * @param path
     *            The path to test.
     * @param pathOperation
     *            The operation to test on the path.
     * @param target
     *            The target {@link Server}.
     */
    public MethodTestResult(final Method how, String path, final Operation pathOperation,
            final Server target) {

        // Add parameters
        final List<String> queryParameters = new ArrayList<>();
        final Map<String, String> requestHeaders = new HashMap<>();

        if (pathOperation == null) {
            System.out.println("path:" + path);
        }
        ExampleFactory exFactory = new ExampleFactory();
        if (pathOperation.getParameters() != null) {
            for (final Parameter para : pathOperation.getParameters()) {
                switch (para.getIn()) {
                    case "query":
                        queryParameters
                                .add(HttpUtils.encodeQueryParameter(para.getName(),
                                        exFactory.getExampleObject(para)));
                        break;
                    case "header":
                        requestHeaders.put(para.getName(), exFactory.getExampleObject(para));
                        break;
                    case "cookie":
                        requestHeaders.put("Cookie",
                                para.getName() + "=" + exFactory.getExampleObject(para));
                        break;
                    case "path":
                        path = path.replace("{" + para.getName() + "}",
                                exFactory.getExampleObject(para));
                        break;
                    default:
                        throw new MalformedSwaggerYamlException(
                                "Unknown parameter type '" + para.getIn() + "' found in "
                                        + pathOperation.getOperationId()
                                        + ". (Parameter is called '" + para.getName() + "')");
                }
            }
        }
        // TODO: Refactor!
        final URL serverUrl = HttpUtils.getFinalServerUrl(target, path);
        final HttpURLConnection con = HttpUtils.getHttpConnection(serverUrl, how);

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
        return getResult().hasErrors();
    }
}