package ar.edu.unju.fi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.lists.ProductList;
import ar.edu.unju.fi.model.Product;

@Controller
@RequestMapping("/productos")
public class productListController {

	ProductList listaProductos = new ProductList();

	@GetMapping("/listado")
	public String getProductListPage(Model model) {

		model.addAttribute(
				"listaProductos",
				listaProductos.getProductos());

		model.addAttribute(
				"listaCategorias",
				listaProductos.getCategorias());

		return "productos";
	}

	@GetMapping("/nuevo")
	public String getNewProductPage(Model model) {

		boolean allowEditing = false;

		model.addAttribute(
				"producto",
				new Product());
		model.addAttribute(
				"editar",
				allowEditing);

		return "nuevo_producto";
	}

	@PostMapping("/guardar")
	public ModelAndView saveProductInformation(@ModelAttribute(value = "producto") Product productoAgregar) {

		ModelAndView modelAndView = new ModelAndView("productos");

		short codigoContador = listaProductos.getProductos().get(listaProductos.getProductos().size() -
				1).getCodigo();
		codigoContador++;

		productoAgregar.setCodigo(codigoContador);

		listaProductos.getProductos().add(productoAgregar);

		modelAndView.addObject(
				"listaProductos",
				listaProductos.getProductos());
		modelAndView.addObject(
				"listaCategorias",
				listaProductos.getCategorias());

		return modelAndView;
	}

	@GetMapping("/modificar/{codigo}")
	public String getModifyProductPage(Model model, @PathVariable(value = "codigo") short codigoProducto) {

		Product productFound = new Product();
		boolean allowEditing = true;

		for (Product producto : listaProductos.getProductos()) {
			if (producto.getCodigo() == codigoProducto) {
				productFound = producto;
				break;
			}
		}

		System.out.println("Precio enviado: " + productFound.getPrecio());

		model.addAttribute("producto", productFound);
		model.addAttribute("editar", allowEditing);

		return "nuevo_producto";
	}

	@PostMapping("/modificar")
	public String modifyProduct(@ModelAttribute(value = "producto") Product productoModificar) {

		for (Product producto : listaProductos.getProductos()) {
			if (producto.getCodigo() == productoModificar.getCodigo()) {

				producto.setNombre(productoModificar.getNombre());
				producto.setPrecio(productoModificar.getPrecio());
				producto.setCategoria(productoModificar.getCategoria());
				producto.setDescuento(productoModificar.getDescuento());
				break;
			}
		}

		return ("redirect:/productos/listado");
	}

	@GetMapping("/eliminar/{codigo}")
	public String deleteProduct(@PathVariable(value = "codigo") short codigoProducto) {
		for (Product producto : listaProductos.getProductos()) {
			if (producto.getCodigo() == codigoProducto) {
				listaProductos.getProductos().remove(producto);
				break;
			}
		}
		return ("redirect:/productos/listado");
	}
}