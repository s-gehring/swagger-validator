/*
 *
 */

package gehring.simon.hobby.swagger.model.v3;

import com.fasterxml.jackson.annotation.JsonProperty;

import gehring.simon.hobby.swagger.model.SwaggerObject;

import java.util.Map;

// TODO: Auto-generated Javadoc
/**
 * The Class Server.
 */
public class Server extends SwaggerObject {

  @JsonProperty
  private String description;

  @JsonProperty
  private String url;

  @JsonProperty
  private Map<String, ServerVariable> variables;

  /**
   * An optional string describing the host designated by the URL. CommonMark
   * syntax MAY be used for rich text representation.
   *
   * @return the description
   */
  public String getDescription() {
    return description;
  }

  /**
   * REQUIRED. A URL to the target host. This URL supports Server Variables and
   * MAY be relative, to indicate that the host location is relative to the
   * location where the OpenAPI document is being served. Variable substitutions
   * will be made when a variable is named in {brackets}.
   *
   * @return the url
   */
  public String getUrl() {
    return url;
  }

  /**
   * A map between a variable name and its value. The value is used for
   * substitution in the server's URL template.
   *
   * @return the variables
   */
  public Map<String, ServerVariable> getVariables() {
    return variables;
  }
}
