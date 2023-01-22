package es.ejercicio.ecomerce.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class Tarifa {
	private Long id;
	private Long idMarca;
	private Long idProducto;
	private LocalDate fechaInicio;
	private LocalDate fechaFin;
	private Long precio;
	private Moneda moneda;
}
