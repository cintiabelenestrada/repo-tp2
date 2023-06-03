package ar.edu.unju.fi.lists;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import ar.edu.unju.fi.model.Product;

@Component
public class ProductList {

	// region Attributes
	private List<Product> productos;
	private List<String> categorias = List.of(
			"Alimentos",
			"Camas",
			"Collares y correas",
			"Higiene",
			"Juguetes",
			"Prendas");
	// endregion

	// region Constructors
	public ProductList() {

		this.productos = new ArrayList<Product>();

		// Productos precargados
		// Alimentos
		this.productos.add(
				new Product(
						"Alimento para perros",
						(short) 0,
						categorias.get(0),
						"/images/alimento_perro.jpg"));
		this.productos.add(
				new Product(
						"Alimento para gatos",
						(short) 1,
						categorias.get(0),
						"/images/alimento_gato.jpg"));

		// Camas
		this.productos.add(
				new Product(
						"Cama colchon colchoneta",
						(short) 2,
						categorias.get(1),
						"/images/products/beds/cama_colchon_colchoneta.jpg"));
		this.productos.add(
				new Product(
						"Cama moises antidesgarro",
						(short) 3,
						categorias.get(1),
						"/images/products/beds/cama_moises_antidesgarro.jpg"));
		this.productos.add(
				new Product(
						"Cama para gatos",
						(short) 4,
						categorias.get(1),
						"/images/products/beds/cama_para_gatos.jpg"));

		// Collares y correas
		this.productos.add(
				new Product(
						"Collar con pañuelo",
						(short) 5,
						categorias.get(2),
						"/images/products/leashes_and_collars/collar_con_pañuelo.jpg"));
		this.productos.add(
				new Product(
						"Correas estampadas",
						(short) 6,
						categorias.get(2),
						"/images/products/leashes_and_collars/correas_estampadas.jpg"));

		// Higiene
		this.productos.add(
				new Product(
						"Caja para gato",
						(short) 7,
						categorias.get(3),
						"/images/products/hygiene/caja_para_gato.jpg"));
		this.productos.add(
				new Product(
						"Champu",
						(short) 8,
						categorias.get(3),
						"/images/products/hygiene/champu_para_mascotas.jpg"));

		// Juguetes para tus mascotas
		this.productos.add(
				new Product(
						"cuerdas",
						(short) 9,
						categorias.get(4),
						"/images/perros_juguetes.jpg"));
		this.productos.add(
				new Product(
						"pelotas",
						(short) 10,
						categorias.get(4),
						"/images/juguetes4.jpg"));
		this.productos.add(
				new Product(
						"frisbee",
						(short) 11,
						categorias.get(4),
						"/images/frisbee.jpg"));
		this.productos.add(
				new Product(
						"mordedores",
						(short) 12,
						categorias.get(4),
						"/images/perro_jugueton.jpg"));
		this.productos.add(
				new Product(
						"juguete interactivo",
						(short) 13,
						categorias.get(4),
						"/images/interactivo.jpg"));
		this.productos.add(
				new Product(
						"Catnip",
						(short) 14,
						categorias.get(4),
						"/images/catnip.jpg"));
		this.productos.add(
				new Product(
						"Rascadores",
						(short) 15,
						categorias.get(4),
						"/images/rascador.jpg"));
		this.productos.add(
				new Product(
						"Peluches",
						(short) 16,
						categorias.get(4),
						"/images/peluches.jpg"));

		// Ropa
		this.productos.add(
				new Product(
						"Campera para gatos",
						(short) 17,
						categorias.get(5),
						"/images/gatos_con_campera.jpg"));
		this.productos.add(
				new Product(
						"Buzo hueso pescado",
						(short) 18,
						categorias.get(5),
						"/images/gatos_cancheros.jpg"));

	}
	// endregion

	// region Getters and Setters
	public List<Product> getProductos() {
		return productos;
	}

	public void setProductos(List<Product> productos) {
		this.productos = productos;
	}

	public List<String> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<String> categorias) {
		this.categorias = categorias;
	}
	// endregion

}
