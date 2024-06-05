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
import co.priv.parqueadero.autoparkadmin.data.dao.entity.VehiculoDAO;
import co.priv.parqueadero.autoparkadmin.data.dao.entity.concrete.SqlConnection;
import co.priv.parqueadero.autoparkadmin.entity.TipoVehiculoEntity;
import co.priv.parqueadero.autoparkadmin.entity.VehiculoEntity;

public class VehiculoPostgreSqlDAO extends SqlConnection implements VehiculoDAO {

	public VehiculoPostgreSqlDAO(final Connection conexion) {
		super(conexion);
	}

	@Override
    public final void crear(VehiculoEntity data) {
        final StringBuilder sentenciaSql = new StringBuilder();

        sentenciaSql.append("INSERT INTO vehiculo (id, matricula, tipoVehiculo) ");
        sentenciaSql.append("VALUES (?,?,?)");

        try (final PreparedStatement sentenciaSqlPreparada = getConexion().prepareStatement(sentenciaSql.toString())) {

            sentenciaSqlPreparada.setObject(1, data.getId());
            sentenciaSqlPreparada.setString(2, data.getMatricula());
            sentenciaSqlPreparada.setObject(3, data.getTipoVehiculo().getId());

            sentenciaSqlPreparada.executeUpdate();

        } catch (final SQLException excepcion) {
            var mensajeUsuario ="mensaje 31";
            var mensajeTecnico = "mensaje 32";
            throw new DataAUTOPARKADMINException(mensajeTecnico, mensajeUsuario, excepcion);
        } catch (final Exception excepcion) {
            var mensajeUsuario = "mensaje 33";
            var mensajeTecnico = "mensaje 34";
            throw new DataAUTOPARKADMINException(mensajeTecnico, mensajeUsuario, excepcion);
        }
    }


    @Override
    public List<VehiculoEntity> consultar (VehiculoEntity data) {
        final StringBuilder sentenciaSql = new StringBuilder();
        sentenciaSql.append("SELECT v.id, v.matricula, ")
                .append("tv.id as idTipoVehiculo, tv.nombre as TipoVehiculo ")
                .append("FROM vehiculo v ")
                .append("INNER JOIN tipovehiculo tv ON v.tipovehiculo = tv.id ")
                .append("WHERE 1=1 ");

        final List<Object> parametros = new ArrayList<>();

        if (!ObjectHelper.getObjectHelper().isNull(data.getId()) &&
                !data.getId().equals(UUIDHelper.getDefault())) {
            sentenciaSql.append(" AND v.id = ?");
            parametros.add(data.getId());
        }
        if (!TextHelper.isNullOrEmpty(data.getMatricula())) {
            sentenciaSql.append(" AND v.matricula = ?");
            parametros.add(data.getMatricula());
        }
        
        if (!ObjectHelper.getObjectHelper().isNull(data.getTipoVehiculo()) &&
                !ObjectHelper.getObjectHelper().isNull(data.getTipoVehiculo().getId()) &&
                !data.getTipoVehiculo().getId().equals(UUIDHelper.getDefault())) {
            sentenciaSql.append(" AND v.tipovehiculo = ?");
            parametros.add(data.getTipoVehiculo().getId());
        }

        final List<VehiculoEntity> vehiculos = new ArrayList<>();

        try (final PreparedStatement sentenciaSqlPreparada = getConexion().prepareStatement(sentenciaSql.toString())) {
            for (int i = 0; i < parametros.size(); i++) {
                sentenciaSqlPreparada.setObject(i + 1, parametros.get(i));
            }

            try (final ResultSet resultado = sentenciaSqlPreparada.executeQuery()) {
                while (resultado.next()) {
                	VehiculoEntity vehiculo = new VehiculoEntity().build()
                        .setId(UUID.fromString(resultado.getString("id")))
                        .setMatricula(resultado.getString("matricula"));

                    TipoVehiculoEntity tipoVehiculo = new TipoVehiculoEntity().build()
                        .setId(UUID.fromString(resultado.getString("idTipoVehiculo")))
                        .setNombre(resultado.getString("TipoVehiculo"));
   

                    vehiculo.setTipoVehiculo(tipoVehiculo);

                    vehiculos.add(vehiculo);
                }
            }
        } catch (final SQLException exception) {
            var mensajeUsuario = "mensaje 35";
            var mensajeTecnico = "mensaje 36";

            throw new DataAUTOPARKADMINException(mensajeTecnico, mensajeUsuario, exception);
        } catch (final Exception exception) {
            var mensajeUsuario = "mensaje 37";
            var mensajeTecnico = "mensaje 38";

            throw new DataAUTOPARKADMINException(mensajeTecnico, mensajeUsuario, exception);
        }

        return vehiculos;
    }

}
