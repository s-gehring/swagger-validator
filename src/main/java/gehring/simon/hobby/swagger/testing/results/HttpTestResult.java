package gehring.simon.hobby.swagger.testing.results;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class HttpTestResult implements AtomicTestResult {

    private static final long   serialVersionUID = -1502759378462075956L;
    private boolean             error;
    private int                 httpCode;
    private HttpURLConnection   connection;
    @SuppressWarnings("unused")
    private static final Logger LOGGER           = LogManager.getLogger(HttpTestResult.class);
    private String              content;

    private boolean isErroreousHttpResponseCode(final int httpCode) {
        return httpCode < 200 || httpCode >= 300;
    }

    private int getHttpResponseCode(final HttpURLConnection con) {
        try {
            return con.getResponseCode();
        } catch (IOException e) {
            throw new RuntimeException("Couldn't retrieve response code.", e);
        }

    }

    /**
     * Instantiates a new test result.
     *
     * @param connection
     *            The connection to extract the information from.
     */
    public HttpTestResult(final HttpURLConnection connection) {
        if (connection == null) {
            throw new NullPointerException("The connection to extract information from is null.");
        }
        httpCode = getHttpResponseCode(connection);
        error = isErroreousHttpResponseCode(httpCode);
        this.connection = connection;
    }

    public HttpURLConnection getConnection() {
        return connection;
    }

    @Override
    public boolean hasErrors() {
        return error;
    }

    private synchronized String getContent(final Charset charset) {
        if (content == null) {
            try {
                if (hasErrors()) {
                    InputStream inputStream = connection.getErrorStream();
                    if (inputStream == null) {
                        content = "";
                    } else {
                        content = getStringFromInputStream(inputStream, charset);
                    }
                } else {
                    content = getStringFromInputStream(connection.getInputStream(), charset);
                }
            } catch (IOException exception) {
                throw new RuntimeException("Failed to read HTTP response.");
            }
        }
        return content;
    }

    private String getStringFromInputStream(final InputStream input, final Charset charset)
            throws IOException {
        ByteArrayOutputStream result = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int length;
        while ((length = input.read(buffer)) != -1) {
            result.write(buffer, 0, length);
        }
        // StandardCharsets.UTF_8.name() > JDK 7
        return result.toString(charset.name());
    }

    public String toString(final Charset charset) {

        return getContent(charset);
    }

    @Override
    public String toString() {
        return toString(StandardCharsets.UTF_8);
    }

}
