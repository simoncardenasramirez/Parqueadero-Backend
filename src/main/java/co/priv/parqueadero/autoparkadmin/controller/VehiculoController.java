package co.priv.parqueadero.autoparkadmin.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.priv.parqueadero.autoparkadmin.business.facade.implvehiculo.ConsultarVehiculoFacade;
import co.priv.parqueadero.autoparkadmin.business.facade.implvehiculo.RegistrarVehiculoFacade;
import co.priv.parqueadero.autoparkadmin.controller.response.VehiculoResponse;
import co.priv.parqueadero.autoparkadmin.crosscutting.exceptions.AUTOPARKADMINException;
import co.priv.parqueadero.autoparkadmin.crosscutting.exceptions.messagecatalog.MessageCatalogStrategy;
import co.priv.parqueadero.autoparkadmin.crosscutting.exceptions.messagecatalog.data.CodigoMensaje;
import co.priv.parqueadero.autoparkadmin.dto.VehiculoDTO;

@RestController
@RequestMapping("/api/v1/vehiculos")
public final class VehiculoController {
	@GetMapping
	public VehiculoDTO vehiculo() {
		return VehiculoDTO.build();
	}

	@GetMapping("/consultar-vehiculo")
	public ResponseEntity<VehiculoResponse> consultar() {

		var httpStatusCode = HttpStatus.ACCEPTED;
		var vehiculoResponse = new VehiculoResponse();

		try {
			var ciudadDto = VehiculoDTO.build();
			var facade = new ConsultarVehiculoFacade();

			vehiculoResponse.setDatos(facade.execute(ciudadDto));
			vehiculoResponse.getMensajes().add(MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00041));

		} catch (final AUTOPARKADMINException excepcion) {
			httpStatusCode = HttpStatus.BAD_REQUEST;
			vehiculoResponse.getMensajes().add(excepcion.getMensajeUsuario());
			excepcion.printStackTrace();
		} catch (final Exception excepcion) {
			httpStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;

			var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00043);
			vehiculoResponse.getMensajes().add(mensajeUsuario);

			excepcion.printStackTrace();
		}

		return new ResponseEntity<>(vehiculoResponse, httpStatusCode);

	}

	@PostMapping("/registrar-vehiculo")
	public ResponseEntity<VehiculoResponse> crear(@RequestBody VehiculoDTO ciudad) {

		var httpStatusCode = HttpStatus.ACCEPTED;
		var vehiculoResponse = new VehiculoResponse();

		try {
			var facade = new RegistrarVehiculoFacade();
			facade.execute(ciudad);
			vehiculoResponse.getMensajes().add(MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00042));

		} catch (final AUTOPARKADMINException excepcion) {
			httpStatusCode = HttpStatus.BAD_REQUEST;
			vehiculoResponse.getMensajes().add(excepcion.getMensajeUsuario());
			excepcion.printStackTrace();
		} catch (final Exception excepcion) {
			httpStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;

			var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00044);
			vehiculoResponse.getMensajes().add(mensajeUsuario);

			excepcion.printStackTrace();
		}

		return new ResponseEntity<>(vehiculoResponse, httpStatusCode);

	}
}
