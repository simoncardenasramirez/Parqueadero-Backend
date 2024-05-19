package co.priv.parqueadero.autoparkadmin.entity;

import java.util.UUID;
import co.priv.parqueadero.autoparkadmin.crosscutting.helpers.TextHelper;



public final class TipoEstadoCeldaEntity {
	
	private UUID id;
	private String nombre;
	
	
	public TipoEstadoCeldaEntity() {
		super();
	}

	public TipoEstadoCeldaEntity(UUID id, String nombre) {
		super();
		setId(id);
		setNombre(nombre);
	}
	
	public static final TipoEstadoCeldaEntity build() {
		return new TipoEstadoCeldaEntity();
	}


	public  UUID getId() {
		return id;
	}


	public  TipoEstadoCeldaEntity setId(final UUID id) {
		this.id = id;
		return this;
	}


	public  String getNombre() {
		return nombre;
	}


	public  TipoEstadoCeldaEntity setNombre(final String nombre) {
		this.nombre =TextHelper.applyTrim(nombre);
		return this;
	}
	
	
	
	
	
}
