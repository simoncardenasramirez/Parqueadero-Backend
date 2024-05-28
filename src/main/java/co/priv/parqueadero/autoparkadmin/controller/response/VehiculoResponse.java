package co.priv.parqueadero.autoparkadmin.controller.response;

import java.util.ArrayList;

import co.priv.parqueadero.autoparkadmin.dto.VehiculoDTO;

public class VehiculoResponse extends Response<VehiculoDTO>{
	
	public VehiculoResponse () {
		setMensajes(new ArrayList<>());
		setDatos(new ArrayList<>());
	}

}
