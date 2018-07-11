package gehring.simon.hobby.swagger.testing.results;

import java.net.HttpURLConnection;

public class TimeoutTestResult extends ErrorTestResult {

	private int connectTimeout;
	private final Premise premise;

	public TimeoutTestResult(final HttpURLConnection con, Premise premise) {
		connectTimeout = con.getConnectTimeout();
		this.premise = premise;
	}

	public int getTimeout() {
		return connectTimeout;
	}

	@Override
	public boolean hasErrors() {
		return true;
	}

	@Override
	public String toString() {
		return super.toString() + "The timeout of " + connectTimeout + " was reached before the server connected.";
	}

	@Override
	public String getDescription() {
		return "The timeout of " + connectTimeout + " was reached before the server connected.";
	}

	@Override
	public String getShortDescription() {
		return "The timeout of " + connectTimeout + " was reached before the server connected.";
	}

	@Override
	public Premise getPremise() {
		return premise;
	}

}
