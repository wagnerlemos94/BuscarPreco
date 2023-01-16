package br.com.volkswagen.buscarprecoapi.repository;

import br.com.volkswagen.buscarprecoapi.config.feign.FeignConfig;
import br.com.volkswagen.buscarprecoapi.config.okapi.OkapiToken;
import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient(url = "${api.okapi.baseUrl}", value = "OkapiApi-repository", configuration = {FeignConfig.class })
public interface OkapiApiRepository{
    //@GetMapping(value = "/oauth2/token")
    @RequestMapping(value = "/oauth2/token", method = RequestMethod.POST)
    OkapiToken buscarToken(OkapiToken okapiToken);

    //@GetMapping(path = "/v3/catalog/pt/types")
    @RequestMapping(value = "/v3/catalog/pt/types", method = RequestMethod.GET)
    ResponseEntity<Object> buscarCatalogo(String token);

    @GetMapping(value = "/v3/catalog/pt/types")
    ResponseEntity<Object> buscarPaises(String token);

    @PostMapping(value = "/v3/catalog/DE/brands/d3f207e5-18d8-5bd2-a5fa-a1acc05629fa/types/base_configuration")
    ResponseEntity<Object> testePost(String token);
}
