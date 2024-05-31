package co.priv.parqueadero.autoparkadmin.business.facade.impl.vehiculo;

import java.util.List;

import co.priv.parqueadero.autoparkadmin.business.assembler.dto.impl.VehiculoAssemblerDTO;
import co.priv.parqueadero.autoparkadmin.business.facade.FacadeWithReturn;
import co.priv.parqueadero.autoparkadmin.business.usecase.impl.vehiculo.ConsultarVehiculos;
import co.priv.parqueadero.autoparkadmin.crosscutting.exceptions.AUTOPARKADMINException;
import co.priv.parqueadero.autoparkadmin.crosscutting.exceptions.custom.BusinessAUTOPARKADMINException;
import co.priv.parqueadero.autoparkadmin.crosscutting.exceptions.messagecatalog.MessageCatalogStrategy;
import co.priv.parqueadero.autoparkadmin.crosscutting.exceptions.messagecatalog.data.CodigoMensaje;
import co.priv.parqueadero.autoparkadmin.data.dao.factory.DAOFactory;
import co.priv.parqueadero.autoparkadmin.dto.VehiculoDTO;

public final class ConsultarVehiculoFacade implements FacadeWithReturn<VehiculoDTO, List<VehiculoDTO>>{
	
	

	private DAOFactory daoFactory;
	
	
	public ConsultarVehiculoFacade() {
		daoFactory = DAOFactory.getFactory();
	}

	

	 @Override
	    public final List<VehiculoDTO> execute(final VehiculoDTO dto) {
	        daoFactory.iniciarTransaccion();
	        try{

	            var useCase = new ConsultarVehiculos(daoFactory);
	            var ciudadDomain = VehiculoAssemblerDTO.getInstance().toDomain(dto);
	            var resultadosDomain = useCase.execute(ciudadDomain);
	            
	            return VehiculoAssemblerDTO.getInstance().toDTOCollection(resultadosDomain);
	            
	        }catch (final AUTOPARKADMINException exception){
	            
	            throw exception;
	        }catch (final Exception exception){
	            
	            var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje( CodigoMensaje.M00024);
	            var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00025);

	            throw new BusinessAUTOPARKADMINException(mensajeTecnico, mensajeUsuario, exception);
	            
	        }finally {
	            daoFactory.cerrarConexion();
	        }
	    }




	
	
}
