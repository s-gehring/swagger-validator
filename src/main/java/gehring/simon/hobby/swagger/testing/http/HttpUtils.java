/*
 *
 */

package gehring.simon.hobby.swagger.testing.http;

import gehring.simon.hobby.swagger.model.v3.Server;
import gehring.simon.hobby.swagger.testing.MalformedSwaggerYamlException;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;

// TODO: Auto-generated Javadoc
/**
 * The Class HttpHandler.
 */
public class HttpUtils {

    private HttpUtils() {
        // Util Class
    }

    /**
     * Encode query parameter.
     *
     * @param key
     *            the key
     * @param value
     *            the value
     * @return the string
     */
    public static String encodeQueryParameter(final String key, final String value) {
        try {
            return URLEncoder.encode(key, "UTF-8") + "=" + URLEncoder.encode(value, "UTF-8");
        } catch (final UnsupportedEncodingException e1) {
            throw new RuntimeException(
                    "Your computer doesn't seem to understand UTF-8. Throw it away!",
                    e1);
        } catch (NullPointerException e) {
            String errMsg = "Cannot encode query parameter. ";
            if (key == null && value == null) {
                errMsg += "Both, the key and the value are null.";
            } else if (key == null) {
                errMsg += "The key is null. The value would be '" + value + "'"
                        + (value.length() == 0 ? " (empty String)." : ".");
            } else if (value == null) {
                errMsg += "The value is null. The key is '" + key + "'"
                        + (key.length() == 0 ? " (empty String)." : ".");
            } else {
                errMsg += "Can't find a reason why though.";
            }
            throw new RuntimeException(errMsg, e);
        }
    }

    /**
     * Gets the final server url.
     *
     * @param target
     *            the target
     * @param path
     *            the path
     * @return the final server url
     */
    public static URL getFinalServerUrl(final Server target, final String path) {
        URL serverUrl;
        try {
            serverUrl = new URL(target.getUrl() + path);
        } catch (final MalformedURLException e) {
            throw new MalformedSwaggerYamlException(
                    "Server URL '" + target.getUrl() + path + "' malformed.", e);
        }
        return serverUrl;
    }

    /**
     * Gets the http connection.
     *
     * @param serverUrl
     *            the server url
     * @param how
     *            the how
     * @return the http connection
     */
    public static HttpURLConnection getHttpConnection(final URL serverUrl, final Method how) {
        HttpURLConnection con;
        try {
            con = (HttpURLConnection) serverUrl.openConnection();
        } catch (final IOException e) {
            throw new RuntimeException("Failed to connect to server " + serverUrl + ".", e);
        }
        try {
            con.setRequestMethod(how.name());
        } catch (final ProtocolException e) {
            throw new MalformedSwaggerYamlException(
                    "An unknown method has been requested: '" + how.name() + "' (" + how.toString()
                            + ").",
                    e);
        }
        // TODO: Hardcoded?
        con.setRequestProperty("accept", "application/json");
        con.setRequestProperty("content-type", "application/json");
        return con;
    }
}
