package co.priv.parqueadero.autoparkadmin.business.facade.usuario;

import java.util.List;

import co.priv.parqueadero.autoparkadmin.business.assembler.dto.impl.UsuarioAssemblerDTO;
import co.priv.parqueadero.autoparkadmin.business.facade.FacadeWithReturn;
import co.priv.parqueadero.autoparkadmin.business.usecase.impl.usuario.ConsultarUsuario;
import co.priv.parqueadero.autoparkadmin.crosscutting.exceptions.AUTOPARKADMINException;
import co.priv.parqueadero.autoparkadmin.crosscutting.exceptions.custom.BusinessAUTOPARKADMINException;
import co.priv.parqueadero.autoparkadmin.data.dao.factory.DAOFactory;
import co.priv.parqueadero.autoparkadmin.dto.UsuarioDTO;

public final class ConsultarUsuarioFacade implements FacadeWithReturn<UsuarioDTO, List<UsuarioDTO>>{
	
	

	private DAOFactory daoFactory;
	
	
	public ConsultarUsuarioFacade() {
		daoFactory = DAOFactory.getFactory();
	}

	

	 @Override
	    public final List<UsuarioDTO> execute(final UsuarioDTO dto) {
	        daoFactory.iniciarTransaccion();
	        try{

	            var useCase = new ConsultarUsuario(daoFactory);
	            var usuarioDomain = UsuarioAssemblerDTO.getInstance().toDomain(dto);
	            var resultadosDomain = useCase.execute(usuarioDomain);
	            
	            return UsuarioAssemblerDTO.getInstance().toDTOCollection(resultadosDomain);
	      
	            
	        }catch (final AUTOPARKADMINException exception){
	            
	            throw exception;
	        }catch (final Exception exception){
	            
	            var mensajeUsuario = "";
	            var mensajeTecnico = "";

	            throw new BusinessAUTOPARKADMINException(mensajeTecnico, mensajeUsuario, exception);
	            
	        }finally {
	            daoFactory.cerrarConexion();
	        }
	    }







	
	
}
