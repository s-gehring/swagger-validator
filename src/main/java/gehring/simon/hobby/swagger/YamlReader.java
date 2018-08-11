/*
 *
 */

package gehring.simon.hobby.swagger;

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import gehring.simon.hobby.swagger.model.v3.OpenApi;
import gehring.simon.hobby.swagger.testing.MethodTestResult;
import gehring.simon.hobby.swagger.testing.PathTestResult;
import gehring.simon.hobby.swagger.testing.SchemeTestResult;
import gehring.simon.hobby.swagger.testing.ServerTestResult;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Collection;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// TODO: Auto-generated Javadoc
/**
 * The Class YamlReader.
 */
public class YamlReader {

    private static final Logger LOGGER = LogManager.getLogger(YamlReader.class);

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

        final URL yamlFile = new URL(
                "https://raw.githubusercontent.com/OAI/OpenAPI-Specification/master/examples/v3.0/petstore.yaml");

        final InputStream is = yamlFile.openStream();

        final YamlReader yaml = new YamlReader(is);

        is.close();
        final SchemeTestResult schemeTestResults = new SchemeTestResult(yaml.parsedYaml);
        schemeTestResults.executeTestsOnAllServers();

        if (schemeTestResults.hasErrors()) {
            Collection<ServerTestResult> serverCauses = schemeTestResults.getCauses();
            LOGGER.error("Scheme had " + serverCauses.size() + " errors.");
            for (ServerTestResult serverResult : serverCauses) {
                Collection<PathTestResult> pathCauses = serverResult.getCauses();
                LOGGER.error(
                        "---SERVER TEST RESULT----(" + pathCauses.size() + " errors) ------------");
                for (PathTestResult pathResult : pathCauses) {
                    Collection<MethodTestResult> methodCauses = pathResult.getCauses();
                    LOGGER.error("---PATH TEST RESULT----(" + methodCauses.size()
                            + " errors) ------------");
                    for (MethodTestResult methodResult : methodCauses) {
                        LOGGER.error(
                                "Method Test result (" + methodResult.getResult().getClass() + ")");
                        LOGGER.error(methodResult.getResult().toString());
                    }
                }

            }
        }

        for (ServerTestResult serverResult : schemeTestResults) {
            for (PathTestResult pathResult : serverResult) {
                for (MethodTestResult methodResult : pathResult) {
                    if (methodResult.hasErrors()) {
                        LOGGER.error(methodResult.getResult());
                    } else {
                        LOGGER.info(methodResult.getResult());
                    }
                }
            }
        }

        if (schemeTestResults.hasErrors()) {
            LOGGER.error("I encountered errors while testing '" + yamlFile.toString() + "' ("
                    + yaml.parsedYaml.getInfo().getTitle() + ")");

        }
        LOGGER.error("\n" + schemeTestResults.toString());

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
    public YamlReader(final InputStream is)
            throws JsonParseException, JsonMappingException, IOException {
        final ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        mapper.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        parsedYaml = mapper.readValue(is, OpenApi.class);
        System.out.println(parsedYaml);
        is.close();
    }
}
