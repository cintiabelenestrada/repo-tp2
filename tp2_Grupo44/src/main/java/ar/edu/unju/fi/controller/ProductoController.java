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

	//#region Components
	@Autowired
	private ProductoServiceImp productoServiceImp;

	@Autowired
	private CategoriaServiceImp categoriaServiceImp;

	@Autowired
	private Producto unProducto;

	@Autowired
	private Categoria unaCategoria;
	//#endregion
	String filtro="todos";

	//#region Methods
	@GetMapping("/listado")
	public ModelAndView getProductosPage() {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("productos");
		modelAndView.addObject("listaProductos", productoServiceImp.getProductos());
		modelAndView.addObject("listaCategorias", categoriaServiceImp.getCategorias());
		modelAndView.addObject("filtro",filtro);
		if(filtro!="todos")
			filtro="todos";
		System.out.println(filtro);
		return modelAndView;
	}

	@GetMapping("/formulario")
	public ModelAndView getNewProductoPage() {

		ModelAndView modelAndView = new ModelAndView();
		boolean allowEditing = false;

		unProducto = new Producto();
		modelAndView.setViewName("nuevo_producto");
		modelAndView.addObject("producto", unProducto);
		modelAndView.addObject("listaCategorias", categoriaServiceImp.getCategorias());
		modelAndView.addObject("editar", allowEditing);

		return modelAndView;
	}

	@PostMapping("/guardar")
	public ModelAndView saveNewProductoInformation(
			@Valid @ModelAttribute(value = "producto") Producto productoAgregar,
			BindingResult resultadoValidacion) {

		ModelAndView modelAndView = new ModelAndView();

		if (resultadoValidacion.hasErrors()) {
			modelAndView.setViewName("nuevo_producto");
			System.out.println("asdfasdf" + resultadoValidacion.toString());
			// modelAndView.addObject("productoo", productoAgregar);
			// modelAndView.addObject("listaCategorias", categoriaServiceImp.getCategorias());
		}	

		unaCategoria = categoriaServiceImp.findCategoriaByIdentifier(productoAgregar.getCategoria().getIdentificador());
		productoAgregar.setCategoria(unaCategoria);
		productoServiceImp.addProducto(productoAgregar);
		modelAndView.setViewName("redirect:/productos/listado");	
		modelAndView.addObject("listaProductos", productoServiceImp.getProductos());
		modelAndView.addObject("listaCategorias", categoriaServiceImp.getCategorias());
		
		return modelAndView;
	}

	@GetMapping("/modificar/{codigo}")
	public ModelAndView getModifyProductoPage(
			@PathVariable(value = "codigo") long codigoProducto) {

		ModelAndView modelAndView = new ModelAndView();
		boolean allowEditing = true;

		unProducto = productoServiceImp.findProductoByCode(codigoProducto);
		modelAndView.setViewName("nuevo_producto");
		modelAndView.addObject("producto", unProducto);
		modelAndView.addObject("listaCategorias", categoriaServiceImp.getCategorias());
		modelAndView.addObject("editar", allowEditing);

		return modelAndView;
	}

	@GetMapping("/eliminar/{codigo}")
	public ModelAndView deleteProducto(@PathVariable(value = "codigo") long codigoProducto) {

		ModelAndView modelAndView = new ModelAndView();

		modelAndView.setViewName("redirect:/productos/listado");
		productoServiceImp.deleteProductoByCode(productoServiceImp.findProductoByCode(codigoProducto));

		return modelAndView;
	}
	//#endregion

	@GetMapping("/filtrar/{categoria}")
	public ModelAndView deleteProducto(@PathVariable(value = "categoria") String categoria) {

		ModelAndView modelAndView = new ModelAndView();

		modelAndView.setViewName("redirect:/productos/listado");
		filtro=categoria;
		modelAndView.addObject("filtro",filtro);
		
		return modelAndView;
		
	}
}