package co.priv.parqueadero.autoparkadmin.business.assembler.entity.impl;

import java.util.ArrayList;
import java.util.List;

import co.priv.parqueadero.autoparkadmin.business.assembler.entity.AssemblerEntity;
import co.priv.parqueadero.autoparkadmin.business.domain.ParqueaderoDomain;
import co.priv.parqueadero.autoparkadmin.crosscutting.helpers.ObjectHelper;
import co.priv.parqueadero.autoparkadmin.entity.ParqueaderoEntity;


public class ParqueaderoAssemblerEntity implements AssemblerEntity<ParqueaderoDomain, ParqueaderoEntity> {

	private static final AssemblerEntity<ParqueaderoDomain, ParqueaderoEntity> instance = new ParqueaderoAssemblerEntity();

	private ParqueaderoAssemblerEntity() {
		super();
	}

	public static AssemblerEntity<ParqueaderoDomain, ParqueaderoEntity> getInstance() {
		return instance;
	}

	@Override
	public ParqueaderoDomain toDomain(ParqueaderoEntity data) {
		var parqueaderoEntityTmp = ObjectHelper.getObjectHelper().getDefaultValue(data, ParqueaderoEntity.build());
		return ParqueaderoDomain.build(parqueaderoEntityTmp.getId(), parqueaderoEntityTmp.getNombre());
	}

	@Override
	public ParqueaderoEntity toEntity(ParqueaderoDomain domain) {
		var parqueaderoDomainTmp = ObjectHelper.getObjectHelper().getDefaultValue(domain, ParqueaderoDomain.build());
		return ParqueaderoEntity.build().setId(parqueaderoDomainTmp.getId())
				.setNombre(parqueaderoDomainTmp.getNombre());
	}

	@Override
	public List<ParqueaderoDomain> toDomainCollection(List<ParqueaderoEntity> entityCollection) {
		var entityCollectionTmp = ObjectHelper.getObjectHelper().getDefaultValue(entityCollection,
				new ArrayList<ParqueaderoEntity>());
		return entityCollectionTmp.stream().map(this::toDomain).toList();
	}

	@Override
	public List<ParqueaderoEntity> toEntityCollection(List<ParqueaderoDomain> domainCollection) {
		var domainCollectionTmp = ObjectHelper.getObjectHelper().getDefaultValue(domainCollection,
				new ArrayList<ParqueaderoDomain>());
		return domainCollectionTmp.stream().map(this::toEntity).toList();
	}

}
