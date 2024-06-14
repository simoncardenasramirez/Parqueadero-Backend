package co.priv.parqueadero.autoparkadmin.business.usecase.impl.estadocelda;

import java.util.List;

import co.priv.parqueadero.autoparkadmin.business.assembler.entity.impl.EstadoCeldaAssemblerEntity;
import co.priv.parqueadero.autoparkadmin.business.domain.EstadoCeldaDomain;
import co.priv.parqueadero.autoparkadmin.business.usecase.UseCaseWithReturn;
import co.priv.parqueadero.autoparkadmin.crosscutting.exceptions.custom.BusinessAUTOPARKADMINException;
import co.priv.parqueadero.autoparkadmin.crosscutting.helpers.ObjectHelper;
import co.priv.parqueadero.autoparkadmin.data.dao.factory.DAOFactory;



public class ConsultarEstadosCelda implements UseCaseWithReturn<EstadoCeldaDomain, List<EstadoCeldaDomain>> {
	
    private DAOFactory factory;

    public ConsultarEstadosCelda(final DAOFactory factory) {
        if(ObjectHelper.getObjectHelper().isNull(factory)) {
            var mensajeUsuario = "Se ha presentado un problema tratando de llevar a cabo la consulta de los estados de celda...";
            var mensajeTecnico = "El dao factory para consultar los estados de celda llegó nulo...";
            throw new BusinessAUTOPARKADMINException(mensajeUsuario, mensajeTecnico);
        }
        
        this.factory = factory;
    }

    @Override
    public List<EstadoCeldaDomain> execute(final EstadoCeldaDomain data) {
        var estadoCeldaEntityFilter = 
                EstadoCeldaAssemblerEntity.getInstance().toEntity(data);
        var resultadosEntity = factory.getEstadoCeldaDAO().consultar(estadoCeldaEntityFilter);
        
        return EstadoCeldaAssemblerEntity.getInstance().
                toDomainCollection(resultadosEntity);
    }

}
