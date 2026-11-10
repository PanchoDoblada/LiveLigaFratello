package dao;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.SQLException;

import modelo.Usuario;

public interface UsuarioDao {
	
	boolean registrarUsuario(Usuario usuario) throws SQLException, NoSuchAlgorithmException, InvalidKeySpecException;
	
	boolean existeNombreUsuario(String nombreUsuario) throws SQLException;
	
	boolean existeEmail(String email ) throws SQLException;
	
	Usuario buscarPorNombre(String nombreUsuario) throws SQLException;
	
}
