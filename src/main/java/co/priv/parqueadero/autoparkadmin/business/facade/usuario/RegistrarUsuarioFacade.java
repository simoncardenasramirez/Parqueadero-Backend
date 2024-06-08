package co.priv.parqueadero.autoparkadmin.business.facade.usuario;

import co.priv.parqueadero.autoparkadmin.business.assembler.dto.impl.UsuarioAssemblerDTO;
import co.priv.parqueadero.autoparkadmin.business.assembler.dto.impl.VehiculoAssemblerDTO;
import co.priv.parqueadero.autoparkadmin.business.domain.VehiculoDomain;
import co.priv.parqueadero.autoparkadmin.business.facade.FacadeWithOutReturn;
import co.priv.parqueadero.autoparkadmin.business.usecase.impl.usuario.RegistrarUsuario;
import co.priv.parqueadero.autoparkadmin.business.usecase.impl.vehiculo.RegistrarVehiculo;
import co.priv.parqueadero.autoparkadmin.crosscutting.exceptions.AUTOPARKADMINException;
import co.priv.parqueadero.autoparkadmin.crosscutting.exceptions.custom.BusinessAUTOPARKADMINException;
import co.priv.parqueadero.autoparkadmin.crosscutting.exceptions.messagecatalog.MessageCatalogStrategy;
import co.priv.parqueadero.autoparkadmin.crosscutting.exceptions.messagecatalog.data.CodigoMensaje;
import co.priv.parqueadero.autoparkadmin.data.dao.factory.DAOFactory;
import co.priv.parqueadero.autoparkadmin.dto.UsuarioDTO;
import co.priv.parqueadero.autoparkadmin.dto.VehiculoDTO;

public final class RegistrarUsuarioFacade implements FacadeWithOutReturn<UsuarioDTO>{
	
	private DAOFactory daoFactory;
	
	
	public RegistrarUsuarioFacade() {
		daoFactory = DAOFactory.getFactory();
	}

	@Override
	public void execute(final UsuarioDTO dto) {
		daoFactory.iniciarTransaccion();
		try {
			var useCase = new RegistrarUsuario(daoFactory);
			var usuarioDomain = UsuarioAssemblerDTO.getInstance().toDomain(dto);
			
			useCase.execute(usuarioDomain);
			
			//ejecutar caso de uso
			daoFactory.confirmarTransaccion();
		} catch (final AUTOPARKADMINException excepcion) {
			daoFactory.cancelarTransaccion();
			throw excepcion;
		}catch (final Exception excepcion) {
			daoFactory.cancelarTransaccion();
			var mensajeUsuario="";
			var mensajeTecnico="";
			throw new BusinessAUTOPARKADMINException(mensajeTecnico,mensajeUsuario, excepcion);
		}finally {
			daoFactory.cerrarConexion();
		}
		
	}
	
	

}
