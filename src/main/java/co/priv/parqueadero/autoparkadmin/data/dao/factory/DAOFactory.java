package co.priv.parqueadero.autoparkadmin.data.dao.factory;

import co.priv.parqueadero.autoparkadmin.data.dao.entity.CeldaDAO;
import co.priv.parqueadero.autoparkadmin.data.dao.entity.EstadoCeldaDAO;
import co.priv.parqueadero.autoparkadmin.data.dao.entity.ParqueaderoDAO;
import co.priv.parqueadero.autoparkadmin.data.dao.entity.TipoVehiculoDAO;
import co.priv.parqueadero.autoparkadmin.data.dao.entity.UsuarioDAO;
import co.priv.parqueadero.autoparkadmin.data.dao.entity.VehiculoDAO;
import co.priv.parqueadero.autoparkadmin.data.dao.factory.concrete.PostgreSQLDAOFactory;

public interface DAOFactory {

	static DAOFactory getFactory() {
		return new PostgreSQLDAOFactory();
	}
	
	void abrirConexion();

	void cerrarConexion();

	void iniciarTransaccion();

	void confirmarTransaccion();

	void cancelarTransaccion();

	VehiculoDAO getVehiculoDAO();

	TipoVehiculoDAO getTipoVehiculoDAO();
	
	UsuarioDAO getUsuarioDAO();
	
	ParqueaderoDAO getParqueaderoDAO();
	
	EstadoCeldaDAO getEstadoCeldaDAO();
	
	CeldaDAO getCeldaDAO();
}
