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
 * The Class Parameter.
 */
public class Parameter extends SwaggerObject {

  @JsonProperty
  private String name;

  @JsonProperty
  private String in;

  @JsonProperty
  private String description;

  @JsonProperty
  private Boolean required;

  @JsonProperty
  private Boolean deprecated;

  @JsonProperty
  private Boolean allowEmptyValue;

  @JsonProperty
  private String style;

  @JsonProperty
  private Boolean explode;

  @JsonProperty
  private Boolean allowReserved;

  @JsonProperty
  private Schema schema;

  @JsonProperty
  private Example example; // In spec it's actually "Any", and not example.

  @JsonProperty
  private Map<String, Example> examples;

  @JsonProperty
  private Map<String, MediaType> content;

  /**
   * Sets the ability to pass empty-valued parameters. This is valid only for
   * query parameters and allows sending a parameter with an empty value. Default
   * value is false. If style is used, and if behavior is n/a (cannot be
   * serialized), the value of allowEmptyValue SHALL be ignored.
   *
   * @return the allow empty value
   */
  public Boolean getAllowEmptyValue() {
    return allowEmptyValue;
  }

  /**
   * Determines whether the parameter value SHOULD allow reserved characters, as
   * defined by RFC3986 :/?#[]@!$&'()*+,;= to be included without
   * percent-encoding. This property only applies to parameters with an in value
   * of query. The default value is false.
   *
   * @return the allow reserved
   */
  public Boolean getAllowReserved() {
    return allowReserved;
  }

  /**
   * A map containing the representations for the parameter. The key is the media
   * type and the value describes it. The map MUST only contain one entry.
   *
   * @return the content
   */
  public Map<String, MediaType> getContent() {
    return content;
  }

  /**
   * Specifies that a parameter is deprecated and SHOULD be transitioned out of
   * usage.
   *
   * @return the deprecated
   */
  public Boolean getDeprecated() {
    return deprecated;
  }

  /**
   * A brief description of the parameter. This could contain examples of use.
   * CommonMark syntax MAY be used for rich text representation.
   *
   * @return the description
   */
  public String getDescription() {
    return description;
  }

  /**
   * Example of the media type. The example SHOULD match the specified schema and
   * encoding properties if present. The example object is mutually exclusive of
   * the examples object. Furthermore, if referencing a schema which contains an
   * example, the example value SHALL override the example provided by the schema.
   * To represent examples of media types that cannot naturally be represented in
   * JSON or YAML, a string value can contain the example with escaping where
   * necessary.
   *
   * @return the example
   */
  public Example getExample() {
    return example;
  }

  /**
   * Examples of the media type. Each example SHOULD contain a value in the
   * correct format as specified in the parameter encoding. The examples object is
   * mutually exclusive of the example object. Furthermore, if referencing a
   * schema which contains an example, the examples value SHALL override the
   * example provided by the schema.
   *
   * @return the examples
   */
  public Map<String, Example> getExamples() {
    return examples;
  }

  /**
   * When this is true, parameter values of type array or object generate separate
   * parameters for each value of the array or key-value pair of the map. For
   * other types of parameters this property has no effect. When style is form,
   *
   * @return the explode
   */
  public Boolean getExplode() {
    return explode;
  }

  /**
   * REQUIRED. The location of the parameter. Possible values are "query",
   * "header", "path" or "cookie".
   *
   * @return the in
   */
  public String getIn() {
    return in;
  }

  /**
   * REQUIRED. The name of the parameter. Parameter names are case sensitive.
   * <br />
   * <ul>
   * <li>If in is "path", the name field MUST correspond to the associated path
   * segment from the path field in the Paths Object. See Path Templating for
   * further information.</li>
   * <li>If in is "header" and the name field is "Accept", "Content-Type" or
   * "Authorization", the parameter definition SHALL be ignored.</li>
   * <li>For all other cases, the name corresponds to the parameter name used by
   * the {@link Parameter#getIn()} property.</li>
   * </ul>
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Determines whether this parameter is mandatory. If the parameter location is
   * "path", this property is REQUIRED and its value MUST be true. Otherwise, the
   * property MAY be included and its default value is false.
   *
   * @return the required
   */
  public Boolean getRequired() {
    return required;
  }

  /**
   * The schema defining the type used for the parameter.
   *
   * @return the schema
   */
  public Schema getSchema() {
    return schema;
  }

  /**
   * Describes how the parameter value will be serialized depending on the type of
   * the parameter value. Default values (based on value of in): for query - form;
   * for path - simple; for header - simple; for cookie - form.
   *
   * @return the style
   */
  public String getStyle() {
    return style;
  }
}
