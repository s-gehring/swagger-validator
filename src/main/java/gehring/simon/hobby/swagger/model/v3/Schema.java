/*
 *
 */

package gehring.simon.hobby.swagger.model.v3;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;

import gehring.simon.hobby.swagger.model.SwaggerObject;

// TODO: Auto-generated Javadoc
/**
 * The Class Schema.
 */
public class Schema extends SwaggerObject {

	@JsonProperty
	private String title;

	@JsonProperty
	private String description;

	@JsonProperty
	private Integer multipleOf;

	@JsonProperty
	private Long maximum;

	@JsonProperty
	private Boolean exclusiveMaximum;

	@JsonProperty
	private Long minimum;

	@JsonProperty
	private Boolean exclusiveMinimum;

	@JsonProperty
	private Integer maxLength;

	@JsonProperty
	private Integer minLength;

	@JsonProperty
	private String pattern;

	@JsonProperty
	private Integer maxItems;

	@JsonProperty
	private Integer minItems;

	@JsonProperty
	private Boolean uniqueItems;

	@JsonProperty
	private Integer maxProperties;

	@JsonProperty
	private Integer minProperties;

	@JsonProperty
	private List<String> required;

	@JsonProperty("enum")
	private List<Object> enumField;

	@JsonProperty
	private String type;

	@JsonProperty
	private List<Schema> allOf;

	@JsonProperty
	private List<Schema> oneOf;

	@JsonProperty
	private List<Schema> anyOf;

	@JsonProperty
	private Schema not;

	@JsonProperty
	private Map<String, Schema> items;

	@JsonProperty
	private Schema properties;

	@JsonProperty
	private Object additionalProperties; // Actually boolean or schema

	@JsonProperty
	private String format;

	@JsonProperty("default")
	private Object defaultField;

	/**
	 * Instantiates a new schema.
	 */
	public Schema() {
		super();
	}

	/**
	 * Instantiates a new schema.
	 *
	 * @param reference
	 *            the reference
	 * @throws JsonProcessingException
	 *             the json processing exception
	 * @throws MalformedURLException
	 *             the malformed URL exception
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public Schema(final String reference) throws JsonProcessingException, MalformedURLException, IOException {
		super(reference);
	}

	/**
	 * <p>
	 * There are no restrictions placed on the value of this keyword.
	 * </p>
	 *
	 * <p>
	 * This keyword can be used to supply a default JSON value associated with a
	 * particular schema. It is RECOMMENDED that a default value be valid against
	 * the associated schema.
	 * </p>
	 *
	 * <p>
	 * This keyword MAY be used in root schemas, and in any subschemas.
	 * </p>
	 *
	 * <p style='color:red'>
	 * The default value represents what would be assumed by the consumer of the
	 * input as the value of the schema if one is not provided. Unlike JSON Schema,
	 * the value MUST conform to the defined type for the Schema Object defined at
	 * the same level. For example, if type is string, then default can be "foo" but
	 * cannot be 1.
	 * </p>
	 *
	 * @return the default
	 */
	public Object getDefault() {
		return defaultField;
	}

	/**
	 * <p>
	 * [This value] can be used to decorate a user interface with information about
	 * the data produced by this user interface. [A] description will provide
	 * explanation about the purpose of the instance described by this schema.
	 * </p>
	 *
	 * <p style='color:red'>
	 * CommonMark syntax MAY be used for rich text representation.
	 * </p>
	 *
	 * @see <a href=
	 *      "https://tools.ietf.org/html/draft-wright-json-schema-validation-00#section-6.1">JSON
	 *      Schema Validation 6.1 "title" and "description"</a>
	 *
	 * @return description the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * <p>
	 * [...] This array SHOULD have at least one element. Elements in the array
	 * SHOULD be unique.
	 * </p>
	 * <p>
	 * Elements in the array MAY be of any type, including null.
	 * </p>
	 * <p>
	 * An instance validates successfully against this keyword if its value is equal
	 * to one of the elements in this keyword's array value.
	 * </p>
	 *
	 * @see <a href=
	 *      "https://tools.ietf.org/html/draft-wright-json-schema-validation-00#section-5.20">JSON
	 *      Schema Validation 5.20 enum</a>
	 *
	 * @return the enum
	 */
	public List<Object> getEnum() {
		return enumField;
	}

	/**
	 * <p>
	 * The value of "additionalProperties" MUST be a boolean or a schema.
	 * </p>
	 *
	 * <p>
	 * If "additionalProperties" is absent, it may be considered present with an
	 * empty schema as a value.
	 * </p>
	 *
	 * <p>
	 * If "additionalProperties" is true, validation always succeeds.
	 * </p>
	 *
	 * <p>
	 * If "additionalProperties" is false, validation succeeds only if the instance
	 * is an object and all properties on the instance were covered by "properties"
	 * and/or "patternProperties".
	 * </p>
	 *
	 * <p>
	 * If "additionalProperties" is an object, validate the value as a schema to all
	 * of the properties that weren't validated by "properties" nor
	 * "patternProperties".
	 * </p>
	 *
	 * <p style='color:red'>
	 * Value can be boolean or object. Inline or referenced schema MUST be of a
	 * Schema Object and not a standard JSON Schema.
	 * </p>
	 *
	 * @see <a href=
	 *      "https://tools.ietf.org/html/draft-wright-json-schema-validation-00#section-5.18">JSON
	 *      Schema Validation 5.18 additionalProperties</a>
	 *
	 * @return the additional properties
	 */
	public Object getAdditionalProperties() {
		return additionalProperties;
	}

	/**
	 * <p>
	 * This array MUST have at least one element.
	 * </p>
	 * <p>
	 * Elements of the array MUST be objects. Each object MUST be a valid JSON
	 * Schema.
	 * </p>
	 * <p>
	 * An instance validates successfully against this keyword if it validates
	 * successfully against all schemas defined by this keyword's value.
	 * </p>
	 * <p style='color:red'>
	 * Inline or referenced schema MUST be of a Schema Object and not a standard
	 * JSON Schema.
	 * </p>
	 *
	 * @see <a href=
	 *      "https://tools.ietf.org/html/draft-wright-json-schema-validation-00#section-5.22">JSON
	 *      Schema Validation 5.22 allOf</a>
	 *
	 * @return the all of
	 */
	public List<Schema> getAllOf() {
		return allOf;
	}

	/**
	 * <p>
	 * This array MUST have at least one element.
	 * </p>
	 *
	 * <p>
	 * Elements of the array MUST be objects. Each object MUST be a valid JSON
	 * Schema.
	 * </p>
	 *
	 * <p>
	 * An instance validates successfully against this keyword if it validates
	 * successfully against at least one schema defined by this keyword's value.
	 * </p>
	 *
	 * <p style='color:red'>
	 * Inline or referenced schema MUST be of a Schema Object and not a standard
	 * JSON Schema.
	 * </p>
	 *
	 * @see <a href=
	 *      "https://tools.ietf.org/html/draft-wright-json-schema-validation-00#section-5.23">JSON
	 *      Schema Validation 5.23 anyOf</a>
	 *
	 * @return the any of
	 */
	public List<Schema> getAnyOf() {
		return anyOf;
	}

	/**
	 * <p>
	 * The value of "exclusiveMaximum" MUST be a boolean, representing whether the
	 * limit in "maximum" is exclusive or not. An undefined value is the same as
	 * false.
	 * </p>
	 *
	 * <p>
	 * If "exclusiveMaximum" is true, the a numeric instance SHOULD NOT be equal to
	 * the value specified in "maximum". If "exclusiveMaximum" is false (or not
	 * specified), then a numeric instance MAY be equal to the value of "maximum".
	 * </p>
	 *
	 * @see <a href=
	 *      "https://tools.ietf.org/html/draft-wright-json-schema-validation-00#section-5.3">JSON
	 *      Schema Validation 5.3 exclusiveMaximum</a>
	 *
	 * @return the exclusive maximum
	 */
	public Boolean getExclusiveMaximum() {
		return exclusiveMaximum;
	}

	/**
	 *
	 * <p>
	 * The value of "exclusiveMinimum" MUST be a boolean, representing whether the
	 * limit in "minimum" is exclusive or not. An undefined value is the same as
	 * false.
	 * </p>
	 * <p>
	 * If "exclusiveMinimum" is true, then a numeric instance SHOULD NOT be equal to
	 * the value specified in "minimum". If "exclusiveMinimum" is false (or not
	 * specified), then a numeric instance MAY be equal to the value of "minimum".
	 * </p>
	 *
	 * @see <a href=
	 *      "https://tools.ietf.org/html/draft-wright-json-schema-validation-00#section-5.5">JSON
	 *      Schema Validation 5.5 exclusiveMinimum</a>
	 *
	 * @return the exclusive minimum
	 */
	public Boolean getExclusiveMinimum() {
		return exclusiveMinimum;
	}

	/**
	 * <p>
	 * Structural validation alone may be insufficient to validate that an instance
	 * meets all the requirements of an application. The "format" keyword is defined
	 * to allow interoperable semantic validation for a fixed subset of values which
	 * are accurately described by authoritative resources, be they RFCs or other
	 * external specifications.
	 * </p>
	 *
	 * <p>
	 * The value of this keyword is called a format attribute. It MUST be a string.
	 * A format attribute can generally only validate a given set of instance types.
	 * If the type of the instance to validate is not in this set, validation for
	 * this format attribute and instance SHOULD succeed.
	 * </p>
	 *
	 * <p style='color:red'>
	 * See <a href="https://swagger.io/specification/#dataTypeFormat">Data Type
	 * Formats</a> for further details. While relying on JSON Schema's defined
	 * formats, the OAS offers a few additional predefined formats.
	 * </p>
	 *
	 * @see <a href=
	 *      "https://tools.ietf.org/html/draft-wright-json-schema-validation-00#section-7">JSON
	 *      Schema Validation 7 Semantic validation with "format"</a>
	 *
	 * @return the format
	 */
	public String getFormat() {
		return format;
	}

	/**
	 *
	 * <p>
	 * The value of "additionalItems" MUST be either a boolean or an object. If it
	 * is an object, this object MUST be a valid JSON Schema.
	 * </p>
	 * <p>
	 * The value of "items" MUST be either a schema or array of schemas.
	 * </p>
	 * <p>
	 * Successful validation of an array instance with regards to these two keywords
	 * is determined as follows:
	 * <ul>
	 * <li>if "items" is not present, or its value is an object, validation of the
	 * instance always succeeds, regardless of the value of "additionalItems";</li>
	 * <li>if the value of "additionalItems" is boolean value true or an object,
	 * validation of the instance always succeeds;</li>
	 * <li>if the value of "additionalItems" is boolean value false and the value of
	 * "items" is an array, the instance is valid if its size is less than, or equal
	 * to, the size of "items".</li>
	 * </ul>
	 * If either keyword is absent, it may be considered present with an empty
	 * schema.
	 * </p>
	 *
	 * <p style='color:red'>
	 * Value MUST be an object and not an array. Inline or referenced schema MUST be
	 * of a Schema Object and not a standard JSON Schema. items MUST be present if
	 * the type is array.
	 * </p>
	 *
	 * @see <a href=
	 *      "https://tools.ietf.org/html/draft-wright-json-schema-validation-00#section-5.9">JSON
	 *      Schema Validation 5.9 additionalItems and items</a>
	 *
	 * @return the items
	 */
	public Map<String, Schema> getItems() {
		return items;
	}

	/**
	 * <p>
	 * The value of "maximum" MUST be a number, representing an upper limit for a
	 * numeric instance.
	 * </p>
	 * <p>
	 * If the instance is a number, then this keyword validates if
	 * "exclusiveMaximum" is true and instance is less than the provided value, or
	 * else if the instance is less than or exactly equal to the provided value.
	 * </p>
	 *
	 * @see <a href=
	 *      "https://tools.ietf.org/html/draft-wright-json-schema-validation-00#section-5.2">JSON
	 *      Schema Validation 5.2 maximum</a>
	 *
	 * @return the maximum
	 */
	public Long getMaximum() {
		return maximum;
	}

	/**
	 *
	 * <p>
	 * [...] This integer MUST be greater than, or equal to, 0.
	 * </p>
	 * <p>
	 * An array instance is valid against "maxItems" if its size is less than, or
	 * equal to, the value of this keyword.
	 * </p>
	 *
	 * @see <a href=
	 *      "https://tools.ietf.org/html/draft-wright-json-schema-validation-00#section-5.10">JSON
	 *      Schema Validation 5.10 maxItems</a>
	 *
	 * @return the max items
	 */
	public Integer getMaxItems() {
		return maxItems;
	}

	/**
	 *
	 * <p>
	 * The value of this keyword MUST be a non-negative integer. [...]
	 * </p>
	 * <p>
	 * A string instance is valid against this keyword if its length is less than,
	 * or equal to, the value of this keyword.
	 * </p>
	 * <p>
	 * The length of a string instance is defined as the number of its characters as
	 * defined by RFC 7159 [RFC7159].
	 * </p>
	 *
	 * @see <a href=
	 *      "https://tools.ietf.org/html/draft-wright-json-schema-validation-00#section-5.6">JSON
	 *      Schema Validation 5.6 maxLength</a>
	 *
	 * @return the max length
	 */
	public Integer getMaxLength() {
		return maxLength;
	}

	/**
	 * <p>
	 * [...] This integer MUST be greater than, or equal to, 0.
	 * </p>
	 * <p>
	 * An object instance is valid against "maxProperties" if its number of
	 * properties is less than, or equal to, the value of this keyword.
	 * </p>
	 *
	 * @see <a href=
	 *      "https://tools.ietf.org/html/draft-wright-json-schema-validation-00#section-5.13">JSON
	 *      Schema Validation 5.13 maxProperties</a>
	 *
	 * @return the max properties
	 */
	public Integer getMaxProperties() {
		return maxProperties;
	}

	/**
	 * <p>
	 * The value of "minimum" MUST be a number, representing a lower limit for a
	 * numeric instance.
	 * </p>
	 * <p>
	 * If the instance is a number, then this keyword validates if
	 * "exclusiveMinimum" is true and instance is greater than the provided value,
	 * or else if the instance is greater than or exactly equal to the provided
	 * value.
	 * </p>
	 *
	 * @see <a href=
	 *      "https://tools.ietf.org/html/draft-wright-json-schema-validation-00#section-5.4">JSON
	 *      Schema Validation 5.4 minimum</a>
	 *
	 * @return the minimum
	 */
	public Long getMinimum() {
		return minimum;
	}

	/**
	 * <p>
	 * [...] This integer MUST be greater than, or equal to, 0.
	 * </p>
	 * <p>
	 * An array instance is valid against "minItems" if its size is greater than, or
	 * equal to, the value of this keyword.
	 * </p>
	 * <p>
	 * If this keyword is not present, it may be considered present with a value of
	 * 0.
	 * </p>
	 *
	 * @see <a href=
	 *      "https://tools.ietf.org/html/draft-wright-json-schema-validation-00#section-5.11">JSON
	 *      Schema Validation 5.11 minItems</a>
	 *
	 * @return the min items
	 */
	public Integer getMinItems() {
		return minItems;
	}

	/**
	 * <p>
	 * A string instance is valid against this keyword if its length is greater
	 * than, or equal to, the value of this keyword.
	 * </p>
	 * <p>
	 * The length of a string instance is defined as the number of its characters as
	 * defined by RFC 7159 [RFC7159].
	 * </p>
	 * <p>
	 * The value of this keyword MUST be an integer. This integer MUST be greater
	 * than, or equal to, 0.
	 * </p>
	 * <p>
	 * "minLength", if absent, may be considered as being present with integer value
	 * 0.
	 * </p>
	 *
	 * @see <a href=
	 *      "https://tools.ietf.org/html/draft-wright-json-schema-validation-00#section-5.7">JSON
	 *      Schema Validation 5.7 minLength</a>
	 *
	 * @return the min length
	 */
	public Integer getMinLength() {
		return minLength;
	}

	/**
	 * <p>
	 * This integer MUST be greater than, or equal to, 0.
	 * </p>
	 * <p>
	 * An object instance is valid against "minProperties" if its number of
	 * properties is greater than, or equal to, the value of this keyword.
	 * </p>
	 * <p>
	 * If this keyword is not present, it may be considered present with a value of
	 * 0.
	 * </p>
	 *
	 * @see <a href=
	 *      "https://tools.ietf.org/html/draft-wright-json-schema-validation-00#section-5.14">JSON
	 *      Schema Validation 5.14 minProperties</a>
	 *
	 * @return the min properties
	 */
	public Integer getMinProperties() {
		return minProperties;
	}

	/**
	 * <p>
	 * The value of "multipleOf" MUST be a number, strictly greater than 0.
	 * </p>
	 * <p>
	 * A numeric instance is only valid if division by this keyword's value results
	 * in an integer.
	 * </p>
	 *
	 * @see <a href=
	 *      "https://tools.ietf.org/html/draft-wright-json-schema-validation-00#section-5.1">
	 *      JSON Schema Validation 5.1 multipleOf</a>
	 *
	 * @return the multiple of
	 */
	public Integer getMultipleOf() {
		return multipleOf;
	}

	/**
	 * <p>
	 * [...] An instance is valid against this keyword if it fails to validate
	 * successfully against the schema defined by this keyword.
	 * </p>
	 *
	 * <p style='color:red'>
	 * Inline or referenced schema MUST be of a Schema Object and not a standard
	 * JSON Schema.
	 * </p>
	 *
	 * @see <a href=
	 *      "https://tools.ietf.org/html/draft-wright-json-schema-validation-00#section-5.25">
	 *      JSON Schema Validation 5.25 not</a>
	 *
	 * @return the not
	 */
	public Schema getNot() {
		return not;
	}

	/**
	 * <p>
	 * This array MUST have at least one element.
	 * </p>
	 *
	 * <p>
	 * Elements of the array MUST be objects. Each object MUST be a valid JSON
	 * Schema.
	 * </p>
	 *
	 * <p>
	 * An instance validates successfully against this keyword if it validates
	 * successfully against exactly one schema defined by this keyword's value.
	 * </p>
	 *
	 * <p style='color:red'>
	 * Inline or referenced schema MUST be of a Schema Object and not a standard
	 * JSON Schema.
	 * </p>
	 *
	 * @see <a href=
	 *      "https://tools.ietf.org/html/draft-wright-json-schema-validation-00#section-5.24">JSON
	 *      Schema Validation 5.24 oneOf</a>
	 *
	 * @return the one of
	 */
	public List<Schema> getOneOf() {
		return oneOf;
	}

	/**
	 * <p>
	 * [...] This string SHOULD be a valid regular expression, according to the ECMA
	 * 262 regular expression dialect.
	 * </p>
	 * <p>
	 * A string instance is considered valid if the regular expression matches the
	 * instance successfully. Recall: regular expressions are not implicitly
	 * anchored.
	 * </p>
	 *
	 * @see <a href=
	 *      "https://tools.ietf.org/html/draft-wright-json-schema-validation-00#section-5.8">JSON
	 *      Schema Validation 5.8 pattern</a>
	 *
	 * @return the pattern
	 */
	public String getPattern() {
		return pattern;
	}

	/**
	 * <p>
	 * The value of "properties" MUST be an object. Each value of this object MUST
	 * be an object, and each object MUST be a valid JSON Schema.
	 * </p>
	 *
	 * <p>
	 * If absent, it can be considered the same as an empty object.
	 * </p>
	 *
	 * <p style='color:red'>
	 * Property definitions MUST be a Schema Object and not a standard JSON Schema
	 * (inline or referenced).
	 * </p>
	 *
	 * @see <a href=
	 *      "https://tools.ietf.org/html/draft-wright-json-schema-validation-00#section-5.16">JSON
	 *      Schema Validation 5.16 properties</a>
	 *
	 * @return the properties
	 */
	public Schema getProperties() {
		return properties;
	}

	/**
	 * <p>
	 * [...] This array MUST have at least one element. Elements of this array MUST
	 * be strings, and MUST be unique.
	 * </p>
	 * <p>
	 * An object instance is valid against this keyword if its property set contains
	 * all elements in this keyword's array value.
	 * </p>
	 *
	 * @see <a href=
	 *      "https://tools.ietf.org/html/draft-wright-json-schema-validation-00#section-5.15">JSON
	 *      Schema Validation 5.15 required</a>
	 *
	 * @return the required
	 */
	public List<String> getRequired() {
		return required;
	}

	/**
	 * <p>
	 * [The title] can be used to decorate a user interface with information about
	 * the data produced by this user interface. A title will preferrably be short
	 * [...].
	 * </p>
	 *
	 * @see <a href=
	 *      "https://tools.ietf.org/html/draft-wright-json-schema-validation-00#section-6.1">JSON
	 *      Schema Validation 6.1 "title" and "description"</a>
	 *
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * <p>
	 * The value of this keyword MUST be either a string or an array. If it is an
	 * array, elements of the array MUST be strings and MUST be unique.
	 * </p>
	 * <p>
	 * String values MUST be one of the seven primitive types defined by the core
	 * specification.
	 * </p>
	 *
	 * <p>
	 * An instance matches successfully if its primitive type is one of the types
	 * defined by keyword. Recall: "number" includes "integer".
	 * </p>
	 *
	 * <p style='color:red'>
	 * Value MUST be a string. Multiple types via an array are not supported.
	 * </p>
	 *
	 * @see <a href=
	 *      "https://tools.ietf.org/html/draft-wright-json-schema-validation-00#section-5.21">JSON
	 *      Schema Validation 5.21 type</a>
	 *
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * <p>
	 * [...] If this keyword has boolean value false, the instance validates
	 * successfully. If it has boolean value true, the instance validates
	 * successfully if all of its elements are unique.
	 * </p>
	 * <p>
	 * If not present, this keyword may be considered present with boolean value
	 * false.
	 * </p>
	 *
	 * @see <a href=
	 *      "https://tools.ietf.org/html/draft-wright-json-schema-validation-00#section-5.12">JSON
	 *      Schema Validation 5.12 uniqueItems</a>
	 *
	 * @return the unique items
	 */
	public Boolean getUniqueItems() {
		return uniqueItems;
	}

}
