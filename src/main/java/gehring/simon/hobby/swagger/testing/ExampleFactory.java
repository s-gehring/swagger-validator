/*
 *
 */

package gehring.simon.hobby.swagger.testing;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import gehring.simon.hobby.swagger.model.v3.Example;
import gehring.simon.hobby.swagger.model.v3.Parameter;

// TODO: Auto-generated Javadoc
/**
 * A factory for creating Example objects.
 */
public class ExampleFactory {

  /**
   * Builds the custom example.
   *
   * @param para
   *          the para
   * @return the string
   */
  public static String buildCustomExample(final Parameter para) {
    // TODO: Implement this
    return "";
  }

  /**
   * Gets the example object.
   *
   * @param parameter
   *          the parameter
   * @return the example object
   */
  // TODO: Evtl. mehrere examples benutzen?
  public static String getExampleObject(final Parameter parameter) {
    if (parameter.getExample() == null) {
      if (parameter.getExample() == null
          || parameter.getExamples().isEmpty()) {
        return buildCustomExample(parameter);
      }
      return buildExampleFromExample(parameter.getExamples().values().iterator().next());
    }
    return buildExampleFromExample(parameter.getExample());
  }

  /**
   * Builds the example from example.
   *
   * @param paraExample
   *          the para example
   * @return the string
   */
  public static String buildExampleFromExample(final Example paraExample) {

    // TODO: global variable?
    final ObjectMapper m = new ObjectMapper();
    try {
      return m.writeValueAsString(paraExample);
    } catch (final JsonProcessingException e) {
      throw new RuntimeException(e);
    }
  }

}
