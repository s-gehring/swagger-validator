package gehring.simon.hobby.swagger.model.v3_0;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

import gehring.simon.hobby.swagger.model.SwaggerObject;

public class MediaType extends SwaggerObject {

    @JsonProperty
    private Schema schema;

    @JsonProperty
    private Example example; // In spec it's actually "Any", not example

    @JsonProperty
    private Map<String, Example> examples;

    @JsonProperty
    private Map<String, Encoding> encoding;

    public Map<String, Encoding> getEncoding() {
        return encoding;
    }

    public Example getExample() {
        return example;
    }

    public Map<String, Example> getExamples() {
        return examples;
    }

    public Schema getSchema() {
        return schema;
    }
}
