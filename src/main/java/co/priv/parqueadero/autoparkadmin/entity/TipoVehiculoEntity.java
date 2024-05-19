package co.priv.parqueadero.autoparkadmin.entity;

import java.util.UUID;
import co.priv.parqueadero.autoparkadmin.crosscutting.helpers.TextHelper;



public final class TipoVehiculoEntity {
	
	private UUID id;
	private String nombre;
	
	
	public TipoVehiculoEntity() {
		super();
	}

	public TipoVehiculoEntity(UUID id, String nombre) {
		super();
		setId(id);
		setNombre(nombre);
	}
	
	public static final TipoVehiculoEntity build() {
		return new TipoVehiculoEntity();
	}


	public  UUID getId() {
		return id;
	}


	public  TipoVehiculoEntity setId(final UUID id) {
		this.id = id;
		return this;
	}


	public  String getNombre() {
		return nombre;
	}


	public  TipoVehiculoEntity setNombre(final String nombre) {
		this.nombre =TextHelper.applyTrim(nombre);
		return this;
	}
	
	
	
	
	
}
