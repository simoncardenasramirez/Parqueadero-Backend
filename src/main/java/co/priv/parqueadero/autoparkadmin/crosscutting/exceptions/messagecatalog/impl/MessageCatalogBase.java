package co.priv.parqueadero.autoparkadmin.crosscutting.exceptions.messagecatalog.impl;

import java.util.HashMap;
import java.util.Map;

import co.priv.parqueadero.autoparkadmin.crosscutting.exceptions.custom.CrosscuttingAUTOPARKADMINException;
import co.priv.parqueadero.autoparkadmin.crosscutting.exceptions.messagecatalog.MessageCatalog;
import co.priv.parqueadero.autoparkadmin.crosscutting.exceptions.messagecatalog.data.CodigoMensaje;
import co.priv.parqueadero.autoparkadmin.crosscutting.exceptions.messagecatalog.data.Mensaje;
import co.priv.parqueadero.autoparkadmin.crosscutting.helpers.ObjectHelper;



public final class MessageCatalogBase implements MessageCatalog {
	
	private final Map<String,Mensaje> mensajes = new HashMap<>();

	@Override
	public final void inicializar() {
		mensajes.clear();
		
		mensajes.put(CodigoMensaje.M00001.getIdentificador(), new Mensaje(CodigoMensaje.M00001,
				"El código del mensaje que quiere obtener del catálogo mensajes llegó nulo..."));
		mensajes.put(CodigoMensaje.M00002.getIdentificador(), new Mensaje(CodigoMensaje.M00002,
				"Se ha presentado un problema tratando de llevar a cabo la operación deseada..."));
		mensajes.put(CodigoMensaje.M00003.getIdentificador(), new Mensaje(CodigoMensaje.M00003,
				"El identificador del mensaje \"${1}\" que se intentó obtener, no está en el catálogo de mensajes base..."));
		mensajes.put(CodigoMensaje.M00004.getIdentificador(), new Mensaje(CodigoMensaje.M00004,
				"El mensaje con identificador \"${1}\" que se intentó obtener, no está configurado para residir en el catálogo de mensajes base..."));
		mensajes.put(CodigoMensaje.M00005.getIdentificador(), new Mensaje(CodigoMensaje.M00005,
				"El mensaje con identificador \"${1}\" que se intentó obtener, no está configurado para residir en el catálogo de mensajes externo..."));
		mensajes.put(CodigoMensaje.M00006.getIdentificador(), new Mensaje(CodigoMensaje.M00006,
				"El identificador del mensaje \"${1}\" que se intentó obtener, no está en el catálogo de mensajes externo..."));
 
		mensajes.put(CodigoMensaje.M00007.getIdentificador(), new Mensaje(CodigoMensaje.M00007,
				"Se ha presentado un problema tratando de validar si la conexión SQL con la fuente de información deseada estaba cerrada..."));
		mensajes.put(CodigoMensaje.M00008.getIdentificador(), new Mensaje(CodigoMensaje.M00008,
				"Se ha presentado un problema INESPERADO tratando de validar si la conexión SQL con la fuente de información deseada estaba cerrada..."));
		mensajes.put(CodigoMensaje.M00009.getIdentificador(), new Mensaje(CodigoMensaje.M00009,
				"Se ha intentado realizar el cierre de una conexión SQL que ya estaba cerrada..."));
		mensajes.put(CodigoMensaje.M00010.getIdentificador(), new Mensaje(CodigoMensaje.M00010,
				"Se ha presentado un problema tratando de cerrar la conexión SQL con la fuente de información deseada..."));
		mensajes.put(CodigoMensaje.M00011.getIdentificador(), new Mensaje(CodigoMensaje.M00011,
				"Se ha presentado un problema INESPERADO tratando de cerrar la conexión SQL con la fuente de información deseada..."));
		mensajes.put(CodigoMensaje.M00012.getIdentificador(), new Mensaje(CodigoMensaje.M00012,
				"Se ha intentado confirmar una transacción con una conexión SQL cerrada..."));
		mensajes.put(CodigoMensaje.M00013.getIdentificador(), new Mensaje(CodigoMensaje.M00013,
				"Se ha intentado confirmar una transacción cuando el autocommit de la conexión con la base de datos estaba activado..."));
		mensajes.put(CodigoMensaje.M00014.getIdentificador(), new Mensaje(CodigoMensaje.M00014,
				"Se ha presentado un problema tratando de confirmar una transacción SQL con la fuente de información deseada..."));
		mensajes.put(CodigoMensaje.M00015.getIdentificador(), new Mensaje(CodigoMensaje.M00015,
				"Se ha presentado un problema INESPERADO tratando de confirmar una transacción SQL con la fuente de información deseada..."));
		mensajes.put(CodigoMensaje.M00016.getIdentificador(), new Mensaje(CodigoMensaje.M00016,
				"Se ha intentado cancelar una transacción con una conexión SQL cerrada..."));
		mensajes.put(CodigoMensaje.M00017.getIdentificador(), new Mensaje(CodigoMensaje.M00017,
				"Se ha intentado cancelar una transacción cuando el autocommit de la conexión con la base de datos estaba activado..."));
		mensajes.put(CodigoMensaje.M00018.getIdentificador(), new Mensaje(CodigoMensaje.M00018,
				"Se ha presentado un problema tratando de cancelar una transacción SQL con la fuente de información deseada..."));
		mensajes.put(CodigoMensaje.M00019.getIdentificador(), new Mensaje(CodigoMensaje.M00019,
				"Se ha presentado un problema INESPERADO tratando de cancelar una transacción SQL con la fuente de información deseada..."));
 
		mensajes.put(CodigoMensaje.M00020.getIdentificador(), new Mensaje(CodigoMensaje.M00020,
				"Se ha intentado iniciar una transacción con una conexión SQL cerrada..."));
		mensajes.put(CodigoMensaje.M00021.getIdentificador(), new Mensaje(CodigoMensaje.M00021,
				"Se ha presentado un problema tratando de iniciar una transacción SQL con la fuente de información deseada..."));
		mensajes.put(CodigoMensaje.M00022.getIdentificador(), new Mensaje(CodigoMensaje.M00022,
				"Se ha presentado un problema INESPERADO tratando de iniciar una transacción SQL con la fuente de información deseada..."));
		mensajes.put(CodigoMensaje.M00023.getIdentificador(),new Mensaje(CodigoMensaje.M00023,
				"se ha presentado un prblema tratando de registrar el vehiculo \"${1}\" y si el problema sigue contacte a el administrador ..." ));
		mensajes.put(CodigoMensaje.M00027.getIdentificador(),new Mensaje(CodigoMensaje.M00027,
				"Se ha presentado un problema tratando de llevar a cabo el registro de un vehículo"));
		mensajes.put(CodigoMensaje.M00028.getIdentificador(),new Mensaje(CodigoMensaje.M00028,
				"Se ha presentado un problema tratando de llevar a cabo el registro de la consulta del vehiculo"));
		mensajes.put(CodigoMensaje.M00029.getIdentificador(),new Mensaje(CodigoMensaje.M00029,
				"El DAOFactory para crear el registro de los vehiculos llego nulo"));
		mensajes.put(CodigoMensaje.M00030.getIdentificador(),new Mensaje(CodigoMensaje.M00030,
				"el DAOfactoty para registrar el vehiculo llego nulo..."));
		mensajes.put(CodigoMensaje.M00032.getIdentificador(),new Mensaje(CodigoMensaje.M00032,
				"Ya existe un vehículo registrado con esta matrícula en la base de datos "));
		mensajes.put(CodigoMensaje.M00046.getIdentificador(),new Mensaje(CodigoMensaje.M00046,
				"No es posible crear el DAO deseado con una conexion cerrada"));
		mensajes.put(CodigoMensaje.M00024.getIdentificador(),new Mensaje(CodigoMensaje.M00024,
				"Ha ocurrido un error inesperado tratando de consultar los vehiculos"));
		mensajes.put(CodigoMensaje.M00025.getIdentificador(),new Mensaje(CodigoMensaje.M00025,
				"No es posible consultar los vehiculos a la base de datos por un error inesperado"));
		mensajes.put(CodigoMensaje.M00026.getIdentificador(),new Mensaje(CodigoMensaje.M00026,
				"No es posible registrar los vehiculos a la base de datos por un error inesperado"));
		mensajes.put(CodigoMensaje.M00034.getIdentificador(),new Mensaje(CodigoMensaje.M00034,
				"No es posible registrar el vehiculo ..."));
		mensajes.put(CodigoMensaje.M00035.getIdentificador(),new Mensaje(CodigoMensaje.M00035,
				"No es posible registrar el vehiculo por un error inesperado ..."));
		mensajes.put(CodigoMensaje.M00036.getIdentificador(),new Mensaje(CodigoMensaje.M00036,
				"No es posible consultar los vehiculos a la base de datos por un Excepcion de tipo SQLException"));
		mensajes.put(CodigoMensaje.M00037.getIdentificador(),new Mensaje(CodigoMensaje.M00037,
				"Ha ocurrido un error inesperado tratando de consultar los tipos de vehiculos"));
		mensajes.put(CodigoMensaje.M00038.getIdentificador(),new Mensaje(CodigoMensaje.M00038,
				"No es posible consultar los vehiculos a la base de datos por un Excepcion de tipo SQLException"));
		mensajes.put(CodigoMensaje.M00039.getIdentificador(),new Mensaje(CodigoMensaje.M00039,
				"Ha ocurrido un error inesperado tratando de consultar los tipos de vehiculos"));
		mensajes.put(CodigoMensaje.M00040.getIdentificador(),new Mensaje(CodigoMensaje.M00040,
				"No es posible consultar los tipos de vehiculos a la base de datos por un error inesperado"));
		mensajes.put(CodigoMensaje.M00041.getIdentificador(),new Mensaje(CodigoMensaje.M00041,
				"Vehículo consultado correctamente"));
		mensajes.put(CodigoMensaje.M00042.getIdentificador(),new Mensaje(CodigoMensaje.M00042,
				"Vehículo registrado correctamente"));
		mensajes.put(CodigoMensaje.M00043.getIdentificador(),new Mensaje(CodigoMensaje.M00043,
				"el vehiculo no se pudo consultar por un error inesperado"));
		mensajes.put(CodigoMensaje.M00045.getIdentificador(),new Mensaje(CodigoMensaje.M00045,
				"el tipo de vehiculo no se pudo consultar  por un error inesperado"));
		mensajes.put(CodigoMensaje.M00047.getIdentificador(),new Mensaje(CodigoMensaje.M00047,
				"el tipo de vehículo consultado correctamente"));
		mensajes.put(CodigoMensaje.M00048.getIdentificador(),new Mensaje(CodigoMensaje.M00048,
				"El formato de la matrícula es incorrecto"));
		mensajes.put(CodigoMensaje.M00049.getIdentificador(),new Mensaje(CodigoMensaje.M00049,
				"El tipo del vehículo debe y no puede ser nulo..."));
		mensajes.put(CodigoMensaje.M00050.getIdentificador(),new Mensaje(CodigoMensaje.M00050,
				"El tipo del vehículo debe y no puede estar vacio..."));
		

	}

	@Override
	public final String obtenerContenidoMensaje(CodigoMensaje codigo,final  String... parametros) {

		return obtenerMensaje(codigo, parametros).getContenido();
	}

	@Override
	public final Mensaje obtenerMensaje(final CodigoMensaje codigo,final  String... parametros) {
		if (ObjectHelper.getObjectHelper().isNull(codigo)) {
			var mensajeUsuario = obtenerContenidoMensaje(CodigoMensaje.M00002);
			var mensajeTecnico = obtenerContenidoMensaje(CodigoMensaje.M00001);
			throw new CrosscuttingAUTOPARKADMINException(mensajeTecnico, mensajeUsuario);
		}
		if (!codigo.isBase()) {
			var mensajeUsuario = obtenerContenidoMensaje(CodigoMensaje.M00002);
			var mensajeTecnico = obtenerContenidoMensaje(CodigoMensaje.M00004,codigo.getIdentificador());
			throw new CrosscuttingAUTOPARKADMINException(mensajeTecnico, mensajeUsuario);
		}
		
		if (!mensajes.containsKey(codigo.getIdentificador())) {
			var mensajeUsuario = obtenerContenidoMensaje(CodigoMensaje.M00002);
			var mensajeTecnico = obtenerContenidoMensaje(CodigoMensaje.M00003,codigo.getIdentificador());
			throw new CrosscuttingAUTOPARKADMINException(mensajeTecnico, mensajeUsuario);
			
		}
		
		
		// TODO: tarea: asegure que si tiene parametros, el contenido del mensaje se retorne  con los parametros reemplazados 
		return mensajes.get(codigo.getIdentificador());
	}



}
