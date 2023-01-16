package br.com.volkswagen.buscarprecoapi.config.okapi;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
public class OkapiToken {

    private final String client_id;
    private final String client_secret;
    private final String grant_type;
    private final String access_token;
}
