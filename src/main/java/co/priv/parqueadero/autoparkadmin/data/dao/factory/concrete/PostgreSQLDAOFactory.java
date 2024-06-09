package co.priv.parqueadero.autoparkadmin.data.dao.factory.concrete;

import java.sql.DriverManager;
import java.sql.SQLException;

import co.priv.parqueadero.autoparkadmin.crosscutting.exceptions.AUTOPARKADMINException;
import co.priv.parqueadero.autoparkadmin.crosscutting.exceptions.custom.DataAUTOPARKADMINException;
import co.priv.parqueadero.autoparkadmin.crosscutting.exceptions.messagecatalog.MessageCatalogStrategy;
import co.priv.parqueadero.autoparkadmin.crosscutting.exceptions.messagecatalog.data.CodigoMensaje;
import co.priv.parqueadero.autoparkadmin.crosscutting.helpers.SQLHelper;
import co.priv.parqueadero.autoparkadmin.data.dao.entity.TipoVehiculoDAO;
import co.priv.parqueadero.autoparkadmin.data.dao.entity.UsuarioDAO;
import co.priv.parqueadero.autoparkadmin.data.dao.entity.VehiculoDAO;
import co.priv.parqueadero.autoparkadmin.data.dao.entity.concrete.SqlConnection;
import co.priv.parqueadero.autoparkadmin.data.dao.entity.concrete.postgresql.TipoVehiculoPostgreSqlDAO;
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
		return new VehiculoPostgreSqlDAO(getConexion());
	}

	@Override
	public TipoVehiculoDAO getTipoVehiculoDAO() {
		return new TipoVehiculoPostgreSqlDAO(getConexion());
	}

	@Override
	public UsuarioDAO getUsuarioDAO() {
		// TODO Auto-generated method stub
		return null;
	}

//	public static void main(String[] args) {
//	    Connection conexion = null;
//	    try {
//	        // Establecer conexión
//	        final String connectionUrl = "jdbc:postgresql://localhost:5432/postgres?user=postgres&password=PoiuytrewQ123";
//	        conexion = DriverManager.getConnection(connectionUrl);
//	        System.out.println("Conexión establecida correctamente.");
//
//	        // Ejecutar una consulta de prueba
//	        String consulta = "SELECT v.id, v.matricula, tv.nombre AS tipo_vehiculo " +
//	                          "FROM vehiculo v " +
//	                          "JOIN tipovehiculo tv ON v.tipovehiculo = tv.id";
//	        java.sql.Statement statement = conexion.createStatement();
//	        ResultSet resultSet = statement.executeQuery(consulta);
//
//	        // Mostrar resultados de la consulta
//	        while (resultSet.next()) {
//	            UUID id = resultSet.getObject("id", UUID.class);
//	            String nombre = resultSet.getString("matricula");
//	            String tipoVehiculo = resultSet.getString("tipo_vehiculo");
//	            System.out.println("ID: " + id + ", matricula: " + nombre + ", tipo vehiculo: " + tipoVehiculo);
//	        }
//
//	    } catch (SQLException excepcion) {
//	        System.out.println("Error al conectar o ejecutar la consulta: " + excepcion.getMessage());
//	    } finally {
//	        // Cerrar la conexión
//	        if (conexion != null) {
//	            try {
//	                conexion.close();
//	                System.out.println("Conexión cerrada.");
//	            } catch (SQLException e) {
//	                System.out.println("Error al cerrar la conexión: " + e.getMessage());
//	            }
//	        }
//	    }
//	}

}