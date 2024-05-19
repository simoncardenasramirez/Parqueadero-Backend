package co.priv.parqueadero.autoparkadmin.entity;

import java.util.UUID;
import co.priv.parqueadero.autoparkadmin.crosscutting.helpers.TextHelper;



public final class EstadoCeldaEntity {
	
	private UUID id;
	private String nombre;
	private TipoEstadoCeldaEntity tipoestadocelda;
	
	
	public EstadoCeldaEntity() {
		super();
	}

	public EstadoCeldaEntity(UUID id, String nombre) {
		super();
		setId(id);
		setNombre(nombre);
	}
	
	
	
	public static final EstadoCeldaEntity build() {
		return new EstadoCeldaEntity();
	}


	public  UUID getId() {
		return id;
	}


	public  EstadoCeldaEntity setId(final UUID id) {
		this.id = id;
		return this;
	}


	public  String getNombre() {
		return nombre;
	}


	public  EstadoCeldaEntity setNombre(final String nombre) {
		this.nombre =TextHelper.applyTrim(nombre);
		return this;
	}

	public TipoEstadoCeldaEntity getTipoestadocelda() {
		return tipoestadocelda;
	}

	public EstadoCeldaEntity setTipoestadocelda(final TipoEstadoCeldaEntity tipoestadocelda) {
		this.tipoestadocelda = tipoestadocelda;
		return this;
	}
	
	
	
	
	
}
