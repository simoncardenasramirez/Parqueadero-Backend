package co.priv.parqueadero.autoparkadmin.dto;

import java.util.UUID;


import co.priv.parqueadero.autoparkadmin.crosscutting.helpers.TextHelper;
import co.priv.parqueadero.autoparkadmin.crosscutting.helpers.UUIDHelper;

public class ParqueaderoDTO {
    
    private UUID id;
    private String nombre;

    public ParqueaderoDTO() {
        super();
        setId(UUIDHelper.getDefault());
        setNombre(TextHelper.EMPTY);
    }

    public ParqueaderoDTO(final UUID id, final String nombre) {
        setId(id);
        setNombre(nombre);
    }

    public static ParqueaderoDTO build() {
        return new ParqueaderoDTO();
    }

    public UUID getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public ParqueaderoDTO setId(UUID id) {
        this.id = UUIDHelper.getDefault(id, UUIDHelper.getDefault());
        return this;
    }

    public ParqueaderoDTO setNombre(String nombre) {
        this.nombre = TextHelper.applyTrim(nombre);
        return this;
    }
}

