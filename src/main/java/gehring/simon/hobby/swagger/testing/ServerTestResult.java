/*
 *
 */

package gehring.simon.hobby.swagger.testing;

import java.util.Map;
import java.util.Map.Entry;

import gehring.simon.hobby.swagger.model.v3.PathItem;
import gehring.simon.hobby.swagger.model.v3.Server;
import gehring.simon.hobby.swagger.testing.results.AbstractTestResult;
import gehring.simon.hobby.swagger.testing.results.Premise;
import gehring.simon.hobby.swagger.testing.results.TestResultCollection;

/**
 * The Class ServerTestResult.
 */
public class ServerTestResult extends TestResultCollection {

	private boolean containsErrors = false;
	private final Premise premise;

	/**
	 * Instantiates a new server test result.
	 *
	 * @param server
	 *            the server
	 * @param paths
	 *            the paths
	 */
	public ServerTestResult(final Server server, final Map<String, PathItem> paths, Premise premise) {
		this.premise = premise;
		AbstractTestResult result;
		for (final Entry<String, PathItem> pathEntries : paths.entrySet()) {
			result = new PathTestResult(pathEntries.getKey(), pathEntries.getValue(), server, this.premise);
			if (result.hasErrors()) {
				containsErrors = true;
			}
			this.add(result);
		}

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
