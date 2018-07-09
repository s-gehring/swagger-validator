/*
 *
 */

package gehring.simon.hobby.swagger.model.v3;

import com.fasterxml.jackson.annotation.JsonProperty;

import gehring.simon.hobby.swagger.model.SwaggerObject;

import java.util.Map;

// TODO: Auto-generated Javadoc
/**
 * The Class Encoding.
 */
public class Encoding extends SwaggerObject {

  @JsonProperty
  private Boolean allowReserved;

  @JsonProperty
  private String contentType;

  @JsonProperty
  private Boolean explode;

  @JsonProperty
  private Map<String, Header> headers;

  @JsonProperty
  private String style;

  /**
   * Determines whether the parameter value SHOULD allow reserved characters, as
   * defined by RFC3986 :/?#[]@!$&'()*+,;= to be included without
   * percent-encoding. The default value is false. This property SHALL be ignored
   * if the request body media type is not application/x-www-form-urlencoded.
   *
   * @return the allow reserved
   */
  public Boolean getAllowReserved() {
    return allowReserved;
  }

  /**
   * The Content-Type for encoding a specific property. Default value depends on
   * the property type: for string with format being binary –
   * application/octet-stream; for other primitive types – text/plain; for object
   * - application/json; for array – the default is defined based on the inner
   * type. The value can be a specific media type (e.g. application/json), a
   * wildcard media type (e.g. image/*), or a comma-separated list of the two
   * types.
   *
   * @return the content type
   */
  public String getContentType() {
    return contentType;
  }

  /**
   * When this is true, property values of type array or object generate separate
   * parameters for each value of the array, or key-value-pair of the map. For
   * other types of properties this property has no effect. When style is form,
   * the default value is true. For all other styles, the default value is false.
   * This property SHALL be ignored if the request body media type is not
   * application/x-www-form-urlencoded.
   *
   * @return the explode
   */
  public Boolean getExplode() {
    return explode;
  }

  /**
   * A map allowing additional information to be provided as headers, for example
   * Content-Disposition. Content-Type is described separately and SHALL be
   * ignored in this section. This property SHALL be ignored if the request body
   * media type is not a multipart.
   *
   * @return the headers
   */
  public Map<String, Header> getHeaders() {
    return headers;
  }

  /**
   * Describes how a specific property value will be serialized depending on its
   * type. See Parameter Object for details on the style property. The behavior
   * follows the same values as query parameters, including default values. This
   * property SHALL be ignored if the request body media type is not
   * application/x-www-form-urlencoded.
   *
   * @return the style
   */
  public String getStyle() {
    return style;
  }

}
