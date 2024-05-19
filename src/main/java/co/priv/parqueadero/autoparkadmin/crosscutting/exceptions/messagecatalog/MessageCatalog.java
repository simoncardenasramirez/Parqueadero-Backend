package co.priv.parqueadero.autoparkadmin.crosscutting.exceptions.messagecatalog;

import co.priv.parqueadero.autoparkadmin.crosscutting.exceptions.messagecatalog.data.CodigoMensaje;
import co.priv.parqueadero.autoparkadmin.crosscutting.exceptions.messagecatalog.data.Mensaje;

public interface MessageCatalog {
	
	void inicializar();
	
	String obtenerContenidoMensaje(final CodigoMensaje Codigo, final String... parametros);
	Mensaje obtenerMensaje(final CodigoMensaje codigo, final String... parametros);

}
