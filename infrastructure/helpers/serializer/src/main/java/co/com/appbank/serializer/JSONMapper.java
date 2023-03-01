package co.com.appbank.serializer;

import org.springframework.stereotype.Component;


public interface JSONMapper {
    String writeToJson(Object object);
    Object readFromJson(String json, Class<?> clazz);
}
