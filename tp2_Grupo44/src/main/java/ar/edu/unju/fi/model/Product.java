package ar.edu.unju.fi.model;

import java.util.Random;

import org.springframework.stereotype.Component;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

@Component
public class Product {

	// region static Objects
	private final static Random random = new Random();
	// endregion

	// region Attributes
	@NotEmpty(message = "Debes introducir un nombre")
	@Size(min = 5, max = 30, message = "El nombre solo puede contener entre 5 y 30 caracteres")
	private String nombre;

	private short codigo;

	@NotNull(message = "Debes ingresar el precio")
	@PositiveOrZero(message = "Debes ingresar un número positivo")
	@Pattern(regexp = "([0-9]*[.])?[0-9]+", message = "Debe ingresar un número valido")
	private String precio;

	@NotBlank(message = "Debe seleccionar una categoria")
	private String categoria;

	@Max(value = 50, message = "El valor máximo permitido es 50")
	@Min(value = 0, message = "El valor mínimo permitido es 0")
	@NotNull(message = "Debes ingresar el descuento")
	@Pattern(regexp = "[0-9]+", message = "Debe ingresar un número valido")
	private String descuento;

	private String imagen;
	// endregion

	// region Constructors
	public Product() {
		this.imagen = "/images/logos/convenience_store.svg";
	}

	public Product(
			String nombre,
			short codigo,
			String precio,
			String categoria,
			String descuento,
			String imagen) {

		this.nombre = nombre;
		this.codigo = codigo;
		this.precio = precio;
		this.categoria = categoria;
		this.descuento = descuento;
		this.imagen = imagen;

	}

	public Product(
			String nombre,
			short codigo,
			String categoria,
			String imagen) {

		this.nombre = nombre;
		this.codigo = codigo;
		this.precio = Float.toString(randomPrecio());
		this.categoria = categoria;
		this.descuento = Byte.toString(randomDescuento());
		this.imagen = imagen;

	}
	// endregion

	// region Getters and Setters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public short getCodigo() {
		return codigo;
	}

	public void setCodigo(short codigo) {
		this.codigo = codigo;
	}

	public String getPrecio() {
		return precio;
	}

	public void setPrecio(String precio) {
		this.precio = precio;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
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
	// endregion

	// region Methods
	/**
	 * Calcula el valor del producto de producirse un descuento o no
	 * 
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
	// endregion

}
