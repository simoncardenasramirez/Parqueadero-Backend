package co.priv.parqueadero.autoparkadmin.business.facade.impl.celda;

import java.util.List;

import co.priv.parqueadero.autoparkadmin.business.assembler.dto.impl.CeldaAssemblerDTO;
import co.priv.parqueadero.autoparkadmin.business.facade.FacadeWithReturn;
import co.priv.parqueadero.autoparkadmin.business.usecase.impl.celda.ConsultarCeldas;
import co.priv.parqueadero.autoparkadmin.crosscutting.exceptions.AUTOPARKADMINException;
import co.priv.parqueadero.autoparkadmin.crosscutting.exceptions.custom.BusinessAUTOPARKADMINException;
import co.priv.parqueadero.autoparkadmin.data.dao.factory.DAOFactory;
import co.priv.parqueadero.autoparkadmin.dto.CeldaDTO;

public class ConsultarCeldasFacade implements FacadeWithReturn<CeldaDTO, List<CeldaDTO>> {

    private DAOFactory daoFactory;

    public ConsultarCeldasFacade() {
        daoFactory = DAOFactory.getFactory();
    }

    @Override
    public List<CeldaDTO> execute(final CeldaDTO dto) {
        try {
            var useCase = new ConsultarCeldas(daoFactory);
            var celdaDomain = CeldaAssemblerDTO.getInstance().toDomain(dto);
            var resultadosDomain = useCase.execute(celdaDomain);
            return CeldaAssemblerDTO.getInstance().toDTOCollection(resultadosDomain);

        } catch (final AUTOPARKADMINException exception) {
            throw exception;
        } catch (final Exception exception) {
            var mensajeUsuario = "Se ha presentado un problema consultando la informacion de las celdas";
            var mensajeTecnico = "Se ha presentado un problema INESPERADO consultando la informacion de las celdas";
            throw new BusinessAUTOPARKADMINException(mensajeTecnico, mensajeUsuario, exception);

        } finally {
            daoFactory.cerrarConexion();
        }
    }
}