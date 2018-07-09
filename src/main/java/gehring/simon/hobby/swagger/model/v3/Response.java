/*
 *
 */

package gehring.simon.hobby.swagger.model.v3;

import com.fasterxml.jackson.annotation.JsonProperty;

import gehring.simon.hobby.swagger.model.SwaggerObject;

import java.util.Map;

// TODO: Auto-generated Javadoc
/**
 * The Class Response.
 */
public class Response extends SwaggerObject {

  @JsonProperty
  private Map<String, MediaType> content;

  @JsonProperty
  private String description;

  @JsonProperty
  private Map<String, Header> headers;

  @JsonProperty
  private Map<String, Link> links;

  /**
   * Instantiates a new response.
   */
  public Response() {

  }

  /**
   * Instantiates a new response.
   *
   * @param reference
   *          the reference
   */
  public Response(final String reference) {
    super(reference);
  }

  /**
   * A map containing descriptions of potential response payloads. The key is a
   * media type or media type range and the value describes it. For responses that
   * match multiple keys, only the most specific key is applicable. e.g.
   * text/plain overrides text/*
   *
   * @return the content
   */
  public Map<String, MediaType> getContent() {
    return content;
  }

  /**
   * REQUIRED. A short description of the response. CommonMark syntax MAY be used
   * for rich text representation.
   * 
   * @return description
   *         the description
   */
  public String getDescription() {
    return description;
  }

  /**
   * Maps a header name to its definition. RFC7230 states header names are case
   * insensitive. If a response header is defined with the name "Content-Type", it
   * SHALL be ignored.
   *
   * @return the headers
   */
  public Map<String, Header> getHeaders() {
    return headers;
  }

  /**
   * A map of operations links that can be followed from the response. The key of
   * the map is a short name for the link, following the naming constraints of the
   * names for Component Objects.
   *
   * @return the links
   */
  public Map<String, Link> getLinks() {
    return links;
  }
}
