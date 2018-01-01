package gehring.simon.hobby.swagger.testing.http;

public class MalformedRequestException extends RuntimeException {

    public MalformedRequestException() {
        super();
    }

    public MalformedRequestException(final String s) {
        super(s);
    }

    public MalformedRequestException(final String s, final Throwable x) {
        super(s, x);
    }

    public MalformedRequestException(final Throwable s) {
        super(s);
    }

}
