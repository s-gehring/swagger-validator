package gehring.simon.hobby.swagger.model.v3_0;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

import gehring.simon.hobby.swagger.model.SwaggerObject;

public class Encoding extends SwaggerObject {

    @JsonProperty
    private String contentType;

    @JsonProperty
    private Map<String, Header> headers;

    @JsonProperty
    private String style;

    @JsonProperty
    private Boolean explode;

    @JsonProperty
    private Boolean allowReserved;

    public Boolean getAllowReserved() {
        return allowReserved;
    }

    public String getContentType() {
        return contentType;
    }

    public Boolean getExplode() {
        return explode;
    }

    public Map<String, Header> getHeaders() {
        return headers;
    }

    public String getStyle() {
        return style;
    }

}
