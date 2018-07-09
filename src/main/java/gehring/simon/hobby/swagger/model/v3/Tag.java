/*
 *
 */

package gehring.simon.hobby.swagger.model.v3;

import com.fasterxml.jackson.annotation.JsonProperty;

import gehring.simon.hobby.swagger.model.SwaggerObject;

// TODO: Auto-generated Javadoc
/**
 * The Class Tag.
 */
public class Tag extends SwaggerObject {

  @JsonProperty
  private String description;

  @JsonProperty
  private ExternalDocumentation externalDocs;

  @JsonProperty
  private String name;

  /**
   * A short description for the tag. CommonMark syntax MAY be used for rich text
   * representation.
   *
   * @return the description
   */
  public String getDescription() {
    return description;
  }

  /**
   * Additional external documentation for this tag.
   *
   * @return the external docs
   */
  public ExternalDocumentation getExternalDocs() {
    return externalDocs;
  }

  /**
   * REQUIRED. The name of the tag.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

}
