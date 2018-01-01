package gehring.simon.hobby.swagger.model.v3_0;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import gehring.simon.hobby.swagger.model.SwaggerObject;

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

    public Operation getDelete() {
        return delete;
    }

    public String getDescription() {
        return description;
    }

    public Operation getGet() {
        return get;
    }

    public Operation getHead() {
        return head;
    }

    public Operation getOptions() {
        return options;
    }

    public List<Parameter> getParameters() {
        return parameters;
    }

    public Operation getPatch() {
        return patch;
    }

    public Operation getPost() {
        return post;
    }

    public Operation getPut() {
        return put;
    }

    public List<Server> getServers() {
        return servers;
    }

    public String getSummary() {
        return summary;
    }

    public Operation getTrace() {
        return trace;
    }
}
