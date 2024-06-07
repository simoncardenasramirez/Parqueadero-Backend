package co.priv.parqueadero.autoparkadmin.business.usecase.impl.vehiculo;

import java.util.UUID;
import co.priv.parqueadero.autoparkadmin.business.assembler.entity.impl.TipoVehiculoAssemblerEntity;
import co.priv.parqueadero.autoparkadmin.business.domain.VehiculoDomain;
import co.priv.parqueadero.autoparkadmin.business.usecase.UseCaseWithOutReturn;
import co.priv.parqueadero.autoparkadmin.crosscutting.exceptions.custom.BusinessAUTOPARKADMINException;
import co.priv.parqueadero.autoparkadmin.crosscutting.exceptions.messagecatalog.MessageCatalogStrategy;
import co.priv.parqueadero.autoparkadmin.crosscutting.exceptions.messagecatalog.data.CodigoMensaje;
import co.priv.parqueadero.autoparkadmin.crosscutting.helpers.ObjectHelper;
import co.priv.parqueadero.autoparkadmin.crosscutting.helpers.UUIDHelper;
import co.priv.parqueadero.autoparkadmin.data.dao.factory.DAOFactory;
import co.priv.parqueadero.autoparkadmin.entity.TipoVehiculoEntity;
import co.priv.parqueadero.autoparkadmin.entity.VehiculoEntity;

public final class RegistrarVehiculo implements UseCaseWithOutReturn<VehiculoDomain> {

	private final DAOFactory factory;
	public static final String FORMATO_MATRICULA_CARRO = "[A-Z]{3}\\d{3}";
	public static final String FORMATO_MATRICULA_MOTO = "[A-Z]{3}\\d{2}[A-Z]";

	public RegistrarVehiculo(final DAOFactory factory) {
		if (ObjectHelper.getObjectHelper().isNull(factory)) {
			var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00027);
			var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00030);
			throw new BusinessAUTOPARKADMINException(mensajeTecnico, mensajeUsuario);
		}
		this.factory = factory;
	}

	@Override
	public void execute(final VehiculoDomain data) {
		// 1. Validar que los casos de uso sean correctos a nivel de tipo de dato,
		// longitud, obligatoriedad, formato, rango, etc...
		validarFormatoMatricula(data.getMatricula());

		// 2. Validar que no exista otro vehículo con la misma matrícula
		validarVehiculoMismaMatricula(data.getMatricula());

		// 3. Validar que el vehiculo tenga un tipo de vehiculo
		validarTipoVehiculoExista(data.getTipoVehiculo().getId());

		var vehiculoEntity = VehiculoEntity.build().setId(generarIdentificadorVehiculo())
				.setMatricula(data.getMatricula())
				.setTipoVehiculo(TipoVehiculoAssemblerEntity.getInstance().toEntity(data.getTipoVehiculo()));

		// 4. Guardar el nuevo vehículo
		factory.getVehiculoDAO().crear(vehiculoEntity);
	}

	private final UUID generarIdentificadorVehiculo() {
		UUID id = UUIDHelper.generate();
		boolean existeId = true;

		while (existeId) {
			id = UUIDHelper.generate();
			var vehiculoEntity = VehiculoEntity.build().setId(id);
			var resultados = factory.getVehiculoDAO().consultar(vehiculoEntity);

			existeId = !resultados.isEmpty();
		}
		return id;
	}

	private final void validarVehiculoMismaMatricula(final String matricula) {
		var vehiculoEntity = VehiculoEntity.build().setMatricula(matricula);
		var resultados = factory.getVehiculoDAO().consultar(vehiculoEntity);

		if (!resultados.isEmpty()) {
			var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00032);
			throw new BusinessAUTOPARKADMINException(mensajeUsuario);
		}
	}

	private void validarFormatoMatricula(String matricula) {

		if (!matricula.matches(FORMATO_MATRICULA_CARRO) && !matricula.matches(FORMATO_MATRICULA_MOTO)) {
			var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00048);
			throw new BusinessAUTOPARKADMINException(mensajeUsuario);
		}
	}

	private void validarTipoVehiculoExista(final UUID idTipoVehiculo) {
		var tipoVehiculoEntity = TipoVehiculoEntity.build().setId(idTipoVehiculo);
		
		var resultados = factory.getTipoVehiculoDAO().consultar(tipoVehiculoEntity);
		
		if (resultados.isEmpty()) {
			var mensajeUsuario = "El Tipo vehiculo al que desea asociar el vehiculo no existe";
			throw new BusinessAUTOPARKADMINException(mensajeUsuario);
		}
	}

}
