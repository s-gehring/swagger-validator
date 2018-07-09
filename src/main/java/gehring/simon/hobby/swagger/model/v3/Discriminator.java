/*
 *
 */

package gehring.simon.hobby.swagger.model.v3;

import com.fasterxml.jackson.annotation.JsonProperty;

import gehring.simon.hobby.swagger.model.SwaggerObject;

import java.util.Map;

// TODO: Auto-generated Javadoc
/**
 * The Class Discriminator.
 */
public class Discriminator extends SwaggerObject {

  /** The mapping. */
  @JsonProperty
  private Map<String, String> mapping;

  /** The property name. */
  @JsonProperty
  private String propertyName;

  /**
   * Gets the mapping.
   *
   * @return the mapping
   */
  public Map<String, String> getMapping() {
    return mapping;
  }

  /**
   * Gets the property name.
   *
   * @return the property name
   */
  public String getPropertyName() {
    return propertyName;
  }
}
