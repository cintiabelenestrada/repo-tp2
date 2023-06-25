package ar.edu.unju.fi.entity;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

@Component
@Entity
@Table(name = "sucursales")
public class Sucursal {

	//#region Attributes
	@Id
	@Column(name = "sucursal_identificador")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long identificador;

	@Column(name = "estado", columnDefinition = "boolean default true")
	private boolean estado;

	@Column(name = "nombre")
	@NotBlank(message = "Debes introducir el nombre de la Nueva Sucursal")
	@Size(min = 3, max = 15, message = "El nombre solo puede contener entre 3 y 15 letras")
	@Pattern(regexp = "[a-zA-Z]+", message = "El nombre solo debe contener letras")
	private String nombre;

	@Column(name = "direccion")
	@NotBlank(message = "Debes introducir la dirección de la Nueva Sucursal")
	@Size(min = 5, max = 30, message = "La dirección debe tener entre 5 y 30 letras")
	@Pattern(regexp = "[a-zA-Z]+", message = "La dirección solo debe tener letras, abajo ingrese la numeracion")
	private String direccion;

	@NotBlank(message = "Debes ingresar el número de la direccion")
	@PositiveOrZero(message = "Debes ingresar un número positivo")
	@Pattern(regexp = "[0-9]+", message = "Debe ingresar solo números en esta seccion")
	@Column(name = "numero_direccion")
	private String numeroDireccion;

	@NotBlank(message = "Debes ingresar el numero de telefono de la sucursal")
	@Pattern(regexp = "0\\d{2}-\\d{7}|\\d{10}", message = "Ingrese un número de teléfono válido, números de teléfono fijo que comienzan con 0 y tienen un código de área de 3 dígitos seguido de un número de 7 dígitos")
	@Column(name = "telefono")
	private String telefono;

	@DateTimeFormat(pattern = "dd-MM-yyyy")
	@NotNull(message = "La fecha una fecha de Inicio")
	@Past(message = "La fecha de inicio debe pasada a la fecha actual")
	@Column(name = "fecha_inicio")
	private LocalDate fechaInicio;

	@DateTimeFormat(pattern = "dd-MM-yyyy")
	@NotNull(message = "Ingrese una fecha de cierre")
	@FutureOrPresent(message = "La fecha de cierre debe ser presente o futura")
	@Column(name = "fecha_cierre")
	private LocalDate fechaCierre;



	@Autowired
	@JoinColumn(name = "provincia_identificador")
	@ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	@NotNull(message = "Debe seleccionar una provincia")
	private Provincia provincia;
	//#endregion

	//#region Constructors
	/**
	 * Constructor por defecto
	 */
	public Sucursal() {
		this.estado = true;
	}

	/**
	 * Constructor parametrizado
	 * @param identificador es el ID de la sucursal
	 * @param estado representa si es VISIBLE o no en el listado
	 * @param nombre
	 * @param direccion
	 * @param numeroDireccion
	 * @param telefono
	 * @param fechaInicio
	 * @param fechaCierre
	 * @param provincia representa la ubicación de la sucursal
	 */
	public Sucursal(
			long identificador,
			boolean estado,
			String nombre,
			String direccion,
			String numeroDireccion,
			String telefono,
			@NotNull(message = "La fecha una fecha de Inicio") @Past(message = "La fecha de inicio debe pasada a la fecha actual") LocalDate fechaInicio,
			LocalDate fechaCierre,
			Provincia provincia) {

		this.identificador = identificador;
		this.estado = estado;
		this.nombre = nombre;
		this.direccion = direccion;
		this.numeroDireccion = numeroDireccion;
		this.telefono = telefono;
		this.fechaInicio = fechaInicio;
		this.fechaCierre = fechaCierre;
		this.provincia = provincia;

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

	public LocalDate getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public LocalDate getFechaCierre() {
		return fechaCierre;
	}

	public void setFechaCierre(LocalDate fechaCierre) {
		this.fechaCierre = fechaCierre;
	}

	public Provincia getProvincia() {
		return provincia;
	}

	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}
	//#endregion

	//#region Methods
	//#endregion

}