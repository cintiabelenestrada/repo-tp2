package ar.edu.unju.fi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ar.edu.unju.fi.lists.DogWalkerList;

@Controller
@RequestMapping("/servicio_de_paseos")
public class DogWalkingServiceController {

    DogWalkerList listaServicios = new DogWalkerList();

    @GetMapping("/listado")
    public String getDogWalkingServicePage(Model model) {

        model.addAttribute(
                "servicios",
                listaServicios.getServicios());

        return "servicio_de_paseos";

    }

}
