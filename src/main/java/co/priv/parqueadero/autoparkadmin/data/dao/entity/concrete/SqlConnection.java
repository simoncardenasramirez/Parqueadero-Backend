package co.priv.parqueadero.autoparkadmin.data.dao.entity.concrete;

import java.sql.Connection;

import co.priv.parqueadero.autoparkadmin.crosscutting.exceptions.custom.DataAUTOPARKADMINException;
import co.priv.parqueadero.autoparkadmin.crosscutting.exceptions.messagecatalog.MessageCatalogStrategy;
import co.priv.parqueadero.autoparkadmin.crosscutting.exceptions.messagecatalog.data.CodigoMensaje;
import co.priv.parqueadero.autoparkadmin.crosscutting.helpers.SQLHelper;



public class SqlConnection {

	private Connection conexion;

	protected SqlConnection(final Connection conexion) {
		setConexion(conexion);
	}

	protected SqlConnection() {
		super();
	}

	protected final Connection getConexion() {
		return conexion;
	}

	protected final void setConexion(final Connection conexion) {

		if (!SQLHelper.isOpen(conexion)) {
			var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00002);
			var MensajeTecnico = "No es posible crear el DAO deseado con una conexion cerrada";

			throw new DataAUTOPARKADMINException(mensajeUsuario, MensajeTecnico);
		}

		this.conexion = conexion;
	}

	public void abrirConexion() {
		// TODO Auto-generated method stub
		
	}

}