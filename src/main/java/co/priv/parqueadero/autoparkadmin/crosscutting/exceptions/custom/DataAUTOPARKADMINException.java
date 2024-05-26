package co.priv.parqueadero.autoparkadmin.crosscutting.exceptions.custom;

import co.priv.parqueadero.autoparkadmin.crosscutting.exceptions.AUTOPARKADMINException;
import co.priv.parqueadero.autoparkadmin.crosscutting.exceptions.enums.Lugar;

public final class DataAUTOPARKADMINException extends AUTOPARKADMINException {

	private static final long serialVersionUID = -1179319726524825522L;

	public DataAUTOPARKADMINException(final String mensajeUsuario) {
		super(mensajeUsuario, Lugar.DATA);

	}
	
	public DataAUTOPARKADMINException(final String mensajeTecnico,final String mensajeUsuario,final  Lugar lugar,Throwable excepcionRaiz) {
		super(mensajeTecnico,mensajeUsuario, Lugar.DATA,excepcionRaiz);

	}
	
	public DataAUTOPARKADMINException(final String mensajeTecnico,final String mensajeUsuario, Throwable excepcionRaiz) {
		super(mensajeTecnico,mensajeUsuario,excepcionRaiz);

	}
	
	public DataAUTOPARKADMINException(final String mensajeTecnico,final String mensajeUsuario) {
		super(mensajeTecnico,mensajeUsuario,Lugar.DATA);

	}
	

}