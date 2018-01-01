package gehring.simon.hobby.swagger.model.v3_0;

import com.fasterxml.jackson.annotation.JsonProperty;

import gehring.simon.hobby.swagger.model.SwaggerObject;

public class ExternalDocumentation extends SwaggerObject {

    @JsonProperty
    private String description;

    @JsonProperty
    private String url;

    public String getDescription() {
        return description;
    }

    public String getUrl() {
        return url;
    }
}
