package dao;

import java.util.List;

import modelo.Equipo;

public interface EquipoDao {
	
	Equipo obternerEquipo(int id);
	
	void agregarEquipo(Equipo equipo);
	
	void actualizarEquipo(Equipo equipo);
	
	void eliminarEquipo(int id);
	
	List<Equipo> obtenerTodosLosEquipos();
}
