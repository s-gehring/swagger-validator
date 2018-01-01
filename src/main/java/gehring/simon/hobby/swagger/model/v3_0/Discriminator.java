package gehring.simon.hobby.swagger.model.v3_0;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

import gehring.simon.hobby.swagger.model.SwaggerObject;

public class Discriminator extends SwaggerObject {

    @JsonProperty
    private String propertyName;

    @JsonProperty
    private Map<String, String> mapping;

    public Map<String, String> getMapping() {
        return mapping;
    }

    public String getPropertyName() {
        return propertyName;
    }
}
