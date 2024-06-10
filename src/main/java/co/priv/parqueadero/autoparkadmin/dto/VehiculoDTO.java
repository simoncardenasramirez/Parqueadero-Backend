package co.priv.parqueadero.autoparkadmin.dto;

import java.util.UUID;

import co.priv.parqueadero.autoparkadmin.crosscutting.helpers.ObjectHelper;
import co.priv.parqueadero.autoparkadmin.crosscutting.helpers.TextHelper;
import co.priv.parqueadero.autoparkadmin.crosscutting.helpers.UUIDHelper;


public class VehiculoDTO {
	
	private UUID id;
	private String matricula;
	private TipoVehiculoDTO tipoVehiculo;
	
	public VehiculoDTO() {
		setId(UUIDHelper.getDefault());
		setMatricula(TextHelper.EMPTY);
		setTipoVehiculo(TipoVehiculoDTO.build());
	}
	
	public VehiculoDTO(final UUID id,final String matricula,final TipoVehiculoDTO tipoVehiculo) {
		setId(id);
		setMatricula(matricula);
		setTipoVehiculo(tipoVehiculo);
	}
	
	public static final VehiculoDTO build() {
		return new VehiculoDTO();
	}



	public UUID getId() {
		return id;
	}

	public final VehiculoDTO setId(final UUID id) {
		this.id = UUIDHelper.getDefault(id, UUIDHelper.getDefault());
		return this;
	}

	public String getMatricula() {
		return matricula;
	}

	public final VehiculoDTO setMatricula(final String matricula) {
		this.matricula = TextHelper.applyTrim(matricula);
		return this;
	}

	public TipoVehiculoDTO getTipoVehiculo() {
		return tipoVehiculo;
	}

	public final VehiculoDTO setTipoVehiculo(final TipoVehiculoDTO tipoVehiculo) {
		this.tipoVehiculo = ObjectHelper.getObjectHelper().
				getDefaultValue(tipoVehiculo, new TipoVehiculoDTO());
		return this;
	}
}
