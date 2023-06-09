package ar.edu.unju.fi.model;

import java.time.LocalTime;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

@Component
public class Branch {

	// region Attributes
	@NotEmpty(message = "Debes introducir un nombre")
	@Size(min = 5, max = 30, message = "El nombre solo puede contener entre 5 y 30 caracteres")
	private String nombre;

	@NotEmpty(message = "Debes introducir una dirección")
	@Size(min = 5, max = 30, message = "La dirección solo puede contener entre 5 y 30 caracteres")
	@Pattern(regexp = "[a-z A-Z]+", message = "Debe contener solo letras")
	private String direccion;

	@NotNull(message = "Debes ingresar el número")
	@PositiveOrZero(message = "Debes ingresar un número positivo")
	@Pattern(regexp = "[0-9]+", message = "Debe contener solo números")
	private String numeroDireccion;

	@NotEmpty(message = "Debes introducir un telefono")
	@Pattern(regexp = "0388-[0-9]{3}-[0-9]{4}", message = "Ingrese un número de telefono válido")
	private String telefono;

	@DateTimeFormat(pattern = "HH:mm")
	@NotNull(message = "Ingrese un horario de apertura")
	private LocalTime horarioApertura;

	@DateTimeFormat(pattern = "HH:mm")
	@NotNull(message = "Ingrese un horario de cierre")
	private LocalTime horarioCierre;

	@NotBlank(message = "Debe seleccionar una provincia")
	private String provincia;

	private short identificador;
	// endregion

	// region Constructors
	public Branch() {}

	public Branch(
			String nombre,
			String direccion,
			String numeroDireccion,
			String telefono,
			LocalTime horarioApertura,
			LocalTime horarioCierre,
			String provincia,
			short identificador) {

		this.nombre = nombre;
		this.direccion = direccion;
		this.numeroDireccion = numeroDireccion;
		this.telefono = telefono;
		this.horarioApertura = horarioApertura;
		this.horarioCierre = horarioCierre;
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

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getNumeroDireccion() {
		return numeroDireccion;
	}

	public void setNumeroDireccion(String numeroDireccion) {
		this.numeroDireccion = numeroDireccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public LocalTime getHorarioApertura() {
		return horarioApertura;
	}

	public void setHorarioApertura(LocalTime horarioApertura) {
		this.horarioApertura = horarioApertura;
	}

	public LocalTime getHorarioCierre() {
		return horarioCierre;
	}

	public void setHorarioCierre(LocalTime horarioCierre) {
		this.horarioCierre = horarioCierre;
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

	// region Methods
	// endregion

}