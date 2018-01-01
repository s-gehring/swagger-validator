package gehring.simon.hobby.swagger.testing;

import java.util.ArrayList;
import java.util.StringJoiner;

public abstract class TestResult extends ArrayList<TestResult> {

    @Override
    public String toString() {
        StringJoiner builder = new StringJoiner(",", "{", "}");
        for (TestResult res : this) {
            builder.add(res.toString());
        }
        return builder.toString();
    }
}
