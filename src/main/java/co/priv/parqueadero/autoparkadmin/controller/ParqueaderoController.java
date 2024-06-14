package co.priv.parqueadero.autoparkadmin.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.priv.parqueadero.autoparkadmin.business.facade.impl.parqueadero.ConsultarParqueaderosFacade;
import co.priv.parqueadero.autoparkadmin.controller.response.ParqueaderoResponse;
import co.priv.parqueadero.autoparkadmin.crosscutting.exceptions.AUTOPARKADMINException;
import co.priv.parqueadero.autoparkadmin.dto.ParqueaderoDTO;


@RestController
@RequestMapping("/parqueaderos/")
public class ParqueaderoController {

	@GetMapping
	public ResponseEntity<ParqueaderoResponse> consultar(){
		
		var httpStatusCode = HttpStatus.ACCEPTED;
		var parqueaderoResponse = new ParqueaderoResponse();
		
		try {
			var parqueaderoDto = ParqueaderoDTO.build();
			var facade = new ConsultarParqueaderosFacade();
			
			parqueaderoResponse.setDatos(facade.execute(parqueaderoDto));
			parqueaderoResponse.getMensajes().add("Parqueaderos consultados exitosamente");
			
		}catch(final AUTOPARKADMINException excepcion) {
			httpStatusCode = HttpStatus.BAD_REQUEST;
			parqueaderoResponse.getMensajes().add(excepcion.getMensajeUsuario());
			excepcion.printStackTrace();
		}catch(final Exception excepcion) {
			httpStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;
			
			var mensajeUsuario = "Se ha presentado un problema al consultar la información del parqueadero";
			parqueaderoResponse.getMensajes().add(mensajeUsuario);
			
			excepcion.printStackTrace();
		}
		
		return new ResponseEntity<>(parqueaderoResponse,httpStatusCode);
	}

}