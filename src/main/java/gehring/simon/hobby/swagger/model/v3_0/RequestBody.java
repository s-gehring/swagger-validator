package gehring.simon.hobby.swagger.model.v3_0;

import java.awt.PageAttributes.MediaType;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

import gehring.simon.hobby.swagger.model.SwaggerObject;

public class RequestBody extends SwaggerObject {

    @JsonProperty
    private String description;

    @JsonProperty
    private Map<String, MediaType> content;

    @JsonProperty
    private Boolean deprecated;

    public RequestBody(final String reference) {
        super(reference);
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
}
