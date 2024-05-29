package co.priv.parqueadero.autoparkadmin.entity;

import java.util.UUID; 

import co.priv.parqueadero.autoparkadmin.crosscutting.helpers.TextHelper;


public class VehiculoEntity {
	
	private UUID id;
	private String matricula;
	private TipoVehiculoEntity tipoVehiculo;
	
	public VehiculoEntity() {
		super();
	}

	public VehiculoEntity(UUID id, String matricula, TipoVehiculoEntity tipoVehiculo) {
		super();
		setId(id);
		setMatricula(matricula);
		setTipoVehiculo(tipoVehiculo);
	}
	
	public static final VehiculoEntity build() {
		return new VehiculoEntity();
	}

	public UUID getId() {
		return id;
	}

	public VehiculoEntity setId(final UUID id) {
		this.id = id;
		return this;
	}

	public String getMatricula() {
		return matricula;
	}

	public VehiculoEntity setMatricula(final String matricula) {
		this.matricula = TextHelper.applyTrim(matricula);
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
