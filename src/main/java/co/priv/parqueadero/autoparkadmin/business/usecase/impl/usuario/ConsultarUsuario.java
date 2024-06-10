package co.priv.parqueadero.autoparkadmin.business.usecase.impl.usuario;

import java.util.List;

import co.priv.parqueadero.autoparkadmin.business.assembler.entity.impl.UsuarioAssemblerEntity;
import co.priv.parqueadero.autoparkadmin.business.domain.UsuarioDomain;
import co.priv.parqueadero.autoparkadmin.business.usecase.UseCaseWithReturn;
import co.priv.parqueadero.autoparkadmin.crosscutting.exceptions.custom.BusinessAUTOPARKADMINException;
import co.priv.parqueadero.autoparkadmin.crosscutting.helpers.ObjectHelper;
import co.priv.parqueadero.autoparkadmin.data.dao.factory.DAOFactory;

public class ConsultarUsuario implements UseCaseWithReturn<UsuarioDomain, List<UsuarioDomain>> {

	private DAOFactory factory;

	public ConsultarUsuario(final DAOFactory factory) {
		if (ObjectHelper.getObjectHelper().isNull(factory)) {
			var mensajeUsuario = "Se ha presentado un problema tratando de llevar a cabo la consulta de los usuarios...";
			var mensajeTecnico = "El dao factory para consultar los usuarios llegó nulo...";
			throw new BusinessAUTOPARKADMINException(mensajeTecnico, mensajeUsuario);
		}
		this.factory = factory;
	}

	@Override
	public List<UsuarioDomain> execute(UsuarioDomain data) {
		var usuarioEntityFilter = UsuarioAssemblerEntity.getInstance().toEntity(data);
		var resultadosEntity = factory.getUsuarioDAO().consultar(usuarioEntityFilter); 

		return UsuarioAssemblerEntity.getInstance().toDomainCollection(resultadosEntity);
	}

}
