package gehring.simon.hobby.swagger.model.v3_0;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

import gehring.simon.hobby.swagger.model.SwaggerObject;

public class Response extends SwaggerObject {

    @JsonProperty
    private Map<String, Header> headers;

    @JsonProperty
    private Map<String, MediaType> content;

    @JsonProperty
    private Map<String, Link> links;

    public Response() {

    }

    public Response(final String reference) {
        super(reference);
    }

    public Map<String, MediaType> getContent() {
        return content;
    }

    public Map<String, Header> getHeaders() {
        return headers;
    }

    public Map<String, Link> getLinks() {
        return links;
    }
}
