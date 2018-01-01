package gehring.simon.hobby.swagger.model.v3_0;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

import gehring.simon.hobby.swagger.model.SwaggerObject;

public class Link extends SwaggerObject {

    @JsonProperty
    private String operationRef;

    @JsonProperty
    private String operationId;

    @JsonProperty
    private Map<String, Object> parameters;

    @JsonProperty
    private Object requestBody;

    @JsonProperty
    private String description;

    @JsonProperty
    private Server server;

    public Link(final String reference) {
        super(reference);
    }

    public String getDescription() {
        return description;
    }

    public String getOperationId() {
        return operationId;
    }

    public String getOperationRef() {
        return operationRef;
    }

    public Map<String, Object> getParameters() {
        return parameters;
    }

    public Object getRequestBody() {
        return requestBody;
    }

    public Server getServer() {
        return server;
    }
}
