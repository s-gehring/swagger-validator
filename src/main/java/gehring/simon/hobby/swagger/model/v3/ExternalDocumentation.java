/*
 *
 */

package gehring.simon.hobby.swagger.model.v3;

import com.fasterxml.jackson.annotation.JsonProperty;

import gehring.simon.hobby.swagger.model.SwaggerObject;

// TODO: Auto-generated Javadoc
/**
 * The Class ExternalDocumentation.
 */
public class ExternalDocumentation extends SwaggerObject {

  @JsonProperty
  private String description;

  @JsonProperty
  private String url;

  /**
   * A short description of the target documentation. CommonMark syntax MAY be
   * used for rich text representation.
   *
   * @return the description
   */
  public String getDescription() {
    return description;
  }

  /**
   * REQUIRED. The URL for the target documentation. Value MUST be in the format
   * of a URL.
   *
   * @return the url
   */
  public String getUrl() {
    return url;
  }
}
