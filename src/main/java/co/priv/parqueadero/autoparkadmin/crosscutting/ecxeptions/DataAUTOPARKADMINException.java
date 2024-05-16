package co.priv.parqueadero.autoparkadmin.crosscutting.ecxeptions;

import co.priv.parqueadero.autoparkadmin.crosscutting.ecxeptions.enums.Lugar;

public final class DataAUTOPARKADMINException extends AUTOPARKADMINException{

	private static final long serialVersionUID = 1L;
	private static final Lugar lugar=Lugar.DATA;

	public DataAUTOPARKADMINException(final String mensajeUsuario) {
		super(mensajeUsuario, lugar );
	}
	
	public DataAUTOPARKADMINException(final String mensajeTecnico, 
			final String mensajeUsuario) {
		super(mensajeTecnico, mensajeUsuario, lugar);
	}
	
	public DataAUTOPARKADMINException(final String mensajeTecnico,final String mensajeUsuario,
			final Throwable exceptionRaiz) {
		super(mensajeTecnico,mensajeUsuario, lugar, exceptionRaiz);
	}
	
}
