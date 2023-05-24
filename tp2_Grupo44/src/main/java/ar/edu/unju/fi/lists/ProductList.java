package ar.edu.unju.fi.lists;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unju.fi.model.Product;

public class ProductList {

	// region Attributes
	private List<Product> productos; // Container
	private List<String> categorias = List.of(
			"Alimentos",
			"Camas",
			"Collares y correas",
			"Higiene",
			"Juguetes");
	// endregion

	// region Constructor
	public ProductList() {

		this.productos = new ArrayList<Product>();

		// Productos precargados
		// Alimentos
		this.productos.add(new Product("Alimento pedigree", (short) 0, categorias.get(0),
				"/images/products/foods/alimento_pedigree.jpg"));
		this.productos.add(new Product("Alimento bonelo", (short) 1, categorias.get(0),
				"/images/products/foods/alimento_bonelo.png"));
		this.productos.add(new Product("Alimento dog chow", (short) 2, categorias.get(0),
				"/images/products/foods/alimento_dog_chow.jpg"));
		this.productos.add(new Product("Alimento dogui", (short) 3, categorias.get(0),
				"/images/products/foods/alimento_dogui.jpg"));
		this.productos.add(new Product("Alimento agility", (short) 4, categorias.get(0),
				"/images/products/foods/alimento_agility.jpg"));
		this.productos.add(
				new Product("Alimento raza", (short) 5, categorias.get(0), "/images/products/foods/alimento_raza.jpg"));
		this.productos.add(new Product("Alimento siete vidas", (short) 6, categorias.get(0),
				"/images/products/foods/alimento_siete_vidas.jpg"));
		this.productos.add(
				new Product("Alimento gati", (short) 7, categorias.get(0), "/images/products/foods/alimento_gati.jpg"));

		// Camas
		this.productos.add(new Product("Cama colchon colchoneta", (short) 8, categorias.get(1),
				"/images/products/beds/cama_colchon_colchoneta.jpg"));
		this.productos.add(new Product("Cama moises antidesgarro", (short) 9, categorias.get(1),
				"/images/products/beds/cama_moises_antidesgarro.jpg"));
		this.productos.add(new Product("Cama moises cuna", (short) 10, categorias.get(1),
				"/images/products/beds/cama_moises_cuna.jpg"));
		this.productos.add(new Product("Colchon liso antidesgarro", (short) 11, categorias.get(1),
				"/images/products/beds/colchon_liso_antidesgarro.jpg"));
		this.productos.add(new Product("Cama para gatos", (short) 12, categorias.get(1),
				"/images/products/beds/cama_para_gatos.jpg"));
		this.productos.add(new Product("Cama y cueva para gatos", (short) 13, categorias.get(1),
				"/images/products/beds/cama_y_cueva_para_gatos.jpg"));
		this.productos.add(new Product("Cama felpa para gatos", (short) 14, categorias.get(1),
				"/images/products/beds/cama_felpa_para_gatos.jpg"));

		// Collares y correas
		this.productos.add(new Product("Collar con pañuelo", (short) 15, categorias.get(2),
				"/images/products/leashes_and_collars/collar_con_pañuelo.jpg"));
		this.productos.add(new Product("Collares nylon lisos", (short) 16, categorias.get(2),
				"/images/products/leashes_and_collars/collares_nylon_lisos.jpg"));
		this.productos.add(new Product("Collares de cuero", (short) 17, categorias.get(2),
				"/images/products/leashes_and_collars/collares_de_cuero.jpg"));
		this.productos.add(new Product("Correa alpina", (short) 18, categorias.get(2),
				"/images/products/leashes_and_collars/correa_alpina.jpg"));
		this.productos.add(new Product("Correa extendible", (short) 19, categorias.get(2),
				"/images/products/leashes_and_collars/correa_extendible.jpg"));
		this.productos.add(new Product("Correa extendible flexible", (short) 20, categorias.get(2),
				"/images/products/leashes_and_collars/correa_extendible_flexi.jpg"));
		this.productos.add(new Product("Correas estampadas", (short) 21, categorias.get(2),
				"/images/products/leashes_and_collars/correas_estampadas.jpg"));

		this.productos.add(new Product("Cepillo para gato", (short) 22, categorias.get(3),
				"/images/products/hygiene/cepillo_para_gatos.jpg"));
		this.productos.add(new Product("Caja para gato", (short) 23, categorias.get(3),
				"/images/products/hygiene/caja_para_gato.jpg"));
		this.productos.add(new Product("Champu", (short) 24, categorias.get(3),
				"/images/products/hygiene/champu_para_mascotas.jpg"));
		this.productos.add(new Product("Perfume", (short) 25, categorias.get(3),
				"/images/products/hygiene/perfume_para_mascotas.jpg"));
		this.productos.add(new Product("Rodillos quitapelos", (short) 26, categorias.get(3),
				"/images/products/hygiene/rodillos_quitapelos.jpg"));
		this.productos.add(new Product("Toallitas", (short) 27, categorias.get(3),
				"/images/products/hygiene/toallitas_higiene_para_perro_y_gato_musgo_blanco_aloe.jpg"));

		this.productos.add(new Product("Hueso para perro", (short) 28, categorias.get(4),
				"/images/products/toys/hueso_para_perro.jpg"));
		this.productos.add(new Product("Juguete mazorca para perro", (short) 29, categorias.get(4),
				"/images/products/toys/juguete_mazorca_para_perros.jpg"));
		this.productos.add(new Product("Juguete para masticar", (short) 30, categorias.get(4),
				"/images/products/toys/juguete_para_masticar.jpg"));
		this.productos.add(new Product("Pelota con alimento para perro", (short) 31, categorias.get(4),
				"/images/products/toys/pelota_con_alimento_para_perro.jpg"));
		this.productos.add(
				new Product("Pelota estire", (short) 32, categorias.get(4), "/images/products/toys/pelota_estire.jpg"));
		this.productos.add(new Product("Raton con sonido", (short) 33, categorias.get(4),
				"/images/products/toys/raton_con_sonido.jpg"));
		this.productos.add(new Product("Tunel para gato", (short) 34, categorias.get(4),
				"/images/products/toys/tunel_para_gato.jpg"));

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

	// region Method
	// endregion

}
