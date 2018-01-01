package gehring.simon.hobby.swagger.model.v3_0;

import com.fasterxml.jackson.annotation.JsonProperty;

import gehring.simon.hobby.swagger.model.SwaggerObject;

public class Example extends SwaggerObject {

    @JsonProperty
    private String summary;

    @JsonProperty
    private String description;

    @JsonProperty
    private Object value;

    @JsonProperty
    private String externalValue;

    public Example() {
        super();
    }

    public Example(final String reference) {
        super(reference);
    }

    public String getDescription() {
        return description;
    }

    public String getExternalValue() {
        return externalValue;
    }

    public String getSummary() {
        return summary;
    }

    public Object getValue() {
        return value;
    }
}
