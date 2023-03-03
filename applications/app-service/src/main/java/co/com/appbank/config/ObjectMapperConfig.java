package co.com.appbank.config;


import co.com.appbank.serializer.JSONMapper;
import co.com.appbank.serializer.JSONMapperImpl;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ObjectMapperConfig {

    @Bean
    public JSONMapper jsonMapper(){
        return new JSONMapperImpl();
    }
}
