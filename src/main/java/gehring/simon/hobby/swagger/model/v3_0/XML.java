package gehring.simon.hobby.swagger.model.v3_0;

import com.fasterxml.jackson.annotation.JsonProperty;

import gehring.simon.hobby.swagger.model.SwaggerObject;

public class XML extends SwaggerObject {

    @JsonProperty
    private String name;

    @JsonProperty
    private String namespace;

    @JsonProperty
    private String prefix;

    @JsonProperty
    private Boolean attribute;

    @JsonProperty
    private Boolean wrapped;

    public Boolean getAttribute() {
        return attribute;
    }

    public String getName() {
        return name;
    }

    public String getNamespace() {
        return namespace;
    }

    public String getPrefix() {
        return prefix;
    }

    public Boolean getWrapped() {
        return wrapped;
    }
}
