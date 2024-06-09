package co.priv.parqueadero.autoparkadmin.controller.response;

import java.util.ArrayList;

import co.priv.parqueadero.autoparkadmin.dto.UsuarioDTO;

public class UsuarioResponse extends Response<UsuarioDTO>{
	
	public UsuarioResponse () {
		setMensajes(new ArrayList<String>());
		setDatos(new ArrayList<>());
	}

}
