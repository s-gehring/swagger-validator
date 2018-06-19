/*
 *
 */

package gehring.simon.hobby.swagger;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import gehring.simon.hobby.swagger.model.v3.OpenApi;
import gehring.simon.hobby.swagger.testing.SchemeTestResult;

// TODO: Auto-generated Javadoc
/**
 * The Class YamlReader.
 */
public class YamlReader {

	/**
	 * The main method.
	 *
	 * @param args
	 *            the arguments
	 * @throws JsonParseException
	 *             the json parse exception
	 * @throws JsonMappingException
	 *             the json mapping exception
	 * @throws FileNotFoundException
	 *             the file not found exception
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public static void main(final String[] args)
			throws JsonParseException, JsonMappingException, FileNotFoundException, IOException {
		// System.out.println(SwaggerObjectFactory.createExample(OpenApi.class));
		// System.exit(0);

		final File yamlFile = new File("C:\\Users\\Simon\\Desktop\\someYaml.yaml");

		final InputStream is = new FileInputStream(yamlFile);

		final YamlReader yaml = new YamlReader(is);

		is.close();
		final SchemeTestResult sv = new SchemeTestResult(yaml.parsedYaml);
		sv.executeTestsOnAllServers();

	}

	/** The parsed yaml. */
	private final OpenApi parsedYaml;

	/**
	 * Instantiates a new yaml reader.
	 *
	 * @param is
	 *            the is
	 * @throws JsonParseException
	 *             the json parse exception
	 * @throws JsonMappingException
	 *             the json mapping exception
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public YamlReader(final InputStream is) throws JsonParseException, JsonMappingException, IOException {
		final ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
		mapper.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		parsedYaml = mapper.readValue(is, OpenApi.class);
		System.out.println(parsedYaml);
		is.close();
	}
}
