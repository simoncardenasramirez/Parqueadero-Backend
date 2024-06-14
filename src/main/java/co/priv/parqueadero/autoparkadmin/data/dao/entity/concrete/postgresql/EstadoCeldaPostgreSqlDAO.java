package co.priv.parqueadero.autoparkadmin.data.dao.entity.concrete.postgresql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.priv.parqueadero.autoparkadmin.crosscutting.exceptions.custom.DataAUTOPARKADMINException;
import co.priv.parqueadero.autoparkadmin.crosscutting.exceptions.messagecatalog.MessageCatalogStrategy;
import co.priv.parqueadero.autoparkadmin.crosscutting.exceptions.messagecatalog.data.CodigoMensaje;
import co.priv.parqueadero.autoparkadmin.crosscutting.helpers.ObjectHelper;
import co.priv.parqueadero.autoparkadmin.crosscutting.helpers.TextHelper;
import co.priv.parqueadero.autoparkadmin.crosscutting.helpers.UUIDHelper;
import co.priv.parqueadero.autoparkadmin.data.dao.entity.EstadoCeldaDAO;
import co.priv.parqueadero.autoparkadmin.data.dao.entity.concrete.SqlConnection;
import co.priv.parqueadero.autoparkadmin.entity.EstadoCeldaEntity;


public class EstadoCeldaPostgreSqlDAO extends SqlConnection implements EstadoCeldaDAO{
	
	
	public EstadoCeldaPostgreSqlDAO(final Connection conexion) {
		super(conexion);
	}

	@Override
	public List<EstadoCeldaEntity> consultar(EstadoCeldaEntity data) {
		final StringBuilder sentenciaSql = new StringBuilder();
		sentenciaSql.append("SELECT e.id, e.nombre");
		sentenciaSql.append(" FROM EstadoCelda e");
		sentenciaSql.append(" WHERE 1=1");

		final List<Object> parametros = new ArrayList<>();

		if (!ObjectHelper.getObjectHelper().isNull(data.getId()) && !data.getId().equals(UUIDHelper.getDefault())) {
			sentenciaSql.append(" AND e.id = ?");
			parametros.add(data.getId());
		}
		
		if (!TextHelper.isNullOrEmpty(data.getNombre())) {
			sentenciaSql.append(" AND e.nombre = ?");
			parametros.add(data.getNombre());
		}

		final List<EstadoCeldaEntity> estadosCeldas = new ArrayList<>();

		try (final PreparedStatement sentenciaSqlPreparada = getConexion().prepareStatement(sentenciaSql.toString())) {
			for (int i = 0; i < parametros.size(); i++) {
				sentenciaSqlPreparada.setObject(i + 1, parametros.get(i));
			}

			try (final ResultSet resultado = sentenciaSqlPreparada.executeQuery()) {
				while (resultado.next()) {
					EstadoCeldaEntity estadoCelda = EstadoCeldaEntity.build();
					estadoCelda.setId(UUIDHelper.convertToUUID(resultado.getString("id")));
					estadoCelda.setNombre(resultado.getString("nombre"));

					estadosCeldas.add(estadoCelda);
				}
			}

		} catch (final SQLException exception) {
			var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00109);
			var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00077);
			
			throw new DataAUTOPARKADMINException(mensajeUsuario, mensajeTecnico, exception);

		} catch (final Exception exception) {
			var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00078);
			var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00079);
			
			throw new DataAUTOPARKADMINException(mensajeUsuario, mensajeTecnico, exception);
		}

		return estadosCeldas;
	}


}
