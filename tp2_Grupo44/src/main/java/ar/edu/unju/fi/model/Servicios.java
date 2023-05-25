package ar.edu.unju.fi.model;

public class Servicios {
	//Atributos
	private String nombre;
	private String apellido;
	private String dia;
	private String horario;
	
	//Constructore sin parametros definidos
	public Servicios() {
		super();
	}
	//Constructor parametrizado con todos los atributos
	public Servicios(String nombre, String apellido, String dia, String horario) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.dia = dia;
		this.horario = horario;
	}
	
	
	//Getters and Settera
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
	

}
