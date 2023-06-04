package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.lists.ProductList;
import ar.edu.unju.fi.model.Product;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/productos")
public class ProductListController {

	@Autowired
	ProductList listaProductos;

	@Autowired
	Product producto;

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
				producto);

		model.addAttribute(
				"editar",
				allowEditing);

		return "nuevo_producto";
	}

	@PostMapping("/guardar")
	public ModelAndView saveProductInformation(
			@Valid @ModelAttribute(value = "producto") Product productoAgregar,
			BindingResult resultadoValidacion) {

		ModelAndView modelAndView = new ModelAndView(
				"redirect:/productos/listado");

		short codigoContador = listaProductos.getProductos().get(listaProductos.getProductos().size() - 1).getCodigo();
		codigoContador++;

		if (resultadoValidacion.hasErrors()) {

			modelAndView.setViewName(
					"nuevo_producto");

			modelAndView.addObject(
					"producto",
					productoAgregar);

			return modelAndView;
		}

		productoAgregar.setCodigo(codigoContador);
		listaProductos.getProductos().add(productoAgregar);

		modelAndView.addObject(
				"listaProductos",
				listaProductos.getProductos());

		return modelAndView;
	}

	@GetMapping("/modificar/{codigo}")
	public String getModifyProductPage(
			Model model,
			@PathVariable(value = "codigo") short codigoProducto) {

		Product ProductFound = new Product();
		boolean allowEditing = true;

		for (Product producto : listaProductos.getProductos()) {
			if (producto.getCodigo() == codigoProducto) {
				ProductFound = producto;
				break;
			}
		}

		model.addAttribute("producto", ProductFound);
		model.addAttribute("editar", allowEditing);

		return "nuevo_producto";
	}

	@PostMapping("/modificar")
	public ModelAndView modifyProduct(
			@Valid @ModelAttribute(value = "producto") Product productoModificar,
			BindingResult resultadoValidacion) {

		ModelAndView modelAndView = new ModelAndView(
				"redirect:/productos/listado");

		boolean allowEditing = true;

		// System.out.println(productoModificar.getNombre());
		// System.out.println(productoModificar.getPrecio());
		// System.out.println(productoModificar.getCategoria());
		// System.out.println(productoModificar.getDescuento());

		if (resultadoValidacion.hasErrors()) {

			modelAndView.setViewName("nuevo_producto");

			modelAndView.addObject(
					"producto",
					productoModificar);

			modelAndView.addObject(
					"editar",
					allowEditing);

			return modelAndView;
		}

		for (Product producto : listaProductos.getProductos()) {
			if (producto.getCodigo() == productoModificar.getCodigo()) {
				producto.setNombre(productoModificar.getNombre());
				producto.setPrecio(productoModificar.getPrecio());
				producto.setCategoria(productoModificar.getCategoria());
				producto.setDescuento(productoModificar.getDescuento());
				break;
			}
		}

		return modelAndView;
	}

	@GetMapping("/eliminar/{codigo}")
	public String deleteProduct(
			@PathVariable(value = "codigo") short codigoProducto) {

		for (Product producto : listaProductos.getProductos()) {
			if (producto.getCodigo() == codigoProducto) {
				listaProductos.getProductos().remove(producto);
				break;
			}
		}

		return ("redirect:/productos/listado");
	}

}