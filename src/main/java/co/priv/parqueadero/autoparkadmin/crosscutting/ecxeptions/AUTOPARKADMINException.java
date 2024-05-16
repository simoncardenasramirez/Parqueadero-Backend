package co.priv.parqueadero.autoparkadmin.crosscutting.ecxeptions;

import co.priv.parqueadero.autoparkadmin.crosscutting.ecxeptions.enums.Lugar;
import co.priv.parqueadero.autoparkadmin.crosscutting.helpers.ObjectHelper;
import co.priv.parqueadero.autoparkadmin.crosscutting.helpers.TextHelper;

public class AUTOPARKADMINException extends RuntimeException{


	private static final long serialVersionUID = -1204292929766811976L;
	
	protected String mensajeUsuario;
	protected Lugar lugar;
	
	public AUTOPARKADMINException(String mensajeTecnico,String mensajeUsuario, Lugar lugar, Throwable excepcionRaiz) {
		super(mensajeTecnico,excepcionRaiz);
		setMensajeUsuario  (mensajeUsuario);
		setLugar (lugar);
	}
	
	public AUTOPARKADMINException(final String mensajeUsuario,final Lugar lugar) {
		super(mensajeUsuario,new Exception());
		setMensajeUsuario  (mensajeUsuario);
		setLugar (lugar);
	}
	
	public AUTOPARKADMINException(String mensajeTecnico,String mensajeUsuario, Lugar lugar) {
		super(mensajeTecnico);
		setMensajeUsuario  (mensajeUsuario);
		setLugar (lugar);
	}



	public static final long getSerialversionuid() {
		return serialVersionUID;
	}



	public final String getMensajeUsuario() {
		return mensajeUsuario;
	}



	public final Lugar getLugar() {
		return lugar;
	}



	private final void setMensajeUsuario(final String mensajeUsuario) {
		this.mensajeUsuario = TextHelper.applyTrim(mensajeUsuario);
	}


	private final void setLugar(final Lugar lugar) {
		this.lugar = ObjectHelper.getObjectHelper().getDefaultValue(lugar, Lugar.DEFAULT);
	}
	
	

}
