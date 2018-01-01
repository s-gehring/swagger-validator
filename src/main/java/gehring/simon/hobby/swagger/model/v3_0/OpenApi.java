package gehring.simon.hobby.swagger.model.v3_0;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

import gehring.simon.hobby.swagger.model.SwaggerObject;

public class OpenApi extends SwaggerObject {

    @JsonProperty
    private String openapi;

    @JsonProperty
    private Info info;

    @JsonProperty
    private List<Server> servers;

    @JsonProperty
    private Map<String, PathItem> paths;

    @JsonProperty
    private Components components;

    @JsonProperty
    private List<SecurityRequirement> security;

    @JsonProperty
    private List<Tag> tags;

    @JsonProperty
    private ExternalDocumentation externalDocs;

    @JsonProperty
    private Map<String, PathItem> definitions;

    @JsonProperty
    private Map<String, SecurityScheme> securityDefinitions;

    public Components getComponents() {
        return components;
    }

    public Map<String, PathItem> getDefinitions() {
        return definitions;
    }

    public ExternalDocumentation getExternalDocs() {
        return externalDocs;
    }

    public Info getInfo() {
        return info;
    }

    public String getOpenapi() {
        return openapi;
    }

    public Map<String, PathItem> getPaths() {
        return paths;
    }

    public List<SecurityRequirement> getSecurity() {
        return security;
    }

    public Map<String, SecurityScheme> getSecurityDefinitions() {
        return securityDefinitions;
    }

    public List<Server> getServers() {
        return servers;
    }

    public List<Tag> getTags() {
        return tags;
    }

}
