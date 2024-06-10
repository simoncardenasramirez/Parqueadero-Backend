package co.priv.parqueadero.autoparkadmin.data.dao.entity.concrete.postgresql;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import co.priv.parqueadero.autoparkadmin.crosscutting.exceptions.custom.DataAUTOPARKADMINException;
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
			var mensajeUsuario = "Error al crear usuario. Por favor, inténtelo de nuevo más tarde.";
			var mensajeTecnico = "Se produjo un error al ejecutar la consulta SQL de inserción.";
			throw new DataAUTOPARKADMINException(mensajeTecnico, mensajeUsuario, excepcion);
		} catch (final Exception excepcion) {
			var mensajeUsuario = "Error al crear usuario. Por favor, inténtelo de nuevo más tarde.";
			var mensajeTecnico = "Se produjo un error inesperado durante la creación del usuario.";
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
			var mensajeUsuario = "Se ha presentado un problema tratando de consultar los usuarios. Por favor, contacte al administrador del sistema.";
			var mensajeTecnico = "Se ha presentado una SQLException tratando de realizar la consulta de los usuarios en la tabla \"Usuario\" de la base de datos PostgreSQL.";
			throw new DataAUTOPARKADMINException(mensajeTecnico, mensajeUsuario, exception);
		} catch (final Exception exception) {
			var mensajeUsuario = "Se ha presentado un problema tratando de consultar los usuarios. Por favor, contacte al administrador del sistema.";
			var mensajeTecnico = "Se ha presentado un problema INESPERADO con una excepción de tipo Exception tratando de realizar la consulta de los usuarios en la tabla \"Usuario\" de la base de datos PostgreSQL.";
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
            var mensajeUsuario = "Se ha presentado un problema tratando de autenticar los usuarios. Por favor, contacte al administrador del sistema.";
            var mensajeTecnico = "Se ha presentado un problema ejecutando la sentencia SQL en la base de datos PostgreSQL";
            throw new DataAUTOPARKADMINException(mensajeTecnico, mensajeUsuario, exception);
        } catch (final Exception exception) {
            var mensajeUsuario = "Se ha presentado un problema tratando de autenticar los usuarios. Por favor, contacte al administrador del sistema.";
            var mensajeTecnico = "Se ha presentado un INESPERADO problema ejecutando la sentencia SQL en la base de datos PostgreSQL";

            throw new DataAUTOPARKADMINException(mensajeTecnico, mensajeUsuario, exception);
        }
    }
}

