/*
 *
 */

package gehring.simon.hobby.swagger.model.v3;

import com.fasterxml.jackson.annotation.JsonProperty;

import gehring.simon.hobby.swagger.model.SwaggerObject;

import java.util.List;
import java.util.Map;

// TODO: Auto-generated Javadoc
/**
 * The Class Operation.
 */
public class Operation extends SwaggerObject {

  @JsonProperty
  private Map<String, Map<String, PathItem>> callbacks;

  @JsonProperty
  private Boolean deprecated;

  @JsonProperty
  private String description;

  @JsonProperty
  private ExternalDocumentation externalDocs;

  @JsonProperty
  private String operationId;

  @JsonProperty
  private List<Parameter> parameters;

  @JsonProperty
  private RequestBody requestBody;

  @JsonProperty
  private Map<String, Response> responses;

  @JsonProperty
  private List<SecurityRequirement> security;

  @JsonProperty
  private List<Server> servers;

  @JsonProperty
  private String summary;

  @JsonProperty
  private List<String> tags;

  /**
   * A map of possible out-of band callbacks related to the parent operation. The
   * key is a unique identifier for the Callback Object. Each value in the map is
   * a Callback Object that describes a request that may be initiated by the API
   * provider and the expected responses. The key value used to identify the
   * callback object is an expression, evaluated at runtime, that identifies a URL
   * to use for the callback operation.
   *
   * @return the callbacks
   */
  public Map<String, Map<String, PathItem>> getCallbacks() {
    return callbacks;
  }

  /**
   * Declares this operation to be deprecated. Consumers SHOULD refrain from usage
   * of the declared operation. Default value is false.
   *
   * @return the deprecated
   */
  public Boolean getDeprecated() {
    return deprecated;
  }

  /**
   * A verbose explanation of the operation behavior. CommonMark syntax MAY be
   * used for rich text representation.
   *
   * @return the description
   */
  public String getDescription() {
    return description;
  }

  /**
   * Additional external documentation for this operation.
   *
   * @return the external docs
   */
  public ExternalDocumentation getExternalDocs() {
    return externalDocs;
  }

  /**
   * Unique string used to identify the operation. The id MUST be unique among all
   * operations described in the API. Tools and libraries MAY use the operationId
   * to uniquely identify an operation, therefore, it is RECOMMENDED to follow
   * common programming naming conventions.
   *
   * @return the operation id
   */
  public String getOperationId() {
    return operationId;
  }

  /**
   * A list of parameters that are applicable for this operation. If a parameter
   * is already defined at the Path Item, the new definition will override it but
   * can never remove it. The list MUST NOT include duplicated parameters. A
   * unique parameter is defined by a combination of a name and location. The list
   * can use the Reference Object to link to parameters that are defined at the
   * OpenAPI Object's components/parameters.
   *
   * @return the parameters
   */
  public List<Parameter> getParameters() {
    return parameters;
  }

  /**
   * The request body applicable for this operation. The requestBody is only
   * supported in HTTP methods where the HTTP 1.1 specification RFC7231 has
   * explicitly defined semantics for request bodies. In other cases where the
   * HTTP spec is vague, requestBody SHALL be ignored by consumers.
   *
   * @return the request body
   */
  public RequestBody getRequestBody() {
    return requestBody;
  }

  /**
   * REQUIRED. The list of possible responses as they are returned from executing
   * this operation.
   *
   * @return the responses
   */
  public Map<String, Response> getResponses() {
    return responses;
  }

  /**
   * A declaration of which security mechanisms can be used for this operation.
   * The list of values includes alternative security requirement objects that can
   * be used. Only one of the security requirement objects need to be satisfied to
   * authorize a request. This definition overrides any declared top-level
   * security. To remove a top-level security declaration, an empty array can be
   * used.
   *
   * @return the security
   */
  public List<SecurityRequirement> getSecurity() {
    return security;
  }

  /**
   * An alternative server array to service this operation. If an alternative
   * server object is specified at the Path Item Object or Root level, it will be
   * overridden by this value.
   *
   * @return the servers
   */
  public List<Server> getServers() {
    return servers;
  }

  /**
   * A short summary of what the operation does.
   *
   * @return the summary
   */
  public String getSummary() {
    return summary;
  }

  /**
   * A list of tags for API documentation control. Tags can be used for logical
   * grouping of operations by resources or any other qualifier.
   *
   * @return the tags
   */
  public List<String> getTags() {
    return tags;
  }
}
