package co.priv.parqueadero.autoparkadmin.business.domain;

import java.util.UUID;

import co.priv.parqueadero.autoparkadmin.crosscutting.helpers.TextHelper;
import co.priv.parqueadero.autoparkadmin.crosscutting.helpers.UUIDHelper;



public class TipoVehiculoDomain {
	
	private UUID id;
	private String nombre;
	
	private TipoVehiculoDomain(final UUID id, final String nombre) {
		setId(id);
		setNombre(nombre);
	}
	
	public static TipoVehiculoDomain build(final UUID id, final String nombre) {
		return new TipoVehiculoDomain(id, nombre);
	}
	
	
	public static TipoVehiculoDomain build(final UUID id) {
		return new TipoVehiculoDomain(id, TextHelper.EMPTY);
	}
	
	public static TipoVehiculoDomain build() {
		return new TipoVehiculoDomain(UUIDHelper.getDefault(), TextHelper.EMPTY);
	}
	
	public final UUID getId() {
		return id;
	}
	public final String getNombre() {
		return nombre;
	}
	private final void setId(final UUID id) {
		this.id = UUIDHelper.getDefault(id,UUIDHelper.getDefault());
	}
	private final void setNombre(final String nombre) {
		this.nombre = TextHelper.applyTrim(nombre);
	}
	

}
