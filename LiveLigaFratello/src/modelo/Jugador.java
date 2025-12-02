package modelo;

public class Jugador {
	
	private int id_jugador;
	private String nombre;
	private int dorsal;
	private Posicion posicion;
	private int id_equipo;
	
	public Jugador(String nombre, int dorsal, Posicion posicion) {
		this.nombre = nombre;
		this.dorsal = dorsal;
		this.posicion = posicion;
	}

	public int getId_jugador() {
		return id_jugador;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getDorsal() {
		return dorsal;
	}

	public void setDorsal(int dorsal) {
		this.dorsal = dorsal;
	}

	public Posicion getPosicion() {
		return posicion;
	}

	public void setPosicion(Posicion posicion) {
		this.posicion = posicion;
	}
	
	public int getId_equipo() {
		return id_equipo;
	}

	@Override
	public String toString() {
		return "Jugador [id: " + id_equipo + ", nombre: " + nombre +", dorsal: " + dorsal + ", posicion: " + posicion;
	}
	
	
}
