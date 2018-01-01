package gehring.simon.hobby.swagger.testing;

import java.util.Map;
import java.util.logging.Logger;

import gehring.simon.hobby.swagger.model.v3_0.OpenApi;
import gehring.simon.hobby.swagger.model.v3_0.PathItem;
import gehring.simon.hobby.swagger.model.v3_0.Server;

public class SchemeTestResult extends TestResult {

    private static final Logger LOGGER = Logger.getLogger(SchemeTestResult.class.getName());

    private OpenApi api = null;

    public SchemeTestResult(final OpenApi api) {
        super();
        this.api = api;
    }

    public boolean executeTestsOnOneServer(final Server server) {
        Map<String, PathItem> paths = api.getPaths();
        ServerTestResult testResult = new ServerTestResult(server, paths);
        this.add(testResult);
        System.out.println(testResult);
        return true;
    }

    public boolean executeTestsOnAllServers() {
        Map<String, PathItem> paths = api.getPaths();
        LOGGER.info("Testing all paths of API '" + api.getInfo().getTitle() + "' (A total of " + paths.size()
                + " paths to test)");

        for (Server server : api.getServers()) {
            executeTestsOnOneServer(server);
        }

        return true;
    }

}
