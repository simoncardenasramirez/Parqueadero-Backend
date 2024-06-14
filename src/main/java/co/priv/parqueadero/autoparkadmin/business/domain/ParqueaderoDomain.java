package co.priv.parqueadero.autoparkadmin.business.domain;

import java.util.UUID;

import co.priv.parqueadero.autoparkadmin.crosscutting.helpers.TextHelper;
import co.priv.parqueadero.autoparkadmin.crosscutting.helpers.UUIDHelper;



public final class ParqueaderoDomain {
	
	private UUID id;
	private String nombre;
	
	private ParqueaderoDomain(final UUID id, final String nombre) {
		setId(id);
		setNombre(nombre);
	}
	
	public ParqueaderoDomain() {
		setNombre(TextHelper.EMPTY);
	}
	
	public static ParqueaderoDomain build (final UUID id, final String nombre) {
		return new ParqueaderoDomain(id, nombre);
	}
	
	public static ParqueaderoDomain build (final UUID id) {
		return new ParqueaderoDomain(id, TextHelper.EMPTY);
	}
	public static ParqueaderoDomain build () {
		return new ParqueaderoDomain();
	}
	
	private final void setId(final UUID id) {
		this.id = UUIDHelper.getDefault(id, UUIDHelper.getDefault());
	}
	
	private final void setNombre(final String nombre) {
		this.nombre = TextHelper.applyTrim(nombre);
	}
	
	public final UUID getId() {
		return id;
	}
	public final String getNombre() {
		return nombre;
	}




	
	
}