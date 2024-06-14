package co.priv.parqueadero.autoparkadmin.business.facade.impl.parqueadero;

import java.util.List;

import co.priv.parqueadero.autoparkadmin.business.assembler.dto.impl.ParqueaderoAssemblerDTO;
import co.priv.parqueadero.autoparkadmin.business.facade.FacadeWithReturn;
import co.priv.parqueadero.autoparkadmin.business.usecase.impl.parqueadero.ConsultarParqueaderos;
import co.priv.parqueadero.autoparkadmin.crosscutting.exceptions.AUTOPARKADMINException;
import co.priv.parqueadero.autoparkadmin.crosscutting.exceptions.custom.BusinessAUTOPARKADMINException;
import co.priv.parqueadero.autoparkadmin.data.dao.factory.DAOFactory;
import co.priv.parqueadero.autoparkadmin.dto.ParqueaderoDTO;


public class ConsultarParqueaderosFacade implements FacadeWithReturn<ParqueaderoDTO, List<ParqueaderoDTO>> {

	private DAOFactory daoFactory;

	public ConsultarParqueaderosFacade() {
		daoFactory = DAOFactory.getFactory();
	}

	@Override
    public List<ParqueaderoDTO> execute(final ParqueaderoDTO dto) {

        try {

            var useCase = new ConsultarParqueaderos(daoFactory);
            var parqueaderoDomain = ParqueaderoAssemblerDTO.getInstance().toDomain(dto);
            var resultadosDomain = useCase.execute(parqueaderoDomain);

            return ParqueaderoAssemblerDTO.getInstance().toDTOCollection(resultadosDomain);

        } catch (final AUTOPARKADMINException exception) {
            throw exception;
        } catch (final Exception exception) {
            var mensajeUsuario = "Se ha presentado un problema al consultar la información del parqueadero";
            var mensajeTecnico = "Se ha presentado un problema INESPERADO tratando de consultar los parqueaderos";
            
            throw new BusinessAUTOPARKADMINException(mensajeTecnico, mensajeUsuario, exception);
            } finally {
            	daoFactory.cerrarConexion();
            }
	}
}
