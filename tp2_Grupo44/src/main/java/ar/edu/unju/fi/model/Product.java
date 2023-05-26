package ar.edu.unju.fi.model;

import java.util.Random;

public class Product {

	// region static Objects
	private final static Random random = new Random();
	// endregion

	// region static Variables
	// endregion

	// region Attributes
	private String nombre;
	private short codigo;
	private float precio;
	private String categoria;
	private byte descuento;
	private String imagen;
	// endregion

	// region Constructor
	public Product() {
	}

	public Product(short codigo) {
		this.codigo = codigo;
	}

	public Product(
			String nombre,
			short codigo,
			float precio,
			String categoria,
			byte descuento,
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
		this.precio = randomPrecio();
		this.categoria = categoria;
		this.descuento = randomDescuento();
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

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public byte getDescuento() {
		return descuento;
	}

	public void setDescuento(byte descuento) {
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

		float resultado = 0f;

		if (descuento == 0) {
			resultado = precio;
		}

		if (descuento > 0) {
			resultado = precio - (precio * this.descuento / 100);
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
