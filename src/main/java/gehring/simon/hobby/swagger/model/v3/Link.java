/*
 *
 */

package gehring.simon.hobby.swagger.model.v3;

import com.fasterxml.jackson.annotation.JsonProperty;

import gehring.simon.hobby.swagger.model.SwaggerObject;

import java.util.Map;

// TODO: Auto-generated Javadoc
/**
 * The Class Link.
 */
public class Link extends SwaggerObject {

  @JsonProperty
  private String description;

  @JsonProperty
  private String operationId;

  @JsonProperty
  private String operationRef;

  @JsonProperty
  private Map<String, Object> parameters;

  @JsonProperty
  private Object requestBody;

  @JsonProperty
  private Server server;

  /**
   * Instantiates a new link.
   *
   * @param reference
   *          the reference
   */
  public Link(final String reference) {
    super(reference);
  }

  /**
   * A description of the link. CommonMark syntax MAY be used for rich text
   * representation.
   *
   * @return the description
   */
  public String getDescription() {
    return description;
  }

  /**
   * The name of an existing, resolvable OAS operation, as defined with a unique
   * operationId. This field is mutually exclusive of the operationRef field.
   *
   * @return the operation id
   */
  public String getOperationId() {
    return operationId;
  }

  /**
   * A relative or absolute reference to an OAS operation. This field is mutually
   * exclusive of the operationId field, and MUST point to an Operation Object.
   * Relative operationRef values MAY be used to locate an existing Operation
   * Object in the OpenAPI definition.
   *
   * @return the operation ref
   */
  public String getOperationRef() {
    return operationRef;
  }

  /**
   * A map representing parameters to pass to an operation as specified with
   * operationId or identified via operationRef. The key is the parameter name to
   * be used, whereas the value can be a constant or an expression to be evaluated
   * and passed to the linked operation. The parameter name can be qualified using
   * the parameter location [{in}.]{name} for operations that use the same
   * parameter name in different locations (e.g. path.id).
   *
   * @return the parameters
   */
  public Map<String, Object> getParameters() {
    return parameters;
  }

  /**
   * A literal value or {expression} to use as a request body when calling the
   * target operation.
   *
   * @return the request body
   */
  public Object getRequestBody() {
    return requestBody;
  }

  /**
   * A server object to be used by the target operation.
   *
   * @return the server
   */
  public Server getServer() {
    return server;
  }
}
