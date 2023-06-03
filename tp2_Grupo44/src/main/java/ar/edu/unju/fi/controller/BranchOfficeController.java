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

import ar.edu.unju.fi.lists.BranchList;
import ar.edu.unju.fi.model.Branch;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/sucursales")
public class BranchOfficeController {

    @Autowired
    BranchList listaSucursales;

    @Autowired
    Branch sucursal;

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

    @GetMapping("/nuevo")
    public String getNewBranchOfficePage(Model model) {

        boolean allowEditing = false;

        model.addAttribute(
                "sucursal",
                sucursal);

        model.addAttribute(
                "editar",
                allowEditing);

        return "nueva_sucursal";
    }

    @PostMapping("/guardar")
    public ModelAndView saveBranchOfficeInformation(
            @Valid @ModelAttribute(value = "sucursal") Branch sucursalAgregar,
            BindingResult resultadoValidacion) {

        ModelAndView modelAndView = new ModelAndView(
                "redirect:/sucursales/listado");

        short identificadorContador = listaSucursales.getSucursales().get(listaSucursales.getSucursales().size() - 1)
                .getIdentificador();
        ++identificadorContador;

        if (resultadoValidacion.hasErrors()) {

            modelAndView.setViewName(
                    "nueva_sucursal");

            modelAndView.addObject(
                    "sucursal",
                    sucursalAgregar);

            return modelAndView;

        }

        sucursalAgregar.setIdentificador(identificadorContador);
        listaSucursales.getSucursales().add(sucursalAgregar);

        modelAndView.addObject(
                "listaSucursales",
                listaSucursales.getSucursales());

        return modelAndView;

    }

    @GetMapping("/modificar/{identificador}")
    public String getModifyBranchOfficePage(
            Model model,
            @PathVariable(value = "identificador") short identificadorSucursal) {

        Branch BranchFound = new Branch();
        boolean allowEditing = true;

        for (Branch paseador : listaSucursales.getSucursales()) {
            if (paseador.getIdentificador() == identificadorSucursal) {
                BranchFound = paseador;
                break;
            }
        }

        model.addAttribute("sucursal", BranchFound);
        model.addAttribute("editar", allowEditing);

        return "nueva_sucursal";
    }

    @PostMapping("/modificar")
    public ModelAndView modifyBranchOffice(
            @Valid @ModelAttribute(value = "sucursal") Branch sucursalModificar,
            BindingResult resultadoValidacion) {

        ModelAndView modelAndView = new ModelAndView(
                "redirect:/sucursales/listado");

        boolean allowEditing = true;

        if (resultadoValidacion.hasErrors()) {

            modelAndView.setViewName("nueva_sucursal");

            modelAndView.addObject(
                    "sucursal",
                    sucursalModificar);

            modelAndView.addObject(
                    "editar",
                    allowEditing);

            return modelAndView;

        }

        for (Branch sucursal : listaSucursales.getSucursales()) {
            if (sucursal.getIdentificador() == sucursalModificar.getIdentificador()) {
                sucursal.setNombre(sucursalModificar.getNombre());
                sucursal.setDireccion(sucursalModificar.getDireccion());
                sucursal.setNumeroDireccion(sucursalModificar.getNumeroDireccion());
                sucursal.setTelefono(sucursalModificar.getTelefono());
                sucursal.setProvincia(sucursalModificar.getProvincia());
                sucursal.setIdentificador(sucursalModificar.getIdentificador());
                break;
            }
        }

        return modelAndView;
    }

    @GetMapping("/eliminar/{identificador}")
    public String deleteBranchOffice(
            @PathVariable(value = "identificador") short identificadorSucursal) {

        for (Branch sucursal : listaSucursales.getSucursales()) {
            if (sucursal.getIdentificador() == identificadorSucursal) {
                listaSucursales.getSucursales().remove(sucursal);
                break;
            }
        }

        return ("redirect:/sucursales/listado");
    }

}
