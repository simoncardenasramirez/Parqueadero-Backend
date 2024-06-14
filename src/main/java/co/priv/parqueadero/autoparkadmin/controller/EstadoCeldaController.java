package co.priv.parqueadero.autoparkadmin.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.priv.parqueadero.autoparkadmin.business.facade.impl.estadocelda.ConsultarEstadosCeldaFacade;
import co.priv.parqueadero.autoparkadmin.controller.response.EstadoCeldaResponse;
import co.priv.parqueadero.autoparkadmin.crosscutting.exceptions.AUTOPARKADMINException;
import co.priv.parqueadero.autoparkadmin.dto.EstadoCeldaDTO;

@RestController
@RequestMapping("/estadosCelda/")
public class EstadoCeldaController {

	@GetMapping
	public ResponseEntity<EstadoCeldaResponse> consultar(){
		
		var httpStatusCode = HttpStatus.ACCEPTED;
		var estadoCeldaResponse = new EstadoCeldaResponse();
		
		try {
			var estadoCeldaDto = EstadoCeldaDTO.build();
			var facade = new ConsultarEstadosCeldaFacade();
			
			estadoCeldaResponse.setDatos(facade.execute(estadoCeldaDto));
			estadoCeldaResponse.getMensajes().add("Estados Celda consultados exitosamente");
			
		}catch(final AUTOPARKADMINException excepcion) {
			httpStatusCode = HttpStatus.BAD_REQUEST;
			estadoCeldaResponse.getMensajes().add(excepcion.getMensajeUsuario());
			excepcion.printStackTrace();
		}catch(final Exception excepcion) {
			httpStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;
			
			var mensajeUsuario = "Se ha presentado un problema al consultar la información de los estados de celda";
			estadoCeldaResponse.getMensajes().add(mensajeUsuario);
			
			excepcion.printStackTrace();
		}
		
		return new ResponseEntity<>(estadoCeldaResponse,httpStatusCode);
	}

}
