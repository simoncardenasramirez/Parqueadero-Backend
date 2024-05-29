package co.priv.parqueadero.autoparkadmin.dto;

import java.util.UUID;

import co.priv.parqueadero.autoparkadmin.crosscutting.helpers.TextHelper;


public class VehiculoDTO {
	
	private UUID id;
	private String nombre;
	private TipoVehiculoDTO tipoVehiculo;
	
	public VehiculoDTO() {
		super();
	}
	
	public static final VehiculoDTO build() {
		return new VehiculoDTO();
	}

	public VehiculoDTO(UUID id, String nombre, TipoVehiculoDTO tipoVehiculo) {
		super();
		setId(id);
		setNombre(nombre);
		setTipoVehiculo(tipoVehiculo);
	}

	public UUID getId() {
		return id;
	}

	public VehiculoDTO setId(final UUID id) {
		this.id = id;
		return this;
	}

	public String getNombre() {
		return nombre;
	}

	public VehiculoDTO setNombre(final String nombre) {
		this.nombre = TextHelper.applyTrim(nombre);
		return this;
	}

	public TipoVehiculoDTO getTipoVehiculo() {
		return tipoVehiculo;
	}

	public VehiculoDTO setTipoVehiculo(final TipoVehiculoDTO tipoVehiculo) {
		this.tipoVehiculo=tipoVehiculo;
		return this;
	}
	
	
	
	
	
	

}
