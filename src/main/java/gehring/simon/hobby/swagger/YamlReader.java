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

import gehring.simon.hobby.swagger.model.v3_0.OpenApi;
import gehring.simon.hobby.swagger.testing.SchemeTestResult;

public class YamlReader {

    public static void main(final String[] args)
            throws JsonParseException, JsonMappingException, FileNotFoundException, IOException {
        System.out.println(SwaggerObjectFactory.createExample(OpenApi.class));
        // System.exit(0);

        File yamlFile = new File("C:\\Users\\Simon\\Desktop\\someYaml.yaml");

        InputStream is = new FileInputStream(yamlFile);

        YamlReader yaml = new YamlReader(is);

        is.close();
        SchemeTestResult sv = new SchemeTestResult(yaml.parsedYaml);
        sv.executeTestsOnAllServers();

    }

    private OpenApi parsedYaml;

    public YamlReader(final InputStream is) throws JsonParseException, JsonMappingException, IOException {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        mapper.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        parsedYaml = mapper.readValue(is, OpenApi.class);
        System.out.println(parsedYaml);
        is.close();
    }
}
