package modelo;

public class Equipo {
	
	private int id_equipo;
	private String nombre;
	private String ciudad;
	private String entrenador;
	
	public Equipo(String nombre, String ciudad, String entrenador) {
		this.nombre = nombre;
		this.ciudad = ciudad;
		this.entrenador = entrenador;
	}
	
	public int getId_equipo() {
		return id_equipo;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getCiudad() {
		return ciudad;
	}
	
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	
	public String getEntrenador() {
		return entrenador;
	}
	
	public void setEntrenador(String entrenador) {
		this.entrenador = entrenador;
	}
	
	@Override
	public String toString() {
		return "Equipo [id: " + id_equipo + ", nombre: " + nombre +", ciudad: " + ciudad + ", entrenador: " + entrenador;
	}
	
}
