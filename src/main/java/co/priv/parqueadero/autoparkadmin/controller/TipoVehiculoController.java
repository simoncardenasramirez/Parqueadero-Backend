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
@RequestMapping("/api/v1/vehiculos")
public final class TipoVehiculoController {

    @GetMapping("/tiposVehiculos")
    public ResponseEntity<TipoVehiculoResponse> consultar(){

        var httpStatusCode = HttpStatus.ACCEPTED;
        var tipoVehiculoResponse = new TipoVehiculoResponse();

        try {
            var tipoVehiculoDto = TipoVehiculoDTO.build();
            var facade = new ConsultarTipoVehiculoFacade();

            tipoVehiculoResponse.setDatos(facade.execute(tipoVehiculoDto));
            var mensajeUsuario = "mensaje 60";
            tipoVehiculoResponse.getMensajes().add(mensajeUsuario);

        }catch(final AUTOPARKADMINException excepcion) {
            httpStatusCode = HttpStatus.BAD_REQUEST;
            tipoVehiculoResponse.getMensajes().add(excepcion.getMensajeUsuario());
            excepcion.printStackTrace();
        }catch(final Exception excepcion) {
            httpStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;

            var mensajeUsuario = "mensaje 43";
            tipoVehiculoResponse.getMensajes().add(mensajeUsuario);

            excepcion.printStackTrace();
        }

        return new ResponseEntity<>(tipoVehiculoResponse,httpStatusCode);
    }
}
