package gehring.simon.hobby.swagger.testing;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

import gehring.simon.hobby.swagger.model.v3_0.Operation;
import gehring.simon.hobby.swagger.model.v3_0.Parameter;
import gehring.simon.hobby.swagger.model.v3_0.Server;
import gehring.simon.hobby.swagger.testing.http.Method;

public class MethodTestResult extends TestResult {

    private void executeConnection(final HttpURLConnection con) {
        // TODO: Do something with results.
        InputStream is;
        try {
            is = con.getInputStream();
        } catch (FileNotFoundException e) {
            // TODO: Put into results.
            System.out.println(con.getHeaderFields());
            try {
                System.out.println(con.getResponseCode());
                System.out.println(con.getErrorStream());

            } catch (IOException e1) {
                throw new RuntimeException(e1);
            }
            throw new RuntimeException("Apparently the file is not at home there. 404 or 410.", e);
        } catch (IOException e) {
            throw new RuntimeException("Something bad happened with my IO.", e);
        }
        Scanner scan = new Scanner(is);
        scan.useDelimiter("\\A");
        System.out.println(scan.hasNext() ? scan.next() : "");
        scan.close();
        try {
            is.close();
        } catch (IOException e) {
        }
    }

    public MethodTestResult(final Method how, String path, final Operation pathOperation, final Server target) {

        // Add parameters
        List<String> queryParameters = new ArrayList<>();
        Map<String, String> requestHeaders = new HashMap<>();
        for (Parameter para : pathOperation.getParameters())
            switch (para.getIn()) {
                case "query":
                    queryParameters.add(
                            HttpHandler.encodeQueryParameter(para.getName(), ExampleFactory.getExampleObject(para)));
                    break;
                case "header":
                    requestHeaders.put(para.getName(), ExampleFactory.getExampleObject(para));
                    break;
                case "cookie":
                    requestHeaders.put("Cookie", para.getName() + "=" + ExampleFactory.getExampleObject(para));
                    break;
                case "path":
                    path = path.replace("{" + para.getName() + "}", ExampleFactory.getExampleObject(para));
                    break;
                default:
                    throw new MalformedSwaggerYamlException("Unknown parameter type '" + para.getIn() + "' found in "
                            + pathOperation.getOperationId() + ". (Parameter is called '" + para.getName() + "')");
            }
        // TODO: Refactor!
        URL serverUrl = HttpHandler.getFinalServerUrl(target, path);
        HttpURLConnection con = HttpHandler.getHttpConnection(serverUrl, how);

        for (Entry<String, String> header : requestHeaders.entrySet())
            con.addRequestProperty(header.getKey(), header.getValue());

        // Will fail on GET.
        con.setDoOutput(true);
        try {
            // TODO: Build example from RequestBody
            OutputStream contentStream = con.getOutputStream();
            contentStream.write(null);
            contentStream.close();
        } catch (IOException e) {
            throw new RuntimeException("Something bad happened with my IO.", e);
        }

        executeConnection(con);
    }

    @Override
    public String toString() {
        return "Method test result (uninitialized arraylist, so we override toString())";
    }
}
