package co.priv.parqueadero.autoparkadmin.dto;

import java.util.UUID;

import co.priv.parqueadero.autoparkadmin.crosscutting.helpers.TextHelper;

public class CeldaDTO {
	
	private UUID id;
	private String nombre;
	private EstadoCeldaDTO estadoCelda;
	
	public CeldaDTO() {
		super();
	}

	public CeldaDTO(UUID id, String nombre, EstadoCeldaDTO estadoCelda ) {
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

	public EstadoCeldaDTO getEstadoCelda() {
		return estadoCelda;
	}

	public CeldaDTO setEstadoCelda(EstadoCeldaDTO estadoCelda) {
		this.estadoCelda = estadoCelda;
		return this;
	}
	

	

	
	
	
	
	
}