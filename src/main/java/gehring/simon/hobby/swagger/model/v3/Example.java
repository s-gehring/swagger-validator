/*
 *
 */

package gehring.simon.hobby.swagger.model.v3;

import com.fasterxml.jackson.annotation.JsonProperty;

import gehring.simon.hobby.swagger.model.SwaggerObject;

// TODO: Auto-generated Javadoc
/**
 * The Class Example.
 */
public class Example extends SwaggerObject {

  @JsonProperty
  private String summary;

  @JsonProperty
  private String description;

  @JsonProperty
  private Object value;

  @JsonProperty
  private String externalValue;

  /**
   * Instantiates a new example.
   */
  public Example() {
    super();
  }

  /**
   * Instantiates a new example.
   *
   * @param reference
   *          the reference
   */
  public Example(final String reference) {
    super(reference);
  }

  /**
   * Long description for the example. CommonMark syntax MAY be used for rich text
   * representation.
   *
   * @return the description
   */
  public String getDescription() {
    return description;
  }

  /**
   * A URL that points to the literal example. This provides the capability to
   * reference examples that cannot easily be included in JSON or YAML documents.
   * The value field and externalValue field are mutually exclusive.
   *
   * @return the external value
   */
  public String getExternalValue() {
    return externalValue;
  }

  /**
   * Short description for the example.
   *
   * @return the summary
   */
  public String getSummary() {
    return summary;
  }

  /**
   * Embedded literal example. The value field and externalValue field are
   * mutually exclusive. To represent examples of media types that cannot
   * naturally represented in JSON or YAML, use a string value to contain the
   * example, escaping where necessary.
   *
   * @return the value
   */
  public Object getValue() {
    return value;
  }
}
