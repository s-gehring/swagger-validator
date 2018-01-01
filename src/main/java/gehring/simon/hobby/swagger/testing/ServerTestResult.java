package gehring.simon.hobby.swagger.testing;

import java.util.Map;
import java.util.Map.Entry;

import gehring.simon.hobby.swagger.model.v3_0.PathItem;
import gehring.simon.hobby.swagger.model.v3_0.Server;

public class ServerTestResult extends TestResult {

    public ServerTestResult(final Server server, final Map<String, PathItem> paths) {
        super();
        for (Entry<String, PathItem> pathEntries : paths.entrySet()) {
            this.add(new PathTestResult(pathEntries.getKey(), pathEntries.getValue(), server));
        }

    }
}
