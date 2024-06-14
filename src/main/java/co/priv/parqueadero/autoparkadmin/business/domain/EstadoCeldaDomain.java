package co.priv.parqueadero.autoparkadmin.business.domain;

import java.util.UUID;

import co.priv.parqueadero.autoparkadmin.crosscutting.helpers.TextHelper;
import co.priv.parqueadero.autoparkadmin.crosscutting.helpers.UUIDHelper;

public class EstadoCeldaDomain {

	private UUID id;
	private String nombre;
	
	private EstadoCeldaDomain(final UUID id, final String nombre) {
		setId(id);
		setNombre(nombre);
	}
	
	public static EstadoCeldaDomain build (final UUID id, final String nombre) {
		return new EstadoCeldaDomain(id, nombre);
	}
	
	public static EstadoCeldaDomain build (final UUID id) {
		return new EstadoCeldaDomain(id, TextHelper.EMPTY);
	}
	public static EstadoCeldaDomain build () {
		return new EstadoCeldaDomain(UUIDHelper.getDefault(), TextHelper.EMPTY);
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