package es.ejercicio.ecomerce.repositorio.entidades;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="T_RATES")
public class TarifaEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private Long id;
	
	@Column(name = "BRAND_ID", nullable = false)
	private  Long idMarca;
	
	@Column(name = "PRODUCT_ID", nullable = false)
	private  Long idProducto;
	
	@Column(name = "START_DATE", nullable = false)
	private  LocalDate fechaInicio;
	
	@Column(name = "END_DATE", nullable = false)
	private  LocalDate fechaFin;
	
	@Column(name = "PRICE", nullable = false)
	private  Long precio;
	
	@Column(name = "CURRENCY_CODE", nullable = false)
	private  String moneda;
}
