package co.priv.parqueadero.autoparkadmin.crosscutting.exceptions.custom;

import co.priv.parqueadero.autoparkadmin.crosscutting.exceptions.AUTOPARKADMINException;
import co.priv.parqueadero.autoparkadmin.crosscutting.exceptions.enums.Lugar;

public final class BusinessAUTOPARKADMINException extends AUTOPARKADMINException {

    private static final long serialVersionUID = 1L;
    private static final Lugar lugar = Lugar.BUSINESS;

    public BusinessAUTOPARKADMINException(final String mensajeUsuario) {
        super(mensajeUsuario, lugar);
    }
    public BusinessAUTOPARKADMINException(final String mensajeTecnico, final String mensajeUsuario) {
        super(mensajeTecnico, mensajeUsuario, lugar);
    }

    public BusinessAUTOPARKADMINException(final String mensajeTecnico, final String mensajeUsuario, final Throwable excepcionRaiz) {
        super(mensajeTecnico, mensajeUsuario, lugar, excepcionRaiz);
    }
}