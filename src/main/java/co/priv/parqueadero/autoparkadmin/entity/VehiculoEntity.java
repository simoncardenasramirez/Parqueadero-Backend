package co.priv.parqueadero.autoparkadmin.entity;

import java.util.UUID;

import co.priv.parqueadero.autoparkadmin.crosscutting.helpers.TextHelper;


public class VehiculoEntity {
	
	private UUID id;
	private String nombre;
	private TipoVehiculoEntity tipoVehiculo;
	
	public VehiculoEntity() {
		super();
	}

	public VehiculoEntity(UUID id, String nombre, TipoVehiculoEntity tipoVehiculo) {
		super();
		setId(id);
		setNombre(nombre);
		setTipoVehiculo(tipoVehiculo);
	}

	public UUID getId() {
		return id;
	}

	public VehiculoEntity setId(final UUID id) {
		this.id = id;
		return this;
	}

	public String getNombre() {
		return nombre;
	}

	public VehiculoEntity setNombre(final String nombre) {
		this.nombre = TextHelper.applyTrim(nombre);
		return this;
	}

	public TipoVehiculoEntity getTipoVehiculo() {
		return tipoVehiculo;
	}

	public VehiculoEntity setTipoVehiculo(final TipoVehiculoEntity tipoVehiculo) {
		this.tipoVehiculo=tipoVehiculo;
		return this;
	}
	
	
	
	
	
	

}
