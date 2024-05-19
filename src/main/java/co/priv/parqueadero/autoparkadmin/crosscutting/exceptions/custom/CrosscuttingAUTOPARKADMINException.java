package co.priv.parqueadero.autoparkadmin.crosscutting.exceptions.custom;

import co.priv.parqueadero.autoparkadmin.crosscutting.exceptions.AUTOPARKADMINException;
import co.priv.parqueadero.autoparkadmin.crosscutting.exceptions.enums.Lugar;

public final class CrosscuttingAUTOPARKADMINException extends AUTOPARKADMINException {

    private static final long serialVersionUID = 1L;
    private static final Lugar lugar = Lugar.CROSSCUTTING;

    public CrosscuttingAUTOPARKADMINException(final String mensajeUsuario) {
        super(mensajeUsuario, lugar);
    }

    public CrosscuttingAUTOPARKADMINException(final String mensajeTecnico,final String mensajeUsuario) {
		super(mensajeTecnico,mensajeUsuario, lugar);

	}
	
	public CrosscuttingAUTOPARKADMINException(final String mensajeTecnico,final String mensajeUsuario,final  Lugar lugar,Throwable excepcionRaiz) {
		super(mensajeTecnico,mensajeUsuario,lugar ,excepcionRaiz);

	}
	
	
	public CrosscuttingAUTOPARKADMINException(final String mensajeTecnico,final String mensajeUsuario,
			final Throwable exceptionRaiz) {
		super(mensajeTecnico,mensajeUsuario, lugar, exceptionRaiz);
	}

	
    
    
}