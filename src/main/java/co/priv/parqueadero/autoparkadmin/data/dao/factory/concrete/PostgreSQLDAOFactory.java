package co.priv.parqueadero.autoparkadmin.data.dao.factory.concrete;

import java.sql.DriverManager;

import java.sql.SQLException;

import co.priv.parqueadero.autoparkadmin.crosscutting.exceptions.AUTOPARKADMINException;
import co.priv.parqueadero.autoparkadmin.crosscutting.exceptions.custom.DataAUTOPARKADMINException;
import co.priv.parqueadero.autoparkadmin.crosscutting.exceptions.messagecatalog.MessageCatalogStrategy;
import co.priv.parqueadero.autoparkadmin.crosscutting.exceptions.messagecatalog.data.CodigoMensaje;
import co.priv.parqueadero.autoparkadmin.crosscutting.helpers.SQLHelper;
import co.priv.parqueadero.autoparkadmin.data.dao.entity.CeldaDAO;
import co.priv.parqueadero.autoparkadmin.data.dao.entity.EstadoCeldaDAO;
import co.priv.parqueadero.autoparkadmin.data.dao.entity.ParqueaderoDAO;
import co.priv.parqueadero.autoparkadmin.data.dao.entity.TipoVehiculoDAO;
import co.priv.parqueadero.autoparkadmin.data.dao.entity.UsuarioDAO;
import co.priv.parqueadero.autoparkadmin.data.dao.entity.VehiculoDAO;
import co.priv.parqueadero.autoparkadmin.data.dao.entity.concrete.SqlConnection;
import co.priv.parqueadero.autoparkadmin.data.dao.entity.concrete.postgresql.CeldaPostgreSqlDAO;
import co.priv.parqueadero.autoparkadmin.data.dao.entity.concrete.postgresql.EstadoCeldaPostgreSqlDAO;
import co.priv.parqueadero.autoparkadmin.data.dao.entity.concrete.postgresql.ParqueaderoPostgreSqlDAO;
import co.priv.parqueadero.autoparkadmin.data.dao.entity.concrete.postgresql.TipoVehiculoPostgreSqlDAO;
import co.priv.parqueadero.autoparkadmin.data.dao.entity.concrete.postgresql.UsuarioPostgreSqlDAO;
import co.priv.parqueadero.autoparkadmin.data.dao.entity.concrete.postgresql.VehiculoPostgreSqlDAO;
import co.priv.parqueadero.autoparkadmin.data.dao.factory.DAOFactory;

public final class PostgreSQLDAOFactory extends SqlConnection implements DAOFactory {

	public PostgreSQLDAOFactory() {
		super();
		abrirConexion();
	}

	@Override
	public void abrirConexion() {
		final String connectionUrl = "jdbc:postgresql://localhost:5432/Parqueadero?user=postgres&password=PoiuytrewQ123";

		try {
			setConexion(DriverManager.getConnection(connectionUrl));
		} catch (final AUTOPARKADMINException excepcion) {
			var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00002);
			var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00051);

			throw new DataAUTOPARKADMINException(mensajeTecnico, mensajeUsuario, excepcion);
		} catch (final SQLException excepcion) {
			var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00002);
			var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00052);

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
		return new VehiculoPostgreSqlDAO(getConexion());
	}

	@Override
	public TipoVehiculoDAO getTipoVehiculoDAO() {
		return new TipoVehiculoPostgreSqlDAO(getConexion());
	}

	@Override
	public UsuarioDAO getUsuarioDAO() {
		return new UsuarioPostgreSqlDAO(getConexion());
	}

	@Override
	public ParqueaderoDAO getParqueaderoDAO() {
		return new ParqueaderoPostgreSqlDAO(getConexion());
	}

	@Override
	public EstadoCeldaDAO getEstadoCeldaDAO() {
		return new EstadoCeldaPostgreSqlDAO(getConexion());
	}

	@Override
	public CeldaDAO getCeldaDAO() {
		return new CeldaPostgreSqlDAO(getConexion());
	}
}