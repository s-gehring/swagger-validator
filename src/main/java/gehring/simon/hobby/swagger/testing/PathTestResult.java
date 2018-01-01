package gehring.simon.hobby.swagger.testing;

import java.util.logging.Logger;

import gehring.simon.hobby.swagger.model.v3_0.PathItem;
import gehring.simon.hobby.swagger.model.v3_0.Server;
import gehring.simon.hobby.swagger.testing.http.Method;

public class PathTestResult extends TestResult {

    private static final Logger LOGGER = Logger.getLogger(PathTestResult.class.getName());

    public PathTestResult(final String path, final PathItem pathOptions, final Server server) {
        super();
        LOGGER.info("Testing path '" + path + "'.");
        // GET, POST, DELETE, OPTIONS, HEAD, PATCH, TRACE, PUT
        if (pathOptions.getGet() != null)
            this.add(new MethodTestResult(Method.GET, path, pathOptions.getGet(), server));
        if (pathOptions.getPost() != null)
            this.add(new MethodTestResult(Method.POST, path, pathOptions.getPost(), server));
        if (pathOptions.getDelete() != null)
            this.add(new MethodTestResult(Method.DELETE, path, pathOptions.getDelete(), server));
        if (pathOptions.getOptions() != null)
            this.add(new MethodTestResult(Method.OPTIONS, path, pathOptions.getOptions(), server));
        if (pathOptions.getHead() != null)
            this.add(new MethodTestResult(Method.HEAD, path, pathOptions.getHead(), server));
        if (pathOptions.getPatch() != null)
            this.add(new MethodTestResult(Method.PATCH, path, pathOptions.getPatch(), server));
        if (pathOptions.getTrace() != null)
            this.add(new MethodTestResult(Method.TRACE, path, pathOptions.getTrace(), server));
        if (pathOptions.getPut() != null)
            this.add(new MethodTestResult(Method.PUT, path, pathOptions.getPut(), server));

    }
}
