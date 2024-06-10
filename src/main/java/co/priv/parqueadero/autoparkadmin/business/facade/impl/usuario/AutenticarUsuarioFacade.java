package co.priv.parqueadero.autoparkadmin.business.facade.impl.usuario;

import co.priv.parqueadero.autoparkadmin.business.assembler.dto.impl.UsuarioAssemblerDTO;
import co.priv.parqueadero.autoparkadmin.business.facade.FacadeWithReturn;
import co.priv.parqueadero.autoparkadmin.business.usecase.impl.usuario.AutenticarUsuario;
import co.priv.parqueadero.autoparkadmin.crosscutting.exceptions.AUTOPARKADMINException;
import co.priv.parqueadero.autoparkadmin.crosscutting.exceptions.custom.BusinessAUTOPARKADMINException;
import co.priv.parqueadero.autoparkadmin.data.dao.factory.DAOFactory;
import co.priv.parqueadero.autoparkadmin.dto.UsuarioDTO;

public class AutenticarUsuarioFacade implements FacadeWithReturn<UsuarioDTO, Boolean> {
	
    private DAOFactory daoFactory;

    public AutenticarUsuarioFacade() {
        daoFactory = DAOFactory.getFactory();
    }

    @Override
    public final Boolean execute(final UsuarioDTO dto) {
        daoFactory.iniciarTransaccion();
        try {
            var usuarioDomain = UsuarioAssemblerDTO.getInstance().toDomain(dto);

            final AutenticarUsuario useCase = new AutenticarUsuario(daoFactory);
            return useCase.execute(usuarioDomain);
        } catch (AUTOPARKADMINException exception) {
            daoFactory.cancelarTransaccion();
            throw exception;
        } catch (Exception exception) {
            daoFactory.cancelarTransaccion();
            var mensajeUsuario = "Se ha presentado un problema tratando de autenticar el usuario";
            var mensajeTecnico = "Se ha presentado un problema INESPERADO tratando de autenticar el usuario";

            throw new BusinessAUTOPARKADMINException(mensajeTecnico, mensajeUsuario);
        } finally {
            daoFactory.cerrarConexion();
        }
    }

}
