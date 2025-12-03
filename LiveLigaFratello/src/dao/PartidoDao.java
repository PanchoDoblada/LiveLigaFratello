package dao;

import java.util.List;

import modelo.Equipo;
import modelo.Partido;

public interface PartidoDao {
	Partido obtenerPartido(int id);
	
	void agregarPartido(Partido partido);
	
	void actualizarPartido(Partido partido);
	
	void eliminarPartido(int id);
	
	List<Partido> obtenerTodosLosPartidos();
}
