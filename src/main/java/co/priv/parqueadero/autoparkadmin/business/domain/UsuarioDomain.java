package co.priv.parqueadero.autoparkadmin.business.domain;

import java.util.UUID;

import co.priv.parqueadero.autoparkadmin.crosscutting.helpers.TextHelper;
import co.priv.parqueadero.autoparkadmin.crosscutting.helpers.UUIDHelper;


public class UsuarioDomain {

	private UUID id;
	private String usuario;
	private String contraseña;

	public UsuarioDomain() {
		setId(UUIDHelper.getDefault());
		setUsuario(TextHelper.EMPTY);
		setContraseña(TextHelper.EMPTY);
	}

	public UsuarioDomain(final UUID id, final String usuario, final String contraseña) {
		setId(id);
		setUsuario(usuario);
		setContraseña(contraseña);
	}
	
	public static final UsuarioDomain build(UUID uuid, String usuario, String contraseña) {
		return new UsuarioDomain(uuid,usuario,contraseña);
	}
	
	public static final UsuarioDomain build() {
		return new UsuarioDomain();
	}


	public UUID getId() {
		return id;
	}

	public UsuarioDomain setId(final UUID id) {
		this.id = UUIDHelper.getDefault(id, UUIDHelper.getDefault());
		return this;
	}

	public String getUsuario() {
		return usuario;
	}

	public UsuarioDomain setUsuario(String usuario) {
		this.usuario = TextHelper.applyTrim(usuario);
		return this;
	}

	public String getContraseña() {
		return contraseña;
	}

	public UsuarioDomain setContraseña(String contraseña) {
		this.contraseña = TextHelper.applyTrim(contraseña);
		return this;
	}

}
