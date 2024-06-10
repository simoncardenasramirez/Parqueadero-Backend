package co.priv.parqueadero.autoparkadmin.entity;

import java.util.UUID;
import co.priv.parqueadero.autoparkadmin.crosscutting.helpers.TextHelper;
import co.priv.parqueadero.autoparkadmin.crosscutting.helpers.UUIDHelper;

public final class TipoVehiculoEntity {
	
	private UUID id;
	private String nombre;
	
	
	public TipoVehiculoEntity() {
        setId(UUIDHelper.getDefault());
        setNombre(TextHelper.EMPTY);
	}

	public TipoVehiculoEntity(final UUID id, final String nombre) {
		setId(id);
		setNombre(nombre);
	}
	
	public static final TipoVehiculoEntity build() {
		return new TipoVehiculoEntity();
	}


	public  UUID getId() {
		return id;
	}


	public final TipoVehiculoEntity setId(final UUID id) {
        this.id = UUIDHelper.getDefault(id, UUIDHelper.getDefault());
        return this;
	}


	public  String getNombre() {
		return nombre;
	}


	public final TipoVehiculoEntity setNombre(final String nombre) {
		this.nombre =TextHelper.applyTrim(nombre);
		return this;
	}
}
