/*
 *
 */

package gehring.simon.hobby.swagger.model.v3;

import com.fasterxml.jackson.annotation.JsonProperty;

import gehring.simon.hobby.swagger.model.SwaggerObject;

// TODO: Auto-generated Javadoc
/**
 * The Class XML.
 */
public class Xml extends SwaggerObject {

  /** The name. */
  @JsonProperty
  private String name;

  /** The namespace. */
  @JsonProperty
  private String namespace;

  /** The prefix. */
  @JsonProperty
  private String prefix;

  /** The attribute. */
  @JsonProperty
  private Boolean attribute;

  /** The wrapped. */
  @JsonProperty
  private Boolean wrapped;

  /**
   * Gets the attribute.
   *
   * @return the attribute
   */
  public Boolean getAttribute() {
    return attribute;
  }

  /**
   * Gets the name.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Gets the namespace.
   *
   * @return the namespace
   */
  public String getNamespace() {
    return namespace;
  }

  /**
   * Gets the prefix.
   *
   * @return the prefix
   */
  public String getPrefix() {
    return prefix;
  }

  /**
   * Gets the wrapped.
   *
   * @return the wrapped
   */
  public Boolean getWrapped() {
    return wrapped;
  }
}
