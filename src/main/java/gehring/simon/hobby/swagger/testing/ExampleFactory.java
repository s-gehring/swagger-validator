/*
 *
 */

package gehring.simon.hobby.swagger.testing;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import gehring.simon.hobby.swagger.model.v3.Example;
import gehring.simon.hobby.swagger.model.v3.Parameter;
import gehring.simon.hobby.swagger.model.v3.Schema;

// TODO: Auto-generated Javadoc
/**
 * A factory for creating Example objects.
 */
public class ExampleFactory {

	public static String buildCustomExampleBySchema(Schema schema) {
		return null;
	}

	public static String buildCustomExample(final Parameter para) {
		/*
		 * Either schema or content is set. Not both.
		 */
		if (para.getSchema() == null && para.getContent() == null)
			throw new MalformedSwaggerYamlException("Parameter '" + para.getName() + "' with description '"
					+ para.getDescription() + "' has neither a schema nor a content definition.");

		if (para.getContent() != null && para.getSchema() != null)
			throw new MalformedSwaggerYamlException("Parameter '" + para.getName() + "' with description '"
					+ para.getDescription() + "' has a schema and a content definition. Cannot have both.");

		if (para.getSchema() != null) {
			return buildCustomExampleBySchema(para.getSchema());
		} else {
			// para.getContent != null
		}
		return null;
	}

	/**
	 * Gets the example object.
	 *
	 * @param parameter
	 *            the parameter
	 * @return the example object
	 */
	// TODO: Evtl. mehrere examples benutzen?
	public static String getExampleObject(final Parameter parameter) {
		if (parameter.getExample() == null) {
			if (parameter.getExample() == null || parameter.getExamples().isEmpty()) {
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
	 *            the para example
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
