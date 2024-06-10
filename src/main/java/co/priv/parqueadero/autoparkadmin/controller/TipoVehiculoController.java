package co.priv.parqueadero.autoparkadmin.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.priv.parqueadero.autoparkadmin.business.facade.impl.tipovehiculo.ConsultarTipoVehiculoFacade;
import co.priv.parqueadero.autoparkadmin.controller.response.TipoVehiculoResponse;
import co.priv.parqueadero.autoparkadmin.crosscutting.exceptions.AUTOPARKADMINException;
import co.priv.parqueadero.autoparkadmin.dto.TipoVehiculoDTO;

@RestController
@RequestMapping("/tipoVehiculo/")
public final class TipoVehiculoController {

    @GetMapping
    public ResponseEntity<TipoVehiculoResponse> consultar(){

        var httpStatusCode = HttpStatus.ACCEPTED;
        var tipoVehiculoResponse = new TipoVehiculoResponse();

        try {
            var tipoVehiculoDto = TipoVehiculoDTO.build();
            var facade = new ConsultarTipoVehiculoFacade();

            tipoVehiculoResponse.setDatos(facade.execute(tipoVehiculoDto));
            var mensajeUsuario = "Tipos de vehiculo consultados exitosamente...";
            tipoVehiculoResponse.getMensajes().add(mensajeUsuario);

        }catch(final AUTOPARKADMINException excepcion) {
            httpStatusCode = HttpStatus.BAD_REQUEST;
            tipoVehiculoResponse.getMensajes().add(excepcion.getMensajeUsuario());
            excepcion.printStackTrace();
        }catch(final Exception excepcion) {
            httpStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;

            var mensajeUsuario = "Se ha presentado un problema tratando de llevar a cabo la consulta de los tipos de vehiculo";
            tipoVehiculoResponse.getMensajes().add(mensajeUsuario);

            excepcion.printStackTrace();
        }

        return new ResponseEntity<>(tipoVehiculoResponse,httpStatusCode);
    }
}
