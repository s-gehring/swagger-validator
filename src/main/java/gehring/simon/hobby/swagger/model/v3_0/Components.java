package gehring.simon.hobby.swagger.model.v3_0;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

import gehring.simon.hobby.swagger.model.SwaggerObject;

public class Components extends SwaggerObject {

    @JsonProperty
    private Map<String, Schema> schemas;

    @JsonProperty
    private Map<String, Response> responses;

    @JsonProperty
    private Map<String, Parameter> parameters;

    @JsonProperty
    private Map<String, Example> examples;

    @JsonProperty
    private Map<String, RequestBody> requestBodies;

    @JsonProperty
    private Map<String, Header> headers;

    @JsonProperty
    private Map<String, SecurityScheme> securitySchemes;

    @JsonProperty
    private Map<String, Link> links;

    @JsonProperty
    private Map<String, Map<String, PathItem>> callbacks;

    /**
     * @return the callbacks
     */
    public Map<String, Map<String, PathItem>> getCallbacks() {
        return callbacks;
    }

    /**
     * @return the examples
     */
    public Map<String, Example> getExamples() {
        return examples;
    }

    /**
     * @return the headers
     */
    public Map<String, Header> getHeaders() {
        return headers;
    }

    /**
     * @return the links
     */
    public Map<String, Link> getLinks() {
        return links;
    }

    /**
     * @return the parameters
     */
    public Map<String, Parameter> getParameters() {
        return parameters;
    }

    /**
     * @return the requestBodies
     */
    public Map<String, RequestBody> getRequestBodies() {
        return requestBodies;
    }

    /**
     * @return the responses
     */
    public Map<String, Response> getResponses() {
        return responses;
    }

    /**
     * @return the schemas
     */
    public Map<String, Schema> getSchemas() {
        return schemas;
    }

    /**
     * @return the securitySchemes
     */
    public Map<String, SecurityScheme> getSecuritySchemes() {
        return securitySchemes;
    }

}
