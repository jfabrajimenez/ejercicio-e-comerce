package es.ejercicio.ecomerce.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import es.ejercicio.ecomerce.dto.Moneda;


@FeignClient(name="servicio-moneda", url = "localhost:8081/v1/currencies")
public interface MonedaClienteRest {
	@GetMapping("/{currencyCode}")
	public Moneda getCurrencyByCode(@PathVariable String currencyCode);
}
