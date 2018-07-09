/*
 *
 */

package gehring.simon.hobby.swagger.model.v3;

import com.fasterxml.jackson.annotation.JsonProperty;

import gehring.simon.hobby.swagger.model.SwaggerObject;

import java.util.Map;

// TODO: Auto-generated Javadoc
/**
 * The Class Components.
 */
public class Components extends SwaggerObject {

  @JsonProperty
  private Map<String, Map<String, PathItem>> callbacks;

  @JsonProperty
  private Map<String, Example> examples;

  @JsonProperty
  private Map<String, Header> headers;

  @JsonProperty
  private Map<String, Link> links;

  @JsonProperty
  private Map<String, Parameter> parameters;

  @JsonProperty
  private Map<String, RequestBody> requestBodies;

  @JsonProperty
  private Map<String, Response> responses;

  @JsonProperty
  private Map<String, Schema> schemas;

  @JsonProperty
  private Map<String, SecurityScheme> securitySchemes;

  /**
   * An object to hold reusable Callback Objects.
   *
   * @return the callbacks
   */
  public Map<String, Map<String, PathItem>> getCallbacks() {
    return callbacks;
  }

  /**
   * An object to hold reusable Example Objects.
   *
   * @return the examples
   */
  public Map<String, Example> getExamples() {
    return examples;
  }

  /**
   * An object to hold reusable Header Objects.
   *
   * @return the headers
   */
  public Map<String, Header> getHeaders() {
    return headers;
  }

  /**
   * An object to hold reusable Link Objects.
   *
   * @return the links
   */
  public Map<String, Link> getLinks() {
    return links;
  }

  /**
   * An object to hold reusable Parameter Objects.
   *
   * @return the parameters
   */
  public Map<String, Parameter> getParameters() {
    return parameters;
  }

  /**
   * An object to hold reusable Request Body Objects.
   *
   * @return the requestBodies
   */
  public Map<String, RequestBody> getRequestBodies() {
    return requestBodies;
  }

  /**
   * An object to hold reusable Response Objects.
   *
   * @return the responses
   */
  public Map<String, Response> getResponses() {
    return responses;
  }

  /**
   * An object to hold reusable Schema Objects.
   *
   * @return the schemas
   */
  public Map<String, Schema> getSchemas() {
    return schemas;
  }

  /**
   * An object to hold reusable Security Scheme Objects.
   *
   * @return the securitySchemes
   */
  public Map<String, SecurityScheme> getSecuritySchemes() {
    return securitySchemes;
  }

}
