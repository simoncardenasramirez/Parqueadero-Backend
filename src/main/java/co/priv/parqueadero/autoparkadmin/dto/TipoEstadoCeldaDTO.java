package co.priv.parqueadero.autoparkadmin.dto;

import java.util.UUID;
import co.priv.parqueadero.autoparkadmin.crosscutting.helpers.TextHelper;



public final class TipoEstadoCeldaDTO {
	
	private UUID id;
	private String nombre;
	
	
	public TipoEstadoCeldaDTO() {
		super();
	}

	public TipoEstadoCeldaDTO(UUID id, String nombre) {
		super();
		setId(id);
		setNombre(nombre);
	}
	
	public static final TipoEstadoCeldaDTO build() {
		return new TipoEstadoCeldaDTO();
	}


	public  UUID getId() {
		return id;
	}


	public  TipoEstadoCeldaDTO setId(final UUID id) {
		this.id = id;
		return this;
	}


	public  String getNombre() {
		return nombre;
	}


	public  TipoEstadoCeldaDTO setNombre(final String nombre) {
		this.nombre =TextHelper.applyTrim(nombre);
		return this;
	}
	
	
	
	
	
}
