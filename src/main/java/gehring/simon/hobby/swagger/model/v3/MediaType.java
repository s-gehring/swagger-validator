/*
 *
 */

package gehring.simon.hobby.swagger.model.v3;

import com.fasterxml.jackson.annotation.JsonProperty;

import gehring.simon.hobby.swagger.model.SwaggerObject;

import java.util.Map;

// TODO: Auto-generated Javadoc
/**
 * The Class MediaType.
 */
public class MediaType extends SwaggerObject {

  @JsonProperty
  private Map<String, Encoding> encoding;

  @JsonProperty
  private Example example; // In spec it's actually "Any", not example

  @JsonProperty
  private Map<String, Example> examples;

  @JsonProperty
  private Schema schema;

  /**
   * A map between a property name and its encoding information. The key, being
   * the property name, MUST exist in the schema as a property. The encoding
   * object SHALL only apply to requestBody objects when the media type is
   * multipart or application/x-www-form-urlencoded.
   *
   * @return the encoding
   */
  public Map<String, Encoding> getEncoding() {
    return encoding;
  }

  /**
   * Example of the media type. The example object SHOULD be in the correct format
   * as specified by the media type. The example object is mutually exclusive of
   * the examples object. Furthermore, if referencing a schema which contains an
   * example, the example value SHALL override the example provided by the schema.
   *
   * @return the example
   */
  public Example getExample() {
    return example;
  }

  /**
   * Examples of the media type. Each example object SHOULD match the media type
   * and specified schema if present. The examples object is mutually exclusive of
   * the example object. Furthermore, if referencing a schema which contains an
   * example, the examples value SHALL override the example provided by the
   * schema.
   *
   * @return the examples
   */
  public Map<String, Example> getExamples() {
    return examples;
  }

  /**
   * The schema defining the type used for the request body.
   *
   * @return the schema
   */
  public Schema getSchema() {
    return schema;
  }
}
