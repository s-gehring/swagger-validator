/*
 *
 */

package gehring.simon.hobby.swagger.model.v3;

import com.fasterxml.jackson.annotation.JsonProperty;

import gehring.simon.hobby.swagger.model.SwaggerObject;

// TODO: Auto-generated Javadoc
/**
 * The Class Info.
 */
public class Info extends SwaggerObject {

  @JsonProperty
  private Contact contact;

  @JsonProperty
  private String description;

  @JsonProperty
  private License license;

  @JsonProperty
  private String termsOfService;

  @JsonProperty
  private String title;

  @JsonProperty
  private String version;

  /**
   * The contact information for the exposed API.
   *
   * @return the contact
   */
  public Contact getContact() {
    return contact;
  }

  /**
   * A short description of the application. CommonMark syntax MAY be used for
   * rich text representation.
   *
   * @return the description
   */
  public String getDescription() {
    return description;
  }

  /**
   * The license information for the exposed API.
   *
   * @return the license
   */
  public License getLicense() {
    return license;
  }

  /**
   * A URL to the Terms of Service for the API. MUST be in the format of a URL.
   *
   * @return the terms of service
   */
  public String getTermsOfService() {
    return termsOfService;
  }

  /**
   * REQUIRED. The title of the application.
   *
   * @return the title
   */
  public String getTitle() {
    return title;
  }

  /**
   * REQUIRED. The version of the OpenAPI document (which is distinct from the
   * OpenAPI Specification version or the API implementation version).
   *
   * @return the version
   */
  public String getVersion() {
    return version;
  }

}
