package co.priv.parqueadero.autoparkadmin.crosscutting.exceptions.custom;

import co.priv.parqueadero.autoparkadmin.crosscutting.exceptions.AUTOPARKADMINException;
import co.priv.parqueadero.autoparkadmin.crosscutting.exceptions.enums.Lugar;

public final class BusinessAUTOPARKADMINException extends AUTOPARKADMINException {

	private static final long serialVersionUID = -1179319726524825522L;

	public BusinessAUTOPARKADMINException(final String mensajeUsuario) {
		super(mensajeUsuario, Lugar.DATA);

	}
	
	public BusinessAUTOPARKADMINException(final String mensajeTecnico,final String mensajeUsuario,final  Lugar lugar,Throwable excepcionRaiz) {
		super(mensajeTecnico,mensajeUsuario, Lugar.DATA,excepcionRaiz);

	}
	

}