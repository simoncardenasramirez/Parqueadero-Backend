package co.priv.parqueadero.autoparkadmin.business.domain;

import java.util.UUID; 

import co.priv.parqueadero.autoparkadmin.crosscutting.helpers.ObjectHelper;
import co.priv.parqueadero.autoparkadmin.crosscutting.helpers.TextHelper;
import co.priv.parqueadero.autoparkadmin.crosscutting.helpers.UUIDHelper;


public class VehiculoDomain {
	
	private UUID id;
	private String matricula;
	private TipoVehiculoDomain tipoVehiculo;
	
	private VehiculoDomain(final UUID id, final String matricula, final TipoVehiculoDomain tipoVehiculo) {
		setId(id);
		setMatricula(matricula);
		setTipoVehiculo(tipoVehiculo);
		
	}
	
	public static VehiculoDomain build(final UUID id, final String matricula, final TipoVehiculoDomain tipoVehiculo) {
		return new VehiculoDomain(id, matricula, tipoVehiculo);
	}
	
	public static VehiculoDomain build(final UUID id) {
		return new VehiculoDomain(id, TextHelper.EMPTY, TipoVehiculoDomain.build());
	}
	
	
	public static VehiculoDomain build() {
		return new VehiculoDomain(UUIDHelper.getDefault(), TextHelper.EMPTY, TipoVehiculoDomain.build());
	}
	
	private final void setId(UUID id) {
		this.id = UUIDHelper.getDefault(id, UUIDHelper.getDefault());
	}
	private final void setMatricula(String matricula) {
		this.matricula = TextHelper.applyTrim(matricula);
	}
	private final void setTipoVehiculo(TipoVehiculoDomain tipoVehiculo) {
		this.tipoVehiculo = ObjectHelper.getObjectHelper().getDefaultValue(tipoVehiculo, TipoVehiculoDomain.build());
	}
	public final UUID getId() {
		return id;
	}
	public final String getMatricula() {
		return matricula;
	}
	public final TipoVehiculoDomain getTipoVehiculo() {
		return tipoVehiculo;
	}

}
