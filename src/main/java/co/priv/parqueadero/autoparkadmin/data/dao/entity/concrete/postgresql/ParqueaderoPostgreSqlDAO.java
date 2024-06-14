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
import co.priv.parqueadero.autoparkadmin.data.dao.entity.ParqueaderoDAO;
import co.priv.parqueadero.autoparkadmin.data.dao.entity.concrete.SqlConnection;
import co.priv.parqueadero.autoparkadmin.entity.ParqueaderoEntity;


public class ParqueaderoPostgreSqlDAO extends SqlConnection implements ParqueaderoDAO {
	
	public ParqueaderoPostgreSqlDAO(final Connection conexion) {
		super(conexion);
	}

	@Override
	public List<ParqueaderoEntity> consultar(ParqueaderoEntity data) {
		final StringBuilder sentenciaSql = new StringBuilder();
		sentenciaSql.append("SELECT p.id, p.nombre");
		sentenciaSql.append(" FROM parqueadero p");
		sentenciaSql.append(" WHERE 1=1");

		final List<Object> parametros = new ArrayList<>();

		if (!ObjectHelper.getObjectHelper().isNull(data.getId()) && !data.getId().equals(UUIDHelper.getDefault())) {
			sentenciaSql.append(" AND p.id = ?");
			parametros.add(data.getId());
		}
		
		if (!TextHelper.isNullOrEmpty(data.getNombre())) {
			sentenciaSql.append(" AND p.nombre = ?");
			parametros.add(data.getNombre());
		}

		final List<ParqueaderoEntity> parqueaderos = new ArrayList<>();

		try (final PreparedStatement sentenciaSqlPreparada = getConexion().prepareStatement(sentenciaSql.toString())) {
			for (int i = 0; i < parametros.size(); i++) {
				sentenciaSqlPreparada.setObject(i + 1, parametros.get(i));
			}

			try (final ResultSet resultado = sentenciaSqlPreparada.executeQuery()) {
				while (resultado.next()) {
					ParqueaderoEntity parqueadero = ParqueaderoEntity.build();
					parqueadero.setId(UUIDHelper.convertToUUID(resultado.getString("id")));
					parqueadero.setNombre(resultado.getString("nombre"));

					parqueaderos.add(parqueadero);
				}
			}

		} catch (final SQLException exception) {
			var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00073);
			var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00074);
			
			throw new DataAUTOPARKADMINException(mensajeUsuario, mensajeTecnico, exception);

		} catch (final Exception exception) {
			var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00075);
			var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00076);
			
			throw new DataAUTOPARKADMINException(mensajeUsuario, mensajeTecnico, exception);
		}

		return parqueaderos;
	}

}
