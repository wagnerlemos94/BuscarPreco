package br.com.volkswagen.buscarprecoapi.config.okapi;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OkpiConfig {

    @Value("${api.okapi.clientId}")
    private String clientId;
    @Value("${api.okapi.clientSecret}")
    private String clientSecret;
    @Value("${api.okapi.clientType}")
    private String clientType;

    @Bean
    public OkapiToken okapiToken(){
        return new OkapiToken(clientId, clientSecret, clientType, null);
    }

}
