package co.priv.parqueadero.autoparkadmin.crosscutting.exceptions.messagecatalog;

import co.priv.parqueadero.autoparkadmin.crosscutting.exceptions.custom.CrosscuttingAUTOPARKADMINException;
import co.priv.parqueadero.autoparkadmin.crosscutting.exceptions.messagecatalog.data.CodigoMensaje;
import co.priv.parqueadero.autoparkadmin.crosscutting.exceptions.messagecatalog.data.Mensaje;
import co.priv.parqueadero.autoparkadmin.crosscutting.exceptions.messagecatalog.impl.MessageCatalogBase;
import co.priv.parqueadero.autoparkadmin.crosscutting.exceptions.messagecatalog.impl.MessageCatalogExternalService;
import co.priv.parqueadero.autoparkadmin.crosscutting.helpers.ObjectHelper;

public final class MessageCatalogStrategy {
	
	private static final MessageCatalog base = new MessageCatalogBase();
	
	private static final MessageCatalog externalService  = new MessageCatalogExternalService();
	
	static {
		
		inicializar();
		
	}
	
	
	public MessageCatalogStrategy() {
		super();
	}

	public static void inicializar() {
		base.inicializar();
		externalService.inicializar();
	}
	
	private static final MessageCatalog getStrategy(final boolean isBase) {
		return isBase? base : externalService;
	}
	
	public static final Mensaje getMensaje(final CodigoMensaje codigo, final String...parametros) {
		
		if (ObjectHelper.getObjectHelper().isNull(codigo)) {
			var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00002);
			var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00001);
			throw new CrosscuttingAUTOPARKADMINException(mensajeTecnico, mensajeUsuario);
		}
		
		return getStrategy(codigo.isBase()).obtenerMensaje(codigo, parametros);
		
	}
	
	public static final String getContenidoMensaje(final CodigoMensaje codigo, final String...parametros) {
		
		return getMensaje(codigo, parametros).getContenido();
		
	}
	

	
}
