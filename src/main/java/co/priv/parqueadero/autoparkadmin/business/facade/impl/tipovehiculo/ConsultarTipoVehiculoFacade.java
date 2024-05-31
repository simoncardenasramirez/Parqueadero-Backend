package co.priv.parqueadero.autoparkadmin.business.facade.impl.tipovehiculo;

import java.util.List;

import co.priv.parqueadero.autoparkadmin.business.assembler.dto.impl.TipoVehiculoAssemblerDTO;
import co.priv.parqueadero.autoparkadmin.business.facade.FacadeWithReturn;
import co.priv.parqueadero.autoparkadmin.business.usecase.impl.tipovehiculo.ConsultarTiposVehiculo;
import co.priv.parqueadero.autoparkadmin.crosscutting.exceptions.AUTOPARKADMINException;
import co.priv.parqueadero.autoparkadmin.crosscutting.exceptions.custom.BusinessAUTOPARKADMINException;
import co.priv.parqueadero.autoparkadmin.crosscutting.exceptions.messagecatalog.MessageCatalogStrategy;
import co.priv.parqueadero.autoparkadmin.crosscutting.exceptions.messagecatalog.data.CodigoMensaje;
import co.priv.parqueadero.autoparkadmin.data.dao.factory.DAOFactory;
import co.priv.parqueadero.autoparkadmin.dto.TipoVehiculoDTO;

public class ConsultarTipoVehiculoFacade implements FacadeWithReturn<TipoVehiculoDTO, List<TipoVehiculoDTO>> {

    private DAOFactory daoFactory;

    public ConsultarTipoVehiculoFacade() {
        daoFactory = DAOFactory.getFactory();
    }

    @Override
    public List<TipoVehiculoDTO> execute(TipoVehiculoDTO dto) {
        try {
            var useCase = new ConsultarTiposVehiculo(daoFactory);
            var tipoVehiculoDomain = TipoVehiculoAssemblerDTO.getInstance().toDomain(dto);
            var resultadosDomain = useCase.execute(tipoVehiculoDomain);
            return TipoVehiculoAssemblerDTO.getInstance().toDTOCollection(resultadosDomain);
        } catch (AUTOPARKADMINException exception) {
            throw exception;
        } catch (Exception exception) {
            var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00027);
            var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00028);
            throw new BusinessAUTOPARKADMINException(mensajeUsuario, mensajeTecnico, exception);
        } finally {
            daoFactory.cerrarConexion();
        }
    }
}