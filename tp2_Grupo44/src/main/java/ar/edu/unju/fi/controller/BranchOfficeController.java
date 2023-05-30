package ar.edu.unju.fi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

import ar.edu.unju.fi.lists.BranchList;

@Controller
@RequestMapping("/sucursales")
public class BranchOfficeController {
    BranchList listaSucursales = new BranchList();

    @GetMapping("/listado")
    public String getBranchOfficePage(Model model) {

        model.addAttribute(
                "listaSucursales",
                listaSucursales.getSucursales());

        model.addAttribute(
                "listaProvincias",
                listaSucursales.getProvincias());

        return "sucursales";

    }
}
