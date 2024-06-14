package co.priv.parqueadero.autoparkadmin.business.assembler.dto.impl;

import java.util.ArrayList;
import java.util.List;

import co.priv.parqueadero.autoparkadmin.business.assembler.dto.AssemblerDTO;
import co.priv.parqueadero.autoparkadmin.business.domain.EstadoCeldaDomain;
import co.priv.parqueadero.autoparkadmin.crosscutting.helpers.ObjectHelper;
import co.priv.parqueadero.autoparkadmin.dto.EstadoCeldaDTO;



public class EstadoCeldaAssemblerDTO implements AssemblerDTO<EstadoCeldaDomain, EstadoCeldaDTO> {

	private static final AssemblerDTO<EstadoCeldaDomain, EstadoCeldaDTO> instance = new EstadoCeldaAssemblerDTO();

	private EstadoCeldaAssemblerDTO() {
		super();
	}

	public static final AssemblerDTO<EstadoCeldaDomain, EstadoCeldaDTO> getInstance() {
		return instance;
	}

	@Override
	public EstadoCeldaDomain toDomain(EstadoCeldaDTO data) {
		var estadoCeldaDtoTmp = ObjectHelper.getObjectHelper().getDefaultValue(data, EstadoCeldaDTO.build());
		return EstadoCeldaDomain.build(estadoCeldaDtoTmp.getId(), estadoCeldaDtoTmp.getNombre());
	}

	@Override
	public EstadoCeldaDTO toDTO(EstadoCeldaDomain domain) {
		var estadoCeldaDomainTmp = ObjectHelper.getObjectHelper().getDefaultValue(domain, EstadoCeldaDomain.build());
		return EstadoCeldaDTO.build().setId(estadoCeldaDomainTmp.getId()).setNombre(estadoCeldaDomainTmp.getNombre());
	}

	@Override
	public List<EstadoCeldaDomain> toDomainCollection(List<EstadoCeldaDTO> dtoCollection) {
		var dtoCollectionTmp = ObjectHelper.getObjectHelper().getDefaultValue(dtoCollection,
				new ArrayList<EstadoCeldaDTO>());
		return dtoCollectionTmp.stream().map(this::toDomain).toList();
	}

	@Override
	public List<EstadoCeldaDTO> toDTOCollection(List<EstadoCeldaDomain> domainCollection) {
		var domainCollectionTmp = ObjectHelper.getObjectHelper().getDefaultValue(domainCollection,
				new ArrayList<EstadoCeldaDomain>());
		return domainCollectionTmp.stream().map(this::toDTO).toList();
	}
}
