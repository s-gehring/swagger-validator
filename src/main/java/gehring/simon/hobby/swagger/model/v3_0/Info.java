package gehring.simon.hobby.swagger.model.v3_0;

import com.fasterxml.jackson.annotation.JsonProperty;

import gehring.simon.hobby.swagger.model.SwaggerObject;

public class Info extends SwaggerObject {

    @JsonProperty
    private String title;

    @JsonProperty
    private String description;

    @JsonProperty
    private String termsOfService;

    @JsonProperty
    private Contact contact;

    @JsonProperty
    private License license;

    @JsonProperty
    private String version;

    public Contact getContact() {
        return contact;
    }

    public String getDescription() {
        return description;
    }

    public License getLicense() {
        return license;
    }

    public String getTermsOfService() {
        return termsOfService;
    }

    public String getTitle() {
        return title;
    }

    public String getVersion() {
        return version;
    }

}
