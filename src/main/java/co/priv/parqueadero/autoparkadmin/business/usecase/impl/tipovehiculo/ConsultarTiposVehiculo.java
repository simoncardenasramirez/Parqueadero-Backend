package co.priv.parqueadero.autoparkadmin.business.usecase.impl.tipovehiculo;

import java.util.List;

import co.priv.parqueadero.autoparkadmin.business.assembler.entity.impl.TipoVehiculoAssemblerEntity;
import co.priv.parqueadero.autoparkadmin.business.domain.TipoVehiculoDomain;
import co.priv.parqueadero.autoparkadmin.business.usecase.UseCaseWithReturn;
import co.priv.parqueadero.autoparkadmin.crosscutting.exceptions.custom.BusinessAUTOPARKADMINException;
import co.priv.parqueadero.autoparkadmin.crosscutting.helpers.ObjectHelper;
import co.priv.parqueadero.autoparkadmin.data.dao.factory.DAOFactory;

public class ConsultarTiposVehiculo implements UseCaseWithReturn<TipoVehiculoDomain, List<TipoVehiculoDomain>> {

    private DAOFactory factory;

    public ConsultarTiposVehiculo(final DAOFactory factory) {
        if(ObjectHelper.getObjectHelper().isNull(factory)) {
            var mensajeUsuario = "Se ha presentado un problema tratando de llevar a cabo la consulta de los tipos de sede...";
            var mensajeTecnico = "El dao factory para consultar el tipo de sede llegó nulo...";
            throw new BusinessAUTOPARKADMINException(mensajeUsuario, mensajeTecnico);
        }
        
        this.factory = factory;
    }

    @Override
    public List<TipoVehiculoDomain> execute(final TipoVehiculoDomain data) {
        var tipoVehiculoEntityFilter = 
                TipoVehiculoAssemblerEntity.getInstance().toEntity(data);
        var resultadosEntity = factory.getTipoVehiculoDAO().consultar(tipoVehiculoEntityFilter);
        
        return TipoVehiculoAssemblerEntity.getInstance().
                toDomainCollection(resultadosEntity);
    }
}
