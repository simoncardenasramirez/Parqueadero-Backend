package co.priv.parqueadero.autoparkadmin.controller;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.priv.parqueadero.autoparkadmin.business.facade.impl.usuario.AutenticarUsuarioFacade;
import co.priv.parqueadero.autoparkadmin.business.facade.impl.usuario.ConsultarUsuarioFacade;
import co.priv.parqueadero.autoparkadmin.business.facade.impl.usuario.RegistrarUsuarioFacade;

import co.priv.parqueadero.autoparkadmin.controller.response.UsuarioResponse;
import co.priv.parqueadero.autoparkadmin.crosscutting.exceptions.AUTOPARKADMINException;
import co.priv.parqueadero.autoparkadmin.dto.UsuarioDTO;

@RestController
@RequestMapping("/usuarios")
public final class UsuarioController {

	@GetMapping
	public ResponseEntity<UsuarioResponse> consultar() {

		var httpStatusCode = HttpStatus.ACCEPTED;
		var usuarioResponse = new UsuarioResponse();

		try {
			var usuarioDto = UsuarioDTO.build();
			var facade = new ConsultarUsuarioFacade();     

			usuarioResponse.setDatos(facade.execute(usuarioDto));
			var mensajeUsuario = "Usuarios consultados exitosamente...";
			usuarioResponse.getMensajes().add(mensajeUsuario);

		} catch (final AUTOPARKADMINException exception) {
			httpStatusCode = HttpStatus.BAD_REQUEST;
			usuarioResponse.getMensajes().add(exception.getMensajeUsuario());
			exception.printStackTrace();

		} catch (final Exception exception) {
			httpStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;
			var mensajeUsuario = "Se ha presentado un problema tratando de llevar la consulta de los usuarios";
			usuarioResponse.getMensajes().add(mensajeUsuario);

			exception.printStackTrace();
		}
		return new ResponseEntity<>(usuarioResponse, httpStatusCode);
	}

	@PostMapping("/registrar")
	public ResponseEntity<UsuarioResponse> registrar(@RequestBody UsuarioDTO usuario) {

		var httpStatusCode = HttpStatus.ACCEPTED;
		var usuarioResponse = new UsuarioResponse();
		try {
			var facade = new RegistrarUsuarioFacade();
			facade.execute(usuario);
			var mensajeUsuario = "Usuario registrado exitosamente...";
			usuarioResponse.getMensajes().add(mensajeUsuario);

		} catch (final AUTOPARKADMINException excepcion) {
			httpStatusCode = HttpStatus.BAD_REQUEST;
			usuarioResponse.getMensajes().add(excepcion.getMensajeUsuario());
			excepcion.printStackTrace();
		} catch (final Exception excepcion) {
			httpStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;

			var mensajeUsuario = "Se ha presentado un problema tratando de registar el Usuario";
			usuarioResponse.getMensajes().add(mensajeUsuario);

			excepcion.printStackTrace();
		}

		return new ResponseEntity<>(usuarioResponse, httpStatusCode);

	}
	
    @PostMapping("/autenticar")
    public ResponseEntity<UsuarioResponse> autenticar(@RequestBody UsuarioDTO usuario) {
		var httpStatusCode = HttpStatus.ACCEPTED;
		var usuarioResponse = new UsuarioResponse();

        try {
        	var facade = new AutenticarUsuarioFacade();
            boolean autenticado = facade.execute(usuario);
            usuarioResponse.getDatos().add(usuario);
            usuarioResponse.getMensajes().add(autenticado ? "Usuario autenticado exitosamente." : "Credenciales incorrectas.");
            if (!autenticado) {
                httpStatusCode = HttpStatus.UNAUTHORIZED;
            }
        } catch (final AUTOPARKADMINException excepcion) {
			httpStatusCode = HttpStatus.BAD_REQUEST;
			usuarioResponse.getMensajes().add(excepcion.getMensajeUsuario());
			excepcion.printStackTrace();
        } catch (final Exception excepcion) {
			httpStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;

			var mensajeUsuario = "Se ha presentado un problema tratando de registar el Usuario";
			usuarioResponse.getMensajes().add(mensajeUsuario);

			excepcion.printStackTrace();
        }
        return new ResponseEntity<>(usuarioResponse, httpStatusCode);
    }

}
