package gehring.simon.hobby.swagger.testing;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;

import gehring.simon.hobby.swagger.model.v3.Server;
import gehring.simon.hobby.swagger.testing.http.Method;

public class HttpHandler {

	public static String encodeQueryParameter(final String key, final String value) {
		if (key == null && value == null)
			throw new IllegalArgumentException("Trying to encode query parameter, but key and value are null.");
		if (key == null)
			throw new IllegalArgumentException(
					"Trying to encode query parameter, but key is null. Value is '" + value + "'.");
		if (value == null)
			throw new IllegalArgumentException(
					"Trying to encode query parameter, but value is null. Key is '" + key + "'.");
		try {
			return URLEncoder.encode(key, "UTF-8") + "=" + URLEncoder.encode(value, "UTF-8");
		} catch (UnsupportedEncodingException e1) {
			throw new RuntimeException("Your computer doesn't seem to understand UTF-8. Throw it away!", e1);
		}
	}

	public static URL getFinalServerUrl(final Server target, final String path) {
		URL serverUrl;
		try {
			serverUrl = new URL(target.getUrl() + path);
		} catch (MalformedURLException e) {
			throw new MalformedSwaggerYamlException("Server URL '" + target.getUrl() + path + "' malformed.", e);
		}
		return serverUrl;
	}

	public static HttpURLConnection getHttpConnection(final URL serverUrl, final Method how) {
		HttpURLConnection con;
		try {
			con = (HttpURLConnection) serverUrl.openConnection();
		} catch (IOException e) {
			throw new RuntimeException("Failed to connect to server " + serverUrl + ".", e);
		}
		try {
			con.setRequestMethod(how.name());
		} catch (ProtocolException e) {
			throw new MalformedSwaggerYamlException(
					"An unknown method has been requested: '" + how.name() + "' (" + how.toString() + ").", e);
		}
		// TODO: Hardcoded?
		con.setRequestProperty("accept", "application/json");
		con.setRequestProperty("content-type", "application/json");
		return con;
	}
}
