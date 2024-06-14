package co.priv.parqueadero.autoparkadmin.business.assembler.entity.impl;

import java.util.ArrayList;
import java.util.List;

import co.priv.parqueadero.autoparkadmin.business.assembler.entity.AssemblerEntity;
import co.priv.parqueadero.autoparkadmin.business.domain.CeldaDomain;
import co.priv.parqueadero.autoparkadmin.business.domain.EstadoCeldaDomain;
import co.priv.parqueadero.autoparkadmin.business.domain.ParqueaderoDomain;
import co.priv.parqueadero.autoparkadmin.business.domain.TipoVehiculoDomain;
import co.priv.parqueadero.autoparkadmin.crosscutting.helpers.ObjectHelper;
import co.priv.parqueadero.autoparkadmin.entity.CeldaEntity;
import co.priv.parqueadero.autoparkadmin.entity.EstadoCeldaEntity;
import co.priv.parqueadero.autoparkadmin.entity.ParqueaderoEntity;
import co.priv.parqueadero.autoparkadmin.entity.TipoVehiculoEntity;

public final class CeldaAssemblerEntity implements AssemblerEntity<CeldaDomain, CeldaEntity> {

    private static final AssemblerEntity<TipoVehiculoDomain, TipoVehiculoEntity> tipoVehiculoAssembler = TipoVehiculoAssemblerEntity.getInstance();
    private static final AssemblerEntity<ParqueaderoDomain, ParqueaderoEntity> parqueaderoAssembler = ParqueaderoAssemblerEntity.getInstance();
    private static final AssemblerEntity<EstadoCeldaDomain, EstadoCeldaEntity> estadoCeldaAssembler = EstadoCeldaAssemblerEntity.getInstance();
    private static final AssemblerEntity<CeldaDomain, CeldaEntity> instance = new CeldaAssemblerEntity();

    private CeldaAssemblerEntity() {
        super();
    }

    public static AssemblerEntity<CeldaDomain, CeldaEntity> getInstance() {
        return instance;
    }

    @Override
    public CeldaDomain toDomain(CeldaEntity data) {
        var celdaEntityTmp = ObjectHelper.getObjectHelper().getDefaultValue(data, CeldaEntity.build());
        var tipoVehiculoDomain = tipoVehiculoAssembler.toDomain(celdaEntityTmp.getTipoVehiculo());
        var parqueaderoDomain = parqueaderoAssembler.toDomain(celdaEntityTmp.getParqueadero());
        var estadoCeldaDomain = estadoCeldaAssembler.toDomain(celdaEntityTmp.getEstadoCelda());
        return CeldaDomain.build(celdaEntityTmp.getId(), celdaEntityTmp.getNombre(), tipoVehiculoDomain, parqueaderoDomain, estadoCeldaDomain);
    }

    @Override
    public CeldaEntity toEntity(CeldaDomain domain) {
        var celdaDomainTmp = ObjectHelper.getObjectHelper().getDefaultValue(domain, CeldaDomain.build());
        var tipoVehiculoEntity = tipoVehiculoAssembler.toEntity(celdaDomainTmp.getTipoVehiculo());
        var parqueaderoEntity = parqueaderoAssembler.toEntity(celdaDomainTmp.getParqueadero());
        var estadoCeldaEntity = estadoCeldaAssembler.toEntity(celdaDomainTmp.getEstadoCelda());
        return CeldaEntity.build()
                .setId(celdaDomainTmp.getId())
                .setNombre(celdaDomainTmp.getNombre())
                .setTipoVehiculo(tipoVehiculoEntity)
                .setParqueadero(parqueaderoEntity)
                .setEstadoCelda(estadoCeldaEntity);
    }

    @Override
    public List<CeldaDomain> toDomainCollection(List<CeldaEntity> entityCollection) {
        var entityCollectionTmp = ObjectHelper.getObjectHelper().getDefaultValue(entityCollection, new ArrayList<CeldaEntity>());
        return entityCollectionTmp.stream().map(this::toDomain).toList();
    }

    @Override
    public List<CeldaEntity> toEntityCollection(List<CeldaDomain> domainCollection) {
        var domainCollectionTmp = ObjectHelper.getObjectHelper().getDefaultValue(domainCollection, new ArrayList<CeldaDomain>());
        return domainCollectionTmp.stream().map(this::toEntity).toList();
    }
    
    
}
