package ar.edu.unju.fi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

import ar.edu.unju.fi.lists.SucursalList;

@Controller
public class sucursalesController {
    SucursalList listaSucursales = new SucursalList();

    @GetMapping("/sucursales")
    public String getSucursalesPage(Model model) {
        model.addAttribute(
                "listaSucursales",
                listaSucursales.getSucursales());

        model.addAttribute(
                "listaProvincias",
                listaSucursales.getProvincias());
        return "sucursales";
    }
}
