package ar.edu.unju.fi.entity;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
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
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.PositiveOrZero;

@Component
@Entity
@Table(name = "productos")
public class Producto {

	//#region Static Objects
	private final static Random random = new Random();
	//#endregion

	//#region Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "producto_codigo")
    private long codigo;

	@Column(name = "producto_estado", columnDefinition = "boolean default true")
    private boolean estado;

	@Column(name = "producto_nombre")
	@NotBlank(message = "Debes ingresar un nombre")
	// @Size(min = 5, max = 30, message = "El nombre solo puede contener entre 5 y 30 caracteres")
	private String nombre;

	@Column(name = "producto_precio")
	@NotBlank(message = "Debes ingresar el precio")
	@PositiveOrZero(message = "Debes ingresar un número positivo")
	@Pattern(regexp = "([0-9]*[.])?[0-9]+", message = "Debe ingresar un número valido")
	private String precio;

	@Column(name = "producto_descuento")
	@Max(value = 50, message = "El valor máximo permitido es 50")
	@Min(value = 0, message = "El valor mínimo permitido es 0")
	@NotNull(message = "Debes ingresar el descuento")
	@Pattern(regexp = "[0-9]+", message = "Debe ingresar un número valido")
	private String descuento;

	@Column(name = "producto_imagen")
	private String imagen;

	@Autowired
	@JoinColumn(name = "categoria_indentificador")
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@NotNull(message = "Debe seleccionar una categoria")
	private Categoria categoria;
	//#endregion

	//#region Constructors
	public Producto() {
		this.estado = true;
		this.imagen = "/images/logos/convenience_store.svg";
	}

	public Producto(
		long codigo,
		boolean estado,
		String nombre,
		String precio,
		String descuento,
		String imagen,
		Categoria categoria) {
		
		this.codigo = codigo;
		this.estado = estado;
		this.nombre = nombre;
		this.precio = precio;
		this.descuento = descuento;
		this.imagen = imagen;
		this.categoria = categoria;

	}
	//#endregion

	//#region Getters and Setters
	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
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

	public String getPrecio() {
		return precio;
	}

	public void setPrecio(String precio) {
		this.precio = precio;
	}

	public String getDescuento() {
		return descuento;
	}

	public void setDescuento(String descuento) {
		this.descuento = descuento;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	//#endregion

	//#region Methods
	
	/**
	 * Calcula el valor del producto de producirse un descuento o no
	 * @return Valor del producto
	 */
	public String calcularDescuento() {

		Float resultado = 0f;

		if (Byte.parseByte(descuento) == 0) {
			resultado = Float.parseFloat(precio);
		}

		if (Byte.parseByte(descuento) > 0) {
			resultado = Float.parseFloat(precio) - (Float.parseFloat(precio) * Byte.parseByte(this.descuento) / 100);
		}

		return String.format("%.2f", resultado);
	}

	public static float randomPrecio() {
		return (float) randomDouble(1000);
	}

	public static byte randomDescuento() {
		return (byte) randomDouble(50);
	}

	public static double randomDouble(int bound) {
		double doubleRandomValue = 0d;
		doubleRandomValue = random.nextInt(bound) + random.nextDouble();
		return (double) Math.round(doubleRandomValue * 100d) / 100;
	}
	//#endregion

}
