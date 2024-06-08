package co.priv.parqueadero.autoparkadmin.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.priv.parqueadero.autoparkadmin.business.facade.impl.vehiculo.ConsultarVehiculoFacade;
import co.priv.parqueadero.autoparkadmin.business.facade.impl.vehiculo.RegistrarVehiculoFacade;
import co.priv.parqueadero.autoparkadmin.business.facade.usuario.ConsultarUsuarioFacade;
import co.priv.parqueadero.autoparkadmin.business.facade.usuario.RegistrarUsuarioFacade;
import co.priv.parqueadero.autoparkadmin.controller.response.UsuarioResponse;
import co.priv.parqueadero.autoparkadmin.controller.response.VehiculoResponse;
import co.priv.parqueadero.autoparkadmin.crosscutting.exceptions.AUTOPARKADMINException;
import co.priv.parqueadero.autoparkadmin.crosscutting.exceptions.messagecatalog.MessageCatalogStrategy;
import co.priv.parqueadero.autoparkadmin.crosscutting.exceptions.messagecatalog.data.CodigoMensaje;
import co.priv.parqueadero.autoparkadmin.dto.UsuarioDTO;
import co.priv.parqueadero.autoparkadmin.dto.VehiculoDTO;

@RestController
@RequestMapping("/usuarios/")
public final class UsuarioController {

	@GetMapping
	public ResponseEntity<UsuarioResponse> consultar() {

		var httpStatusCode = HttpStatus.ACCEPTED;
		var usuarioResponse = new UsuarioResponse();

		try {
			var usuarioDto = UsuarioDTO.build();
			var facade = new ConsultarUsuarioFacade();     

			usuarioResponse.setDatos(facade.execute(usuarioDto));
			var mensajeUsuario = "mensaje 59";
			usuarioResponse.getMensajes().add(mensajeUsuario);

		} catch (final AUTOPARKADMINException exception) {
			httpStatusCode = HttpStatus.BAD_REQUEST;
			usuarioResponse.getMensajes().add(exception.getMensajeUsuario());
			exception.printStackTrace();

		} catch (final Exception exception) {
			httpStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;
			var mensajeUsuario = "mensaje 45";
			usuarioResponse.getMensajes().add(mensajeUsuario);

			exception.printStackTrace();
		}
		return new ResponseEntity<>(usuarioResponse, httpStatusCode);
	}

	@PostMapping
	public ResponseEntity<UsuarioResponse> registrar(@RequestBody UsuarioDTO usuario) {

		var httpStatusCode = HttpStatus.ACCEPTED;
		var usuarioResponse = new UsuarioResponse();

		try {
			var facade = new RegistrarUsuarioFacade(); // crear facade
			facade.execute(usuario);
			var mensajeUsuario = "mensaje 61";
			usuarioResponse.getMensajes().add(mensajeUsuario);

		} catch (final AUTOPARKADMINException excepcion) {
			httpStatusCode = HttpStatus.BAD_REQUEST;
			usuarioResponse.getMensajes().add(excepcion.getMensajeUsuario());
			excepcion.printStackTrace();
		} catch (final Exception excepcion) {
			httpStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;

			var mensajeUsuario = "mensaje 57";
			usuarioResponse.getMensajes().add(mensajeUsuario);

			excepcion.printStackTrace();
		}

		return new ResponseEntity<>(usuarioResponse, httpStatusCode);

	}

}
