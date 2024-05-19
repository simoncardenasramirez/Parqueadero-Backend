package co.priv.parqueadero.autoparkadmin.dto;

import java.util.UUID;
import co.priv.parqueadero.autoparkadmin.crosscutting.helpers.TextHelper;



public final class EstadoCeldaDTO {
	
	private UUID id;
	private String nombre;
	private TipoEstadoCeldaDTO tipoestadocelda;
	
	
	public EstadoCeldaDTO() {
		super();
	}

	public EstadoCeldaDTO(UUID id, String nombre) {
		super();
		setId(id);
		setNombre(nombre);
	}
	
	
	
	public static final EstadoCeldaDTO build() {
		return new EstadoCeldaDTO();
	}


	public  UUID getId() {
		return id;
	}


	public  EstadoCeldaDTO setId(final UUID id) {
		this.id = id;
		return this;
	}


	public  String getNombre() {
		return nombre;
	}


	public  EstadoCeldaDTO setNombre(final String nombre) {
		this.nombre =TextHelper.applyTrim(nombre);
		return this;
	}

	public TipoEstadoCeldaDTO getTipoestadocelda() {
		return tipoestadocelda;
	}

	public EstadoCeldaDTO setTipoestadocelda(final TipoEstadoCeldaDTO tipoestadocelda) {
		this.tipoestadocelda = tipoestadocelda;
		return this;
	}
	
	
	
	
	
}
