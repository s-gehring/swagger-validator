package gehring.simon.hobby.swagger.testing.results;

import java.net.HttpURLConnection;

public class TimeoutTestResult extends RuntimeException implements AtomicTestResult {

    private static final long       serialVersionUID = 4803365562612510337L;
    private final HttpURLConnection connection;

    public TimeoutTestResult(final Throwable cause, final HttpURLConnection underlyingConnection) {
        super(cause);
        connection = underlyingConnection;
    }

    public HttpURLConnection getConnection() {
        return connection;
    }

    @Override
    public boolean hasErrors() {
        return true;
    }

}
