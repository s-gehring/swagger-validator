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
 * The Class Header.
 */
public class Header extends SwaggerObject {

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
   * Instantiates a new header.
   */
  public Header() {

  }

  /**
   * Instantiates a new header.
   *
   * @param reference
   *          the reference
   */
  public Header(final String reference) {
    super(reference);
  }

  /**
   * Sets the ability to pass empty-valued parameters. This is valid only for
   * query parameters and allows sending a parameter with an empty value. Default
   * value is false. If style is used, and if behavior is n/a (cannot be
   * serialized), the value of allowEmptyValue SHALL be ignored.
   *
   * @see Parameter#getAllowEmptyValue()
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
   * @see Parameter#getAllowReserved()
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
   * @see Parameter#getContent()
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
   * @see Parameter#getDeprecated()
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
   * @see Parameter#getDescription()
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
   * @see Parameter#getExample()
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
   * @see Parameter#getExamples()
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
   * the default value is true. For all other styles, the default value is false.
   *
   * @see Parameter#getExplode()
   *
   * @return the explode
   */
  public Boolean getExplode() {
    return explode;
  }

  /**
   * Determines whether this parameter is mandatory. If the parameter location is
   * "path", this property is REQUIRED and its value MUST be true. Otherwise, the
   * property MAY be included and its default value is false.
   *
   * @see Parameter#getRequired()
   *
   * @return the required
   */
  public Boolean getRequired() {
    return required;
  }

  /**
   * The schema defining the type used for the parameter.
   *
   * @see Parameter#getSchema()
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
   * @see Parameter#getStyle()
   *
   * @return the style
   */
  public String getStyle() {
    return style;
  }
}
