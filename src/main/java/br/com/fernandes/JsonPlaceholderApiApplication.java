package br.com.fernandes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class JsonPlaceholderApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(JsonPlaceholderApiApplication.class, args);
	}

}
