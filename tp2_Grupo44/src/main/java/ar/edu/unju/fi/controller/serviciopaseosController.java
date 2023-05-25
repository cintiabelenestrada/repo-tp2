package ar.edu.unju.fi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ar.edu.unju.fi.lists.ServiciosList;

@Controller
@RequestMapping("/servicios")

public class serviciopaseosController {
	
	ServiciosList listaServicios = new ServiciosList ();
	
    @GetMapping("/listado")
    public String getServicioPaseosPage(Model model) {
    	
    	model.addAttribute("servicios", listaServicios.getServicios());
    	
        return "serviciopaseos";
    }
    
}
