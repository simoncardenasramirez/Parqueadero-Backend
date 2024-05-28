package co.priv.parqueadero.autoparkadmin.business.assembler.dto.impl;

import java.util.ArrayList;
import java.util.List;

import co.priv.parqueadero.autoparkadmin.business.assembler.dto.AssemblerDTO;
import co.priv.parqueadero.autoparkadmin.business.domain.TipoVehiculoDomain;
import co.priv.parqueadero.autoparkadmin.crosscutting.helpers.ObjectHelper;
import co.priv.parqueadero.autoparkadmin.dto.TipoVehiculoDTO;

public final class TipoVehiculoAssemblerDTO implements AssemblerDTO<TipoVehiculoDomain,TipoVehiculoDTO>{

	@Override
	public TipoVehiculoDomain toDomain(TipoVehiculoDTO data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TipoVehiculoDomain> toDomainCollection(List<TipoVehiculoDTO> entityCollection) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TipoVehiculoDTO toDTO(TipoVehiculoDomain domain) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TipoVehiculoDTO> toDTOCollection(List<TipoVehiculoDomain> domainCollection) {
		// TODO Auto-generated method stub
		return null;
	}
	
//	private static final AssemblerDTO<TipoVehiculoDomain,TipoVehiculoDTO> instance= new TipoVehiculoAssemblerDTO();
//
//
//	private TipoVehiculoAssemblerDTO(){
//		super();
//	}
//	
//	public static final AssemblerDTO<TipoVehiculoDomain,TipoVehiculoDTO> getInstance(){
//		return instance;
//	}
//	
//	
//	@Override
//	public final TipoVehiculoDomain toDomain(final TipoVehiculoDTO data) {
//		var tipoVehiculoDtoTmp=getObjectHelper().getDefaultValue(data, TipoVehiculoDTO.build());
//		return TipoVehiculoDomain.build(tipoVehiculoDtoTmp.getId(), tipoVehiculoDtoTmp.getNombre());
//	}
//
//	@Override
//	public final TipoVehiculoDTO toDTO(final TipoVehiculoDomain domain) {
//		var paisDomainTmp=getObjectHelper().getDefaultValue(domain, TipoVehiculoDomain.build());
//		return TipoVehiculoDTO.build().setId(paisDomainTmp.getId()).setNombre(paisDomainTmp.getNombre());
//	}
//
//	@Override
//	public List<TipoVehiculoDomain> toDomainCollection(List<TipoVehiculoDTO> dtoCollection) {
//		var dtoCollectionTmp = ObjectHelper.getObjectHelper().getDefaultValue(dtoCollection, new ArrayList<TipoVehiculoDTO>());
//		return dtoCollectionTmp.stream().map(this :: toDomain).toList();
//	}
//
//	@Override
//	public List<TipoVehiculoDTO> toDTOCollection(List<TipoVehiculoDomain> domainCollection) {
//		var domainCollectionTmp = ObjectHelper.getObjectHelper().getDefaultValue(domainCollection, new ArrayList<TipoVehiculoDomain>());
//		return domainCollectionTmp.stream().map(this :: toDTO).toList();
//	}

}
