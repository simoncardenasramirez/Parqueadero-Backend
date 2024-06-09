package co.priv.parqueadero.autoparkadmin.business.assembler.dto.impl;

import java.util.ArrayList;   
import java.util.List;

import co.priv.parqueadero.autoparkadmin.business.assembler.dto.AssemblerDTO;
import co.priv.parqueadero.autoparkadmin.business.domain.TipoVehiculoDomain;
import co.priv.parqueadero.autoparkadmin.business.domain.UsuarioDomain;
import co.priv.parqueadero.autoparkadmin.crosscutting.helpers.ObjectHelper;
import co.priv.parqueadero.autoparkadmin.dto.TipoVehiculoDTO;
import co.priv.parqueadero.autoparkadmin.dto.UsuarioDTO;

import static co.priv.parqueadero.autoparkadmin.crosscutting.helpers.ObjectHelper.getObjectHelper;

public class UsuarioAssemblerDTO implements AssemblerDTO<UsuarioDomain, UsuarioDTO> {

    private static final UsuarioAssemblerDTO instance = new UsuarioAssemblerDTO();

    private UsuarioAssemblerDTO() {
        super();
    }

    public static final UsuarioAssemblerDTO getInstance() {
        return instance;
    }

    @Override
    public final UsuarioDomain toDomain(final UsuarioDTO dto) {
        return UsuarioDomain.build(dto.getId(), dto.getUsuario(), dto.getContraseña());
    }

    @Override
    public final UsuarioDTO toDTO(final UsuarioDomain domain) {
        return UsuarioDTO.build()
                .setId(domain.getId())
                .setUsuario(domain.getUsuario())
                .setContraseña(domain.getContraseña());
    }

    @Override
    public List<UsuarioDomain> toDomainCollection(List<UsuarioDTO> dtoCollection) {
        return dtoCollection.stream().map(this::toDomain).toList();
    }

    @Override
    public List<UsuarioDTO> toDTOCollection(List<UsuarioDomain> domainCollection) {
        return domainCollection.stream().map(this::toDTO).toList();
    }
}
