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
 * The Class OpenApi.
 */
public class OpenApi extends SwaggerObject {

  @JsonProperty
  private String openapi;

  @JsonProperty
  private Info info;

  @JsonProperty
  private List<Server> servers;

  @JsonProperty
  private Map<String, PathItem> paths;

  @JsonProperty
  private Components components;

  @JsonProperty
  private List<SecurityRequirement> security;

  @JsonProperty
  private List<Tag> tags;

  @JsonProperty
  private ExternalDocumentation externalDocs;

  /**
   * An element to hold various schemas for the specification.
   *
   * @return the components
   */
  public Components getComponents() {
    return components;
  }

  /**
   * Additional external documentation.
   *
   * @return the external docs
   */
  public ExternalDocumentation getExternalDocs() {
    return externalDocs;
  }

  /**
   * REQUIRED. Provides metadata about the API. The metadata MAY be used by
   * tooling as required.
   *
   * @return the info
   */
  public Info getInfo() {
    return info;
  }

  /**
   * REQUIRED. This string MUST be the semantic version number of the OpenAPI
   * Specification version that the OpenAPI document uses. The openapi field
   * SHOULD be used by tooling specifications and clients to interpret the OpenAPI
   * document. This is not related to the API info.version string.
   *
   * @return the openapi
   */
  public String getOpenapi() {
    return openapi;
  }

  /**
   * REQUIRED. The available paths and operations for the API.
   *
   * @return the paths
   */
  public Map<String, PathItem> getPaths() {
    return paths;
  }

  /**
   * A declaration of which security mechanisms can be used across the API. The
   * list of values includes alternative security requirement objects that can be
   * used. Only one of the security requirement objects need to be satisfied to
   * authorize a request. Individual operations can override this definition.
   *
   * @return the security
   */
  public List<SecurityRequirement> getSecurity() {
    return security;
  }

  /**
   * An array of Server Objects, which provide connectivity information to a
   * target server. If the servers property is not provided, or is an empty array,
   * the default value would be a Server Object with a url value of /.
   *
   * @return the servers
   */
  public List<Server> getServers() {
    return servers;
  }

  /**
   * A list of tags used by the specification with additional metadata. The order
   * of the tags can be used to reflect on their order by the parsing tools. Not
   * all tags that are used by the Operation Object must be declared. The tags
   * that are not declared MAY be organized randomly or based on the tools' logic.
   * Each tag name in the list MUST be unique.
   *
   * @return the tags
   */
  public List<Tag> getTags() {
    return tags;
  }

}
