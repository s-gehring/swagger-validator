package gehring.simon.hobby.swagger;

import java.util.List;
import java.util.StringJoiner;

import gehring.simon.hobby.swagger.model.v3_0.Schema;

public class VerificationResult {

    private List<Error>     errorTrace;
    private InstancedObject toVerify;
    private Schema          against;

    public VerificationResult(final InstancedObject toVerify, final Schema against, final List<Error> errorTrace) {
        this.toVerify = toVerify;
        this.against = against;
        this.errorTrace = errorTrace;
    }

    public boolean failed() {
        return errorTrace != null;
    }

    public List<Error> getErrorTrace() {
        return errorTrace;
    }

    public InstancedObject getObject() {
        return toVerify;
    }

    public Schema getScheme() {
        return against;
    }

    public boolean succeeded() {
        return !failed();
    }

    @Override
    public String toString() {
        if (failed()) {
            StringJoiner builder = new StringJoiner(" because of\n\t", "Result: Failed because of\n\t", "");
            builder.add("Result: Failed because of");
            for (Error err : errorTrace) {
                builder.add(err.toString());
                builder.add(" because of \n");
            }
            return builder.toString();
        }
        return "Success!";
    }
}
