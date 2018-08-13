/*
 *
 */

package gehring.simon.hobby.swagger.model;

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

import gehring.simon.hobby.swagger.testing.NotImplementedException;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * The parent class for all OpenAPI classes.
 */
public abstract class SwaggerObject {

    /** The Constant LOGGER. */
    protected static final Logger LOGGER = LogManager.getLogger(SwaggerObject.class.toString());

    /**
     * All properties, that are not explicitly defined in the OpenAPI definition go
     * in this {@link Map}<{@link String}, {@link JsonNode}>.
     */
    private final Map<String, JsonNode> otherProperties = new LinkedHashMap<>();

    /**
     * Instantiates a new swagger object.
     */
    public SwaggerObject() {
    }

    /**
     * Instantiates a new swagger object by a reference.
     *
     * @param ref
     *            The reference string.
     */
    @JsonCreator
    public SwaggerObject(@JsonProperty("$ref") final String ref) {
        final ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        mapper.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);

        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        URL url;
        try {

            url = new URL(ref);
            LOGGER.info("Loading external YAML: '" + ref + "'");
        } catch (final MalformedURLException e) {
            // TODO: Load local definitions.
            LOGGER.info("Loading internal definitions: '" + ref + "'.");
            throw new NotImplementedException();
        }
        InputStream is = null;
        try {
            is = url.openStream();
            mapper.readerForUpdating(this).readValue(is);
            is.close();
        } catch (final IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (final IOException e) {
                    throw new RuntimeException("Failed to close inputstream.", e);
                }
            }
        }
    }

    /**
     * Gets the unknown properties.
     *
     * @return the unknown properties
     */
    @JsonAnyGetter
    private Map<String, JsonNode> getUnknownProperties() {
        return otherProperties;
    }

    /**
     * Gets the unknown property.
     *
     * @param name
     *            the name
     * @return the unknown property
     */
    public JsonNode getUnknownProperty(final String name) {
        return otherProperties.get(name);
    }

    /**
     * Checks for unknown properties.
     *
     * @return true, if successful
     */
    public boolean hasUnknownProperties() {
        return !otherProperties.isEmpty();
    }

    /**
     * Sets the unknown property.
     *
     * @param name
     *            the name
     * @param value
     *            the value
     */
    @JsonAnySetter
    private void setUnknownProperty(final String name, final JsonNode value) {
        otherProperties.put(name, value);
    }

    /**
     * To json string.
     *
     * @return the string
     */
    public String toJsonString() {
        return toString();
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        try {
            final ObjectMapper x = new ObjectMapper();
            x.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);
            x.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
            x.configure(SerializationFeature.WRITE_NULL_MAP_VALUES, false);

            return x.writeValueAsString(this);
        } catch (final JsonProcessingException e) {
            throw new RuntimeException("Failed to serialize object to JSON.", e);
        }
    }

    /**
     * To yaml string.
     *
     * @return the string
     */
    public String toYamlString() {
        try {
            final YAMLMapper x = new YAMLMapper();
            x.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);
            x.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
            x.configure(SerializationFeature.WRITE_NULL_MAP_VALUES, false);
            return x.writeValueAsString(this);
        } catch (final JsonProcessingException e) {
            throw new RuntimeException("Failed to serialize object to YAML.", e);
        }
    }

}
