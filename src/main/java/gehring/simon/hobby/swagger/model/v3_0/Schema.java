package gehring.simon.hobby.swagger.model.v3_0;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;

import gehring.simon.hobby.swagger.model.SwaggerObject;

public class Schema extends SwaggerObject {

    @JsonProperty
    private String title;

    @JsonProperty
    private Integer multipleOf;

    @JsonProperty
    private Integer maximum;

    @JsonProperty
    private Boolean exclusiveMaximum;

    @JsonProperty
    private Integer minimum;

    @JsonProperty
    private Boolean exclusiveMinimum;

    @JsonProperty
    private Integer maxLength;

    @JsonProperty
    private Integer minLength;

    @JsonProperty
    private String pattern;

    @JsonProperty
    private Integer maxItems;

    @JsonProperty
    private Integer minItems;

    @JsonProperty
    private Boolean uniqueItems;

    @JsonProperty
    private Integer maxProperties;

    @JsonProperty
    private Integer minProperties;

    @JsonProperty
    private List<String> required;

    @JsonProperty("enum")
    private List<Object> _enum;

    @JsonProperty
    private String type;

    @JsonProperty
    private List<Schema> allOf;

    @JsonProperty
    private List<Schema> oneOf;

    @JsonProperty
    private List<Schema> anyOf;

    @JsonProperty
    private Schema not;

    @JsonProperty
    private Map<String, Schema> items;

    @JsonProperty
    private Schema properties;

    @JsonProperty
    private Object additionalProperties; // Actually boolean or schema

    @JsonProperty
    private String format;

    @JsonProperty("default")
    private Object _default;

    public Schema() {
        super();
    }

    public Schema(final String reference) throws JsonProcessingException, MalformedURLException, IOException {
        super(reference);
    }

    public Object get_default() {
        return _default;
    }

    public List<Object> get_enum() {
        return _enum;
    }

    public Object getAdditionalProperties() {
        return additionalProperties;
    }

    public List<Schema> getAllOf() {
        return allOf;
    }

    public List<Schema> getAnyOf() {
        return anyOf;
    }

    public Boolean getExclusiveMaximum() {
        return exclusiveMaximum;
    }

    public Boolean getExclusiveMinimum() {
        return exclusiveMinimum;
    }

    public String getFormat() {
        return format;
    }

    public Map<String, Schema> getItems() {
        return items;
    }

    public Integer getMaximum() {
        return maximum;
    }

    public Integer getMaxItems() {
        return maxItems;
    }

    public Integer getMaxLength() {
        return maxLength;
    }

    public Integer getMaxProperties() {
        return maxProperties;
    }

    public Integer getMinimum() {
        return minimum;
    }

    public Integer getMinItems() {
        return minItems;
    }

    public Integer getMinLength() {
        return minLength;
    }

    public Integer getMinProperties() {
        return minProperties;
    }

    public Integer getMultipleOf() {
        return multipleOf;
    }

    public Schema getNot() {
        return not;
    }

    public List<Schema> getOneOf() {
        return oneOf;
    }

    public String getPattern() {
        return pattern;
    }

    public Schema getProperties() {
        return properties;
    }

    public List<String> getRequired() {
        return required;
    }

    public String getTitle() {
        return title;
    }

    public String getType() {
        return type;
    }

    public Boolean getUniqueItems() {
        return uniqueItems;
    }

}
