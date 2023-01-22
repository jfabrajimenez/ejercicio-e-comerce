package es.ejercicio.ecomerce;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableFeignClients
public class EcomerceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcomerceApplication.class, args);
	}

	@Bean
	ModelMapper modelMapper() {
		return new ModelMapper();
	}
}
