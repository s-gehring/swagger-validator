/*
 *
 */

package gehring.simon.hobby.swagger.model.v3;

import com.fasterxml.jackson.annotation.JsonProperty;

import gehring.simon.hobby.swagger.model.SwaggerObject;

// TODO: Auto-generated Javadoc
/**
 * The Class SecurityScheme.
 */
public class SecurityScheme extends SwaggerObject {

  /** The type. */
  @JsonProperty
  private String type;

  /** The description. */
  @JsonProperty
  private String description;

  /** The name. */
  @JsonProperty
  private String name;

  /** The in. */
  @JsonProperty
  private String in;

  /** The scheme. */
  @JsonProperty
  private String scheme;

  /** The bearer format. */
  @JsonProperty
  private String bearerFormat;

  /** The flows. */
  @JsonProperty
  private OAuthFlows flows;

  /** The open id connect url. */
  @JsonProperty
  private String openIdConnectUrl;

  /**
   * Instantiates a new security scheme.
   */
  public SecurityScheme() {
    super();
  }

  /**
   * Instantiates a new security scheme.
   *
   * @param reference
   *          the reference
   */
  public SecurityScheme(final String reference) {
    super(reference);
  }

  /**
   * Gets the bearer format.
   *
   * @return the bearer format
   */
  public String getBearerFormat() {
    return bearerFormat;
  }

  /**
   * Gets the description.
   *
   * @return the description
   */
  public String getDescription() {
    return description;
  }

  /**
   * Gets the flows.
   *
   * @return the flows
   */
  public OAuthFlows getFlows() {
    return flows;
  }

  /**
   * Gets the in.
   *
   * @return the in
   */
  public String getIn() {
    return in;
  }

  /**
   * Gets the name.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Gets the open id connect url.
   *
   * @return the open id connect url
   */
  public String getOpenIdConnectUrl() {
    return openIdConnectUrl;
  }

  /**
   * Gets the scheme.
   *
   * @return the scheme
   */
  public String getScheme() {
    return scheme;
  }

  /**
   * Gets the type.
   *
   * @return the type
   */
  public String getType() {
    return type;
  }
}
