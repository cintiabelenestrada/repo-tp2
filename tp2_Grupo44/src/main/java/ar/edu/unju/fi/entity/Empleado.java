package ar.edu.unju.fi.entity;

import java.time.LocalTime;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Component
@Entity
@Table(name = "empleados")
public class Empleado {

	//#region Attributes
	@Id
    @Column(name = "empleado_identificador")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long identificador;

	@Column(name = "empleado_estado", columnDefinition = "boolean default true")
    private boolean estado;

	@Column(name = "empleado_nombre")
	@NotEmpty(message = "Debes introducir un nombre")
	@Size(min = 3, max = 30, message = "El nombre solo puede contener entre 3 y 30 caracteres")
	@Pattern(regexp = "[a-z A-Z]+", message = "Debe contener solo letras")
	private String nombre;

	@Column(name = "empleado_apellido")
	@NotEmpty(message = "Debes introducir un apellido")
	@Size(min = 4, max = 30, message = "El apellido solo puede contener entre 4 y 30 caracteres")
	@Pattern(regexp = "[a-z A-Z]+", message = "Debe contener solo letras")
	private String apellido;

	@Column(name = "empleado_horario_disponible_desde")
	@DateTimeFormat(pattern = "HH:mm")
	@NotNull(message = "Ingrese un horario inicial")
	private LocalTime horarioDisponibleDesde;

	@Column(name = "empleado_horario_disponible_hasta")
	@DateTimeFormat(pattern = "HH:mm")
	@NotNull(message = "Ingrese un horario final")
	private LocalTime horarioDisponibleHasta;

	@OneToOne(mappedBy = "empleado")
	private Servicio servicio;
	//#endregion

	//#region Constructors
	public Empleado() {
		this.estado = true;
	}

	public Empleado(
		long identificador,
		boolean estado,
		String nombre,
		String apellido,
		LocalTime horarioDisponibleDesde,
		LocalTime horarioDisponibleHasta,
		Servicio servicio) {

		this.identificador = identificador;
		this.estado = estado;
		this.nombre = nombre;
		this.apellido = apellido;
		this.horarioDisponibleDesde = horarioDisponibleDesde;
		this.horarioDisponibleHasta = horarioDisponibleHasta;
		this.servicio = servicio;

	}
	//#endregion

	//#region Getters and Setters
	public long getIdentificador() {
		return identificador;
	}

	public void setIdentificador(long identificador) {
		this.identificador = identificador;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

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

	public LocalTime getHorarioDisponibleDesde() {
		return horarioDisponibleDesde;
	}

	public void setHorarioDisponibleDesde(LocalTime horarioDisponibleDesde) {
		this.horarioDisponibleDesde = horarioDisponibleDesde;
	}

	public LocalTime getHorarioDisponibleHasta() {
		return horarioDisponibleHasta;
	}

	public void setHorarioDisponibleHasta(LocalTime horarioDisponibleHasta) {
		this.horarioDisponibleHasta = horarioDisponibleHasta;
	}

	public Servicio getServicio() {
		return servicio;
	}

	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}
	//#endregion

	//#region Methods
	//#endregion

}
