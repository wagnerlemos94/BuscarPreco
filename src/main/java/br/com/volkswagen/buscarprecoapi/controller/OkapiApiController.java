package br.com.volkswagen.buscarprecoapi.controller;


import br.com.volkswagen.buscarprecoapi.config.okapi.OkapiToken;
import br.com.volkswagen.buscarprecoapi.repository.OkapiApiRepository;
import com.google.gson.Gson;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import lombok.RequiredArgsConstructor;
import okhttp3.*;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
//import org.springframework.http.*;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.net.ssl.SSLContext;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

@RequestMapping(value = "okapi/")
@RestController
@RequiredArgsConstructor
public class OkapiApiController{

    private final OkapiApiRepository okapiApiRepository;
    private final OkapiToken okapiToken;

    @GetMapping("/teste2")
    public String teste2() throws KeyStoreException, NoSuchAlgorithmException, KeyManagementException, IOException, UnirestException {
        String token = "Bearer " + okapiApiRepository.buscarToken(okapiToken).getAccess_token();

        Unirest.setTimeouts(0, 0);
        HttpResponse<String> response = Unirest.get("https://api.productdata.volkswagenag.com/v3/catalog/pt/types")
                .header("Authorization", "Bearer App61OWGVu10ITTxHo00JdoV3GJos18m")
                .asString();

        return response.getBody();
    }
}
