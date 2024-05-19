package co.priv.parqueadero.autoparkadmin.crosscutting.exceptions.custom;

import co.priv.parqueadero.autoparkadmin.crosscutting.exceptions.AUTOPARKADMINException;
import co.priv.parqueadero.autoparkadmin.crosscutting.exceptions.enums.Lugar;

public final class DtoAUTOPARKADMINxception extends AUTOPARKADMINException {

	private static final long serialVersionUID = -1179319726524825522L;

	public DtoAUTOPARKADMINxception(final String mensajeUsuario) {
		super(mensajeUsuario, Lugar.DATA);

	}
	
	public DtoAUTOPARKADMINxception(final String mensajeTecnico,final String mensajeUsuario,final  Lugar lugar,Throwable excepcionRaiz) {
		super(mensajeTecnico,mensajeUsuario, Lugar.DATA,excepcionRaiz);

	}
	

}