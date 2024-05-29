package co.priv.parqueadero.autoparkadmin.business.usecase.impl.vehiculo;

import java.util.List;

import co.priv.parqueadero.autoparkadmin.business.assembler.entity.impl.VehiculoAssemblerEntity;
import co.priv.parqueadero.autoparkadmin.business.domain.VehiculoDomain;
import co.priv.parqueadero.autoparkadmin.business.usecase.UseCaseWithReturn;
import co.priv.parqueadero.autoparkadmin.crosscutting.exceptions.custom.BusinessAUTOPARKADMINException;
import co.priv.parqueadero.autoparkadmin.crosscutting.exceptions.messagecatalog.MessageCatalogStrategy;
import co.priv.parqueadero.autoparkadmin.crosscutting.exceptions.messagecatalog.data.CodigoMensaje;
import co.priv.parqueadero.autoparkadmin.crosscutting.helpers.ObjectHelper;
import co.priv.parqueadero.autoparkadmin.data.dao.factory.DAOFactory;

public class ConsultarVehiculos implements UseCaseWithReturn<VehiculoDomain, List<VehiculoDomain>>{
	
private DAOFactory factory;
	
	public ConsultarVehiculos(final DAOFactory factory) {
		if (ObjectHelper.getObjectHelper().isNull(factory)) {
			var mensajeUsuario= MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00028);
			var mensajeTecnico =MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00029);
			throw new BusinessAUTOPARKADMINException(mensajeTecnico, mensajeUsuario);
		}
		this.factory= factory;
	}

	@Override
	public List<VehiculoDomain> execute(VehiculoDomain data) {
		var vehiculoEntityFilter =
				VehiculoAssemblerEntity.getInstance().toEntity(data);
		var resultadosEntity = factory.getVehiculoDAO().consultar(vehiculoEntityFilter);
		
		var resultadosDomain =  VehiculoAssemblerEntity.getInstance().toDomainCollection(resultadosEntity);
		
		
		return resultadosDomain;
	}

}
