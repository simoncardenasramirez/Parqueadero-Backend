package co.priv.parqueadero.autoparkadmin.business.facade.impl.usuario;

import java.util.List;

import co.priv.parqueadero.autoparkadmin.business.assembler.dto.impl.UsuarioAssemblerDTO;
import co.priv.parqueadero.autoparkadmin.business.facade.FacadeWithReturn;
import co.priv.parqueadero.autoparkadmin.business.usecase.impl.usuario.ConsultarUsuarios;
import co.priv.parqueadero.autoparkadmin.crosscutting.exceptions.AUTOPARKADMINException;
import co.priv.parqueadero.autoparkadmin.crosscutting.exceptions.custom.BusinessAUTOPARKADMINException;
import co.priv.parqueadero.autoparkadmin.data.dao.factory.DAOFactory;
import co.priv.parqueadero.autoparkadmin.dto.UsuarioDTO;

public final class ConsultarUsuariosFacade implements FacadeWithReturn<UsuarioDTO, List<UsuarioDTO>> {

	private DAOFactory daoFactory;

	public ConsultarUsuariosFacade() {
		daoFactory = DAOFactory.getFactory();
	}

	@Override
	public final List<UsuarioDTO> execute(final UsuarioDTO dto) {
		try {

			var useCase = new ConsultarUsuarios(daoFactory);
			var usuarioDomain = UsuarioAssemblerDTO.getInstance().toDomain(dto);
			var resultadosDomain = useCase.execute(usuarioDomain);
			return UsuarioAssemblerDTO.getInstance().toDTOCollection(resultadosDomain);

		} catch (final AUTOPARKADMINException exception) {

			throw exception;
		} catch (final Exception exception) {

			var mensajeUsuario = "Se ha presentado un problema consultar la informacion de los usuarios";
			var mensajeTecnico = "Se ha presentado un problema INESPERADO tratando de consultar los usuarios";

			throw new BusinessAUTOPARKADMINException(mensajeTecnico, mensajeUsuario, exception);

		} finally {
			daoFactory.cerrarConexion();
		}
	}

}
