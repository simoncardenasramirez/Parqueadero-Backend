package co.priv.parqueadero.autoparkadmin.data.dao.factory.concrete;

import java.sql.DriverManager;
import java.sql.SQLException;

import co.priv.parqueadero.autoparkadmin.crosscutting.exceptions.AUTOPARKADMINException;
import co.priv.parqueadero.autoparkadmin.crosscutting.exceptions.custom.DataAUTOPARKADMINException;
import co.priv.parqueadero.autoparkadmin.crosscutting.exceptions.messagecatalog.MessageCatalogStrategy;
import co.priv.parqueadero.autoparkadmin.crosscutting.exceptions.messagecatalog.data.CodigoMensaje;
import co.priv.parqueadero.autoparkadmin.crosscutting.helpers.SQLHelper;
import co.priv.parqueadero.autoparkadmin.data.dao.entity.TipoVehiculoDAO;
import co.priv.parqueadero.autoparkadmin.data.dao.entity.VehiculoDAO;
import co.priv.parqueadero.autoparkadmin.data.dao.entity.concrete.SqlConnection;
import co.priv.parqueadero.autoparkadmin.data.dao.factory.DAOFactory;

public final class PostgreSQLDAOFactory extends SqlConnection implements DAOFactory {

	public PostgreSQLDAOFactory() {
		super();
		abrirConexion();
	}



	@Override
	public void abrirConexion() {
		final String connectionUrl = "jdbc:postgresql://localhost:5432/Parqueadero?user=postgres&password=f4n2d1j9";
	
		try {
			setConexion(DriverManager.getConnection(connectionUrl));
		} catch (final AUTOPARKADMINException excepcion) {
			var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00002);
			var mensajeTecnico = "Se ha presentado un problema tratando de obtener la conexión con la base de datos wednesday en el servidor de bases de datos wednesday.database.windows.net. Por favor revise la traza de errores para identificar y solucionar el problema...";

			throw new DataAUTOPARKADMINException(mensajeTecnico, mensajeUsuario, excepcion);
		} catch (final SQLException excepcion) {
			var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00002);
			var mensajeTecnico = "Se ha presentado un problema tratando de obtener la conexión con la base de datos wednesday en el servidor de bases de datos wednesday.database.windows.net. Por favor revise la traza de errores para identificar y solucionar el problema...";

			throw new DataAUTOPARKADMINException(mensajeTecnico, mensajeUsuario, excepcion);
		} catch (final Exception excepcion) {
			var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00002);
			var mensajeTecnico = "Se ha presentado un problema INESPERADO tratando de obtener la conexión con la base de datos wednesday en el servidor de bases de datos wednesday.database.windows.net. Por favor revise la traza de errores para identificar y solucionar el problema...";

			throw new DataAUTOPARKADMINException(mensajeTecnico, mensajeUsuario, excepcion);
		}
	}

	@Override
	public void cerrarConexion() {
		SQLHelper.close(getConexion());
	}

	@Override
	public void iniciarTransaccion() {
		SQLHelper.initTransaction(getConexion());
	}

	@Override
	public void confirmarTransaccion() {
		SQLHelper.commit(getConexion());
	}

	@Override
	public void cancelarTransaccion() {
		SQLHelper.rollback(getConexion());
	}

	@Override
	public VehiculoDAO getVehiculoDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TipoVehiculoDAO getTipoVehiculoDAO() {
		// TODO Auto-generated method stub
		return null;
	}

}