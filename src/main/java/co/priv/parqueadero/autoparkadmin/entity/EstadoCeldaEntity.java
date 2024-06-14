package co.priv.parqueadero.autoparkadmin.entity;

import java.util.UUID;

import co.priv.parqueadero.autoparkadmin.crosscutting.helpers.TextHelper;
import co.priv.parqueadero.autoparkadmin.crosscutting.helpers.UUIDHelper;

public class EstadoCeldaEntity {
	
	private UUID id;
	private String nombre;

	public EstadoCeldaEntity() {
		super();
		setId(UUIDHelper.getDefault());
		setNombre(TextHelper.EMPTY);
	}

	public EstadoCeldaEntity(final UUID id, final String nombre) {
		setId(id);
		setNombre(nombre);
	}
	
	public static final EstadoCeldaEntity build() {
		return new EstadoCeldaEntity();
	}

	public final EstadoCeldaEntity setId(final UUID id) {
		this.id = UUIDHelper.getDefault(id, UUIDHelper.getDefault());
		return this;
	}

	public final EstadoCeldaEntity setNombre(final String nombre) {
		this.nombre = TextHelper.applyTrim(nombre);
		return this;
	}

	public final UUID getId() {
		return id;
	}

	public final String getNombre() {
		return nombre;
	}

}
