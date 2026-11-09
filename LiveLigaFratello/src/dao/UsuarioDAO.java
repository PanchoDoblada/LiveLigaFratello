package dao;

import java.sql.SQLException;

import modelo.Usuario;

public interface UsuarioDAO {
	
	boolean registrarUsuario(Usuario usuario) throws SQLException;
	
	boolean existeUsuario(Usuario usuario) throws SQLException;
	
	boolean existeEmail(Usuario usuario ) throws SQLException;
	
	Usuario buscarPorNombre(String nombreUsuario) throws SQLException;
	
}
