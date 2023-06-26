package ar.edu.unju.fi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/gestion_de_datos")
public class GestionController {

    @GetMapping("listado")
    public ModelAndView getGestionPage() {
        ModelAndView modelAndView = new ModelAndView("gestion_de_datos");
        return modelAndView;
    }

    @GetMapping("/categoria/{seleccion}")
    public ModelAndView getCategoriaPage(
        @PathVariable(value = "seleccion") String seleccion) {
        
        ModelAndView modelAndView = new ModelAndView();

        if (seleccion.equals("formulario")) {
            modelAndView.setViewName("redirect:/categorias/formulario");
        }

        if (seleccion.equals("listado")) {
            modelAndView.setViewName("redirect:/categorias/listado");
        }
        
        return modelAndView;
    }

    @GetMapping("/provincia/{seleccion}")
    public ModelAndView getProvinciaPage(
        @PathVariable(value = "seleccion") String seleccion) {
        
        ModelAndView modelAndView = new ModelAndView();

        if (seleccion.equals("formulario")) {
            modelAndView.setViewName("redirect:/provincias/formulario");
        }

        if (seleccion.equals("listado")) {
            modelAndView.setViewName("redirect:/provincias/listado");
        }

        return modelAndView;
    }

    @GetMapping("/sucursal/{seleccion}")
    public ModelAndView getSucursalPage(
        @PathVariable(value = "seleccion") String seleccion) {
        
        ModelAndView modelAndView = new ModelAndView();

        if (seleccion.equals("formulario")) {
            modelAndView.setViewName("redirect:/sucursales/formulario");
        }

        if (seleccion.equals("listado")) {
            modelAndView.setViewName("redirect:/sucursales/listado");
        }

        return modelAndView;
    }

    @GetMapping("/empleado/{seleccion}")
    public ModelAndView getEmpleadoPage(
        @PathVariable(value = "seleccion") String seleccion) {
        
        ModelAndView modelAndView = new ModelAndView();

        if (seleccion.equals("formulario")) {
            modelAndView.setViewName("redirect:/empleados/formulario");
        }

        if (seleccion.equals("listado")) {
            modelAndView.setViewName("redirect:/empleados/listado");
        }

        return modelAndView;
    }

    @GetMapping("/producto/{seleccion}")
    public ModelAndView getProductoPage(
        @PathVariable(value = "seleccion") String seleccion) {
        
        ModelAndView modelAndView = new ModelAndView();

        if (seleccion.equals("formulario")) {
            modelAndView.setViewName("redirect:/productos/formulario");
        }

        if (seleccion.equals("listado")) {
            modelAndView.setViewName("redirect:/productos/listado");
        }

        return modelAndView;
    }

    @GetMapping("/servicio/{seleccion}")
    public ModelAndView getServicioPage(
        @PathVariable(value = "seleccion") String seleccion) {
        
        ModelAndView modelAndView = new ModelAndView();

        if (seleccion.equals("formulario")) {
            modelAndView.setViewName("redirect:/servicios/formulario");
        }

        if (seleccion.equals("listado")) {
            modelAndView.setViewName("redirect:/servicios/listado");
        }

        return modelAndView;
    }
    
}
