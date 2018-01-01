package gehring.simon.hobby.swagger.model.v3_0;

import java.awt.PageAttributes.MediaType;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

import gehring.simon.hobby.swagger.model.SwaggerObject;

public class Header extends SwaggerObject {

    @JsonProperty
    private String description;

    @JsonProperty
    private Boolean required;

    @JsonProperty
    private Boolean deprecated;

    @JsonProperty
    private Boolean allowEmptyValue;

    @JsonProperty
    private String style;

    @JsonProperty
    private Boolean explode;

    @JsonProperty
    private Boolean allowReserved;

    @JsonProperty
    private Schema schema;

    @JsonProperty
    private Example example; // In spec it's actually "Any", and not example.

    @JsonProperty
    private Map<String, Example> examples;

    @JsonProperty
    private Map<String, MediaType> content;

    public Header() {

    }

    public Header(final String reference) {
        super(reference);
    }

    public Boolean getAllowEmptyValue() {
        return allowEmptyValue;
    }

    public Boolean getAllowReserved() {
        return allowReserved;
    }

    public Map<String, MediaType> getContent() {
        return content;
    }

    public Boolean getDeprecated() {
        return deprecated;
    }

    public String getDescription() {
        return description;
    }

    public Example getExample() {
        return example;
    }

    public Map<String, Example> getExamples() {
        return examples;
    }

    public Boolean getExplode() {
        return explode;
    }

    public Boolean getRequired() {
        return required;
    }

    public Schema getSchema() {
        return schema;
    }

    public String getStyle() {
        return style;
    }
}
