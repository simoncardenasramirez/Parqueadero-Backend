package co.priv.parqueadero.autoparkadmin.entity;

import java.util.UUID;

import co.priv.parqueadero.autoparkadmin.crosscutting.helpers.TextHelper;

public class CeldaEntity {
	
	private UUID id;
	private String nombre;
	private EstadoCeldaEntity estadoCelda;
	
	public CeldaEntity() {
		super();
	}

	public CeldaEntity(UUID id, String nombre, EstadoCeldaEntity estadoCelda ) {
		super();
		setId(id);
		setNombre(nombre);
		setEstadoCelda(estadoCelda);
	}

	public UUID getId() {
		return id;
	}

	public void setId(final UUID id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(final String nombre) {
		this.nombre = TextHelper.applyTrim(nombre);
	}

	public EstadoCeldaEntity getEstadoCelda() {
		return estadoCelda;
	}

	public CeldaEntity setEstadoCelda(EstadoCeldaEntity estadoCelda) {
		this.estadoCelda = estadoCelda;
		return this;
	}
	

	

	
	
	
	
	
}