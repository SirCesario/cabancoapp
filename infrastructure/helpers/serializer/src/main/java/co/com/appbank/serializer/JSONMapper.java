package co.com.appbank.serializer;

public interface JSONMapper {
    String writeToJson(Object object);
    Object readFromJson(String json, Class<?> clazz);
}
