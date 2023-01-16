package br.com.volkswagen.buscarprecoapi.controller;


import br.com.volkswagen.buscarprecoapi.config.okapi.OkapiToken;
import br.com.volkswagen.buscarprecoapi.repository.OkapiApiRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RequestMapping(value = "okapi/")
@RestController
@RequiredArgsConstructor
public class OkapiApiController{

    private final OkapiApiRepository okapiApiRepository;
    private final OkapiToken okapiToken;

    @GetMapping("/token")
    public String buscarToken() {
        System.out.println(okapiApiRepository.buscarToken(okapiToken).getAccess_token());
        return okapiApiRepository.buscarToken(okapiToken).getAccess_token();
    }

    @GetMapping("/bucarCatalogo")
    public ResponseEntity<Object> buscarCatalogo() {
        //String token = okapiApiRepository.buscarToken(okapiToken).getAccess_token();
        return okapiApiRepository.buscarCatalogo("token");
    }

    @GetMapping("/buscarPaises")
    public ResponseEntity<Object> buscarPaises() {
        String token = okapiApiRepository.buscarToken(okapiToken).getAccess_token();
        return okapiApiRepository.buscarPaises(token);
    }

    @GetMapping("/teste")
    public Object teste(){
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<OkapiToken> request = new HttpEntity<>(new OkapiToken("db21466bb6baa1c6535c1c8d5870ff7abc6a27b1_okapi", "8c4d2a06b120385351dbafa57ba0296ed6f2c4a6",
                "client_credentials", null));
        String fooResourceUrl
                = "https://api.productdata.volkswagenag.com/oauth2/token";

        ResponseEntity<Object> response = restTemplate.exchange(fooResourceUrl, HttpMethod.POST, request, Object.class);

        return response.getBody();

    }

    @GetMapping("/teste2")
    public Object teste2(){
        String token = "Bearer " + okapiApiRepository.buscarToken(okapiToken).getAccess_token();
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();

        headers.add("Content-Type", "application/json; charset=utf-8");
        headers.add("Authorization", token);
        HttpEntity<OkapiToken> request = new HttpEntity<>(headers);
        String fooResourceUrl
                = "https://api.productdata.volkswagenag.com/v3/catalog/pt/types";

        ResponseEntity<Object> response = restTemplate.exchange(fooResourceUrl, HttpMethod.GET, request, Object.class);

        return response.getBody();

    }

    @GetMapping("/testePost")
    public ResponseEntity<Object> testePost(){
        //String token = "Bearer " + okapiApiRepository.buscarToken(okapiToken).getAccess_token();
        return okapiApiRepository.testePost("token");
    }


}
