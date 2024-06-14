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
import co.priv.parqueadero.autoparkadmin.data.dao.entity.UsuarioDAO;
import co.priv.parqueadero.autoparkadmin.data.dao.entity.concrete.SqlConnection;
import co.priv.parqueadero.autoparkadmin.entity.UsuarioEntity;

public class UsuarioPostgreSqlDAO extends SqlConnection implements UsuarioDAO {

	public UsuarioPostgreSqlDAO(final Connection conexion) {
		super(conexion);
	}

	@Override
	public final void crear(UsuarioEntity data) {
		final StringBuilder sentenciaSql = new StringBuilder();

		sentenciaSql.append("INSERT INTO Usuario (id, usuario, contraseña) ");
		sentenciaSql.append("VALUES (?,?,?)");

		try (final PreparedStatement sentenciaSqlPreparada = getConexion().prepareStatement(sentenciaSql.toString())) {

			sentenciaSqlPreparada.setObject(1, data.getId());
			sentenciaSqlPreparada.setString(2, data.getUsuario());
			sentenciaSqlPreparada.setString(3, data.getContraseña());

			sentenciaSqlPreparada.executeUpdate();

		} catch (final SQLException excepcion) {
			var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00053);
			var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00054);
			throw new DataAUTOPARKADMINException(mensajeTecnico, mensajeUsuario, excepcion);
		} catch (final Exception excepcion) {
			var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00055);
			var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00056);
			throw new DataAUTOPARKADMINException(mensajeTecnico, mensajeUsuario, excepcion);
		}
	}

	@Override
	public List<UsuarioEntity> consultar(UsuarioEntity data) {
		final StringBuilder sentenciaSql = new StringBuilder();
		sentenciaSql.append("SELECT id, usuario, contraseña ").append("FROM Usuario ").append("WHERE 1=1");

		final List<Object> parametros = new ArrayList<>();

		if (!ObjectHelper.getObjectHelper().isNull(data.getId()) && !data.getId().equals(UUIDHelper.getDefault())) {
			sentenciaSql.append(" AND id = ?");
			parametros.add(data.getId());
		}
		if (!TextHelper.isNullOrEmpty(data.getUsuario())) {
			sentenciaSql.append(" AND usuario = ?");
			parametros.add(data.getUsuario());
		}
		if (!TextHelper.isNullOrEmpty(data.getContraseña())) {
			sentenciaSql.append(" AND contraseña = ?");
			parametros.add(data.getContraseña());
		}

		final List<UsuarioEntity> usuarios = new ArrayList<>();

		try (final PreparedStatement sentenciaSqlPreparada = getConexion().prepareStatement(sentenciaSql.toString())) {
			for (int i = 0; i < parametros.size(); i++) {
				sentenciaSqlPreparada.setObject(i + 1, parametros.get(i));
			}

			try (final ResultSet resultado = sentenciaSqlPreparada.executeQuery()) {
				while (resultado.next()) {
					UsuarioEntity usuario = UsuarioEntity.build().setId(UUID.fromString(resultado.getString("id")))
							.setUsuario(resultado.getString("usuario"))
							.setContraseña(resultado.getString("contraseña"));
					usuarios.add(usuario);
				}
			}
		} catch (final SQLException exception) {
			var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00057);
			var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00058);
			throw new DataAUTOPARKADMINException(mensajeTecnico, mensajeUsuario, exception);
		} catch (final Exception exception) {
			var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00059);
			var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00060);
			throw new DataAUTOPARKADMINException(mensajeTecnico, mensajeUsuario, exception);
		}

		return usuarios;
	}

	@Override
    public boolean autenticarUsuario(final String usuario, final String contraseña) {
        final StringBuilder sentenciaSql = new StringBuilder();
        sentenciaSql.append("SELECT id FROM Usuario WHERE usuario = ? AND contraseña = ?");

        try (final PreparedStatement sentenciaPreparada = getConexion().prepareStatement(sentenciaSql.toString())) {
            sentenciaPreparada.setString(1, usuario);
            sentenciaPreparada.setString(2, contraseña);

            try (final ResultSet resultado = sentenciaPreparada.executeQuery()) {
                return resultado.next();
            }
        } catch (SQLException exception) {
            var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00061);
            var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00062);
            throw new DataAUTOPARKADMINException(mensajeTecnico, mensajeUsuario, exception);
        } catch (final Exception exception) {
            var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00063);
            var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00064);

            throw new DataAUTOPARKADMINException(mensajeTecnico, mensajeUsuario, exception);
        }
    }
	
    @Override
    public UsuarioEntity consultarPorNombreUsuario(final String nombreUsuario) {
        final StringBuilder sentenciaSql = new StringBuilder();
        sentenciaSql.append("SELECT id, usuario, contraseña FROM Usuario WHERE usuario = ?");

        try (final PreparedStatement sentenciaPreparada = getConexion().prepareStatement(sentenciaSql.toString())) {
            sentenciaPreparada.setString(1, nombreUsuario);

            try (final ResultSet resultado = sentenciaPreparada.executeQuery()) {
                if (resultado.next()) {
                    return UsuarioEntity.build()
                            .setId(UUID.fromString(resultado.getString("id")))
                            .setUsuario(resultado.getString("usuario"))
                            .setContraseña(resultado.getString("contraseña"));
                } else {
                    return null;
                }
            }
        } catch (SQLException exception) {
            var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00065);
            var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00066);
            throw new DataAUTOPARKADMINException(mensajeTecnico, mensajeUsuario, exception);
        } catch (final Exception exception) {
            var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00067);
            var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00068);
            throw new DataAUTOPARKADMINException(mensajeTecnico, mensajeUsuario, exception);
        }
    }
}


