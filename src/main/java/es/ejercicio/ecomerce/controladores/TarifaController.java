package es.ejercicio.ecomerce.controladores;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.github.tomakehurst.wiremock.WireMockServer;

import es.ejercicio.ecomerce.dto.Moneda;
import es.ejercicio.ecomerce.dto.Tarifa;
import es.ejercicio.ecomerce.dto.query.TarifaQuery;
import es.ejercicio.ecomerce.servicio.ServicioTarifa;

@RestController
@RequestMapping("v1/tarifas")
public class TarifaController {

	@Autowired
	private ServicioTarifa servicioTarifa;
	
	@GetMapping("/{id}")
	public Tarifa get(@PathVariable long id) {
		return this.servicioTarifa.get(id).orElse(null);
	}
	
	@GetMapping("/{idMarca}/{idProducto}/{fecha}")
	public Tarifa get(TarifaQuery tarifaQuery) {
		return this.servicioTarifa.get(tarifaQuery).orElse(null);
	}
	
	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public Tarifa crear(@RequestBody Tarifa tarifa) {
		return this.servicioTarifa.crear(tarifa);
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(value=HttpStatus.CREATED)
	public Tarifa modificar(@PathVariable long id, @RequestBody Tarifa tarifa){
		return this.servicioTarifa.modificar(id, tarifa);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(value=HttpStatus.NO_CONTENT)
	public void eliminar(@PathVariable long id){
		this.servicioTarifa.eliminar(id);
	}
	
}
