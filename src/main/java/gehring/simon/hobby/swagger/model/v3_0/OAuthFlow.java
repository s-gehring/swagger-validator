package gehring.simon.hobby.swagger.model.v3_0;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

import gehring.simon.hobby.swagger.model.SwaggerObject;

public class OAuthFlow extends SwaggerObject {

    @JsonProperty
    private String authorizationUrl;

    @JsonProperty
    private String tokenUrl;

    @JsonProperty
    private String refreshUrl;

    @JsonProperty
    private Map<String, String> scopes;

    public String getAuthorizationUrl() {
        return authorizationUrl;
    }

    public String getRefreshUrl() {
        return refreshUrl;
    }

    public Map<String, String> getScopes() {
        return scopes;
    }

    public String getTokenUrl() {
        return tokenUrl;
    }
}
