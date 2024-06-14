package co.priv.parqueadero.autoparkadmin.business.facade.impl.estadocelda;

import java.util.List;

import co.priv.parqueadero.autoparkadmin.business.assembler.dto.impl.EstadoCeldaAssemblerDTO;
import co.priv.parqueadero.autoparkadmin.business.facade.FacadeWithReturn;
import co.priv.parqueadero.autoparkadmin.business.usecase.impl.estadocelda.ConsultarEstadosCelda;
import co.priv.parqueadero.autoparkadmin.crosscutting.exceptions.AUTOPARKADMINException;
import co.priv.parqueadero.autoparkadmin.crosscutting.exceptions.custom.BusinessAUTOPARKADMINException;
import co.priv.parqueadero.autoparkadmin.data.dao.factory.DAOFactory;
import co.priv.parqueadero.autoparkadmin.dto.EstadoCeldaDTO;



public class ConsultarEstadosCeldaFacade implements FacadeWithReturn<EstadoCeldaDTO, List<EstadoCeldaDTO>> {
	
	private DAOFactory daoFactory;

	public ConsultarEstadosCeldaFacade() {
		daoFactory = DAOFactory.getFactory();
	}

	@Override
    public List<EstadoCeldaDTO> execute(final EstadoCeldaDTO dto) {

        try {

            var useCase = new ConsultarEstadosCelda(daoFactory);
            var estadoCeldaDomain = EstadoCeldaAssemblerDTO.getInstance().toDomain(dto);
            var resultadosDomain = useCase.execute(estadoCeldaDomain);

            return EstadoCeldaAssemblerDTO.getInstance().toDTOCollection(resultadosDomain);

        } catch (final AUTOPARKADMINException exception) {
            throw exception;
        } catch (final Exception exception) {
            var mensajeUsuario = "Se ha presentado un problema al consultar la información de los estados de celda";
            var mensajeTecnico = "Se ha presentado un problema INESPERADO tratando de consultar los estados de celda";
            
            throw new BusinessAUTOPARKADMINException(mensajeTecnico, mensajeUsuario, exception);
            } finally {
            	daoFactory.cerrarConexion();
            }
	}

}
