package gehring.simon.hobby.swagger.testing.factories;

import java.util.HashMap;

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

class JsonObject extends HashMap<String, Object> {

	@Override
	public String toString() {
		try {
			final ObjectMapper x = new ObjectMapper();
			x.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);
			x.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
			x.configure(SerializationFeature.WRITE_NULL_MAP_VALUES, false);

			return x.writeValueAsString(this);
		} catch (final JsonProcessingException e) {
			throw new RuntimeException("Failed to serialize object to JSON.", e);
		}
	}

}
