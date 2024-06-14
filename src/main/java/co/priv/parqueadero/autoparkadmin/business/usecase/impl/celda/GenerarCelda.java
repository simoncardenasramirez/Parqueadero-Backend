package co.priv.parqueadero.autoparkadmin.business.usecase.impl.celda;

import java.util.UUID;


import co.priv.parqueadero.autoparkadmin.business.assembler.entity.impl.EstadoCeldaAssemblerEntity;
import co.priv.parqueadero.autoparkadmin.business.assembler.entity.impl.ParqueaderoAssemblerEntity;
import co.priv.parqueadero.autoparkadmin.business.assembler.entity.impl.TipoVehiculoAssemblerEntity;
import co.priv.parqueadero.autoparkadmin.business.domain.CeldaDomain;
import co.priv.parqueadero.autoparkadmin.business.usecase.UseCaseWithOutReturn;
import co.priv.parqueadero.autoparkadmin.crosscutting.exceptions.custom.BusinessAUTOPARKADMINException;
import co.priv.parqueadero.autoparkadmin.crosscutting.helpers.ObjectHelper;
import co.priv.parqueadero.autoparkadmin.crosscutting.helpers.TextHelper;
import co.priv.parqueadero.autoparkadmin.crosscutting.helpers.UUIDHelper;
import co.priv.parqueadero.autoparkadmin.data.dao.factory.DAOFactory;
import co.priv.parqueadero.autoparkadmin.entity.CeldaEntity;
import co.priv.parqueadero.autoparkadmin.entity.EstadoCeldaEntity;
import co.priv.parqueadero.autoparkadmin.entity.ParqueaderoEntity;
import co.priv.parqueadero.autoparkadmin.entity.TipoVehiculoEntity;

public class GenerarCelda implements UseCaseWithOutReturn<CeldaDomain> {

    private DAOFactory factory;

    public GenerarCelda(final DAOFactory factory) {
        if (ObjectHelper.getObjectHelper().isNull(factory)) {
            var mensajeUsuario = "Se ha presentado un problema tratando de generar la nueva Celda";
            var mensajeTecnico = "El DAO Factory para registrar el perfil llegó nulo";
            throw new BusinessAUTOPARKADMINException(mensajeTecnico, mensajeUsuario);
        }
        this.factory = factory;
    }

    @Override
    public void execute(final CeldaDomain data) {
        // Validación inicial
        validarEntrada(data);

        validarNombreCelda(data.getNombre());
        validarParqueaderoExista(data.getParqueadero().getId());
        validarTipoVehiculoExista(data.getTipoVehiculo().getId());
        validarEstadoCeldaExista(data.getEstadoCelda().getId());
        validarUnicidadNombreCelda(data.getNombre());

        var celdaEntity = CeldaEntity.build()
                .setId(generarIdentificadorCelda())
                .setNombre(data.getNombre())
                .setParqueadero(ParqueaderoAssemblerEntity.getInstance().toEntity(data.getParqueadero()))
                .setTipoVehiculo(TipoVehiculoAssemblerEntity.getInstance().toEntity(data.getTipoVehiculo()))
                .setEstadoCelda(EstadoCeldaAssemblerEntity.getInstance().toEntity(data.getEstadoCelda()));

        factory.getCeldaDAO().crear(celdaEntity);
    }

    private void validarEntrada(final CeldaDomain data) {
        if (data.getParqueadero() == null || data.getParqueadero().getId() == null || data.getParqueadero().getId().toString().isEmpty()) {
            throw new BusinessAUTOPARKADMINException("El parqueadero no puede estar vacío o tener un UUID no válido", "El parqueadero no puede estar vacío o tener un UUID no válido");
        }
        if (data.getTipoVehiculo() == null || data.getTipoVehiculo().getId() == null || data.getTipoVehiculo().getId().toString().isEmpty()) {
            throw new BusinessAUTOPARKADMINException("El tipo de vehículo no puede estar vacío o tener un UUID no válido", "El tipo de vehículo no puede estar vacío o tener un UUID no válido");
        }
        if (data.getEstadoCelda() == null || data.getEstadoCelda().getId() == null || data.getEstadoCelda().getId().toString().isEmpty()) {
            throw new BusinessAUTOPARKADMINException("El estado de la celda no puede estar vacío o tener un UUID no válido", "El estado de la celda no puede estar vacío o tener un UUID no válido");
        }
    }

    private final UUID generarIdentificadorCelda() {
        UUID id = UUIDHelper.generate();
        boolean existeId = true;
        while (existeId) {
            id = UUIDHelper.generate();
            var celdaEntity = CeldaEntity.build().setId(id);
            var resultados = factory.getCeldaDAO().consultar(celdaEntity);
            existeId = !resultados.isEmpty();
        }
        return id;
    }


    private void validarNombreCelda(String nombre) {
        if (nombre == null) {
            var mensajeUsuario = "El nombre de la celda no puede estar vacío";
            var mensajeTecnico = "Los datos proporcionados para el nombre de la celda son nulos";
            throw new BusinessAUTOPARKADMINException(mensajeTecnico, mensajeUsuario);
        }
        if (!TextHelper.longitudMinimaPermitida(nombre, 2) || !TextHelper.longitudMaximaPermitida(nombre, 5)) {
            var mensajeUsuario = "El nombre de la celda debe tener entre 2 y 5 caracteres";
            var mensajeTecnico = "El nombre de la celda no cumple con la longitud mínima o máxima requerida";
            throw new BusinessAUTOPARKADMINException(mensajeTecnico, mensajeUsuario);
        }
    }

    private void validarParqueaderoExista(final UUID idParqueadero) {
        var parqueaderoEntity = ParqueaderoEntity.build().setId(idParqueadero);

        var resultados = factory.getParqueaderoDAO().consultar(parqueaderoEntity);

        if (resultados.isEmpty()) {
            var mensajeUsuario = "El parqueadero no existe";
            throw new BusinessAUTOPARKADMINException(mensajeUsuario);
        }
    }

    private void validarTipoVehiculoExista(UUID idTipoVehiculo) {
        var tipoVehiculoEntity = TipoVehiculoEntity.build().setId(idTipoVehiculo);
        var resultados = factory.getTipoVehiculoDAO().consultar(tipoVehiculoEntity);
        if (resultados.isEmpty()) {
            var mensajeUsuario = "El tipo de vehículo no existe";
            throw new BusinessAUTOPARKADMINException(mensajeUsuario);
        }
    }

    private void validarEstadoCeldaExista(UUID idEstadoCelda) {
        var estadoCeldaEntity = EstadoCeldaEntity.build().setId(idEstadoCelda);
        var resultados = factory.getEstadoCeldaDAO().consultar(estadoCeldaEntity);
        if (resultados.isEmpty()) {
            var mensajeUsuario = "El estado de celda no existe";
            throw new BusinessAUTOPARKADMINException(mensajeUsuario);
        }
    }

    private void validarUnicidadNombreCelda(String nombreCelda) {
        var celdaEntity = CeldaEntity.build().setNombre(nombreCelda);
        var resultados = factory.getCeldaDAO().consultar(celdaEntity);
        if (!resultados.isEmpty()) {
            var mensajeUsuario = "Ya existe una celda con nombre igual en la base de datos";
            throw new BusinessAUTOPARKADMINException(mensajeUsuario);
        }
    }
}

