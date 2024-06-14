package co.priv.parqueadero.autoparkadmin.entity;

import java.util.UUID;

import co.priv.parqueadero.autoparkadmin.crosscutting.helpers.ObjectHelper;
import co.priv.parqueadero.autoparkadmin.crosscutting.helpers.TextHelper;
import co.priv.parqueadero.autoparkadmin.crosscutting.helpers.UUIDHelper;


public class CeldaEntity {
	
	private UUID id;
	private String nombre;
	private TipoVehiculoEntity tipoVehiculo;
	private ParqueaderoEntity parqueadero;
	private EstadoCeldaEntity estadoCelda;
	
	public CeldaEntity() {
		super();
		setId(UUIDHelper.getDefault());
		setNombre(TextHelper.EMPTY);
		setParqueadero(ParqueaderoEntity.build());
		setTipoVehiculo(TipoVehiculoEntity.build());
		setEstadoCelda(EstadoCeldaEntity.build());
	}

	public CeldaEntity(final UUID id,final String nombre,final TipoVehiculoEntity tipoVehiculo,final ParqueaderoEntity parqueadero,
			final EstadoCeldaEntity estadoCelda) {
		setId(id);
		setNombre(nombre);
		setTipoVehiculo(tipoVehiculo);
		setParqueadero(parqueadero);
		setEstadoCelda(estadoCelda);
	}
	
	public static final CeldaEntity build() {
		return new CeldaEntity();
	}

	public final UUID getId() {
		return id;
	}

	public final String getNombre() {
		return nombre;
	}

	public final TipoVehiculoEntity getTipoVehiculo() {
		return tipoVehiculo;
	}

	public final ParqueaderoEntity getParqueadero() {
		return parqueadero;
	}

	public final EstadoCeldaEntity getEstadoCelda() {
		return estadoCelda;
	}

	public final CeldaEntity setId(UUID id) {
        this.id = UUIDHelper.getDefault(id, UUIDHelper.getDefault());
        return this;
	}

	public final CeldaEntity setNombre(String nombre) {
        this.nombre = TextHelper.applyTrim(nombre);
        return this;
	}

	public final CeldaEntity setTipoVehiculo(TipoVehiculoEntity tipoVehiculo) {
	      this.tipoVehiculo = ObjectHelper.getObjectHelper().
	                getDefaultValue(tipoVehiculo, new TipoVehiculoEntity());
	        return this;
	}

	public final CeldaEntity setParqueadero(ParqueaderoEntity parqueadero) {
		this.parqueadero = ObjectHelper.getObjectHelper().getDefaultValue(parqueadero, new ParqueaderoEntity());
		return this;
	}
	public final CeldaEntity setEstadoCelda(EstadoCeldaEntity estadoCelda) {
		this.estadoCelda = ObjectHelper.getObjectHelper().getDefaultValue(estadoCelda, new EstadoCeldaEntity());
		return this;
	}
	

}
