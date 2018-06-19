/*
 *
 */

package gehring.simon.hobby.swagger.model.v3;

import com.fasterxml.jackson.annotation.JsonProperty;

import gehring.simon.hobby.swagger.model.SwaggerObject;

// TODO: Auto-generated Javadoc
/**
 * The Class Contact.
 */
public class Contact extends SwaggerObject {

  @JsonProperty
  private String name;

  @JsonProperty
  private String url;

  @JsonProperty
  private String email;

  /**
   * The email address of the contact person/organization. MUST be in the format
   * of an email address.
   *
   * @return the email
   */
  public String getEmail() {
    return email;
  }

  /**
   * The identifying name of the contact person/organization.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * The URL pointing to the contact information. MUST be in the format of a URL.
   *
   * @return the url
   */
  public String getUrl() {
    return url;
  }
}
