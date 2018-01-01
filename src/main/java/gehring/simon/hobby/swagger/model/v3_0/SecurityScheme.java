package gehring.simon.hobby.swagger.model.v3_0;

import com.fasterxml.jackson.annotation.JsonProperty;

import gehring.simon.hobby.swagger.model.SwaggerObject;

public class SecurityScheme extends SwaggerObject {

    @JsonProperty
    private String type;
    @JsonProperty
    private String description;

    @JsonProperty
    private String name;

    @JsonProperty
    private String in;

    @JsonProperty
    private String scheme;

    @JsonProperty
    private String bearerFormat;

    @JsonProperty
    private OAuthFlows flows;

    @JsonProperty
    private String openIdConnectUrl;

    public SecurityScheme() {

    }

    public SecurityScheme(final String reference) {
        super(reference);
    }

    public String getBearerFormat() {
        return bearerFormat;
    }

    public String getDescription() {
        return description;
    }

    public OAuthFlows getFlows() {
        return flows;
    }

    public String getIn() {
        return in;
    }

    public String getName() {
        return name;
    }

    public String getOpenIdConnectUrl() {
        return openIdConnectUrl;
    }

    public String getScheme() {
        return scheme;
    }

    public String getType() {
        return type;
    }
}
