package gehring.simon.hobby.swagger.model;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Logger;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

public abstract class SwaggerObject {

    protected static final Logger LOGGER          = Logger.getLogger(SwaggerObject.class.toString());
    private Map<String, JsonNode> otherProperties = new LinkedHashMap<>();

    public SwaggerObject() {
    }

    @JsonCreator
    public SwaggerObject(@JsonProperty("$ref") final String ref) {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        mapper.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);

        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        URL url;
        try {

            url = new URL(ref);
            LOGGER.info("Loading external YAML: '" + ref + "'");
        } catch (MalformedURLException e) {
            // TODO: Load local definitions.
            LOGGER.info("Loading internal definitions: '" + ref + "'.");
            return;
        }
        InputStream is = null;
        try {
            is = url.openStream();
            mapper.readerForUpdating(this).readValue(is);
            is.close();
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        } finally {
            if (is != null)
                try {
                    is.close();
                } catch (IOException e) {
                    throw new RuntimeException("Failed to close inputstream.", e);
                }
        }
    }

    @JsonAnyGetter
    private Map<String, JsonNode> getUnknownProperties() {
        return otherProperties;
    }

    public JsonNode getUnknownProperty(final String name) {
        return otherProperties.get(name);
    }

    public boolean hasUnknownProperties() {
        return !otherProperties.isEmpty();
    }

    @JsonAnySetter
    private void setUnknownProperty(final String name, final JsonNode value) {
        otherProperties.put(name, value);
    }

    public String toJsonString() {
        return toString();
    }

    @Override
    public String toString() {
        try {
            ObjectMapper x = new ObjectMapper();
            x.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);
            x.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
            x.configure(SerializationFeature.WRITE_NULL_MAP_VALUES, false);

            return x.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Failed to serialize object to JSON.", e);
        }
    }

    public String toYamlString() {
        try {
            YAMLMapper x = new YAMLMapper();
            x.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);
            x.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
            x.configure(SerializationFeature.WRITE_NULL_MAP_VALUES, false);
            return x.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Failed to serialize object to YAML.", e);
        }
    }

}
