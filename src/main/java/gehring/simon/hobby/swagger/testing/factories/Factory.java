package gehring.simon.hobby.swagger.testing.factories;

import java.io.Serializable;

abstract class Factory implements Serializable {

	public String getFactoryDescription() {
		// TODO: make abstract.
		return "This is a factory, that does not override getFactoryDescription(). This is depreciated.";
	};
}
