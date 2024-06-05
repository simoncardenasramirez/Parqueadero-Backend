package co.priv.parqueadero.autoparkadmin.entity;

import java.util.UUID;

import static co.priv.parqueadero.autoparkadmin.crosscutting.helpers.TextHelper.EMPTY;

import co.priv.parqueadero.autoparkadmin.crosscutting.helpers.ObjectHelper;
import co.priv.parqueadero.autoparkadmin.crosscutting.helpers.TextHelper;
import co.priv.parqueadero.autoparkadmin.crosscutting.helpers.UUIDHelper;


public class VehiculoEntity {
	
	private UUID id;
	private String matricula;
	private TipoVehiculoEntity tipoVehiculo;
	
	public VehiculoEntity() {
		setId(UUIDHelper.getDefault());
		setMatricula(EMPTY);
		setTipoVehiculo(TipoVehiculoEntity.build());
	}

	public VehiculoEntity(final UUID id,final String matricula,final TipoVehiculoEntity tipoVehiculo) {
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
		this.id = UUIDHelper.getDefault(id, UUIDHelper.getDefault());
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
        this.tipoVehiculo = ObjectHelper.getObjectHelper().
                getDefaultValue(tipoVehiculo, new TipoVehiculoEntity());
        return this;
	}
	
	
	
	
	
	

}
