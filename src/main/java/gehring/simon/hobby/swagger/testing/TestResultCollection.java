package gehring.simon.hobby.swagger.testing;

import gehring.simon.hobby.swagger.testing.results.TestResult;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class TestResultCollection<T extends TestResult> extends ArrayList<T> implements TestResult {

    public Collection<T> getCauses() {
        if (this.isEmpty()) {
            throw new IllegalStateException(
                    "Trying to get error causes of an empty test result collection.");
        }
        List<T> causes = new LinkedList<>();
        for (T result : this) {
            if (result.hasErrors())
                causes.add(result);
        }

        return causes;
    }

    @Override
    public boolean hasErrors() {

        for (T result : this) {
            if (result.hasErrors())
                return true;
        }

        return false;
    }

}
