package gehring.simon.hobby.swagger.testing;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import gehring.simon.hobby.swagger.model.v3_0.Example;
import gehring.simon.hobby.swagger.model.v3_0.Parameter;

public class ExampleFactory {

    public static String buildCustomExample(final Parameter para) {
        // TODO: Implement this
        return null;
    }

    // TODO: Evtl. mehrere examples benutzen?
    public static String getExampleObject(final Parameter parameter) {
        if (parameter.getExample() == null) {
            if (parameter.getExample() == null || parameter.getExamples().isEmpty())
                return buildCustomExample(parameter);
            return buildExampleFromExample(parameter.getExamples().values().iterator().next());
        }
        return "";
    }

    public static String buildExampleFromExample(final Example paraExample) {
        // TODO: global variable?
        ObjectMapper m = new ObjectMapper();
        try {
            return m.writeValueAsString(paraExample);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

}
