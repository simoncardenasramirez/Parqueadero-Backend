package co.priv.parqueadero.autoparkadmin.business.facade.impl.celda;

import co.priv.parqueadero.autoparkadmin.business.assembler.dto.impl.CeldaAssemblerDTO;
import co.priv.parqueadero.autoparkadmin.business.facade.FacadeWithOutReturn;
import co.priv.parqueadero.autoparkadmin.business.usecase.impl.celda.GenerarCelda;
import co.priv.parqueadero.autoparkadmin.crosscutting.exceptions.AUTOPARKADMINException;
import co.priv.parqueadero.autoparkadmin.crosscutting.exceptions.custom.BusinessAUTOPARKADMINException;
import co.priv.parqueadero.autoparkadmin.data.dao.factory.DAOFactory;
import co.priv.parqueadero.autoparkadmin.dto.CeldaDTO;

public final class GenerarCeldaFacade implements FacadeWithOutReturn<CeldaDTO> {

    private DAOFactory daoFactory;

    public GenerarCeldaFacade() {
        daoFactory = DAOFactory.getFactory();
    }

    @Override
    public void execute(final CeldaDTO dto) {
    	daoFactory.iniciarTransaccion();
    	
        try {
            var useCase = new GenerarCelda(daoFactory);
            var celdaDomain = CeldaAssemblerDTO.getInstance().toDomain(dto);
            useCase.execute(celdaDomain);
            
            daoFactory.confirmarTransaccion();
        } catch (final AUTOPARKADMINException exception) {
        	daoFactory.cancelarTransaccion();
            throw exception;
        } catch (final Exception exception) {
        	daoFactory.cancelarTransaccion();
            var mensajeUsuario = "Se ha presentado un problema tratando de registrar la informacion para generar la celda";
            var mensajeTecnico = "Se ha presentado un problema INESPERADO tratando de registrar la informacion para generar la celda";
            throw new BusinessAUTOPARKADMINException(mensajeTecnico, mensajeUsuario, exception);
        } finally {
            daoFactory.cerrarConexion();
        }
    }
}
