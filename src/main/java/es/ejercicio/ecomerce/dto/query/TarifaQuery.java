package es.ejercicio.ecomerce.dto.query;

import java.time.LocalDate;

import lombok.Data;

@Data
public class TarifaQuery {
	private Long idMarca;
	private Long idProducto;
	private LocalDate fecha;
}
