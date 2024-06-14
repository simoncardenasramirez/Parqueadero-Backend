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
				"La matricula tiene que seguir el formato de 3 letras y 3 numeros: Ejemplo AAA000"));
		mensajes.put(CodigoMensaje.M00049.getIdentificador(),new Mensaje(CodigoMensaje.M00049,
				"El tipo del vehículo debe y no puede ser nulo..."));
		mensajes.put(CodigoMensaje.M00050.getIdentificador(),new Mensaje(CodigoMensaje.M00050,
				"El tipo del vehículo debe y no puede estar vacio..."));


		mensajes.put(CodigoMensaje.M00051.getIdentificador(),new Mensaje(CodigoMensaje.M00051,
				"Se ha presentado un problema tratando de obtener la conexión con la base de datos PostgreSQL. Por favor revise la traza de errores para identificar y solucionar el problema..."));
		mensajes.put(CodigoMensaje.M00052.getIdentificador(),new Mensaje(CodigoMensaje.M00052,
				"Se ha presentado un problema INESPERADO tratando de obtener la conexión con la base de datos PostgreSQL. Por favor revise la traza de errores para identificar y solucionar el problema..."));



		mensajes.put(CodigoMensaje.M00053.getIdentificador(),new Mensaje(CodigoMensaje.M00053,
				"Error al crear usuario. Por favor, inténtelo de nuevo más tarde."));

		mensajes.put(CodigoMensaje.M00054.getIdentificador(),new Mensaje(CodigoMensaje.M00054,
				"Se produjo un error al ejecutar la consulta SQL de inserción."));

		mensajes.put(CodigoMensaje.M00055.getIdentificador(),new Mensaje(CodigoMensaje.M00055,
				"Error al crear usuario. Por favor, inténtelo de nuevo más tarde."));

		mensajes.put(CodigoMensaje.M00056.getIdentificador(),new Mensaje(CodigoMensaje.M00056,
				"Se produjo un error inesperado durante la creación del usuario."));

		mensajes.put(CodigoMensaje.M00057.getIdentificador(),new Mensaje(CodigoMensaje.M00057,
				"Se ha presentado un problema tratando de consultar los usuarios. Por favor, contacte al administrador del sistema."));

		mensajes.put(CodigoMensaje.M00058.getIdentificador(),new Mensaje(CodigoMensaje.M00058,
				"Se ha presentado una SQLException tratando de realizar la consulta de los usuarios en la tabla \"Usuario\" de la base de datos PostgreSQL."));

		mensajes.put(CodigoMensaje.M00059.getIdentificador(),new Mensaje(CodigoMensaje.M00059,
				"Se ha presentado un problema tratando de consultar los usuarios. Por favor, contacte al administrador del sistema."));

		mensajes.put(CodigoMensaje.M00060.getIdentificador(),new Mensaje(CodigoMensaje.M00060,
				"Se ha presentado un problema INESPERADO con una excepción de tipo Exception tratando de realizar la consulta de los usuarios en la tabla \"Usuario\" de la base de datos PostgreSQL."));

		mensajes.put(CodigoMensaje.M00061.getIdentificador(),new Mensaje(CodigoMensaje.M00061,
				"Se ha presentado un problema tratando de autenticar los usuarios. Por favor, contacte al administrador del sistema."));

		mensajes.put(CodigoMensaje.M00062.getIdentificador(),new Mensaje(CodigoMensaje.M00062,
				"Se ha presentado un problema ejecutando la sentencia SQL en la base de datos PostgreSQL"));

		mensajes.put(CodigoMensaje.M00063.getIdentificador(),new Mensaje(CodigoMensaje.M00063,
				"Se ha presentado un problema tratando de autenticar los usuarios. Por favor, contacte al administrador del sistema."));

		mensajes.put(CodigoMensaje.M00064.getIdentificador(),new Mensaje(CodigoMensaje.M00064,
				"Se ha presentado un INESPERADO problema ejecutando la sentencia SQL en la base de datos PostgreSQL"));

		mensajes.put(CodigoMensaje.M00065.getIdentificador(),new Mensaje(CodigoMensaje.M00065,
				"Se ha presentado un problema tratando de consultar los usuarios. Por favor, contacte al administrador del sistema."));

		mensajes.put(CodigoMensaje.M00066.getIdentificador(),new Mensaje(CodigoMensaje.M00066,
				"Se ha presentado una SQLException tratando de realizar la consulta de los usuarios en la tabla \"Usuario\" de la base de datos PostgreSQL."));

		mensajes.put(CodigoMensaje.M00067.getIdentificador(),new Mensaje(CodigoMensaje.M00067,
				"Se ha presentado un problema tratando de consultar los usuarios. Por favor, contacte al administrador del sistema."));

		mensajes.put(CodigoMensaje.M00068.getIdentificador(),new Mensaje(CodigoMensaje.M00068,
				"Se ha presentado un problema INESPERADO con una excepción de tipo Exception tratando de realizar la consulta de los usuarios en la tabla \"Usuario\" de la base de datos PostgreSQL."));

		mensajes.put(CodigoMensaje.M00069.getIdentificador(),new Mensaje(CodigoMensaje.M00069,
				"Se ha presentado un problema tratando de consultar los tipos de vehiculo. Por favor, contacte al administrador del sistema."));

		mensajes.put(CodigoMensaje.M00070.getIdentificador(),new Mensaje(CodigoMensaje.M00070,
				"Se ha presentado una SQLException tratando de realizar la consulta de los tipo de vehiculo en la tabla \"TipoVehiculo\" de la base de datos PostgreSQL."));

		mensajes.put(CodigoMensaje.M00071.getIdentificador(),new Mensaje(CodigoMensaje.M00071,
				"Se ha presentado un problema tratando de consultar los tipo de vehiculo. Por favor, contacte al administrador del sistema."));

		mensajes.put(CodigoMensaje.M00072.getIdentificador(),new Mensaje(CodigoMensaje.M00072,
				"Se ha presentado una SQLException tratando de realizar la consulta de los tipo de vehiculo en la tabla \"TipoVehiculo\" de la base de datos PostgreSQL."));

		mensajes.put(CodigoMensaje.M00073.getIdentificador(),new Mensaje(CodigoMensaje.M00073,
				"Se ha presentado un problema al consultar la información del parqueadero"));

		mensajes.put(CodigoMensaje.M00074.getIdentificador(),new Mensaje(CodigoMensaje.M00074,
				"Se ha presentado una SQLException tratando de realizar la consulta de los parqueaderos en la tabla \"Parqueadero\" de la base de datos."));

		mensajes.put(CodigoMensaje.M00075.getIdentificador(),new Mensaje(CodigoMensaje.M00075,
				"Se ha presentado un problema al consultar la información del parqueadero"));

		mensajes.put(CodigoMensaje.M00076.getIdentificador(),new Mensaje(CodigoMensaje.M00076,
				"Se ha presentado una SQLException tratando de realizar la consulta de los parqueaderos en la tabla \"Parqueadero\" de la base de datos."));

		mensajes.put(CodigoMensaje.M00077.getIdentificador(),new Mensaje(CodigoMensaje.M00077,
				"Se ha presentado una SQLException tratando de realizar la consulta de los estados de celda en la tabla \"EstadoCelda\" de la base de datos."));

		mensajes.put(CodigoMensaje.M00078.getIdentificador(),new Mensaje(CodigoMensaje.M00078,
				"Se ha presentado un problema al consultar la información de los estados de celda"));

		mensajes.put(CodigoMensaje.M00079.getIdentificador(),new Mensaje(CodigoMensaje.M00079,
				"Se ha presentado una SQLException tratando de realizar la consulta de los estados de celda en la tabla \"EstadoCelda\" de la base de datos."));

		mensajes.put(CodigoMensaje.M00080.getIdentificador(),new Mensaje(CodigoMensaje.M00080,
				"Se ha presentado un problema tratando de crear la celda. Por favor, inténtelo de nuevo y si el problema persiste, contacte con el administrador."));

		mensajes.put(CodigoMensaje.M00081.getIdentificador(),new Mensaje(CodigoMensaje.M00081,
				"Se ha presentado una excepción de tipo SQLException tratando de realizar el insert de la celda en la tabla \"Celda\" de la base de datos PostgreSQL. Para más detalles, revise de forma completa la excepción raíz presentada."));

		mensajes.put(CodigoMensaje.M00082.getIdentificador(),new Mensaje(CodigoMensaje.M00082,
				"Se ha presentado un problema tratando de crear la celda. Por favor, inténtelo de nuevo y si el problema persiste, contacte con el administrador."));

		mensajes.put(CodigoMensaje.M00083.getIdentificador(),new Mensaje(CodigoMensaje.M00083,
				"Se ha presentado un problema inesperado de tipo Exception tratando de realizar el insert de la celda en la tabla \"Celda\" de la base de datos PostgreSQL. Para más detalles, revise de forma completa la excepción raíz presentada."));

		mensajes.put(CodigoMensaje.M00084.getIdentificador(),new Mensaje(CodigoMensaje.M00084,
				"Se ha presentado un problema al consultar la información de las celdas"));

		mensajes.put(CodigoMensaje.M00085.getIdentificador(),new Mensaje(CodigoMensaje.M00085,
				"Se ha presentado una SQLException tratando de realizar la consulta de las celdas en la tabla \"Celda\" de la base de datos."));

		mensajes.put(CodigoMensaje.M00086.getIdentificador(),new Mensaje(CodigoMensaje.M00086,
				"Se ha presentado un problema al consultar la información de las celdas"));

		mensajes.put(CodigoMensaje.M00087.getIdentificador(),new Mensaje(CodigoMensaje.M00087,
				"Se ha presentado una SQLException tratando de realizar la consulta de las celdas en la tabla \"Celda\" de la base de datos."));


		/*
		mensajes.put(CodigoMensaje.M00088.getIdentificador(),new Mensaje(CodigoMensaje.M00088,
				));


		mensajes.put(CodigoMensaje.M00089.getIdentificador(),new Mensaje(CodigoMensaje.M00089,
				));

		mensajes.put(CodigoMensaje.M00090.getIdentificador(),new Mensaje(CodigoMensaje.M00090,
				));

		mensajes.put(CodigoMensaje.M00091.getIdentificador(),new Mensaje(CodigoMensaje.M00091,
				));

		mensajes.put(CodigoMensaje.M00092.getIdentificador(),new Mensaje(CodigoMensaje.M00092,
				));

		mensajes.put(CodigoMensaje.M00093.getIdentificador(),new Mensaje(CodigoMensaje.M00093,
				));

		mensajes.put(CodigoMensaje.M00094.getIdentificador(),new Mensaje(CodigoMensaje.M00094,
				));

		mensajes.put(CodigoMensaje.M00095.getIdentificador(),new Mensaje(CodigoMensaje.M00095,
				));

		mensajes.put(CodigoMensaje.M00096.getIdentificador(),new Mensaje(CodigoMensaje.M00096,
				));

		mensajes.put(CodigoMensaje.M00097.getIdentificador(),new Mensaje(CodigoMensaje.M00097,
				));

		mensajes.put(CodigoMensaje.M00098.getIdentificador(),new Mensaje(CodigoMensaje.M00098,
				));

		mensajes.put(CodigoMensaje.M00099.getIdentificador(),new Mensaje(CodigoMensaje.M00099,
				));

		mensajes.put(CodigoMensaje.M00115.getIdentificador(),new Mensaje(CodigoMensaje.M00115,
				));

		mensajes.put(CodigoMensaje.M00116.getIdentificador(),new Mensaje(CodigoMensaje.M00116,
				));

		mensajes.put(CodigoMensaje.M00117.getIdentificador(),new Mensaje(CodigoMensaje.M00117,
				));

		mensajes.put(CodigoMensaje.M00118.getIdentificador(),new Mensaje(CodigoMensaje.M00118,
				));

		mensajes.put(CodigoMensaje.M00119.getIdentificador(),new Mensaje(CodigoMensaje.M00119,
				));

		mensajes.put(CodigoMensaje.M00120.getIdentificador(),new Mensaje(CodigoMensaje.M00120,
				));

		mensajes.put(CodigoMensaje.M00121.getIdentificador(),new Mensaje(CodigoMensaje.M00121,
				));

		mensajes.put(CodigoMensaje.M00122.getIdentificador(),new Mensaje(CodigoMensaje.M00122,
				));

		mensajes.put(CodigoMensaje.M00123.getIdentificador(),new Mensaje(CodigoMensaje.M00123,
				));

		mensajes.put(CodigoMensaje.M00124.getIdentificador(),new Mensaje(CodigoMensaje.M00124,
				));

		mensajes.put(CodigoMensaje.M00125.getIdentificador(),new Mensaje(CodigoMensaje.M00125,
				));

		mensajes.put(CodigoMensaje.M00126.getIdentificador(),new Mensaje(CodigoMensaje.M00126,
				));

		mensajes.put(CodigoMensaje.M00127.getIdentificador(),new Mensaje(CodigoMensaje.M00127,
				));

		mensajes.put(CodigoMensaje.M00128.getIdentificador(),new Mensaje(CodigoMensaje.M00128,
				));

		mensajes.put(CodigoMensaje.M00129.getIdentificador(),new Mensaje(CodigoMensaje.M00129,
				));





		mensajes.put(CodigoMensaje..getIdentificador(),new Mensaje(CodigoMensaje.,
				));

		mensajes.put(CodigoMensaje..getIdentificador(),new Mensaje(CodigoMensaje.,
				));

		mensajes.put(CodigoMensaje..getIdentificador(),new Mensaje(CodigoMensaje.,
				));

		mensajes.put(CodigoMensaje..getIdentificador(),new Mensaje(CodigoMensaje.,
				));
		mensajes.put(CodigoMensaje..getIdentificador(),new Mensaje(CodigoMensaje.,
				));

		mensajes.put(CodigoMensaje..getIdentificador(),new Mensaje(CodigoMensaje.,
				));
		mensajes.put(CodigoMensaje..getIdentificador(),new Mensaje(CodigoMensaje.,
				));

		mensajes.put(CodigoMensaje..getIdentificador(),new Mensaje(CodigoMensaje.,
				));
		mensajes.put(CodigoMensaje..getIdentificador(),new Mensaje(CodigoMensaje.,
				));

		mensajes.put(CodigoMensaje..getIdentificador(),new Mensaje(CodigoMensaje.,
				));
		mensajes.put(CodigoMensaje..getIdentificador(),new Mensaje(CodigoMensaje.,
				));

		mensajes.put(CodigoMensaje..getIdentificador(),new Mensaje(CodigoMensaje.,
				));
		mensajes.put(CodigoMensaje..getIdentificador(),new Mensaje(CodigoMensaje.,
				));

		mensajes.put(CodigoMensaje..getIdentificador(),new Mensaje(CodigoMensaje.,
				));
		mensajes.put(CodigoMensaje..getIdentificador(),new Mensaje(CodigoMensaje.,
				));

		mensajes.put(CodigoMensaje..getIdentificador(),new Mensaje(CodigoMensaje.,
				));
		mensajes.put(CodigoMensaje..getIdentificador(),new Mensaje(CodigoMensaje.,
				));

		mensajes.put(CodigoMensaje..getIdentificador(),new Mensaje(CodigoMensaje.,
				));
		mensajes.put(CodigoMensaje..getIdentificador(),new Mensaje(CodigoMensaje.,
				));

		mensajes.put(CodigoMensaje..getIdentificador(),new Mensaje(CodigoMensaje.,
				));
		mensajes.put(CodigoMensaje..getIdentificador(),new Mensaje(CodigoMensaje.,
				));

		mensajes.put(CodigoMensaje..getIdentificador(),new Mensaje(CodigoMensaje.,
				));
		mensajes.put(CodigoMensaje..getIdentificador(),new Mensaje(CodigoMensaje.,
				));

		mensajes.put(CodigoMensaje..getIdentificador(),new Mensaje(CodigoMensaje.,
				));
		mensajes.put(CodigoMensaje..getIdentificador(),new Mensaje(CodigoMensaje.,
				));

		mensajes.put(CodigoMensaje..getIdentificador(),new Mensaje(CodigoMensaje.,
				));
		mensajes.put(CodigoMensaje..getIdentificador(),new Mensaje(CodigoMensaje.,
				));

		mensajes.put(CodigoMensaje..getIdentificador(),new Mensaje(CodigoMensaje.,
				));
		mensajes.put(CodigoMensaje..getIdentificador(),new Mensaje(CodigoMensaje.,
				));

		mensajes.put(CodigoMensaje..getIdentificador(),new Mensaje(CodigoMensaje.,
				));
		mensajes.put(CodigoMensaje..getIdentificador(),new Mensaje(CodigoMensaje.,
				));

		mensajes.put(CodigoMensaje..getIdentificador(),new Mensaje(CodigoMensaje.,
				));
		mensajes.put(CodigoMensaje..getIdentificador(),new Mensaje(CodigoMensaje.,
				));

		mensajes.put(CodigoMensaje..getIdentificador(),new Mensaje(CodigoMensaje.,
				));
		mensajes.put(CodigoMensaje..getIdentificador(),new Mensaje(CodigoMensaje.,
				));

		mensajes.put(CodigoMensaje..getIdentificador(),new Mensaje(CodigoMensaje.,
				));
		mensajes.put(CodigoMensaje..getIdentificador(),new Mensaje(CodigoMensaje.,
				));

		mensajes.put(CodigoMensaje..getIdentificador(),new Mensaje(CodigoMensaje.,
				));
		mensajes.put(CodigoMensaje..getIdentificador(),new Mensaje(CodigoMensaje.,
				));

		mensajes.put(CodigoMensaje..getIdentificador(),new Mensaje(CodigoMensaje.,
				));
		mensajes.put(CodigoMensaje..getIdentificador(),new Mensaje(CodigoMensaje.,
				));

		mensajes.put(CodigoMensaje..getIdentificador(),new Mensaje(CodigoMensaje.,
				));
		mensajes.put(CodigoMensaje..getIdentificador(),new Mensaje(CodigoMensaje.,
				));

		mensajes.put(CodigoMensaje..getIdentificador(),new Mensaje(CodigoMensaje.,
				));



		 */












//Agregados para volver para arreglar el orden de los mensajes
		mensajes.put((CodigoMensaje.M00101.getIdentificador()),new Mensaje(CodigoMensaje.M00101,
				"Se ha presentado un problema tratando de crear el vehiculo. Por favor intente de nuevo y si el problema persiste contacte con el administrador..."));

		mensajes.put((CodigoMensaje.M00102.getIdentificador()), new Mensaje(CodigoMensaje.M00102,
				"Se ha presentado una excepcion de tipo SQLException tratando de realizar el insert del vehiculo  en la tabla \"Vehiculo\" de la base de datos " +
				"PostgreSQL. Para más detalles, revise de forma completa la excepción raíz presentada.."));

		mensajes.put((CodigoMensaje.M00103.getIdentificador()), new Mensaje(CodigoMensaje.M00103,
				"Se ha presentado un problema tratando de registrar el vehiculo \"%s\". Por favor intente de nuevo y si el problema persiste contacte con el administrador..."));

		mensajes.put((CodigoMensaje.M00104.getIdentificador()), new Mensaje(CodigoMensaje.M00104,
				"Se ha presentado un problema INESPERADO de tipo Exception tratando de realizar el insert del vehiculo  en la tabla \"Vehiculo\" de la base de datos PostgreSQL. Para más detalles, revise de forma completa la excepción raíz presentada.."));

		mensajes.put((CodigoMensaje.M00105.getIdentificador()),new Mensaje(CodigoMensaje.M00105,
				"Se ha presentado un problema tratando de consultar el vehiculo. Por favor, contacte al administrador del sistema."));

		mensajes.put((CodigoMensaje.M00106.getIdentificador()),new Mensaje(CodigoMensaje.M00106,
				"Se ha presentado una SQLException tratando de realizar la consulta de los vehiculos en la tabla \"Vehiculo\" de la base de datos PostgreSQL."));

		mensajes.put((CodigoMensaje.M00107.getIdentificador()), new Mensaje(CodigoMensaje.M00107,
				"Se ha presentado un problema tratando de consultar los vehiculos. Por favor, contacte al administrador del sistema."));

		mensajes.put((CodigoMensaje.M00108.getIdentificador()), new Mensaje(CodigoMensaje.M00108,
				"Se ha presentado un problema INESPERADO con una excepción de tipo Exception tratando de realizar la consulta de los vehiculos en la tabla \"Vehiculo\" de la base de datos PostgreSQL."));

		mensajes.put(CodigoMensaje.M00109.getIdentificador(),new Mensaje(CodigoMensaje.M00109,
				"Se ha presentado un problema al consultar la información de los estados de celda"));

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
		
		return mensajes.get(codigo.getIdentificador());
	}
}
