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
			var mensajeUsuario = "No se pudo crear el objeto ConsultarUsuario. El DAOFactory proporcionado es nulo.";
			var mensajeTecnico = "El parámetro factory pasado al constructor ConsultarUsuario es nulo.";
			throw new BusinessAUTOPARKADMINException(mensajeTecnico, mensajeUsuario);
		}
		this.factory = factory;
	}

	@Override
	public List<UsuarioDomain> execute(UsuarioDomain data) {
		var usuarioEntityFilter = UsuarioAssemblerEntity.getInstance().toEntity(data);
		var resultadosEntity = factory.getUsuarioDAO().consultar(usuarioEntityFilter);

		var resultadosDomain = UsuarioAssemblerEntity.getInstance().toDomainCollection(resultadosEntity);

		return resultadosDomain;
	}

}
