package co.priv.parqueadero.autoparkadmin.business.facade.impl.vehiculo;

import co.priv.parqueadero.autoparkadmin.business.assembler.dto.impl.VehiculoAssemblerDTO;
import co.priv.parqueadero.autoparkadmin.business.facade.FacadeWithOutReturn;
import co.priv.parqueadero.autoparkadmin.business.facade.FacadeWithReturn;
import co.priv.parqueadero.autoparkadmin.business.usecase.impl.vehiculo.RegistrarVehiculo;
import co.priv.parqueadero.autoparkadmin.crosscutting.exceptions.AUTOPARKADMINException;
import co.priv.parqueadero.autoparkadmin.crosscutting.exceptions.custom.BusinessAUTOPARKADMINException;
import co.priv.parqueadero.autoparkadmin.crosscutting.exceptions.messagecatalog.MessageCatalogStrategy;
import co.priv.parqueadero.autoparkadmin.crosscutting.exceptions.messagecatalog.data.CodigoMensaje;
import co.priv.parqueadero.autoparkadmin.data.dao.factory.DAOFactory;
import co.priv.parqueadero.autoparkadmin.dto.VehiculoDTO;

public final class RegistrarVehiculoFacade implements FacadeWithOutReturn<VehiculoDTO>{
	
	private DAOFactory daoFactory;
	
	
	public RegistrarVehiculoFacade() {
		daoFactory = DAOFactory.getFactory();
	}

	@Override
	public void execute(final VehiculoDTO dto) {
		daoFactory.iniciarTransaccion();
		try {
			var useCase = new RegistrarVehiculo(daoFactory);
			var ciudadDomain = VehiculoAssemblerDTO.getInstance().toDomain(dto);
			
			useCase.execute(ciudadDomain);
			
			//ejecutar caso de uso
			daoFactory.confirmarTransaccion();
		} catch (final AUTOPARKADMINException excepcion) {
			daoFactory.cancelarTransaccion();
			throw excepcion;
		}catch (final Exception excepcion) {
			daoFactory.cancelarTransaccion();
			var mensajeUsuario=MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00026);
			var mensajeTecnico=MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00027);
			throw new BusinessAUTOPARKADMINException(mensajeTecnico,mensajeUsuario, excepcion);
		}finally {
			daoFactory.cerrarConexion();
		}
		
	}
	
	

}
