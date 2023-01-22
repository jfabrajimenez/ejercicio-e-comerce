package es.ejercicio.ecomerce.servicio.implementacion;

import java.time.LocalDate;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.ejercicio.ecomerce.client.MonedaClienteRest;
import es.ejercicio.ecomerce.dto.Tarifa;
import es.ejercicio.ecomerce.dto.query.TarifaQuery;
import es.ejercicio.ecomerce.repositorio.dao.RepositorioTarifa;
import es.ejercicio.ecomerce.repositorio.entidades.TarifaEntity;
import es.ejercicio.ecomerce.servicio.ServicioTarifa;

@Service
public class ServicioTarifaImpl implements ServicioTarifa {

	@Autowired
	private RepositorioTarifa repositorioTarifa;
	
	@Autowired
	private MonedaClienteRest clienteMoneda;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public Optional <Tarifa> get(Long idTarifa) {
		return this.repositorioTarifa.findById(idTarifa).map(this::mapear);
	}
	
	@Override
	public Optional <Tarifa> get(TarifaQuery tarifaQuery) {
		return this.repositorioTarifa.get(tarifaQuery.getIdMarca(), tarifaQuery.getIdProducto(), tarifaQuery.getFecha())
				.map(this::mapear);
	}

	@Override
	@Transactional
	public Tarifa crear(Tarifa tarifa) {
		return Optional.ofNullable(this.repositorioTarifa.save(this.mapear(tarifa))).map(this::mapear).orElse(null);
	}

	@Override
	@Transactional
	public Tarifa modificar(Long idTarifa, Tarifa tarifa) {
		if(Optional.ofNullable(tarifa).isPresent()) {
			Optional<TarifaEntity> oTarifaBd=this.repositorioTarifa.findById(idTarifa);
			
			if(oTarifaBd.isPresent()) {
				TarifaEntity tarifaBd=oTarifaBd.get();
				tarifaBd.setIdProducto(tarifa.getIdProducto());
				tarifaBd.setFechaInicio(tarifa.getFechaInicio());
				tarifaBd.setFechaFin(tarifa.getFechaFin());
				tarifaBd.setPrecio(tarifa.getPrecio());
				tarifaBd.setMoneda(tarifa.getMoneda().getCodigo());
				
				return Optional.ofNullable(this.repositorioTarifa.save(tarifaBd)).map(this::mapear).orElse(null);
			}
		}
		throw new IllegalArgumentException("No se ha proporcionado la tarifa a modificar");
	}

	@Override
	@Transactional
	public void eliminar(Long idTarifa) {
		this.repositorioTarifa.deleteById(idTarifa);
	}
	
	private Tarifa mapear(TarifaEntity tarifaE) {
		Tarifa tarifa= this.modelMapper.map(tarifaE, Tarifa.class);
		
		tarifa.setMoneda(this.clienteMoneda.getCurrencyByCode(tarifaE.getMoneda()));
		
		return tarifa;
	}
	
	private TarifaEntity mapear(Tarifa tarifa) {
		return this.modelMapper.map(tarifa, TarifaEntity.class);
	}
	
	

}
