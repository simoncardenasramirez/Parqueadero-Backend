package co.priv.parqueadero.autoparkadmin.business.usecase.impl.usuario;

import java.util.UUID;

import co.priv.parqueadero.autoparkadmin.business.domain.UsuarioDomain;
import co.priv.parqueadero.autoparkadmin.business.usecase.UseCaseWithOutReturn;
import co.priv.parqueadero.autoparkadmin.crosscutting.exceptions.custom.BusinessAUTOPARKADMINException;
import co.priv.parqueadero.autoparkadmin.crosscutting.helpers.ObjectHelper;
import co.priv.parqueadero.autoparkadmin.crosscutting.helpers.UUIDHelper;
import co.priv.parqueadero.autoparkadmin.data.dao.factory.DAOFactory;
import co.priv.parqueadero.autoparkadmin.entity.UsuarioEntity;

public final class RegistrarUsuario implements UseCaseWithOutReturn<UsuarioDomain> {

	private final DAOFactory factory;

	public RegistrarUsuario(final DAOFactory factory) {
		if (ObjectHelper.getObjectHelper().isNull(factory)) {
			var mensajeUsuario = "Se ha presentado un problema tratando de registar el usuario";
			var mensajeTecnico = "El DAO Factory para registrar el usuario llegó nulo";
			throw new BusinessAUTOPARKADMINException(mensajeTecnico, mensajeUsuario);
		}
		this.factory = factory;
	}

	@Override
	public void execute(final UsuarioDomain data) {
		verificarUsuarioExistente(data.getUsuario());

		var usuarioEntity = UsuarioEntity.build().setId(generarIdentificadorUsuario()).setUsuario(data.getUsuario())
				.setContraseña(data.getContraseña());

		factory.getUsuarioDAO().crear(usuarioEntity);
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
	
	private void verificarUsuarioExistente(String nombreUsuario) {
		var usuarioEntity = UsuarioEntity.build().setUsuario(nombreUsuario);
		var resultados = factory.getUsuarioDAO().consultar(usuarioEntity);

        if (!resultados.isEmpty()) {
            var mensajeUsuario = "Ya existe un perfil con el mismo nombre de usuario...";
            var mensajeTecnico = "El nombre de usuario que se ingresó, es unico de cada perfil, por lo tanto ya se encuentra registrado en la base de datos.";
            throw new BusinessAUTOPARKADMINException(mensajeTecnico, mensajeUsuario);
        }
	}

}
