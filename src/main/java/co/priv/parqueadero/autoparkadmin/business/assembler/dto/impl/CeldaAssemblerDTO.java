package co.priv.parqueadero.autoparkadmin.business.assembler.dto.impl;

import java.util.ArrayList;
import java.util.List;

import co.priv.parqueadero.autoparkadmin.business.assembler.dto.AssemblerDTO;
import co.priv.parqueadero.autoparkadmin.business.domain.CeldaDomain;
import co.priv.parqueadero.autoparkadmin.business.domain.EstadoCeldaDomain;
import co.priv.parqueadero.autoparkadmin.business.domain.ParqueaderoDomain;
import co.priv.parqueadero.autoparkadmin.business.domain.TipoVehiculoDomain;
import co.priv.parqueadero.autoparkadmin.crosscutting.helpers.ObjectHelper;
import co.priv.parqueadero.autoparkadmin.dto.CeldaDTO;
import co.priv.parqueadero.autoparkadmin.dto.EstadoCeldaDTO;
import co.priv.parqueadero.autoparkadmin.dto.ParqueaderoDTO;
import co.priv.parqueadero.autoparkadmin.dto.TipoVehiculoDTO;

public final class CeldaAssemblerDTO implements AssemblerDTO<CeldaDomain, CeldaDTO> {

    private static final AssemblerDTO<TipoVehiculoDomain, TipoVehiculoDTO> tipoVehiculoAssembler = TipoVehiculoAssemblerDTO.getInstance();
    private static final AssemblerDTO<ParqueaderoDomain, ParqueaderoDTO> parqueaderoAssembler = ParqueaderoAssemblerDTO.getInstance();
    private static final AssemblerDTO<EstadoCeldaDomain, EstadoCeldaDTO> estadoCeldaAssembler = EstadoCeldaAssemblerDTO.getInstance();
    private static final AssemblerDTO<CeldaDomain, CeldaDTO> instance = new CeldaAssemblerDTO();

    private CeldaAssemblerDTO() {
        super();
    }

    public static AssemblerDTO<CeldaDomain, CeldaDTO> getInstance() {
        return instance;
    }

    @Override
    public CeldaDomain toDomain(CeldaDTO data) {
        var celdaDtoTmp = ObjectHelper.getObjectHelper().getDefaultValue(data, CeldaDTO.build());
        var tipoVehiculoDomain = tipoVehiculoAssembler.toDomain(celdaDtoTmp.getTipoVehiculo());
        var parqueaderoDomain = parqueaderoAssembler.toDomain(celdaDtoTmp.getParqueadero());
        var estadoCeldaDomain = estadoCeldaAssembler.toDomain(celdaDtoTmp.getEstadoCelda());
        return CeldaDomain.build(celdaDtoTmp.getId(), celdaDtoTmp.getNombre(), tipoVehiculoDomain, parqueaderoDomain, estadoCeldaDomain);
    }

    @Override
    public CeldaDTO toDTO(CeldaDomain domain) {
        var celdaDomainTmp = ObjectHelper.getObjectHelper().getDefaultValue(domain, CeldaDomain.build());
        var tipoVehiculoDTO = tipoVehiculoAssembler.toDTO(celdaDomainTmp.getTipoVehiculo());
        var parqueaderoDTO = parqueaderoAssembler.toDTO(celdaDomainTmp.getParqueadero());
        var estadoCeldaDTO = estadoCeldaAssembler.toDTO(celdaDomainTmp.getEstadoCelda());
        return CeldaDTO.build()
                .setId(celdaDomainTmp.getId())
                .setNombre(celdaDomainTmp.getNombre())
                .setTipoVehiculo(tipoVehiculoDTO)
                .setParqueadero(parqueaderoDTO)
                .setEstadoCelda(estadoCeldaDTO);
    }

    @Override
    public List<CeldaDomain> toDomainCollection(List<CeldaDTO> dtoCollection) {
        var dtoCollectionTmp = ObjectHelper.getObjectHelper().getDefaultValue(dtoCollection, new ArrayList<CeldaDTO>());
        return dtoCollectionTmp.stream().map(this::toDomain).toList();
    }

    @Override
    public List<CeldaDTO> toDTOCollection(List<CeldaDomain> domainCollection) {
        var domainCollectionTmp = ObjectHelper.getObjectHelper().getDefaultValue(domainCollection, new ArrayList<CeldaDomain>());
        return domainCollectionTmp.stream().map(this::toDTO).toList();
    }
}

