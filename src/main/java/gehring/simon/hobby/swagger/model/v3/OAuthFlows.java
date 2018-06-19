/*
 *
 */

package gehring.simon.hobby.swagger.model.v3;

import com.fasterxml.jackson.annotation.JsonProperty;

import gehring.simon.hobby.swagger.model.SwaggerObject;

// TODO: Auto-generated Javadoc
/**
 * The Class OAuthFlows.
 */
public class OAuthFlows extends SwaggerObject {

  /** The implicit. */
  @JsonProperty
  private OAuthFlow implicit;

  /** The password. */
  @JsonProperty
  private OAuthFlow password;

  /** The client credentials. */
  @JsonProperty
  private OAuthFlow clientCredentials;

  /** The authorization code. */
  @JsonProperty
  private OAuthFlow authorizationCode;

  /**
   * Gets the authorization code.
   *
   * @return the authorization code
   */
  public OAuthFlow getAuthorizationCode() {
    return authorizationCode;
  }

  /**
   * Gets the client credentials.
   *
   * @return the client credentials
   */
  public OAuthFlow getClientCredentials() {
    return clientCredentials;
  }

  /**
   * Gets the implicit.
   *
   * @return the implicit
   */
  public OAuthFlow getImplicit() {
    return implicit;
  }

  /**
   * Gets the password.
   *
   * @return the password
   */
  public OAuthFlow getPassword() {
    return password;
  }
}
