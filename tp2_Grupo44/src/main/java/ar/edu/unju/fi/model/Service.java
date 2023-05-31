package ar.edu.unju.fi.model;

public class Service {

	// region Attributes
	private String nombre;
	private String apellido;
	private String dia;
	private String horario;
	// endregion

	// region Constructors
	public Service() {
	}

	public Service(String nombre, String apellido, String dia, String horario) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.dia = dia;
		this.horario = horario;
	}
	// endregion

	// region Getters and Setters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDia() {
		return dia;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}
	// endregion

}
