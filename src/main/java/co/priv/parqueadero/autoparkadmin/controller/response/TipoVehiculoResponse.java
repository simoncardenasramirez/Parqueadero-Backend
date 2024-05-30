package co.priv.parqueadero.autoparkadmin.controller.response;

import java.util.ArrayList;

import co.priv.parqueadero.autoparkadmin.data.dao.entity.TipoVehiculoDAO;

public class TipoVehiculoResponse extends Response<TipoVehiculoDAO> {

	public TipoVehiculoResponse() {
		setMensajes(new ArrayList<>());
		setDatos(new ArrayList<>());
	}

}
