package gehring.simon.hobby.swagger.model.v3_0;

import com.fasterxml.jackson.annotation.JsonProperty;

import gehring.simon.hobby.swagger.model.SwaggerObject;

public class Tag extends SwaggerObject {

    @JsonProperty
    private String name;

    @JsonProperty
    private String description;

    @JsonProperty
    private ExternalDocumentation externalDocs;

    public String getDescription() {
        return description;
    }

    public ExternalDocumentation getExternalDocs() {
        return externalDocs;
    }

    public String getName() {
        return name;
    }

}
