/*
 *
 */

package gehring.simon.hobby.swagger.model.v3;

import com.fasterxml.jackson.annotation.JsonProperty;

import gehring.simon.hobby.swagger.model.SwaggerObject;

import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class PathItem.
 */
public class PathItem extends SwaggerObject {

  @JsonProperty
  private String summary;

  @JsonProperty
  private String description;

  @JsonProperty
  private Operation get;

  @JsonProperty
  private Operation put;

  @JsonProperty
  private Operation post;

  @JsonProperty
  private Operation delete;

  @JsonProperty
  private Operation options;

  @JsonProperty
  private Operation head;

  @JsonProperty
  private Operation patch;

  @JsonProperty
  private Operation trace;

  @JsonProperty
  private List<Server> servers;

  @JsonProperty
  private List<Parameter> parameters;

  /**
   * A definition of a DELETE operation on this path.
   *
   * @return the delete
   */
  public Operation getDelete() {
    return delete;
  }

  /**
   * An optional, string description, intended to apply to all operations in this
   * path. CommonMark syntax MAY be used for rich text representation.
   *
   * @return the description
   */
  public String getDescription() {
    return description;
  }

  /**
   * A definition of a GET operation on this path.
   *
   * @return the gets the
   */
  public Operation getGet() {
    return get;
  }

  /**
   * A definition of a HEAD operation on this path.
   *
   * @return the head
   */
  public Operation getHead() {
    return head;
  }

  /**
   * A definition of a OPTIONS operation on this path.
   *
   * @return the options
   */
  public Operation getOptions() {
    return options;
  }

  /**
   * A list of parameters that are applicable for all the operations described
   * under this path. These parameters can be overridden at the operation level,
   * but cannot be removed there. The list MUST NOT include duplicated parameters.
   * A unique parameter is defined by a combination of a name and location. The
   * list can use the Reference Object to link to parameters that are defined at
   * the OpenAPI Object's components/parameters.
   *
   * @return the parameters
   */
  public List<Parameter> getParameters() {
    return parameters;
  }

  /**
   * A definition of a PATCH operation on this path.
   *
   * @return the patch
   */
  public Operation getPatch() {
    return patch;
  }

  /**
   * A definition of a POST operation on this path.
   *
   * @return the post
   */
  public Operation getPost() {
    return post;
  }

  /**
   * A definition of a PUT operation on this path.
   *
   * @return the put
   */
  public Operation getPut() {
    return put;
  }

  /**
   * An alternative server array to service all operations in this path.
   *
   * @return the servers
   */
  public List<Server> getServers() {
    return servers;
  }

  /**
   * An optional, string summary, intended to apply to all operations in this
   * path.
   *
   * @return the summary
   */
  public String getSummary() {
    return summary;
  }

  /**
   * A definition of a TRACE operation on this path.
   *
   * @return the trace
   */
  public Operation getTrace() {
    return trace;
  }
}
