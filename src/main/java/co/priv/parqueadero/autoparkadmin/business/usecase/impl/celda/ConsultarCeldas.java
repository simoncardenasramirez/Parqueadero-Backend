package co.priv.parqueadero.autoparkadmin.business.usecase.impl.celda;

import java.util.List;

import co.priv.parqueadero.autoparkadmin.business.assembler.entity.impl.CeldaAssemblerEntity;
import co.priv.parqueadero.autoparkadmin.business.domain.CeldaDomain;
import co.priv.parqueadero.autoparkadmin.business.usecase.UseCaseWithReturn;
import co.priv.parqueadero.autoparkadmin.crosscutting.exceptions.custom.BusinessAUTOPARKADMINException;
import co.priv.parqueadero.autoparkadmin.crosscutting.helpers.ObjectHelper;
import co.priv.parqueadero.autoparkadmin.data.dao.factory.DAOFactory;

public class ConsultarCeldas implements UseCaseWithReturn<CeldaDomain, List<CeldaDomain>> {

    private DAOFactory factory;

    public ConsultarCeldas(final DAOFactory factory) {
        if (ObjectHelper.getObjectHelper().isNull(factory)) {
            var mensajeUsuario = "Se ha presentado un problema tratando de llevar a cabo la consulta de las celdas...";
            var mensajeTecnico = "El dao factory para consultar las celdas llegó nulo...";
            throw new BusinessAUTOPARKADMINException(mensajeUsuario, mensajeTecnico);
        }
        this.factory = factory;
    }

    @Override
    public List<CeldaDomain> execute(final CeldaDomain data) {
        var celdaEntityFilter = CeldaAssemblerEntity.getInstance().toEntity(data);
        var resultadosEntity = factory.getCeldaDAO().consultar(celdaEntityFilter);
        return CeldaAssemblerEntity.getInstance().toDomainCollection(resultadosEntity);
    }
}
	