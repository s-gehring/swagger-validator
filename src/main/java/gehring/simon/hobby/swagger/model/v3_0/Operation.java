package gehring.simon.hobby.swagger.model.v3_0;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

import gehring.simon.hobby.swagger.model.SwaggerObject;

public class Operation extends SwaggerObject {

    @JsonProperty
    private List<String> tags;

    @JsonProperty
    private String summary;

    @JsonProperty
    private String description;

    @JsonProperty
    private ExternalDocumentation externalDocs;

    @JsonProperty
    private String operationId;

    @JsonProperty
    private List<Parameter> parameters;

    @JsonProperty
    private RequestBody requestBody;

    @JsonProperty
    private Map<String, Response> responses;

    @JsonProperty
    private Map<String, Map<String, PathItem>> callbacks;

    @JsonProperty
    private Boolean deprecated;

    @JsonProperty
    private List<SecurityRequirement> security;

    @JsonProperty
    private List<Server> servers;

    public Map<String, Map<String, PathItem>> getCallbacks() {
        return callbacks;
    }

    public Boolean getDeprecated() {
        return deprecated;
    }

    public String getDescription() {
        return description;
    }

    public ExternalDocumentation getExternalDocs() {
        return externalDocs;
    }

    public String getOperationId() {
        return operationId;
    }

    public List<Parameter> getParameters() {
        return parameters;
    }

    public RequestBody getRequestBody() {
        return requestBody;
    }

    public Map<String, Response> getResponses() {
        return responses;
    }

    public List<SecurityRequirement> getSecurity() {
        return security;
    }

    public List<Server> getServers() {
        return servers;
    }

    public String getSummary() {
        return summary;
    }

    public List<String> getTags() {
        return tags;
    }
}
