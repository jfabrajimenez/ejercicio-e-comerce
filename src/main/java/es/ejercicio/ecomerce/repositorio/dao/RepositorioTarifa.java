package es.ejercicio.ecomerce.repositorio.dao;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import es.ejercicio.ecomerce.repositorio.entidades.TarifaEntity;

public interface RepositorioTarifa extends JpaRepository<TarifaEntity, Long> {
	@Query("select tarifa from TarifaEntity tarifa where tarifa.idMarca = :idMarca and tarifa.idProducto = :idProducto and tarifa.fechaInicio <= :fecha and tarifa.fechaFin >= :fecha")
	Optional<TarifaEntity> get(Long idMarca, Long idProducto, LocalDate fecha);
}
