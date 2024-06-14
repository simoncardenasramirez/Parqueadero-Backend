package co.priv.parqueadero.autoparkadmin.business.domain;

import java.util.UUID;

import co.priv.parqueadero.autoparkadmin.crosscutting.helpers.ObjectHelper;
import co.priv.parqueadero.autoparkadmin.crosscutting.helpers.TextHelper;
import co.priv.parqueadero.autoparkadmin.crosscutting.helpers.UUIDHelper;



public class CeldaDomain {

    private UUID id;
    private String nombre;
    private TipoVehiculoDomain tipoVehiculo;
    private ParqueaderoDomain parqueadero;
    private EstadoCeldaDomain estadoCelda;

    public CeldaDomain(final UUID id, final String nombre, final TipoVehiculoDomain tipoVehiculo, final ParqueaderoDomain parqueadero, final EstadoCeldaDomain estadoCelda) {
        setId(id);
        setNombre(nombre);
        setTipoVehiculo(tipoVehiculo);
        setParqueadero(parqueadero);
        setEstadoCelda(estadoCelda);
    }

    public static CeldaDomain build(final UUID id, final String nombre, final TipoVehiculoDomain tipoVehiculo, final ParqueaderoDomain parqueadero, final EstadoCeldaDomain estadoCelda) {
        return new CeldaDomain(id, nombre, tipoVehiculo, parqueadero, estadoCelda);
    }

    public static CeldaDomain build(final UUID id) {
        return new CeldaDomain(id, TextHelper.EMPTY, TipoVehiculoDomain.build(), ParqueaderoDomain.build(), EstadoCeldaDomain.build());
    }

    public static CeldaDomain build() {
        return new CeldaDomain(UUIDHelper.getDefault(), TextHelper.EMPTY, TipoVehiculoDomain.build(), ParqueaderoDomain.build(), EstadoCeldaDomain.build());
    }

    public UUID getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public TipoVehiculoDomain getTipoVehiculo() {
        return tipoVehiculo;
    }

    public ParqueaderoDomain getParqueadero() {
        return parqueadero;
    }

    public EstadoCeldaDomain getEstadoCelda() {
        return estadoCelda;
    }

    private void setId(UUID id) {
        this.id = UUIDHelper.getDefault(id, UUIDHelper.getDefault());
    }

    private void setNombre(String nombre) {
        this.nombre = TextHelper.applyTrim(nombre != null ? nombre : TextHelper.EMPTY);
    }

    private void setTipoVehiculo(TipoVehiculoDomain tipoVehiculo) {
        this.tipoVehiculo = ObjectHelper.getObjectHelper().getDefaultValue(tipoVehiculo != null ? tipoVehiculo : TipoVehiculoDomain.build(), TipoVehiculoDomain.build());
    }

    private void setParqueadero(ParqueaderoDomain parqueadero) {
        this.parqueadero = ObjectHelper.getObjectHelper().getDefaultValue(parqueadero != null ? parqueadero : ParqueaderoDomain.build(), ParqueaderoDomain.build());
    }

    private void setEstadoCelda(EstadoCeldaDomain estadoCelda) {
        this.estadoCelda = ObjectHelper.getObjectHelper().getDefaultValue(estadoCelda != null ? estadoCelda : EstadoCeldaDomain.build(), EstadoCeldaDomain.build());
    }
}

