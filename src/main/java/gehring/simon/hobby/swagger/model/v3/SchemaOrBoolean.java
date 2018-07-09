package gehring.simon.hobby.swagger.model.v3;

import java.io.IOException;

import gehring.simon.hobby.swagger.model.SwaggerObject;
import gehring.simon.hobby.swagger.testing.MalformedSwaggerYamlException;

public class SchemaOrBoolean extends SwaggerObject {

	public static enum Type {
		Boolean, Schema
	}
	private final Boolean underlyingBoolean;

	private final Schema underlyingSchema;

	private final Type underlyingType;

	public SchemaOrBoolean(String content) {
		if (content.equalsIgnoreCase("false") || content.equalsIgnoreCase("true")) {
			underlyingType = Type.Boolean;
			underlyingBoolean = Boolean.parseBoolean(content);
			underlyingSchema = null;
		} else {
			underlyingType = Type.Schema;
			underlyingBoolean = null;
			try {
				underlyingSchema = new Schema(content);
			} catch (IOException e) {
				throw new MalformedSwaggerYamlException("Failed to parse schema '" + content + "'.", e);
			}
		}
	}

	public Boolean getBoolean() {
		if (underlyingType == Type.Schema) {
			throw new ClassCastException("Tried to get boolean, but is actually a schema.");
		}
		return underlyingBoolean;
	}

	public Schema getSchema() {
		if (underlyingType == Type.Boolean) {
			throw new ClassCastException("Tried to get schema, but is actually a boolean.");
		}
		return underlyingSchema;
	}

	public Type getType() {
		return underlyingType;
	}

	public Class<?> getTypeClass() {
		if (underlyingType == Type.Boolean)
			return Boolean.class;
		return Schema.class;
	}

}
