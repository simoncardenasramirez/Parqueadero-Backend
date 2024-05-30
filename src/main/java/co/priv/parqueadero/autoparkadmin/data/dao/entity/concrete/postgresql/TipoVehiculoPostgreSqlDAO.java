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
import co.priv.parqueadero.autoparkadmin.data.dao.entity.TipoVehiculoDAO;
import co.priv.parqueadero.autoparkadmin.data.dao.entity.VehiculoDAO;
import co.priv.parqueadero.autoparkadmin.data.dao.entity.concrete.SqlConnection;
import co.priv.parqueadero.autoparkadmin.entity.TipoVehiculoEntity;
import co.priv.parqueadero.autoparkadmin.entity.VehiculoEntity;

public class TipoVehiculoPostgreSqlDAO extends SqlConnection implements TipoVehiculoDAO {

	public TipoVehiculoPostgreSqlDAO(final Connection conexion) {
		super(conexion);
	}

	@Override
	public List<TipoVehiculoEntity> consultar(TipoVehiculoEntity data) {
		final List<TipoVehiculoEntity> tiposVehiculo = new ArrayList<>();

	
		final StringBuilder sentenciaSql = new StringBuilder();
		sentenciaSql.append("SELECT codigo, nombre FROM TipoVehiculo");


		if (ObjectHelper.getObjectHelper().isNull(data)) {
			if (ObjectHelper.getObjectHelper().isNull(data.getId())) {
				sentenciaSql.append(" WHERE codigo = ?");
			}
			if (!TextHelper.isNullOrEmpty(data.getNombre())) {
				if (sentenciaSql.toString().contains("WHERE")) {
					sentenciaSql.append(" AND nombre = ?");
				} else {
					sentenciaSql.append(" WHERE nombre = ?");
				}
			}
		}

		try (final PreparedStatement sentenciaSqlPreparada = getConexion().prepareStatement(sentenciaSql.toString())) {
		
			int index = 1;
			if (ObjectHelper.getObjectHelper().isNull(data.getId())) {
				if (ObjectHelper.getObjectHelper().isNull(data.getId())) {
					sentenciaSqlPreparada.setObject(index++, data.getId());
				}
				if (!TextHelper.isNullOrEmpty(data.getNombre())) {
					sentenciaSqlPreparada.setString(index++, data.getNombre());
				}
			}

		
		
			try (final ResultSet resultado = sentenciaSqlPreparada.executeQuery()) {
			    while (resultado.next()) {
			        TipoVehiculoEntity tipoVehiculo = new TipoVehiculoEntity();
			        tipoVehiculo.setId((UUID) resultado.getObject("codigo"));
			        tipoVehiculo.setNombre(resultado.getString("nombre"));
			        tiposVehiculo.add(tipoVehiculo);
			    }
			}

		} catch (final SQLException excepcion) {
			var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00037);
			var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00038);
			throw new DataAUTOPARKADMINException(mensajeUsuario, mensajeTecnico, excepcion);
		} catch (final Exception excepcion) {
			var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00039);
			var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00040);
			throw new DataAUTOPARKADMINException(mensajeUsuario, mensajeTecnico, excepcion);
		}

		return tiposVehiculo;
	}

}
