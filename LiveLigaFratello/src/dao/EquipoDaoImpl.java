package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modelo.Equipo;
import utiles.Conexion;

public class EquipoDaoImpl implements EquipoDao {
	
	@Override
    public Equipo obtenerEquipo(int id) throws SQLException {

        String sql = "SELECT * FROM equipos WHERE id_equipo = ?";

        try (Connection conexion = Conexion.obtenerConexion();
             PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {

                    Equipo equipo = new Equipo(
                        rs.getString("nombre"),
                        rs.getString("ciudad"),
                        rs.getString("entrenador")
                    );

                    equipo.setId_equipo(rs.getInt("id_equipo"));

                    return equipo;
                }
            }
        }

        return null;
    }
	

    @Override
    public void agregarEquipo(Equipo equipo) throws SQLException {

        String sql = "INSERT INTO equipos (nombre, ciudad, entrenador) VALUES (?, ?, ?)";

        try (Connection conexion = Conexion.obtenerConexion();
             PreparedStatement ps = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, equipo.getNombre());
            ps.setString(2, equipo.getCiudad());
            ps.setString(3, equipo.getEntrenador());

            ps.executeUpdate();

            try (ResultSet rs = ps.getGeneratedKeys()) {

                if (rs.next()) {
                    equipo.setId_equipo(rs.getInt(1));
                }
            }
        }
    }

    @Override
    public void actualizarEquipo(Equipo equipo) throws SQLException {

        String sql = "UPDATE equipos SET nombre = ?, ciudad = ?, entrenador = ? WHERE id_equipo = ?";

        try (Connection conexion = Conexion.obtenerConexion();
             PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setString(1, equipo.getNombre());
            ps.setString(2, equipo.getCiudad());
            ps.setString(3, equipo.getEntrenador());
            ps.setInt(4, equipo.getId_equipo());

            ps.executeUpdate();
        }
    }

    @Override
    public void eliminarEquipo(int id) throws SQLException {

        String sql = "DELETE FROM equipos WHERE id_equipo = ?";

        try (Connection conexion = Conexion.obtenerConexion();
             PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setInt(1, id);

            ps.executeUpdate();
        }
    }

    @Override
    public List<Equipo> obtenerTodosLosEquipos() throws SQLException {

        List<Equipo> equipos = new ArrayList<>();

        String sql = "SELECT * FROM equipos";

        try (Connection conexion = Conexion.obtenerConexion();
             PreparedStatement ps = conexion.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                Equipo equipo = new Equipo(
                    rs.getString("nombre"),
                    rs.getString("ciudad"),
                    rs.getString("entrenador")
                );

                equipo.setId_equipo(rs.getInt("id_equipo"));

                equipos.add(equipo);
            }
        }

        return equipos;
    }
}
