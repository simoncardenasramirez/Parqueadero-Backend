package co.priv.parqueadero.autoparkadmin.controller.response;

import java.util.ArrayList;

import co.priv.parqueadero.autoparkadmin.dto.ParqueaderoDTO;

public class ParqueaderoResponse extends Response<ParqueaderoDTO>{
	
	public ParqueaderoResponse(){
		setMensajes(new ArrayList<String>());
		setDatos(new ArrayList<>());
	}

}
