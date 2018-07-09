package gehring.simon.hobby.swagger.testing.results;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

public class HttpTestResult extends ErrorTestResult {

  private boolean error;
  private int     httpCode;
  private String  httpResponse;

  /**
   * Instantiates a new test result.
   *
   * @param connection
   *          The connection to extract the information from.
   */
  public HttpTestResult(final HttpURLConnection connection) {
    if (connection == null) {
      throw new NullPointerException("The connection to extract information from is null.");
    }
    httpCode = extractHttpCode(connection);
    error = extractErrorValue(httpCode);
    httpResponse = extractHttpResponse(connection, error);
  }

  private boolean extractErrorValue(final int httpCode) {
    return httpCode < 200 || httpCode >= 300;
  }

  private int extractHttpCode(final HttpURLConnection con) {
    try {
      return con.getResponseCode();

    } catch (IOException e) {
      throw new RuntimeException("Couldn't retrieve response code.", e);
    }

  }

  private String extractHttpResponse(final HttpURLConnection con, final boolean faulty) {

    InputStream is;
    if (faulty) {
      is = con.getErrorStream();
    } else {
      try {
        is = con.getInputStream();
      } catch (IOException e) {
        throw new RuntimeException("Failed to read HTTP response.", e);
      }
    }

    StringBuilder builder = new StringBuilder();
    BufferedReader br = new BufferedReader(new InputStreamReader(is));
    String line;

    try {
      while ((line = br.readLine()) != null) {
        builder.append(line);
      }
    } catch (IOException e) {
      throw new RuntimeException("Error reading HTTP Response.", e);
    } finally {
      if (br != null) {
        try {
          br.close();
        } catch (IOException e) {
          throw new RuntimeException("Error while closing erroreous BufferedReader.", e);
        }
      }
      if (is != null) {
        try {
          is.close();
        } catch (IOException e) {
          throw new RuntimeException("Error while closing erroreous InputStream.", e);
        }
      }
    }
    return builder.toString();
  }

  @Override
  public boolean hasErrors() {
    return error;
  }

  public String httpResponse() {
    return httpResponse;
  }

  public int httpResponseCode() {
    return httpCode;
  }

  @Override
  public String toString() {
    return super.toString() + "HTTP Response code was " + httpResponseCode() + ". The answer was "
        + httpResponse.length() + " characters long.";
  }
}
