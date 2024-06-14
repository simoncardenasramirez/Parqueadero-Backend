package co.priv.parqueadero.autoparkadmin.business.assembler.entity.impl;

import java.util.ArrayList;
import java.util.List;

import co.priv.parqueadero.autoparkadmin.business.assembler.entity.AssemblerEntity;
import co.priv.parqueadero.autoparkadmin.business.domain.EstadoCeldaDomain;
import co.priv.parqueadero.autoparkadmin.crosscutting.helpers.ObjectHelper;
import co.priv.parqueadero.autoparkadmin.entity.EstadoCeldaEntity;



public class EstadoCeldaAssemblerEntity implements AssemblerEntity<EstadoCeldaDomain, EstadoCeldaEntity>{
	
	private static final AssemblerEntity<EstadoCeldaDomain, EstadoCeldaEntity> instance = new EstadoCeldaAssemblerEntity();

	private EstadoCeldaAssemblerEntity() {
		super();
	}

	public static AssemblerEntity<EstadoCeldaDomain, EstadoCeldaEntity> getInstance() {
		return instance;
	}

	@Override
	public EstadoCeldaDomain toDomain(EstadoCeldaEntity data) {
		var estadoCeldaEntityTmp = ObjectHelper.getObjectHelper().getDefaultValue(data, EstadoCeldaEntity.build());
		return EstadoCeldaDomain.build(estadoCeldaEntityTmp.getId(), estadoCeldaEntityTmp.getNombre());
	}

	@Override
	public EstadoCeldaEntity toEntity(EstadoCeldaDomain domain) {
		var estadoCeldaDomainTmp = ObjectHelper.getObjectHelper().getDefaultValue(domain, EstadoCeldaDomain.build());
		return EstadoCeldaEntity.build().setId(estadoCeldaDomainTmp.getId())
				.setNombre(estadoCeldaDomainTmp.getNombre());
	}

	@Override
	public List<EstadoCeldaDomain> toDomainCollection(List<EstadoCeldaEntity> entityCollection) {
		var entityCollectionTmp = ObjectHelper.getObjectHelper().getDefaultValue(entityCollection,
				new ArrayList<EstadoCeldaEntity>());
		return entityCollectionTmp.stream().map(this::toDomain).toList();
	}

	@Override
	public List<EstadoCeldaEntity> toEntityCollection(List<EstadoCeldaDomain> domainCollection) {
		var domainCollectionTmp = ObjectHelper.getObjectHelper().getDefaultValue(domainCollection,
				new ArrayList<EstadoCeldaDomain>());
		return domainCollectionTmp.stream().map(this::toEntity).toList();
	}

}
