package dao;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Base64;

import modelo.Usuario;
import utiles.Conexion;
import utiles.Seguridad;

public class UsuarioDaoImpl implements UsuarioDao{

	private static final int ITERACIONES = 600000;
	private static final int LONGITUD_HASH = 256;
	    
	
	@Override
	public boolean registrarUsuario(Usuario usuario) throws SQLException, NoSuchAlgorithmException, InvalidKeySpecException {
		String sql = "INSERT INTO usuarios "
                + "(username, password, correo_electronico, genero) "
                + "VALUES (?, ?, ?, ?)";

     // Generar salt
     byte[] salt = Seguridad.generarSalt();

     // Generar hash de la contraseña
     String hash = Seguridad.generarHashPassword(
         usuario.getPassword(),
         salt,
         ITERACIONES,
         LONGITUD_HASH
     );

     // Preparar los datos para almacenarlos juntos
     String saltBase64 = Base64.getEncoder().encodeToString(salt);

     String passwordGuardada = ITERACIONES + ":"
                             + saltBase64 + ":"
                             + hash;

     try (Connection conexion = Conexion.obtenerConexion();
          PreparedStatement ps = conexion.prepareStatement(sql)) {

         ps.setString(1, usuario.getNombreUsuario());
         ps.setString(2, passwordGuardada);
         ps.setString(3, usuario.getEmail());
         ps.setString(4, usuario.getGenero());

         return ps.executeUpdate() > 0;
     }
	}

	@Override
	public boolean existeNombreUsuario(String nombreUsuario) throws SQLException {
		String sql = "SELECT 1 FROM usuarios WHERE username = ?";

        try (Connection conexion = Conexion.obtenerConexion();
             PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setString(1, nombreUsuario);

            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }
        }
	}

	@Override
	public boolean existeEmail(String email) throws SQLException {
		String sql = "SELECT 1 FROM usuarios WHERE correo_electronico = ?";

        try (Connection conexion = Conexion.obtenerConexion();
             PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setString(1, email);

            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }
        }
	}

	@Override
	public Usuario buscarPorNombre(String nombreUsuario) throws SQLException {
		String sql = "SELECT * FROM usuarios WHERE username = ?";

        try (Connection conexion = Conexion.obtenerConexion();
             PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setString(1, nombreUsuario);

            try (ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {

                    Usuario usuario = new Usuario();

                    usuario.setIdUsuario(rs.getInt("id_usuario"));
                    usuario.setNombreUsuario(rs.getString("username"));
                    usuario.setPassword(rs.getString("password"));
                    usuario.setEmail(
                        rs.getString("correo_electronico")
                    );
                    usuario.setGenero(rs.getString("genero"));
                    usuario.setFechaCreacion(rs.getTimestamp("creado_en"));

                    return usuario;
                }
            }
        }

        return null;
    }
	
}
