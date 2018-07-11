/*
 *
 */

package gehring.simon.hobby.swagger.testing;

import java.util.Map;
import java.util.logging.Logger;

import gehring.simon.hobby.swagger.model.v3.OpenApi;
import gehring.simon.hobby.swagger.model.v3.PathItem;
import gehring.simon.hobby.swagger.model.v3.Server;
import gehring.simon.hobby.swagger.testing.results.Premise;
import gehring.simon.hobby.swagger.testing.results.TestResultCollection;

/**
 * The Class SchemeTestResult.
 */
public class SchemeTestResult extends TestResultCollection {

	/** The Constant LOGGER. */
	private static final Logger LOGGER = Logger.getLogger(SchemeTestResult.class.getName());

	/** The api. */
	private OpenApi api = null;
	private final Premise premise;

	private boolean containsErrors = false;

	/**
	 * Instantiates a new scheme test result.
	 *
	 * @param api
	 *            the api
	 */
	public SchemeTestResult(final OpenApi api, Premise premise) {
		super();
		this.api = api;

		this.premise = premise;
	}

	/**
	 * Execute tests on all servers.
	 *
	 * @return true, if successful
	 */
	public boolean executeTestsOnAllServers() {
		final Map<String, PathItem> paths = api.getPaths();
		LOGGER.info("Testing all paths of API '" + api.getInfo().getTitle() + "' (A total of " + paths.size()
				+ " paths to test)");

		for (final Server server : api.getServers()) {
			executeTestsOnOneServer(server);
		}

		return true;
	}

	/**
	 * Execute tests on one server.
	 *
	 * @param server
	 *            the server
	 * @return true, if successful
	 */
	public boolean executeTestsOnOneServer(final Server server) {
		final Map<String, PathItem> paths = api.getPaths();
		final ServerTestResult testResult = new ServerTestResult(server, paths, premise);
		this.add(testResult);
		if (testResult.hasErrors()) {
			containsErrors = true;
		}
		return true;
	}

	@Override
	public boolean hasErrors() {
		return containsErrors;
	}

	@Override
	public Premise getPremise() {
		// TODO Auto-generated method stub
		return null;
	}

}
