package modelo;

import java.sql.Timestamp;

public class Usuario {
	private int idUsuario;
	private String nombreUsuario;
	private String password;
	private String email;
	private String genero;
	private Timestamp fechaCreacion;
	
	public Usuario() {
		
	}
	
	public Usuario(String nombreUsuario, String password, String email, String genero) {
		this.nombreUsuario = nombreUsuario;
		this.password = password;
		this.email = email;
		this.genero = genero;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public Timestamp getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Timestamp fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	
	
	
}
