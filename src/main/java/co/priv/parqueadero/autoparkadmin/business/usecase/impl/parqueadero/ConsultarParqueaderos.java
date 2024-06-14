package co.priv.parqueadero.autoparkadmin.business.usecase.impl.parqueadero;

import java.util.List;

import co.priv.parqueadero.autoparkadmin.business.assembler.entity.impl.ParqueaderoAssemblerEntity;
import co.priv.parqueadero.autoparkadmin.business.domain.ParqueaderoDomain;
import co.priv.parqueadero.autoparkadmin.business.usecase.UseCaseWithReturn;
import co.priv.parqueadero.autoparkadmin.crosscutting.exceptions.custom.BusinessAUTOPARKADMINException;
import co.priv.parqueadero.autoparkadmin.crosscutting.helpers.ObjectHelper;
import co.priv.parqueadero.autoparkadmin.data.dao.factory.DAOFactory;


public class ConsultarParqueaderos implements UseCaseWithReturn<ParqueaderoDomain, List<ParqueaderoDomain>> {

    private DAOFactory factory;

    public ConsultarParqueaderos(final DAOFactory factory) {
        if(ObjectHelper.getObjectHelper().isNull(factory)) {
            var mensajeUsuario = "Se ha presentado un problema tratando de llevar a cabo la consulta de los parqueaderos...";
            var mensajeTecnico = "El dao factory para consultar el parqueadero llegó nulo...";
            throw new BusinessAUTOPARKADMINException(mensajeUsuario, mensajeTecnico);
        }
        
        this.factory = factory;
    }

    @Override
    public List<ParqueaderoDomain> execute(final ParqueaderoDomain data) {
        var parqueaderoEntityFilter = 
                ParqueaderoAssemblerEntity.getInstance().toEntity(data);
        var resultadosEntity = factory.getParqueaderoDAO().consultar(parqueaderoEntityFilter);
        
        return ParqueaderoAssemblerEntity.getInstance().
                toDomainCollection(resultadosEntity);
    }
}
