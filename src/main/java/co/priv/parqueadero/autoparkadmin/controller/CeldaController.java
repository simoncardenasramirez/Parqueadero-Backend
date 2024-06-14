package co.priv.parqueadero.autoparkadmin.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.priv.parqueadero.autoparkadmin.business.facade.impl.celda.ConsultarCeldasFacade;
import co.priv.parqueadero.autoparkadmin.business.facade.impl.celda.GenerarCeldaFacade;
import co.priv.parqueadero.autoparkadmin.controller.response.CeldaResponse;
import co.priv.parqueadero.autoparkadmin.crosscutting.exceptions.AUTOPARKADMINException;
import co.priv.parqueadero.autoparkadmin.crosscutting.exceptions.custom.BusinessAUTOPARKADMINException;
import co.priv.parqueadero.autoparkadmin.dto.CeldaDTO;

@RestController
@RequestMapping("/celdas/")
public class CeldaController {

    @GetMapping
    public ResponseEntity<CeldaResponse> consultar() {

        var httpStatusCode = HttpStatus.ACCEPTED;
        var celdaResponse = new CeldaResponse();

        try {
            var celdaDto = CeldaDTO.build(); 
            var facade = new ConsultarCeldasFacade(); 

            celdaResponse.setDatos(facade.execute(celdaDto)); 
            celdaResponse.getMensajes().add("Celdas consultadas exitosamente");

        } catch (final AUTOPARKADMINException excepcion) {
            httpStatusCode = HttpStatus.BAD_REQUEST;
            celdaResponse.getMensajes().add(excepcion.getMensajeUsuario());
            excepcion.printStackTrace();
        } catch (final Exception excepcion) {
            httpStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;

            var mensajeUsuario = "Se ha presentado un problema al consultar la información de las celdas";
            celdaResponse.getMensajes().add(mensajeUsuario);

            excepcion.printStackTrace();
        }

        return new ResponseEntity<>(celdaResponse, httpStatusCode);
    }
    
    @PostMapping
    public ResponseEntity<CeldaResponse> crear(@RequestBody CeldaDTO celda) {

        var httpStatusCode = HttpStatus.ACCEPTED;
        var celdaResponse = new CeldaResponse();

        try {
            var facade = new GenerarCeldaFacade();
            facade.execute(celda);
            var mensajeUsuario = "Celda creada exitosamente";
            celdaResponse.getMensajes().add(mensajeUsuario);

        } catch (final BusinessAUTOPARKADMINException excepcion) {
            httpStatusCode = HttpStatus.BAD_REQUEST;
            celdaResponse.getMensajes().add(excepcion.getMensajeUsuario());
            excepcion.printStackTrace();
        } catch (final Exception excepcion) {
            httpStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;

            var mensajeUsuario = "Se ha presentado un problema tratando de registrar la nueva celda";
            celdaResponse.getMensajes().add(mensajeUsuario);

            excepcion.printStackTrace();
        }

        return new ResponseEntity<>(celdaResponse, httpStatusCode);

    }

}
