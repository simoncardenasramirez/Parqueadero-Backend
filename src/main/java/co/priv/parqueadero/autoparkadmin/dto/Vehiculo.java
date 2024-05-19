package co.priv.parqueadero.autoparkadmin.dto;

import java.util.UUID;

import co.priv.parqueadero.autoparkadmin.crosscutting.helpers.TextHelper;


public class Vehiculo {
	
	private UUID id;
	private String nombre;
	private TipoVehiculoDTO tipoVehiculo;
	
	public Vehiculo() {
		super();
	}

	public Vehiculo(UUID id, String nombre, TipoVehiculoDTO tipoVehiculo) {
		super();
		setId(id);
		setNombre(nombre);
		setTipoVehiculo(tipoVehiculo);
	}

	public UUID getId() {
		return id;
	}

	public Vehiculo setId(final UUID id) {
		this.id = id;
		return this;
	}

	public String getNombre() {
		return nombre;
	}

	public Vehiculo setNombre(final String nombre) {
		this.nombre = TextHelper.applyTrim(nombre);
		return this;
	}

	public TipoVehiculoDTO getTipoVehiculo() {
		return tipoVehiculo;
	}

	public Vehiculo setTipoVehiculo(final TipoVehiculoDTO tipoVehiculo) {
		this.tipoVehiculo=tipoVehiculo;
		return this;
	}
	
	
	
	
	
	

}
