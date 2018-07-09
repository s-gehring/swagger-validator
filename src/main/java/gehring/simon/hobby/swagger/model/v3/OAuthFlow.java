/*
 *
 */

package gehring.simon.hobby.swagger.model.v3;

import com.fasterxml.jackson.annotation.JsonProperty;

import gehring.simon.hobby.swagger.model.SwaggerObject;

import java.util.Map;

// TODO: Auto-generated Javadoc
/**
 * The Class OAuthFlow.
 */
public class OAuthFlow extends SwaggerObject {

  /** The authorization url. */
  @JsonProperty
  private String authorizationUrl;

  /** The refresh url. */
  @JsonProperty
  private String refreshUrl;

  /** The scopes. */
  @JsonProperty
  private Map<String, String> scopes;

  /** The token url. */
  @JsonProperty
  private String tokenUrl;

  /**
   * Gets the authorization url.
   *
   * @return the authorization url
   */
  public String getAuthorizationUrl() {
    return authorizationUrl;
  }

  /**
   * Gets the refresh url.
   *
   * @return the refresh url
   */
  public String getRefreshUrl() {
    return refreshUrl;
  }

  /**
   * Gets the scopes.
   *
   * @return the scopes
   */
  public Map<String, String> getScopes() {
    return scopes;
  }

  /**
   * Gets the token url.
   *
   * @return the token url
   */
  public String getTokenUrl() {
    return tokenUrl;
  }
}
