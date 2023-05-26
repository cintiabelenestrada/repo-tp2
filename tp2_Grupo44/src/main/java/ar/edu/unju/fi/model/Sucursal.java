package ar.edu.unju.fi.model;

public class Sucursal {

	// Attributes
	private String nombre;
	private String direccion;
	private String telefono;
	private String horario;
	private String provincia;

	// Constructores
	public Sucursal() {
	}

	public Sucursal(
			String nombre,
			String direccion,
			String telefono,
			String horario,
			String provincia) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
		this.horario = horario;
		this.provincia = provincia;
	}

	// Getters and Setters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

}