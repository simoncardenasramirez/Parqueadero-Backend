package co.priv.parqueadero.autoparkadmin.crosscutting.ecxeptions;

import co.priv.parqueadero.autoparkadmin.crosscutting.ecxeptions.enums.Lugar;
import co.priv.parqueadero.autoparkadmin.crosscutting.helpers.ObjectHelper;
import co.priv.parqueadero.autoparkadmin.crosscutting.helpers.TextHelper;

public class BusinessAUTOPARKADMINExcepcion extends RuntimeException{

	private static final long serialVersionUID = 1L;
	protected String mensajeUsuario;
	protected Lugar lugar = Lugar.CROSSCUTTING ;
	
	public BusinessAUTOPARKADMINExcepcion(String mensajeTecnico, String mensajeUsuario,Lugar lugar, Throwable excepcionRaiz ) {
		super(mensajeTecnico,excepcionRaiz);
		setMensajeUsuario(mensajeUsuario);
		setLugar(lugar);
	}
	
	public BusinessAUTOPARKADMINExcepcion(final String mensajeUsuario, final Lugar lugar ) {
		super(mensajeUsuario, new Exception());
		setMensajeUsuario(mensajeUsuario);
		setLugar(lugar);
	}
	
	
	public BusinessAUTOPARKADMINExcepcion(final String mensajeTecnico, final String mensajeUsuario, final Lugar lugar ) {
		super(mensajeUsuario, new Exception());
		setMensajeUsuario(mensajeUsuario);
		setLugar(lugar);
	}


	
	public void setMensajeUsuario(String mensajeUsuario) {
		this.mensajeUsuario = TextHelper.applyTrim(mensajeUsuario);
	}
	
	private final void setLugar(final Lugar lugar) {
		this.lugar = ObjectHelper.getObjectHelper().getDefaultValue(lugar, lugar.DEFAULT);
	}

	public Lugar getLugar() {
		return lugar;
	}

	public String getMensajeUsuario() {
		return mensajeUsuario;
	}
	
	

	
	
	
	
	
	


}
