package fab.wallet.backend.util;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Converter {
  static ObjectMapper objectMapper = new ObjectMapper();

  static {
    objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    objectMapper.setSerializationInclusion(Include.NON_NULL);
  }

  /**
   * Convert a string into object
   * 
   * @param template
   * @param clazz
   * @return
   * @throws IOException
   * @throws JsonMappingException
   * @throws JsonParseException
   */
  public static <T> T jsonToObject(String template, Class<T> clazz)
      throws JsonParseException, JsonMappingException, IOException {
    return objectMapper.readValue(template, clazz);
  }

  public static <K, V> Map<K, V> jsonToMap(String data, TypeReference<Map<K, V>> type)
      throws JsonParseException, JsonMappingException, IOException {
    Map<K, V> map = objectMapper.readValue(data, type);
    return map;
  }

  public static <T> List<T> jsonToList(String data, TypeReference<List<T>> type)
      throws JsonParseException, JsonMappingException, IOException {
    List<T> list = objectMapper.readValue(data, type);
    return list;
  }

  public static <T> Set<T> jsonToSet(String data, TypeReference<Set<T>> type) {
    Set<T> list = null;
    try {
      list = objectMapper.readValue(data, type);
    } catch (IOException e) {
      e.printStackTrace();
    }
    return list;
  }

  public static String objectToJson(Object obj) {
    String json = null;
    try {
      json = objectMapper.writeValueAsString(obj);
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }
    return json;
  }

}
