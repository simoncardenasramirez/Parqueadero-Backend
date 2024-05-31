package co.priv.parqueadero.autoparkadmin.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import co.priv.parqueadero.autoparkadmin.business.facade.impl.vehiculo.ConsultarVehiculoFacade;
import co.priv.parqueadero.autoparkadmin.controller.response.VehiculoResponse;
import co.priv.parqueadero.autoparkadmin.crosscutting.exceptions.AUTOPARKADMINException;
import co.priv.parqueadero.autoparkadmin.crosscutting.exceptions.messagecatalog.MessageCatalogStrategy;
import co.priv.parqueadero.autoparkadmin.crosscutting.exceptions.messagecatalog.data.CodigoMensaje;
import co.priv.parqueadero.autoparkadmin.dto.VehiculoDTO;

public final class TipoVehiculoController {

	@GetMapping("/consultar-tipovehiculo")
	public ResponseEntity<VehiculoResponse> consultar() {

		var httpStatusCode = HttpStatus.ACCEPTED;
		var vehiculoResponse = new VehiculoResponse();

		try {
			var ciudadDto = VehiculoDTO.build();
			var facade = new ConsultarVehiculoFacade();

			List<VehiculoDTO> vehiculoDtoList = facade.execute(ciudadDto);

			vehiculoResponse.setDatos(vehiculoDtoList);
			vehiculoResponse.getMensajes().add(MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00047));

		} catch (final AUTOPARKADMINException excepcion) {
			httpStatusCode = HttpStatus.BAD_REQUEST;
			vehiculoResponse.getMensajes().add(excepcion.getMensajeUsuario());
			excepcion.printStackTrace();
		} catch (final Exception excepcion) {
			httpStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;

			var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00045);
			vehiculoResponse.getMensajes().add(mensajeUsuario);

			excepcion.printStackTrace();
		}

		return new ResponseEntity<>(vehiculoResponse, httpStatusCode);
	}

}
