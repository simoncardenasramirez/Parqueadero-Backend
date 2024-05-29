package co.priv.parqueadero.autoparkadmin.business.assembler.entity.impl;

import co.priv.parqueadero.autoparkadmin.business.assembler.entity.AssemblerEntity;
import co.priv.parqueadero.autoparkadmin.business.domain.TipoVehiculoDomain;
import co.priv.parqueadero.autoparkadmin.business.domain.VehiculoDomain;
import co.priv.parqueadero.autoparkadmin.crosscutting.helpers.ObjectHelper;
import co.priv.parqueadero.autoparkadmin.entity.TipoVehiculoEntity;
import co.priv.parqueadero.autoparkadmin.entity.VehiculoEntity;
import static co.priv.parqueadero.autoparkadmin.crosscutting.helpers.ObjectHelper.getObjectHelper;

import java.util.ArrayList;
import java.util.List;

public class VehiculoAssemblerEntity implements AssemblerEntity<VehiculoDomain, VehiculoEntity> {

	private static final AssemblerEntity<TipoVehiculoDomain, TipoVehiculoEntity> tipoVehiculoAssembler =  TipoVehiculoAssemblerEntity.getInstance();
	private static final AssemblerEntity<VehiculoDomain, VehiculoEntity> instance =
			new VehiculoAssemblerEntity();
	private VehiculoAssemblerEntity() {
		super();
	}
	
	public static final AssemblerEntity<VehiculoDomain, VehiculoEntity> getInstance(){
		return instance;
	}
	@Override
	public VehiculoDomain toDomain(VehiculoEntity data) {
		var vehiculoEntityTmp = getObjectHelper().getDefaultValue(data, VehiculoEntity.build());
		var tipoVehiculoDomain = tipoVehiculoAssembler.toDomain(vehiculoEntityTmp.getTipoVehiculo());
		return VehiculoDomain.build(vehiculoEntityTmp.getId(),vehiculoEntityTmp.getMatricula(),tipoVehiculoDomain);
	}

	@Override
	public VehiculoEntity toEntity(VehiculoDomain domain) {
		var vehiculoDomainTmp = getObjectHelper().getDefaultValue(domain, VehiculoDomain.build());
		var tipoVehiculoEntity = tipoVehiculoAssembler.toEntity(vehiculoDomainTmp.getTipoVehiculo());
		return VehiculoEntity.build().setId(vehiculoDomainTmp.getId()).setMatricula(vehiculoDomainTmp.getMatricula()).setTipoVehiculo(tipoVehiculoEntity);
	}

	@Override
	public List<VehiculoDomain> toDomainCollection(List<VehiculoEntity> entityCollection) {
		var entityCollectionTmp = ObjectHelper.getObjectHelper().getDefaultValue(entityCollection, new ArrayList<VehiculoEntity>());
		return entityCollectionTmp.stream().map(this::toDomain).toList();
	}

	@Override
	public List<VehiculoEntity> toEntityCollection(List<VehiculoDomain> domainCollection) {
		var domainCollectionTmp = ObjectHelper.getObjectHelper().getDefaultValue(domainCollection,
				new ArrayList<VehiculoDomain>());
		return domainCollectionTmp.stream().map(this::toEntity).toList();
	}
	
	

}
