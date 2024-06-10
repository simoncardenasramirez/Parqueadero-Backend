package co.priv.parqueadero.autoparkadmin.dto;

import java.util.UUID;

import co.priv.parqueadero.autoparkadmin.crosscutting.helpers.TextHelper;
import co.priv.parqueadero.autoparkadmin.crosscutting.helpers.UUIDHelper;


public class UsuarioDTO {
	
	private UUID id;
	private String usuario;
	private String contraseña;
	
	public UsuarioDTO() {
		setId(UUIDHelper.getDefault());
		setUsuario(TextHelper.EMPTY);
		setContraseña(TextHelper.EMPTY);
	}
	
	public UsuarioDTO(final UUID id,final String usuario,final String contraseña) {
		setId(id);
		setUsuario(usuario);
		setContraseña(contraseña);
	}
	
	public static final UsuarioDTO build() {
		return new UsuarioDTO();
	}

	public UUID getId() {
		return id;
	}

	public UsuarioDTO setId(final UUID id) {
		this.id = UUIDHelper.getDefault(id, UUIDHelper.getDefault());
		return this;
	}

	public String getUsuario() {
		return usuario;
	}

	public UsuarioDTO setUsuario(String usuario) {
		this.usuario = TextHelper.applyTrim(usuario);
		return this;
	}

	public String getContraseña() {
		return contraseña;
	}

	public UsuarioDTO setContraseña(String contraseña) {
		this.contraseña = TextHelper.applyTrim(contraseña);
		return this;
	}
}
