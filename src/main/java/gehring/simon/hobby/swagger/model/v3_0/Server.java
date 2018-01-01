package gehring.simon.hobby.swagger.model.v3_0;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

import gehring.simon.hobby.swagger.model.SwaggerObject;

public class Server extends SwaggerObject {

    @JsonProperty
    private String url;

    @JsonProperty
    private String description;

    @JsonProperty
    private Map<String, ServerVariable> variables;

    public String getDescription() {
        return description;
    }

    public String getUrl() {
        return url;
    }

    public Map<String, ServerVariable> getVariables() {
        return variables;
    }
}
