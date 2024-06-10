package co.priv.parqueadero.autoparkadmin.data.dao.entity;

import co.priv.parqueadero.autoparkadmin.entity.UsuarioEntity;

public interface UsuarioDAO extends CreateDAO<UsuarioEntity>, RetrieveDAO<UsuarioEntity> {
	boolean autenticarUsuario(String usuario, String contraseña);

}
