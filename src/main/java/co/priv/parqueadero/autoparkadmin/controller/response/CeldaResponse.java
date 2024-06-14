package co.priv.parqueadero.autoparkadmin.controller.response;

import java.util.ArrayList;

import co.priv.parqueadero.autoparkadmin.dto.CeldaDTO;


public class CeldaResponse extends Response<CeldaDTO>{
	
	public CeldaResponse () {
		setMensajes(new ArrayList<String>());
		setDatos(new ArrayList<>());
	}

}