package co.priv.parqueadero.autoparkadmin.dto;

import java.util.UUID; 

import co.priv.parqueadero.autoparkadmin.crosscutting.helpers.TextHelper;


public class VehiculoDTO {
	
	private UUID id;
	private String matricula;
	private TipoVehiculoDTO tipoVehiculo;
	
	public VehiculoDTO() {
		super();
	}
	
	public static final VehiculoDTO build() {
		return new VehiculoDTO();
	}

	public VehiculoDTO(UUID id, String matricula, TipoVehiculoDTO tipoVehiculo) {
		super();
		setId(id);
		setMatricula(matricula);
		setTipoVehiculo(tipoVehiculo);
	}

	public UUID getId() {
		return id;
	}

	public VehiculoDTO setId(final UUID id) {
		this.id = id;
		return this;
	}

	public String getMatricula() {
		return matricula;
	}

	public VehiculoDTO setMatricula(final String matricula) {
		this.matricula = TextHelper.applyTrim(matricula);
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
