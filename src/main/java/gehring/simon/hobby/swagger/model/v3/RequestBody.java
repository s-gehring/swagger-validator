/*
 *
 */

package gehring.simon.hobby.swagger.model.v3;

import com.fasterxml.jackson.annotation.JsonProperty;

import gehring.simon.hobby.swagger.model.SwaggerObject;

import java.awt.PageAttributes.MediaType;
import java.util.Map;

// TODO: Auto-generated Javadoc
/**
 * The Class RequestBody.
 */
public class RequestBody extends SwaggerObject {

  @JsonProperty
  private String description;

  @JsonProperty
  private Map<String, MediaType> content;

  @JsonProperty
  private Boolean required;

  /**
   * Instantiates a new request body.
   *
   * @param reference
   *          the reference
   */
  public RequestBody(final String reference) {
    super(reference);
  }

  /**
   * REQUIRED. The content of the request body. The key is a media type or media
   * type range and the value describes it. For requests that match multiple keys,
   * only the most specific key is applicable. e.g. text/plain overrides text/*
   *
   * @return the content
   */
  public Map<String, MediaType> getContent() {
    return content;
  }

  /**
   * Determines if the request body is required in the request. Defaults to false.
   *
   * @return the required
   */
  public Boolean getRequired() {
    return required;
  }

  /**
   * A brief description of the request body. This could contain examples of use.
   * CommonMark syntax MAY be used for rich text representation.
   *
   * @return the description
   */
  public String getDescription() {
    return description;
  }
}
