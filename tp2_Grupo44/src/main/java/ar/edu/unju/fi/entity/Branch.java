package ar.edu.unju.fi.entity;

import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Component
@Entity
@Table(name = "sucursales")
public class Branch {

	// #region Attributes
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	// @Column(name = "identificador")
	private Long identificador;

	// @Column(name = "estado", columnDefinition = "boolean default true")
	private boolean estado;

	// @NotEmpty(message = "Debes introducir un nombre")
	// @Size(min = 5, max = 30, message = "El nombre solo puede contener entre 5 y
	// 30 caracteres")
	// @Column(name = "nombre")
	private String nombre;

	// @NotEmpty(message = "Debes introducir una dirección")
	// @Size(min = 5, max = 30, message = "La dirección solo puede contener entre 5
	// y 30 caracteres")
	// @Pattern(regexp = "[a-z A-Z]+", message = "Debe contener solo letras")
	// @Column(name = "direccion")
	private String direccion;

	// @NotNull(message = "Debes ingresar el número")
	// @PositiveOrZero(message = "Debes ingresar un número positivo")
	// @Pattern(regexp = "[0-9]+", message = "Debe contener solo números")
	// @Column(name = "numero_direccion")
	private String numeroDireccion;

	// @NotEmpty(message = "Debes introducir un telefono")
	// @Pattern(regexp = "0388-[0-9]{3}-[0-9]{4}", message = "Ingrese un número de
	// telefono válido")
	// @Column(name = "telefono")
	private String telefono;

	// @DateTimeFormat(pattern = "HH:mm")
	// @NotNull(message = "Ingrese un horario de apertura")
	// @Column(name = "horario_apertura")
	private LocalTime horarioApertura;

	// @DateTimeFormat(pattern = "HH:mm")
	// @NotNull(message = "Ingrese un horario de cierre")
	// @Column(name = "horario_cierre")
	private LocalTime horarioCierre;

	@Autowired
	// @NotBlank(message = "Debe seleccionar una provincia")
	@JoinColumn(name = "provincia")
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Province provincia;
	// #endregion

	// #region Constructors
	public Branch() {
		this.estado = true;
	}

	public Branch(
			Long identificador,
			boolean estado,
			String nombre,
			String direccion,
			String numeroDireccion,
			String telefono,
			LocalTime horarioApertura,
			LocalTime horarioCierre,
			Province provincia) {

		this.identificador = identificador;
		this.estado = estado;
		this.nombre = nombre;
		this.direccion = direccion;
		this.numeroDireccion = numeroDireccion;
		this.telefono = telefono;
		this.horarioApertura = horarioApertura;
		this.horarioCierre = horarioCierre;
		this.provincia = provincia;

	}
	// #endregion

	// #region Getters and Setters
	public Long getIdentificador() {
		return identificador;
	}

	public void setIdentificador(Long identificador) {
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

	public Province getProvincia() {
		return provincia;
	}

	public void setProvincia(Province provincia) {
		this.provincia = provincia;
	}
	// #endregion

	// #region Methods
	// #endregion

}