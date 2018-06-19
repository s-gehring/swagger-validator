/*
 *
 */

package gehring.simon.hobby.swagger;

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import gehring.simon.hobby.swagger.model.SwaggerObject;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// TODO: Auto-generated Javadoc
/**
 * A factory for creating SwaggerObject objects.
 */
public class SwaggerObjectFactory {

  /** The random. */
  private static Random random = new Random(0);

  /**
   * Creates a new SwaggerObject object.
   *
   * @param <T>
   *          the generic type
   * @param classToCreate
   *          the class to create
   * @return the t
   */
  public static <T extends SwaggerObject> T createExample(final Class<T> classToCreate) {
    T result;
    try {
      result = classToCreate.newInstance();
    } catch (IllegalAccessException | InstantiationException e) {
      throw new RuntimeException("SwaggerObject cannot be instantiated via reflection.", e);
    }

    final List<Field> annotatedFields = new ArrayList<>();

    // System.out.println(classToCreate.get);
    for (final Field field : classToCreate.getDeclaredFields()) {
      field.setAccessible(true);
      if (field.isAnnotationPresent(JsonProperty.class)) {
        annotatedFields.add(field);

        try {
          if (SwaggerObject.class.isAssignableFrom(field.getType())) {
            @SuppressWarnings("unchecked")
            final Class<? extends SwaggerObject> castField = (Class<? extends SwaggerObject>) field
                .getType();
            field.set(result, createExample(castField));
          } else {
            field.set(result, getPrimitiveExampleValue(field.getType()));
          }

        } catch (IllegalArgumentException | IllegalAccessException e) {
          throw new RuntimeException("Unable to set JsonProperty " + field + ".");
        }
      }
    }

    return result;
  }

  /**
   * Gets the primitive example value.
   *
   * @param <T>
   *          the generic type
   * @param classToCreate
   *          the class to create
   * @return the primitive example value
   */
  private static <T> T getPrimitiveExampleValue(final Class<T> classToCreate) {
    if (classToCreate.equals(String.class)) {
      return classToCreate
          .cast("This is an example string with random number " + random.nextInt() + ".");
    }
    if (classToCreate.equals(Integer.class)) {
      return classToCreate.cast(random.nextInt());
    }

    T result;
    try {
      result = classToCreate.newInstance();
    } catch (final IllegalAccessException e) {
      throw new RuntimeException("Failed to access constructor of class " + classToCreate + ".", e);
    } catch (final InstantiationException e) {
      return null;
    }
    return result;
  }

  /**
   * Read.
   *
   * @param <T>
   *          the generic type
   * @param reference
   *          the reference
   * @param classToCreate
   *          the class to create
   * @return the t
   * @throws JsonParseException
   *           the json parse exception
   * @throws IOException
   *           Signals that an I/O exception has occurred.
   */
  public static <T extends SwaggerObject> T read(final String reference,
      final Class<T> classToCreate) throws JsonParseException, IOException {

    final ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
    mapper.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);

    mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    final InputStream is = new FileInputStream(new File(reference));
    final T parsed = mapper.readValue(is, classToCreate);
    is.close();

    return parsed;
  }

}
