package co.priv.parqueadero.autoparkadmin.business.assembler.entity.impl;

import java.util.ArrayList;   

import java.util.List;
import co.priv.parqueadero.autoparkadmin.business.assembler.entity.AssemblerEntity;
import co.priv.parqueadero.autoparkadmin.business.domain.UsuarioDomain;
import co.priv.parqueadero.autoparkadmin.crosscutting.helpers.ObjectHelper;
import co.priv.parqueadero.autoparkadmin.entity.UsuarioEntity;

import static co.priv.parqueadero.autoparkadmin.crosscutting.helpers.ObjectHelper.getObjectHelper;

public final class UsuarioAssemblerEntity implements AssemblerEntity<UsuarioDomain, UsuarioEntity>{
	
	private static final AssemblerEntity<UsuarioDomain, UsuarioEntity> instance= new UsuarioAssemblerEntity();


	private UsuarioAssemblerEntity(){
		super();
	}
	
	public static final AssemblerEntity<UsuarioDomain, UsuarioEntity> getInstance(){
		return instance;
	}
	
	
	@Override
	public final UsuarioDomain toDomain(final UsuarioEntity data) {
		var usuarioEntityoTmp=getObjectHelper().getDefaultValue(data, UsuarioEntity.build());
		return UsuarioDomain.build(usuarioEntityoTmp.getId(),usuarioEntityoTmp.getUsuario(),usuarioEntityoTmp.getContraseña());
	}

	@Override
	public final UsuarioEntity toEntity(final UsuarioDomain domain) {
		var usuarioDomainTmp=getObjectHelper().getDefaultValue(domain, UsuarioDomain.build());
		return UsuarioEntity.build().setId(usuarioDomainTmp.getId()).setUsuario(usuarioDomainTmp.getUsuario()).setContraseña(usuarioDomainTmp.getContraseña());
	}

	@Override
	public List<UsuarioDomain> toDomainCollection(List<UsuarioEntity> entityCollection) {
		var entityCollectionTmp = ObjectHelper.getObjectHelper().getDefaultValue(entityCollection, new ArrayList<UsuarioEntity>());
		return entityCollectionTmp.stream().map(this :: toDomain).toList();
	}

	@Override
	public List<UsuarioEntity> toEntityCollection(List<UsuarioDomain> domainCollection) {
	    var domainCollectionTmp = ObjectHelper.getObjectHelper().getDefaultValue(domainCollection, new ArrayList<UsuarioDomain>());
	    return domainCollectionTmp.stream().map(this :: toEntity).toList();
	}




	
}
