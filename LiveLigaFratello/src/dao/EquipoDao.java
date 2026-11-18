package dao;

import java.sql.SQLException;
import java.util.List;

import modelo.Equipo;

public interface EquipoDao {
	
	Equipo obternerEquipo(int id) throws SQLException;
	
	void agregarEquipo(Equipo equipo) throws SQLException;
	
	void actualizarEquipo(Equipo equipo) throws SQLException;
	
	void eliminarEquipo(int id) throws SQLException;
	
	List<Equipo> obtenerTodosLosEquipos() throws SQLException;
}
