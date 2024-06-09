package co.priv.parqueadero.autoparkadmin.business.assembler.dto.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import co.priv.parqueadero.autoparkadmin.business.assembler.dto.AssemblerDTO;
import co.priv.parqueadero.autoparkadmin.business.domain.TipoVehiculoDomain;
import co.priv.parqueadero.autoparkadmin.business.domain.UsuarioDomain;
import co.priv.parqueadero.autoparkadmin.business.domain.VehiculoDomain;
import co.priv.parqueadero.autoparkadmin.crosscutting.helpers.ObjectHelper;
import co.priv.parqueadero.autoparkadmin.dto.TipoVehiculoDTO;
import co.priv.parqueadero.autoparkadmin.dto.UsuarioDTO;
import co.priv.parqueadero.autoparkadmin.dto.VehiculoDTO;
import static co.priv.parqueadero.autoparkadmin.crosscutting.helpers.ObjectHelper.getObjectHelper;;

public class VehiculoAssemblerDTO implements AssemblerDTO<VehiculoDomain, VehiculoDTO> {

	private static final AssemblerDTO<TipoVehiculoDomain, TipoVehiculoDTO> TipoVehiculoAssembler = TipoVehiculoAssemblerDTO
			.getInstance();
	private static final AssemblerDTO<VehiculoDomain, VehiculoDTO> instance = new VehiculoAssemblerDTO();

	private VehiculoAssemblerDTO() {
		super();
	}

	public static final AssemblerDTO<VehiculoDomain, VehiculoDTO> getInstance() {
		return instance;
	}

	@Override
	public VehiculoDomain toDomain(VehiculoDTO data) {
		var vehiculoDTOTmp = getObjectHelper().getDefaultValue(data, VehiculoDTO.build());
		var tipoVehiculoDomain = TipoVehiculoAssembler.toDomain(vehiculoDTOTmp.getTipoVehiculo());
		return VehiculoDomain.build(vehiculoDTOTmp.getId(), vehiculoDTOTmp.getMatricula(), tipoVehiculoDomain);
	}

	@Override
	public VehiculoDTO toDTO(final VehiculoDomain domain) {
		var vehiculoDomainTmp = getObjectHelper().getDefaultValue(domain, VehiculoDomain.build());
		var tipoVehiculoDTO = TipoVehiculoAssembler.toDTO(vehiculoDomainTmp.getTipoVehiculo());
		return VehiculoDTO.build().setId(vehiculoDomainTmp.getId()).setMatricula(vehiculoDomainTmp.getMatricula())
				.setTipoVehiculo(tipoVehiculoDTO);
	}

	@Override
	public List<VehiculoDomain> toDomainCollection(List<VehiculoDTO> dtoCollection) {
		var dtoCollectionTmp = ObjectHelper.getObjectHelper().getDefaultValue(dtoCollection,
				new ArrayList<VehiculoDTO>());
		return dtoCollectionTmp.stream().map(this::toDomain).toList();
	}

	@Override
	public List<VehiculoDTO> toDTOCollection(List<VehiculoDomain> domainCollection) {
		var domainCollectionTmp = ObjectHelper.getObjectHelper().getDefaultValue(domainCollection,
				new ArrayList<VehiculoDomain>());
		return domainCollectionTmp.stream().map(this::toDTO).toList();

	}

}