package co.priv.parqueadero.autoparkadmin.business.assembler.dto.impl;

import java.util.ArrayList;   

import java.util.List;
import co.priv.parqueadero.autoparkadmin.business.assembler.dto.AssemblerDTO;
import co.priv.parqueadero.autoparkadmin.business.domain.UsuarioDomain;
import co.priv.parqueadero.autoparkadmin.dto.UsuarioDTO;

import static co.priv.parqueadero.autoparkadmin.crosscutting.helpers.ObjectHelper.getObjectHelper;

public class UsuarioAssemblerDTO implements AssemblerDTO<UsuarioDomain, UsuarioDTO> {

	private static final AssemblerDTO<UsuarioDomain,UsuarioDTO> instance= new UsuarioAssemblerDTO();

    private UsuarioAssemblerDTO() {
        super();
    }

	public static final AssemblerDTO<UsuarioDomain,UsuarioDTO> getInstance(){
		return instance;
	}

    @Override
    public final UsuarioDomain toDomain(final UsuarioDTO data) {
    	var usuarioDtoTmp=getObjectHelper().getDefaultValue(data, UsuarioDTO.build());
    	return UsuarioDomain.build(usuarioDtoTmp.getId(), usuarioDtoTmp.getUsuario(), usuarioDtoTmp.getContraseña());
    }

    @Override
    public final UsuarioDTO toDTO(final UsuarioDomain domain) {
        var usuarioDomainTmp= getObjectHelper().getDefaultValue(domain,UsuarioDomain.build());
        return UsuarioDTO.build().setId(usuarioDomainTmp.getId()).setUsuario(usuarioDomainTmp.getUsuario()).setContraseña(usuarioDomainTmp.getContraseña());
    }

    @Override
    public List<UsuarioDomain> toDomainCollection(final List<UsuarioDTO> dtoCollection) {
        var dtoCollectionTmp=getObjectHelper().getDefaultValue(dtoCollection,new ArrayList<UsuarioDTO>());
        var resultadosDomain=new ArrayList<UsuarioDomain>();

        for (UsuarioDTO usuarioDTO:dtoCollectionTmp){
            var usuarioDomainTmp= toDomain(usuarioDTO);
            resultadosDomain.add(usuarioDomainTmp);
        }
        return resultadosDomain;
    }

    @Override
    public final List<UsuarioDTO> toDTOCollection(final List<UsuarioDomain> domainCollection) {
        var domainCollectionTmp=getObjectHelper().getDefaultValue(domainCollection,
                new ArrayList<UsuarioDomain>());
        return domainCollectionTmp.stream().map(this::toDTO).toList();
    }
}
