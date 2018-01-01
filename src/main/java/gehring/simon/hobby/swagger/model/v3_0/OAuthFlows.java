package gehring.simon.hobby.swagger.model.v3_0;

import com.fasterxml.jackson.annotation.JsonProperty;

import gehring.simon.hobby.swagger.model.SwaggerObject;

public class OAuthFlows extends SwaggerObject {

    @JsonProperty
    private OAuthFlow implicit;

    @JsonProperty
    private OAuthFlow password;

    @JsonProperty
    private OAuthFlow clientCredentials;

    @JsonProperty
    private OAuthFlow authorizationCode;

    public OAuthFlow getAuthorizationCode() {
        return authorizationCode;
    }

    public OAuthFlow getClientCredentials() {
        return clientCredentials;
    }

    public OAuthFlow getImplicit() {
        return implicit;
    }

    public OAuthFlow getPassword() {
        return password;
    }
}
