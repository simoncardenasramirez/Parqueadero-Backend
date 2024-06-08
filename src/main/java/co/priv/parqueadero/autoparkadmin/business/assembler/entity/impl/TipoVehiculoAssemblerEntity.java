package co.priv.parqueadero.autoparkadmin.business.assembler.entity.impl;

import java.util.ArrayList;
import java.util.List;

import co.priv.parqueadero.autoparkadmin.business.assembler.entity.AssemblerEntity;
import co.priv.parqueadero.autoparkadmin.business.domain.TipoVehiculoDomain;
import co.priv.parqueadero.autoparkadmin.crosscutting.helpers.ObjectHelper;
import co.priv.parqueadero.autoparkadmin.entity.TipoVehiculoEntity;
import static co.priv.parqueadero.autoparkadmin.crosscutting.helpers.ObjectHelper.getObjectHelper;

public class TipoVehiculoAssemblerEntity implements AssemblerEntity<TipoVehiculoDomain, TipoVehiculoEntity> {

	private final static AssemblerEntity<TipoVehiculoDomain, TipoVehiculoEntity> instance = new TipoVehiculoAssemblerEntity();

	private TipoVehiculoAssemblerEntity() {
		super();
	}

	public static final AssemblerEntity<TipoVehiculoDomain, TipoVehiculoEntity> getInstance() {
		return instance;
	}

	@Override
	public TipoVehiculoDomain toDomain(TipoVehiculoEntity data) {
		var tipoVehiculoEntityTmp = getObjectHelper().getDefaultValue(data, TipoVehiculoEntity.build());
		return TipoVehiculoDomain.build(data.getId(), tipoVehiculoEntityTmp.getNombre());
	}

	@Override
	public TipoVehiculoEntity toEntity(TipoVehiculoDomain domain) {
		var tipoVehiculoDomainTmp = getObjectHelper().getDefaultValue(domain, TipoVehiculoDomain.build());
		return TipoVehiculoEntity.build().setId(tipoVehiculoDomainTmp.getId())
				.setNombre(tipoVehiculoDomainTmp.getNombre());
	}

	@Override
	public List<TipoVehiculoDomain> toDomainCollection(List<TipoVehiculoEntity> entityCollection) {
		var entityCollectionTmp = ObjectHelper.getObjectHelper().getDefaultValue(entityCollection,
				new ArrayList<TipoVehiculoEntity>());
		return entityCollectionTmp.stream().map(this::toDomain).toList();
	}

	@Override
	public List<TipoVehiculoEntity> toEntityCollection(List<TipoVehiculoDomain> domainCollection) {
		var domainCollectionTmp = ObjectHelper.getObjectHelper().getDefaultValue(domainCollection,
				new ArrayList<TipoVehiculoDomain>());
		return domainCollectionTmp.stream().map(this::toEntity).toList();
	}

}