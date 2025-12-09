package dao;

import java.util.List;

import modelo.Jugador;

public interface JugadorDao {
	
	Jugador obtenerJugador(int id);
	
	void agregarJugador(Jugador jugador);
	
	void actualizarJugador(Jugador jugador);
	
	void eliminarJugador(int id);
	
	List<Jugador> obtenerTodosLosJugadores();
	
}
