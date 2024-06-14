package co.priv.parqueadero.autoparkadmin.business.assembler.dto.impl;

import java.util.ArrayList;
import java.util.List;

import co.priv.parqueadero.autoparkadmin.business.assembler.dto.AssemblerDTO;
import co.priv.parqueadero.autoparkadmin.business.domain.ParqueaderoDomain;
import co.priv.parqueadero.autoparkadmin.crosscutting.helpers.ObjectHelper;
import co.priv.parqueadero.autoparkadmin.dto.ParqueaderoDTO;


public class ParqueaderoAssemblerDTO implements AssemblerDTO<ParqueaderoDomain, ParqueaderoDTO> {

	private static final AssemblerDTO<ParqueaderoDomain, ParqueaderoDTO> instance = new ParqueaderoAssemblerDTO();

	private ParqueaderoAssemblerDTO() {
		super();
	}

	public static final AssemblerDTO<ParqueaderoDomain, ParqueaderoDTO> getInstance() {
		return instance;
	}

	@Override
	public ParqueaderoDomain toDomain(ParqueaderoDTO data) {
		var parqueaderoDtoTmp = ObjectHelper.getObjectHelper().getDefaultValue(data, ParqueaderoDTO.build());
		return ParqueaderoDomain.build(parqueaderoDtoTmp.getId(), parqueaderoDtoTmp.getNombre());
	}

	@Override
	public ParqueaderoDTO toDTO(ParqueaderoDomain domain) {
		var parqueaderoDomainTmp = ObjectHelper.getObjectHelper().getDefaultValue(domain, ParqueaderoDomain.build());
		return ParqueaderoDTO.build().setId(parqueaderoDomainTmp.getId()).setNombre(parqueaderoDomainTmp.getNombre());
	}

	@Override
	public List<ParqueaderoDomain> toDomainCollection(List<ParqueaderoDTO> dtoCollection) {
		var dtoCollectionTmp = ObjectHelper.getObjectHelper().getDefaultValue(dtoCollection,
				new ArrayList<ParqueaderoDTO>());
		return dtoCollectionTmp.stream().map(this::toDomain).toList();
	}

	@Override
	public List<ParqueaderoDTO> toDTOCollection(List<ParqueaderoDomain> domainCollection) {
		var domainCollectionTmp = ObjectHelper.getObjectHelper().getDefaultValue(domainCollection,
				new ArrayList<ParqueaderoDomain>());
		return domainCollectionTmp.stream().map(this::toDTO).toList();
	}


}