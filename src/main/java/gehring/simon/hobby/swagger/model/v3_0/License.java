package gehring.simon.hobby.swagger.model.v3_0;

import com.fasterxml.jackson.annotation.JsonProperty;

import gehring.simon.hobby.swagger.model.SwaggerObject;

public class License extends SwaggerObject {

    @JsonProperty
    private String name;

    @JsonProperty
    private String url;

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }
}
