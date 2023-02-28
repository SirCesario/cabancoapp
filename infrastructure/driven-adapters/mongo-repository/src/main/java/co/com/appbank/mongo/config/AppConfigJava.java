package co.com.appbank.mongo.config;


import co.com.appbank.mongo.generic.serializer.JSONMapper;
import co.com.appbank.mongo.generic.serializer.JSONMapperImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfigJava {
    @Bean
    public JSONMapper getJsonMApper(){
        return new JSONMapperImpl();
    }
}
