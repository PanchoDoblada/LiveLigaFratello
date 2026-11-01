package modelo;

public class Partido {
	
	private int id_partido;
	private int jornada;
	private int id_equipo_local;
	private int id_equipo_visitante;
	private int goles_equipo_local;
	private int goles_equipo_visitante;
	private EstadoPartido estadoPartido;
	
	public Partido(int jornada, int id_equipo_local, int id_equipo_visitante, int goles_equipo_local, int goles_equipo_visitante) {
		this.jornada = jornada;
		this.id_equipo_local = id_equipo_local;
		this.id_equipo_visitante = id_equipo_visitante;
		this.goles_equipo_local = goles_equipo_local;
		this.goles_equipo_visitante = goles_equipo_visitante;
	}

	public int getId_partido() {
		return id_partido;
	}

	public int getJornada() {
		return jornada;
	}

	public void setJornada(int jornada) {
		this.jornada = jornada;
	}

	public int getId_equipo_local() {
		return id_equipo_local;
	}

	public int getId_equipo_visitante() {
		return id_equipo_visitante;
	}

	public int getGoles_equipo_local() {
		return goles_equipo_local;
	}

	public void setGoles_equipo_local(int goles_equipo_local) {
		this.goles_equipo_local = goles_equipo_local;
	}

	public int getGoles_equipo_visitante() {
		return goles_equipo_visitante;
	}

	public void setGoles_equipo_visitante(int goles_equipo_visitante) {
		this.goles_equipo_visitante = goles_equipo_visitante;
	}
	
	@Override
	public String toString() {
		return "Partido [ jornada: " + jornada +", id_equipo_local: " + id_equipo_local + ", id_equipo_visitante: " + id_equipo_visitante + ", goles local: " + goles_equipo_local + ", goles visitante: " + goles_equipo_visitante;
	}

	public EstadoPartido getEstadoPartido() {
		return estadoPartido;
	}

	public void setEstadoPartido(EstadoPartido estadoPartido) {
		this.estadoPartido = estadoPartido;
	}
	
	
}
