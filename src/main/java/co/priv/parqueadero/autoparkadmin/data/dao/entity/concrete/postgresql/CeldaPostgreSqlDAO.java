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
import co.priv.parqueadero.autoparkadmin.data.dao.entity.CeldaDAO;
import co.priv.parqueadero.autoparkadmin.data.dao.entity.concrete.SqlConnection;
import co.priv.parqueadero.autoparkadmin.entity.CeldaEntity;
import co.priv.parqueadero.autoparkadmin.entity.EstadoCeldaEntity;
import co.priv.parqueadero.autoparkadmin.entity.ParqueaderoEntity;
import co.priv.parqueadero.autoparkadmin.entity.TipoVehiculoEntity;


public final class CeldaPostgreSqlDAO extends SqlConnection implements CeldaDAO {

    public CeldaPostgreSqlDAO(final Connection conexion){
        super(conexion);
    }

    @Override
    public final void crear(CeldaEntity data) {
        final StringBuilder sentenciaSql = new StringBuilder();

        sentenciaSql.append("INSERT INTO Celda (id, nombre, tipoVehiculo, estadoCelda, parqueadero) ");
        sentenciaSql.append("VALUES (?,?,?,?,?)");

        try (final PreparedStatement sentenciaSqlPreparada = getConexion().prepareStatement(sentenciaSql.toString())) {

            sentenciaSqlPreparada.setObject(1, data.getId());
            sentenciaSqlPreparada.setString(2, data.getNombre());
            sentenciaSqlPreparada.setObject(3, data.getTipoVehiculo().getId());
            sentenciaSqlPreparada.setObject(4, data.getEstadoCelda().getId());
            sentenciaSqlPreparada.setObject(5, data.getParqueadero().getId());
            sentenciaSqlPreparada.executeUpdate();

        } catch (final SQLException excepcion) {
            var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00080);
            var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00081);
            throw new DataAUTOPARKADMINException(mensajeTecnico, mensajeUsuario, excepcion);
        } catch (final Exception excepcion) {
            var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00082);
            var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00083);
            throw new DataAUTOPARKADMINException(mensajeTecnico, mensajeUsuario, excepcion);
        }
    }


    @Override
    public List<CeldaEntity> consultar(CeldaEntity data) {
        final StringBuilder sentenciaSql = new StringBuilder();
        sentenciaSql.append("SELECT c.id, c.nombre, ")
                    .append("t.id AS idTipoVehiculo, t.nombre AS nombreTipoVehiculo, ")
                    .append("p.id AS idParqueadero, p.nombre AS nombreParqueadero, ")
                    .append("e.id AS idEstadoCelda, e.nombre AS nombreEstadoCelda ")
                    .append("FROM Celda c ")
                    .append("INNER JOIN TipoVehiculo t ON c.tipoVehiculo = t.id ")
                    .append("INNER JOIN Parqueadero p ON c.parqueadero = p.id ")
                    .append("INNER JOIN EstadoCelda e ON c.estadoCelda = e.id ")
                    .append("WHERE 1=1 ");

        final List<Object> parametros = new ArrayList<>();

        if (!ObjectHelper.getObjectHelper().isNull(data.getId()) &&
                !data.getId().equals(UUIDHelper.getDefault())) {
            sentenciaSql.append(" AND c.id = ?");
            parametros.add(data.getId());
        }
        if (!TextHelper.isNullOrEmpty(data.getNombre())) {
            sentenciaSql.append(" AND c.nombre = ?");
            parametros.add(data.getNombre());
        }
        if (!ObjectHelper.getObjectHelper().isNull(data.getTipoVehiculo()) &&
                !ObjectHelper.getObjectHelper().isNull(data.getTipoVehiculo().getId()) &&
                !data.getTipoVehiculo().getId().equals(UUIDHelper.getDefault())) {
            sentenciaSql.append(" AND p.tipodocumento = ?");
            parametros.add(data.getTipoVehiculo().getId());
        }
        if (!ObjectHelper.getObjectHelper().isNull(data.getParqueadero()) &&
                !ObjectHelper.getObjectHelper().isNull(data.getParqueadero().getId()) &&
                !data.getParqueadero().getId().equals(UUIDHelper.getDefault())) {
            sentenciaSql.append(" AND c.parqueadero = ?");
            parametros.add(data.getParqueadero().getId());
        }
        if (!ObjectHelper.getObjectHelper().isNull(data.getEstadoCelda()) &&
                !ObjectHelper.getObjectHelper().isNull(data.getEstadoCelda().getId()) &&
                !data.getEstadoCelda().getId().equals(UUIDHelper.getDefault())) {
            sentenciaSql.append(" AND c.estadoCelda = ?");
            parametros.add(data.getEstadoCelda().getId());
        }

        final List<CeldaEntity> celdas = new ArrayList<>();

        try (final PreparedStatement sentenciaSqlPreparada = getConexion().prepareStatement(sentenciaSql.toString())) {
            for (int i = 0; i < parametros.size(); i++) {
                sentenciaSqlPreparada.setObject(i + 1, parametros.get(i));
            }

            try (final ResultSet resultado = sentenciaSqlPreparada.executeQuery()) {
                while (resultado.next()) {
                    CeldaEntity celda = new CeldaEntity();
                    celda.setId(UUID.fromString(resultado.getString("id")));
                    celda.setNombre(resultado.getString("nombre"));

                    TipoVehiculoEntity tipoVehiculo = new TipoVehiculoEntity();
                    tipoVehiculo.setId(UUID.fromString(resultado.getString("idTipoVehiculo")));
                    tipoVehiculo.setNombre(resultado.getString("nombreTipoVehiculo"));

                    ParqueaderoEntity parqueadero = new ParqueaderoEntity();
                    parqueadero.setId(UUID.fromString(resultado.getString("idParqueadero")));
                    parqueadero.setNombre(resultado.getString("nombreParqueadero"));

                    EstadoCeldaEntity estadoCelda = new EstadoCeldaEntity();
                    estadoCelda.setId(UUID.fromString(resultado.getString("idEstadoCelda")));
                    estadoCelda.setNombre(resultado.getString("nombreEstadoCelda"));

                    celda.setTipoVehiculo(tipoVehiculo);
                    celda.setParqueadero(parqueadero);
                    celda.setEstadoCelda(estadoCelda);

                    celdas.add(celda);
                }
            }
        } catch (final SQLException exception) {
            var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00084);
            var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00085);

            throw new DataAUTOPARKADMINException(mensajeTecnico, mensajeUsuario, exception);
        } catch (final Exception exception) {
            var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00086);
            var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00087);

            throw new DataAUTOPARKADMINException(mensajeTecnico, mensajeUsuario, exception);
        }

        return celdas;
    }

}