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
import co.priv.parqueadero.autoparkadmin.crosscutting.helpers.UUIDHelper;
import co.priv.parqueadero.autoparkadmin.data.dao.entity.TipoVehiculoDAO;
import co.priv.parqueadero.autoparkadmin.data.dao.entity.VehiculoDAO;
import co.priv.parqueadero.autoparkadmin.data.dao.entity.concrete.SqlConnection;
import co.priv.parqueadero.autoparkadmin.entity.TipoVehiculoEntity;
import co.priv.parqueadero.autoparkadmin.entity.VehiculoEntity;

public final class TipoVehiculoPostgreSqlDAO extends SqlConnection implements TipoVehiculoDAO {

    private static final String CONSULTAR_TIPOS_VEHICULO_SQL = "SELECT id, nombre FROM TipoVehiculo WHERE 1=1";

    public TipoVehiculoPostgreSqlDAO(final Connection conexion) {
        super(conexion);
    }

    @Override
    public List<TipoVehiculoEntity> consultar(final TipoVehiculoEntity data) {

        final StringBuilder sentenciaSql = new StringBuilder(CONSULTAR_TIPOS_VEHICULO_SQL);
        final List<Object> parametros = new ArrayList<>();

        if (!ObjectHelper.getObjectHelper().isNull(data.getId()) && !data.getId().equals(UUIDHelper.getDefault())) {
            sentenciaSql.append(" AND id = ?");
            parametros.add(data.getId());
        }
        if (!TextHelper.isNullOrEmpty(data.getNombre())) {
            sentenciaSql.append(" AND nombre = ?");
            parametros.add(data.getNombre());
        }

        final List<TipoVehiculoEntity> tipoVehiculos = new ArrayList<>();

        try (final PreparedStatement sentenciaSqlPreparada = getConexion().prepareStatement(sentenciaSql.toString())) {
            for (int i = 0; i < parametros.size(); i++) {
                sentenciaSqlPreparada.setObject(i + 1, parametros.get(i));
            }

            try (final ResultSet resultado = sentenciaSqlPreparada.executeQuery()) {
                while (resultado.next()) {
                	TipoVehiculoEntity tipoVehiculo = TipoVehiculoEntity.build()
                            .setId(UUID.fromString(resultado.getString("id")))
                            .setNombre(resultado.getString("nombre"));

                    tipoVehiculos.add(tipoVehiculo);
                }
            }

        } catch (final SQLException exception) {
            var mensajeUsuario = "mensaje 27";
            var mensajeTecnico = "mensaje 28";

            throw new DataAUTOPARKADMINException(mensajeTecnico, mensajeUsuario, exception);

        } catch (final Exception exception) {
            var mensajeUsuario = "mensaje 29";
            var mensajeTecnico = "mensaje 30";

            throw new DataAUTOPARKADMINException(mensajeTecnico, mensajeUsuario, exception);

        }

        return tipoVehiculos;
    }
}