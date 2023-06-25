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
import ar.edu.unju.fi.service.imp.CategoriaServiceImp;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/categorias")
public class CategoriaController {
    
    //#region Components
    @Autowired
    private CategoriaServiceImp categoriaServiceImp;
    
    @Autowired
    private Categoria unaCategoria;

    @GetMapping("/listado")
    public ModelAndView getCategoriasPage() {

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("categorias");
        modelAndView.addObject("listaCategorias", categoriaServiceImp.getAllCategorias());

        return modelAndView;
    }

    @GetMapping("/formulario")
    public ModelAndView getNewCategoriaPage() {

        ModelAndView modelAndView = new ModelAndView();
        boolean allowEditing = false;

        unaCategoria = new Categoria();
        modelAndView.setViewName("nueva_categoria");
        modelAndView.addObject("categoria", unaCategoria);
        modelAndView.addObject("editar", allowEditing);

        return modelAndView;
    }

    @PostMapping("/guardar")
    public ModelAndView saveNewCategoria(
            @Valid @ModelAttribute(value = "categoria") Categoria categoria,
            BindingResult resultadoValidacion) {

        ModelAndView modelAndView = new ModelAndView();

        if (resultadoValidacion.hasErrors()) {
            modelAndView.setViewName("nueva_categoria");
        } else {
            categoriaServiceImp.addCategoria(categoria);

            modelAndView.setViewName("redirect:/categorias/listado");
            modelAndView.addObject("listaCategorias", categoriaServiceImp.getAllCategorias());
        }

        return modelAndView;
    }

    @GetMapping("/modificar/{identificador}")
    public ModelAndView getModifyCategoriaPage(
            @PathVariable(value = "identificador") long identificador) {

        ModelAndView modelAndView = new ModelAndView();
        boolean allowEditing = true;

        unaCategoria = categoriaServiceImp.findCategoriaByIdentifier(identificador);
        modelAndView.setViewName("nueva_categoria");
        modelAndView.addObject("categoria", unaCategoria);
        modelAndView.addObject("editar", allowEditing);

        return modelAndView;
    }

    @GetMapping("/eliminar/{identificador}")
    public ModelAndView deleteCategoria(
            @PathVariable(value = "identificador") long identificador) {
            
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("redirect:/categorias/listado");
        categoriaServiceImp.deleteCategoriaByIdentifier(categoriaServiceImp.findCategoriaByIdentifier(identificador));

        return modelAndView;
    }

}
