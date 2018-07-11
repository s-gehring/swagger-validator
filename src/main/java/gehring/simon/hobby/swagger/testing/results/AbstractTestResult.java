package gehring.simon.hobby.swagger.testing.results;

public interface AbstractTestResult {

	public boolean hasErrors();

	public Premise getPremise();

	public String getDescription();

	public String getShortDescription();
}
