package co.priv.parqueadero.autoparkadmin.entity;

import java.util.UUID;

import co.priv.parqueadero.autoparkadmin.crosscutting.helpers.ObjectHelper;
import co.priv.parqueadero.autoparkadmin.crosscutting.helpers.TextHelper;
import co.priv.parqueadero.autoparkadmin.crosscutting.helpers.UUIDHelper;


public class UsuarioEntity {
	
	private UUID id;
	private String usuario;
	private String contraseña;
	
	public UsuarioEntity() {
		setId(UUIDHelper.getDefault());
		setUsuario(TextHelper.EMPTY);
		setContraseña(TextHelper.EMPTY);
	}
	
	public UsuarioEntity(final UUID id,final String usuario,final String contraseña) {
		setId(id);
		setUsuario(usuario);
		setContraseña(contraseña);
	}
	
	public static final UsuarioEntity build() {
		return new UsuarioEntity();
	}



	public UUID getId() {
		return id;
	}

	public UsuarioEntity setId(final UUID id) {
		this.id = UUIDHelper.getDefault(id, UUIDHelper.getDefault());
		return this;
	}

	public String getUsuario() {
		return usuario;
	}

	public UsuarioEntity setUsuario(String usuario) {
		this.usuario = TextHelper.applyTrim(usuario);
		return this;
	}

	public String getContraseña() {
		return contraseña;
	}

	public UsuarioEntity setContraseña(String contraseña) {
		this.contraseña = TextHelper.applyTrim(contraseña);
		return this;
	}


	
	
	
	

}
