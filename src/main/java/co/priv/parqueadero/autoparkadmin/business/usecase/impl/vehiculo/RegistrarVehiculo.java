package co.priv.parqueadero.autoparkadmin.business.usecase.impl.vehiculo;

import java.util.UUID;

import co.priv.parqueadero.autoparkadmin.business.domain.VehiculoDomain;
import co.priv.parqueadero.autoparkadmin.crosscutting.exceptions.custom.BusinessAUTOPARKADMINException;
import co.priv.parqueadero.autoparkadmin.crosscutting.helpers.ObjectHelper;
import co.priv.parqueadero.autoparkadmin.crosscutting.helpers.TextHelper;
import co.priv.parqueadero.autoparkadmin.crosscutting.helpers.UUIDHelper;
import co.priv.parqueadero.autoparkadmin.data.dao.factory.DAOFactory;
import co.priv.parqueadero.autoparkadmin.entity.VehiculoEntity;

public final class RegistrarVehiculo implements FacadeWithoutReturn<VehiculoDomain> {

    private final DAOFactory factory;

    public RegistrarVehiculo(final DAOFactory factory){
        if(ObjectHelper.getObjectHelper().isNull(factory)){
            var mensajeUsuario = "Se ha presentado un problema tratando de llevar a cabo el registro de un vehículo";
            var mensajeTecnico = "El DAOFactory para crear el vehículo llegó nulo...";
            throw new BusinessAUTOPARKADMINException(mensajeTecnico, mensajeUsuario);
        }
        this.factory = factory;
    }

    @Override
    public void execute(final VehiculoDomain data) {
        // 1. Validar que los casos de uso sean correctos a nivel de tipo de dato, longitud, obligatoriedad, formato, rango, etc...

        // 2. Validar que no exista otro vehículo con la misma matrícula
        validarVehiculoMismaMatricula(data.getNombre());

        // 3. Validar que el tipo de vehículo sea válido para registrar

        // 4. Guardar el nuevo vehículo
        
    }

    private final UUID generarIdentificadorVehiculo() {
        UUID id = UUIDHelper.generate();
        boolean existeId = true;

        while (existeId) {
            id = UUIDHelper.generate();
            var vehiculoEntity = VehiculoEntity.build().setId(id);
            var resultados = factory.getVehiculoDAO().consultar(vehiculoEntity);

            existeId = !resultados.isEmpty();
        }
        return id;
    }

    private final void validarVehiculoMismaMatricula(final String matricula) {
        var vehiculoEntity = VehiculoEntity.build().setNombre(matricula);
        var resultados = factory.getVehiculoDAO().consultar(vehiculoEntity);

        if (!resultados.isEmpty()) {
            var mensajeUsuario = "Ya existe un vehículo con la matrícula \"" + matricula + "\"";
            var mensajeTecnico = "Vehículo duplicado encontrado con matrícula: " + matricula;
            throw new BusinessAUTOPARKADMINException(mensajeTecnico, mensajeUsuario);
        }
    }

}
