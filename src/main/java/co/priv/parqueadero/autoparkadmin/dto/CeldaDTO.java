package co.priv.parqueadero.autoparkadmin.dto;

import java.util.UUID;

import co.priv.parqueadero.autoparkadmin.crosscutting.helpers.ObjectHelper;
import co.priv.parqueadero.autoparkadmin.crosscutting.helpers.TextHelper;
import co.priv.parqueadero.autoparkadmin.crosscutting.helpers.UUIDHelper;

public class CeldaDTO {
	
	private UUID id;
	private String nombre;
	private TipoVehiculoDTO tipoVehiculo;
	private ParqueaderoDTO parqueadero;
	private EstadoCeldaDTO estadoCelda;
	
	public CeldaDTO() {
		super();
		setId(UUIDHelper.getDefault());
		setNombre(TextHelper.EMPTY);
		setParqueadero(ParqueaderoDTO.build());
		setTipoVehiculo(TipoVehiculoDTO.build());
		setEstadoCelda(EstadoCeldaDTO.build());
	}

	public CeldaDTO(final UUID id,final String nombre,final TipoVehiculoDTO tipoVehiculo,final ParqueaderoDTO parqueadero,
			final EstadoCeldaDTO estadoCelda) {
		setId(id);
		setNombre(nombre);
		setTipoVehiculo(tipoVehiculo);
		setParqueadero(parqueadero);
		setEstadoCelda(estadoCelda);
	}
	
	public static final CeldaDTO build() {
		return new CeldaDTO();
	}

	public final UUID getId() {
		return id;
	}

	public final String getNombre() {
		return nombre;
	}

	public final TipoVehiculoDTO getTipoVehiculo() {
		return tipoVehiculo;
	}

	public final ParqueaderoDTO getParqueadero() {
		return parqueadero;
	}

	public final EstadoCeldaDTO getEstadoCelda() {
		return estadoCelda;
	}

	public final CeldaDTO setId(UUID id) {
        this.id = UUIDHelper.getDefault(id, UUIDHelper.getDefault());
        return this;
	}

	public final CeldaDTO setNombre(String nombre) {
        this.nombre = TextHelper.applyTrim(nombre);
        return this;
	}

	public final CeldaDTO setTipoVehiculo(TipoVehiculoDTO tipoVehiculo) {
	      this.tipoVehiculo = ObjectHelper.getObjectHelper().
	                getDefaultValue(tipoVehiculo, new TipoVehiculoDTO());
	        return this;
	}

	public final CeldaDTO setParqueadero(ParqueaderoDTO parqueadero) {
		this.parqueadero = ObjectHelper.getObjectHelper().getDefaultValue(parqueadero, new ParqueaderoDTO());
		return this;
	}
	public final CeldaDTO setEstadoCelda(EstadoCeldaDTO estadoCelda) {
		this.estadoCelda = ObjectHelper.getObjectHelper().getDefaultValue(estadoCelda, new EstadoCeldaDTO());
		return this;
	}
	
	
	
	
	
	

}
