package co.priv.parqueadero.autoparkadmin.data.dao.entity.concrete.postgresql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import co.priv.parqueadero.autoparkadmin.crosscutting.exceptions.custom.DataAUTOPARKADMINException;
import co.priv.parqueadero.autoparkadmin.crosscutting.exceptions.messagecatalog.MessageCatalogStrategy;
import co.priv.parqueadero.autoparkadmin.crosscutting.exceptions.messagecatalog.data.CodigoMensaje;
import co.priv.parqueadero.autoparkadmin.crosscutting.helpers.ObjectHelper;
import co.priv.parqueadero.autoparkadmin.crosscutting.helpers.TextHelper;
import co.priv.parqueadero.autoparkadmin.data.dao.entity.VehiculoDAO;
import co.priv.parqueadero.autoparkadmin.data.dao.entity.concrete.SqlConnection;
import co.priv.parqueadero.autoparkadmin.entity.VehiculoEntity;

public class VehiculoPostgreSqlDAO extends SqlConnection implements VehiculoDAO {

	public VehiculoPostgreSqlDAO(final Connection conexion) {
		super(conexion);
	}

	@Override
	public void crear(VehiculoEntity data) {
		final StringBuilder sentenciaSQL = new StringBuilder();

		sentenciaSQL.append("INSERT INTO Vehiculo(id,matricula,tipovehiculo)");
		sentenciaSQL.append("SELECT ?,?,?");

		try (final PreparedStatement sentenciaSQLPreparada = getConexion().prepareStatement(sentenciaSQL.toString())) {
			sentenciaSQLPreparada.setObject(1, data.getId());
			sentenciaSQLPreparada.setString(2, data.getMatricula());
			sentenciaSQLPreparada.setObject(3, data.getTipoVehiculo().getId());

			sentenciaSQLPreparada.executeUpdate();

		} catch (final SQLException excepcion) {
			var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00034);
			var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00026);
			throw new DataAUTOPARKADMINException(mensajeTecnico, mensajeUsuario, excepcion);

		} catch (final Exception excepcion) {
			var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00035);
			var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00026);
			throw new DataAUTOPARKADMINException(mensajeTecnico, mensajeUsuario, excepcion);
		}

	}

	@Override
	public List<VehiculoEntity> consultar(VehiculoEntity data) {
		final StringBuilder sentenciaSql = new StringBuilder();
		sentenciaSql.append("SELECT codigo, matricula FROM Vehiculo WHERE 1=1");

		if (ObjectHelper.getObjectHelper().isNull(data)) {
			if (ObjectHelper.getObjectHelper().isNull(data.getId())) {
				sentenciaSql.append(" AND codigo = ?");
			}
			if (!TextHelper.isNullOrEmpty(data.getMatricula())) {
				sentenciaSql.append(" AND matricula = ?");
			}
		}

		final List<VehiculoEntity> paises = new ArrayList<>();

		try (final PreparedStatement sentenciaSqlPreparada = getConexion().prepareStatement(sentenciaSql.toString())) {

			int index = 1;

			if (ObjectHelper.getObjectHelper().isNull(data)) {
				if (ObjectHelper.getObjectHelper().isNull(data.getId())) {
					sentenciaSqlPreparada.setObject(index++, data.getId());
				}
				if (!TextHelper.isNullOrEmpty(data.getMatricula())) {
					sentenciaSqlPreparada.setString(index++, data.getMatricula());
				}
			}

			try (final ResultSet resultado = sentenciaSqlPreparada.executeQuery()) {
				while (resultado.next()) {
					VehiculoEntity vehiculo = new VehiculoEntity();
					vehiculo.setId((UUID) resultado.getObject("codigo"));
					vehiculo.setMatricula(resultado.getString("matricula"));
					paises.add(vehiculo);
				}
			}

		} catch (final SQLException excepcion) {
			var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00024);
			var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00036);

			throw new DataAUTOPARKADMINException(mensajeUsuario, mensajeTecnico, excepcion);

		} catch (final Exception excepcion) {
			var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00024);
			var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00025);

			throw new DataAUTOPARKADMINException(mensajeUsuario, mensajeTecnico, excepcion);
		}

		return paises;
	}

}
