package co.priv.parqueadero.autoparkadmin.business.usecase.impl.usuario;

import co.priv.parqueadero.autoparkadmin.business.domain.UsuarioDomain;
import co.priv.parqueadero.autoparkadmin.business.usecase.UseCaseWithReturn;
import co.priv.parqueadero.autoparkadmin.crosscutting.exceptions.custom.BusinessAUTOPARKADMINException;
import co.priv.parqueadero.autoparkadmin.data.dao.factory.DAOFactory;

public final class AutenticarUsuario implements UseCaseWithReturn<UsuarioDomain, Boolean> {

    private final DAOFactory factory;

    public AutenticarUsuario(final DAOFactory factory) {
        this.factory = factory;
    }

    @Override
    public Boolean execute(final UsuarioDomain data) {

        if (data.getUsuario().isEmpty() && data.getContraseña().isEmpty()) {
            var mensajeUsuario = "Los campo usuario y contraseña no pueden estar vacíos.";
            throw new BusinessAUTOPARKADMINException(mensajeUsuario);
        }

        if (data.getUsuario().isEmpty()) {
            var mensajeUsuario = "El campo usuario no puede estar vacío";
            throw new BusinessAUTOPARKADMINException(mensajeUsuario);
        }

        if (data.getContraseña().isEmpty()) {
            var mensajeUsuario = "El campo contraseña no puede estar vacío.";
            throw new BusinessAUTOPARKADMINException(mensajeUsuario);
        }

        var usuarioDAO = factory.getUsuarioDAO();
        boolean isAuthenticated = usuarioDAO.autenticarUsuario(data.getUsuario(), data.getContraseña());

        if (!isAuthenticated) {

            var mensajeUsuario = "El usuario y/o contraseña son incorrectos.";
            throw new BusinessAUTOPARKADMINException(mensajeUsuario);
        }
        return true;
    }
}
