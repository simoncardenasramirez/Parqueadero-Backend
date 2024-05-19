package co.priv.parqueadero.autoparkadmin.dto;

import java.util.UUID;
import co.priv.parqueadero.autoparkadmin.crosscutting.helpers.TextHelper;



public final class TipoVehiculoDTO {
	
	private UUID id;
	private String nombre;
	
	
	public TipoVehiculoDTO() {
		super();
	}

	public TipoVehiculoDTO(UUID id, String nombre) {
		super();
		setId(id);
		setNombre(nombre);
	}
	
	public static final TipoVehiculoDTO build() {
		return new TipoVehiculoDTO();
	}


	public  UUID getId() {
		return id;
	}


	public  TipoVehiculoDTO setId(final UUID id) {
		this.id = id;
		return this;
	}


	public  String getNombre() {
		return nombre;
	}


	public  TipoVehiculoDTO setNombre(final String nombre) {
		this.nombre =TextHelper.applyTrim(nombre);
		return this;
	}
	
	
	
	
	
}
