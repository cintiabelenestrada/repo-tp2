package ar.edu.unju.fi.entity;

import java.time.LocalTime;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Component
public class DogWalker {

	// region Attributes
	@NotEmpty(message = "Debes introducir un nombre")
	@Size(min = 3, max = 30, message = "El nombre solo puede contener entre 3 y 30 caracteres")
	@Pattern(regexp = "[a-z A-Z]+", message = "Debe contener solo letras")
	private String nombre;

	@NotEmpty(message = "Debes introducir un apelldio")
	@Size(min = 4, max = 30, message = "El apellido solo puede contener entre 4 y 30 caracteres")
	@Pattern(regexp = "[a-z A-Z]+", message = "Debe contener solo letras")
	private String apellido;

	@NotBlank(message = "Debe seleccionar un día")
	private String diaDisponible;

	@DateTimeFormat(pattern = "HH:mm")
	@NotNull(message = "Ingrese un horario inicial")
	private LocalTime horarioDisponibleDesde;

	@DateTimeFormat(pattern = "HH:mm")
	@NotNull(message = "Ingrese un horario final")
	private LocalTime horarioDisponibleHasta;

	@NotBlank(message = "Debe seleccionar una provincia")
	private String provincia;

	private short identificador;
	// endregion

	// region Constructors
	public DogWalker() {
	}

	public DogWalker(
			String nombre,
			String apellido,
			String diaDisponible,
			LocalTime horarioDisponibleDesde,
			LocalTime horarioDisponibleHasta,
			String provincia,
			short identificador) {

		this.nombre = nombre;
		this.apellido = apellido;
		this.diaDisponible = diaDisponible;
		this.horarioDisponibleDesde = horarioDisponibleDesde;
		this.horarioDisponibleHasta = horarioDisponibleHasta;
		this.provincia = provincia;
		this.identificador = identificador;

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

	public String getDiaDisponible() {
		return diaDisponible;
	}

	public void setDiaDisponible(String diaDisponible) {
		this.diaDisponible = diaDisponible;
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

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public short getIdentificador() {
		return identificador;
	}

	public void setIdentificador(short identificador) {
		this.identificador = identificador;
	}
	// endregion

}
