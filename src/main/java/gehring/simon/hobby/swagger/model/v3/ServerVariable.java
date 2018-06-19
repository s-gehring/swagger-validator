/*
 *
 */

package gehring.simon.hobby.swagger.model.v3;

import com.fasterxml.jackson.annotation.JsonProperty;

import gehring.simon.hobby.swagger.model.SwaggerObject;

import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class ServerVariable.
 */
public class ServerVariable extends SwaggerObject {

  @JsonProperty("enum")
  private List<String> enumField;

  @JsonProperty
  private String defaultField;

  @JsonProperty
  private String description;

  /**
   * REQUIRED. The default value to use for substitution, and to send, if an
   * alternate value is not supplied. Unlike the Schema Object's default, this
   * value MUST be provided by the consumer.
   *
   * @return the default
   */
  public String getDefault() {
    return defaultField;
  }

  /**
   * An enumeration of string values to be used if the substitution options are
   * from a limited set.
   *
   * @return the enum
   */
  public List<String> getEnum() {
    return enumField;
  }

  /**
   * An optional description for the server variable. CommonMark syntax MAY be
   * used for rich text representation.
   *
   * @return the description
   */
  public String getDescription() {
    return description;
  }
}
