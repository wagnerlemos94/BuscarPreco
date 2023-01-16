package br.com.volkswagen.buscarprecoapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class BuscarPrecoApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BuscarPrecoApiApplication.class, args);
	}

}
