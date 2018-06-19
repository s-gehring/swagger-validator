package gehring.simon.hobby.swagger.testing.results;

import java.net.HttpURLConnection;

public class TimeoutTestResult extends ErrorTestResult {

  private int connectTimeout;

  public TimeoutTestResult(final HttpURLConnection con) {
    connectTimeout = con.getConnectTimeout();
  }

  public int getTimeout() {
    return connectTimeout;
  }

  @Override
  public String toString() {
    return super.toString() + "The timeout of " + connectTimeout
        + " was reached before the server connected.";
  }

  @Override
  public boolean hasErrors() {
    return true;
  }

}
