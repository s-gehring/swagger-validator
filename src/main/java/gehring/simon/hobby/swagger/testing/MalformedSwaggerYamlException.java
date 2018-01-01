package gehring.simon.hobby.swagger.testing;

public class MalformedSwaggerYamlException extends RuntimeException {

    public MalformedSwaggerYamlException() {
        super();
    }

    public MalformedSwaggerYamlException(final String s) {
        super(s);
    }

    public MalformedSwaggerYamlException(final String s, final Throwable x) {
        super(s, x);
    }

    public MalformedSwaggerYamlException(final Throwable s) {
        super(s);
    }

}
