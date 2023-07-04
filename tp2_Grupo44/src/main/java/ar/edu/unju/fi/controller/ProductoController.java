package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.entity.Categoria;
import ar.edu.unju.fi.entity.Producto;
import ar.edu.unju.fi.service.imp.CategoriaServiceImp;
import ar.edu.unju.fi.service.imp.ProductoServiceImp;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/productos")
public class ProductoController {

	@Autowired
	private Producto unProducto;

	@Autowired
	private Categoria unaCategoria;

	@Autowired
	private ProductoServiceImp productoServiceImp;

	@Autowired
	private CategoriaServiceImp categoriaServiceImp;

	@GetMapping("/listado")
	public ModelAndView getProductosPage() {

		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.setViewName("productos");
		modelAndView.addObject("listaProductos", productoServiceImp.getAllProductos());
		modelAndView.addObject("listaCategorias", categoriaServiceImp.getAllCategorias());

		return modelAndView;
	}

	@GetMapping("/formulario")
	public ModelAndView getNewProductoPage() {

		ModelAndView modelAndView = new ModelAndView();
		boolean allowEditing = false;

		unProducto = new Producto();
		modelAndView.setViewName("nuevo_producto");
		modelAndView.addObject("producto", unProducto);
		modelAndView.addObject("listaCategorias", categoriaServiceImp.getAllCategorias());
		modelAndView.addObject("editar", allowEditing);

		return modelAndView;
	}

	@PostMapping("/guardar")
	public ModelAndView saveNewProducto(
			@Valid @ModelAttribute(value = "producto") Producto producto,
			BindingResult resultadoValidacion) {

		ModelAndView modelAndView = new ModelAndView();

		if (resultadoValidacion.hasErrors()) {
			modelAndView.setViewName("nuevo_producto");
			modelAndView.addObject("listaCategorias", categoriaServiceImp.getAllCategorias());
		} else {
			unaCategoria = categoriaServiceImp.findCategoriaByIdentifier(producto.getCategoria().getIdentificador());
			producto.setCategoria(unaCategoria);
			productoServiceImp.addProducto(producto);

			modelAndView.setViewName("redirect:/productos/listado");	
			modelAndView.addObject("listaProductos", productoServiceImp.getAllProductos());
			modelAndView.addObject("listaCategorias", categoriaServiceImp.getAllCategorias());

		}

		return modelAndView;
	}

	@GetMapping("/modificar/{codigo}")
	public ModelAndView getModifyProductoPage(
			@PathVariable(value = "codigo") long codigo) {

		ModelAndView modelAndView = new ModelAndView();
		boolean allowEditing = true;

		unProducto = productoServiceImp.findProductoByCodigo(codigo);
		modelAndView.setViewName("nuevo_producto");
		modelAndView.addObject("producto", unProducto);
		modelAndView.addObject("listaCategorias", categoriaServiceImp.getAllCategorias());
		modelAndView.addObject("editar", allowEditing);

		return modelAndView;
	}

	@GetMapping("/eliminar/{codigo}")
	public ModelAndView deleteProducto(@PathVariable(value = "codigo") long codigo) {

		ModelAndView modelAndView = new ModelAndView();

		modelAndView.setViewName("redirect:/productos/listado");
		productoServiceImp.deleteProductoByCodigo(productoServiceImp.findProductoByCodigo(codigo));

		return modelAndView;
	}

}