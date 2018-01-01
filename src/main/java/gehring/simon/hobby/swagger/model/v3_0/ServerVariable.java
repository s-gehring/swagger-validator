package gehring.simon.hobby.swagger.model.v3_0;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import gehring.simon.hobby.swagger.model.SwaggerObject;

public class ServerVariable extends SwaggerObject {

    @JsonProperty("enum")
    private List<String> _enum;

    @JsonProperty
    private String _default;

    @JsonProperty
    private String description;

    public String get_default() {
        return _default;
    }

    public List<String> get_enum() {
        return _enum;
    }

    public String getDescription() {
        return description;
    }
}
