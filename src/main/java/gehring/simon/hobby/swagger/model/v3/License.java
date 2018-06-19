/*
 *
 */

package gehring.simon.hobby.swagger.model.v3;

import com.fasterxml.jackson.annotation.JsonProperty;

import gehring.simon.hobby.swagger.model.SwaggerObject;

// TODO: Auto-generated Javadoc
/**
 * The Class License.
 */
public class License extends SwaggerObject {

  @JsonProperty
  private String name;

  @JsonProperty
  private String url;

  /**
   * REQUIRED. The license name used for the API.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * A URL to the license used for the API. MUST be in the format of a URL.
   *
   * @return the url
   */
  public String getUrl() {
    return url;
  }
}
