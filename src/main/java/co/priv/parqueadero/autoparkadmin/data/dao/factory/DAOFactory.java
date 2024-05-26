package co.priv.parqueadero.autoparkadmin.data.dao.factory;

import co.priv.parqueadero.autoparkadmin.data.dao.entity.TipoVehiculoDAO;
import co.priv.parqueadero.autoparkadmin.data.dao.entity.VehiculoDAO;

public interface DAOFactory {

	static DAOFactory getFactory() {
		//TIENE QUE RETORNAR UN POSTGRESSQLDaoFactory
		//return new AzureSQLDAOFactory();
		return null;
	}

	void cerrarConexion();

	void iniciarTransaccion();

	void confirmarTransaccion();

	void cancelarTransaccion();

	VehiculoDAO getVehiculoDAO();

	TipoVehiculoDAO getTipoVehiculoDAO();

}
