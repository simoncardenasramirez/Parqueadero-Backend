package co.priv.parqueadero.autoparkadmin.dto;

import java.util.UUID; 

import co.priv.parqueadero.autoparkadmin.crosscutting.helpers.TextHelper;
import co.priv.parqueadero.autoparkadmin.crosscutting.helpers.UUIDHelper;


public class VehiculoDTO {
	
	private UUID id;
	private String matricula;
	private TipoVehiculoDTO TipoVehiculo;
	
	public VehiculoDTO() {
		super();
		setId(UUIDHelper.getDefault());
		setMatricula(TextHelper.EMPTY);
		setTipoVehiculo(TipoVehiculoDTO.build());
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
		return TipoVehiculo;
	}

	public VehiculoDTO setTipoVehiculo(final TipoVehiculoDTO tipoVehiculo) {
		TipoVehiculo = tipoVehiculo;
		return this;
	}
	
	
	
	
	
	

}
