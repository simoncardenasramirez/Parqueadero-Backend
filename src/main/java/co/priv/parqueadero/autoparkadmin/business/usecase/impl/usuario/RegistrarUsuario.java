package co.priv.parqueadero.autoparkadmin.business.usecase.impl.usuario;

import java.util.UUID;
import co.priv.parqueadero.autoparkadmin.business.assembler.entity.impl.TipoVehiculoAssemblerEntity;
import co.priv.parqueadero.autoparkadmin.business.domain.UsuarioDomain;
import co.priv.parqueadero.autoparkadmin.business.domain.VehiculoDomain;
import co.priv.parqueadero.autoparkadmin.business.usecase.UseCaseWithOutReturn;
import co.priv.parqueadero.autoparkadmin.crosscutting.exceptions.custom.BusinessAUTOPARKADMINException;
import co.priv.parqueadero.autoparkadmin.crosscutting.exceptions.messagecatalog.MessageCatalogStrategy;
import co.priv.parqueadero.autoparkadmin.crosscutting.exceptions.messagecatalog.data.CodigoMensaje;
import co.priv.parqueadero.autoparkadmin.crosscutting.helpers.ObjectHelper;
import co.priv.parqueadero.autoparkadmin.crosscutting.helpers.UUIDHelper;
import co.priv.parqueadero.autoparkadmin.data.dao.factory.DAOFactory;
import co.priv.parqueadero.autoparkadmin.entity.TipoVehiculoEntity;
import co.priv.parqueadero.autoparkadmin.entity.UsuarioEntity;
import co.priv.parqueadero.autoparkadmin.entity.VehiculoEntity;

public final class RegistrarUsuario implements UseCaseWithOutReturn<UsuarioDomain> {

	private final DAOFactory factory;

	public RegistrarUsuario(final DAOFactory factory) {
		if (ObjectHelper.getObjectHelper().isNull(factory)) {
			var mensajeUsuario = "";
			var mensajeTecnico = "";
			throw new BusinessAUTOPARKADMINException(mensajeTecnico, mensajeUsuario);
		}
		this.factory = factory;
	}

	@Override
	public void execute(final UsuarioDomain data) {
		verificarUsuarioExistente(data.getUsuario());

		// Crear nuevo usuario
		var usuarioEntity = UsuarioEntity.build().setId(generarIdentificadorUsuario()).setUsuario(data.getUsuario())
				.setContraseña(data.getContraseña());

		// Guardar el nuevo usuario
		factory.getUsuarioDAO().crear(usuarioEntity);
	}

	private void verificarUsuarioExistente(String nombreUsuario) {
		var usuarioEntity = UsuarioEntity.build().setUsuario(nombreUsuario);
		var resultados = factory.getUsuarioDAO().consultar(usuarioEntity);

		var mensajeUsuario = "El usuario ya existe.";
		if (!resultados.isEmpty()) {
			throw new BusinessAUTOPARKADMINException(mensajeUsuario);
		}
	}

	private final UUID generarIdentificadorUsuario() {
		UUID id = UUIDHelper.generate();
		boolean existeId = true;

		while (existeId) {
			id = UUIDHelper.generate();
			var usuarioEntity = UsuarioEntity.build().setId(id);
			var resultados = factory.getUsuarioDAO().consultar(usuarioEntity);

			existeId = !resultados.isEmpty();
		}
		return id;
	}

}
