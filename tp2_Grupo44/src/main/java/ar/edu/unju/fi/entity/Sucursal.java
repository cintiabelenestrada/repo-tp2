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
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
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

	@Column(name = "sucursal_estado", columnDefinition = "boolean default true")
	private boolean estado;

	@Column(name = "sucursal_nombre")
	@NotBlank(message = "Debes introducir un nombre")
	@Size(min = 5, max = 15, message = "El nombre de la sucursal solo puede contener entre 5 y 15 caracteres")
	@Pattern(regexp = "[a-z A-Z 0-9]+", message = "El nombre puede contener letras y/o numeros")
	private String nombre;

	@Column(name = "sucursal_direccion")
	@NotBlank(message = "Debes introducir una dirección")
	@Size(min = 5, max = 30, message = "La dirección solo puede contener entre 5 y 30 caracteres")
	@Pattern(regexp = "[a-z A-Z]+", message = "La dirección solo puede contener letras")
	private String direccion;

	@Column(name = "sucursal_numero_direccion")
	@NotBlank(message = "Debes ingresar el número de la dirección")
	@Pattern(regexp = "[0-9]+", message = "Debe contener solo números")
	private String numeroDireccion;

	@Column(name = "sucursal_telefono")
	@NotBlank(message = "Debes introducir un número de telefono")
	@Pattern(regexp = "0388-[0-9]{3}-[0-9]{4}", message = "Ingrese un número de telefono válido")
	private String telefono;

	@Column(name = "sucursal_fecha_apertura")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull(message = "Debes ingresar una fecha")
	@Past(message = "Fecha incorrecta")
	private LocalDate fechaApertura;

	@Autowired
	@JoinColumn(name = "provincia_identificador")
	@ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	@NotNull(message = "Debe seleccionar una provincia")
	private Provincia provincia;
	//#endregion

	//#region Constructors
	public Sucursal() {
		this.estado = true;
	}

	public Sucursal(
			long identificador,
			boolean estado,
			String nombre,
			String direccion,
			String numeroDireccion,
			String telefono,
			LocalDate fechaApertura,
			Provincia provincia) {

		this.identificador = identificador;
		this.estado = estado;
		this.nombre = nombre;
		this.direccion = direccion;
		this.numeroDireccion = numeroDireccion;
		this.telefono = telefono;
		this.fechaApertura = fechaApertura;
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

	public LocalDate getFechaApertura() {
		return fechaApertura;
	}

	public void setFechaApertura(LocalDate fechaApertura) {
		this.fechaApertura = fechaApertura;
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