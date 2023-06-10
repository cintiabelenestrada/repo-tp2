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

import ar.edu.unju.fi.model.Product;
import ar.edu.unju.fi.service.IProductService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/productos")
public class ProductListController {

	@Autowired
	private IProductService productService;

	@GetMapping("/listado")
	public String getProductListPage(Model model) {

		model.addAttribute("listaProductos", productService.getProductos());
		model.addAttribute("listaCategorias", productService.getCategorias());

		return "productos";
	}

	@GetMapping("/nuevo")
	public String getNewProductPage(Model model) {

		boolean allowEditing = false;

		model.addAttribute("producto", productService.getProduct());
		model.addAttribute("editar", allowEditing);

		return "nuevo_producto";
	}

	@PostMapping("/guardar")
	public ModelAndView saveProductInformation(
			@Valid @ModelAttribute(value = "producto") Product productoAgregar,
			BindingResult resultadoValidacion) {

		ModelAndView modelAndView = new ModelAndView("redirect:/productos/listado");

		if (resultadoValidacion.hasErrors()) {
			modelAndView.setViewName("nuevo_producto");
			modelAndView.addObject("producto", productoAgregar);
			return modelAndView;
		}		

		productService.setProductCode(productoAgregar);
		productService.saveNewProduct(productoAgregar);

		modelAndView.addObject("listaProductos",productService.getProductos());

		return modelAndView;
	}

	@GetMapping("/modificar/{codigo}")
	public String getModifyProductPage(
			Model model,
			@PathVariable(value = "codigo") short codigoProducto) {

		Product productFound = productService.findProductByCode(codigoProducto);
		boolean allowEditing = true;

		model.addAttribute("producto", productFound);
		model.addAttribute("editar", allowEditing);

		return "nuevo_producto";
	}

	@PostMapping("/modificar")
	public ModelAndView modifyProduct(
			@Valid @ModelAttribute(value = "producto") Product productoModificar,
			BindingResult resultadoValidacion) {

		ModelAndView modelAndView = new ModelAndView("redirect:/productos/listado");
		boolean allowEditing = true;

		if (resultadoValidacion.hasErrors()) {
			modelAndView.setViewName("nuevo_producto");
			modelAndView.addObject("producto", productoModificar);
			modelAndView.addObject("editar", allowEditing);
			return modelAndView;
		}

		productService.modifyProductByCode(productoModificar);

		return modelAndView;
	}

	@GetMapping("/eliminar/{codigo}")
	public String deleteProduct(
			@PathVariable(value = "codigo") short codigoProducto) {

		productService.deleteProductByCode(codigoProducto);

		return ("redirect:/productos/listado");
	}

}