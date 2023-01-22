package es.ejercicio.ecomerce.servicio;

import java.util.Optional;

import es.ejercicio.ecomerce.dto.Tarifa;
import es.ejercicio.ecomerce.dto.query.TarifaQuery;

public interface ServicioTarifa {
	Optional <Tarifa> get(Long idTarifa);
	Optional <Tarifa> get(TarifaQuery tarifaQuery);
	Tarifa crear(Tarifa tarifa);
	Tarifa modificar(Long idTarifa, Tarifa tarifa);
	void eliminar(Long idTarifa);
}
