package co.priv.parqueadero.autoparkadmin.controller.response;

import java.util.ArrayList;

import co.priv.parqueadero.autoparkadmin.dto.EstadoCeldaDTO;

public class EstadoCeldaResponse extends Response<EstadoCeldaDTO>{
	
	public EstadoCeldaResponse(){
		setMensajes(new ArrayList<String>());
		setDatos(new ArrayList<>());
	}

}
