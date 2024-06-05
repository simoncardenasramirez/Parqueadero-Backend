package co.priv.parqueadero.autoparkadmin.controller.response;

import java.util.ArrayList;

import co.priv.parqueadero.autoparkadmin.dto.TipoVehiculoDTO;

public class TipoVehiculoResponse extends Response<TipoVehiculoDTO> {

	public TipoVehiculoResponse() {
		setMensajes(new ArrayList<String>());
		setDatos(new ArrayList<>());
	}

}
