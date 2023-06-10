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

import ar.edu.unju.fi.model.Branch;
import ar.edu.unju.fi.service.IBranchService;
import ar.edu.unju.fi.service.ICommonService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/sucursales")
public class BranchOfficeController {

    @Autowired
    private IBranchService branchService;

    @Autowired
    private ICommonService commonService;

    @GetMapping("/listado")
    public String getBranchOfficePage(Model model) {

        model.addAttribute("listaSucursales", branchService.getSucursales());
        model.addAttribute("listaProvincias", branchService.getProvincias());
        model.addAttribute("listaImagenes", commonService.getImagenes());
        
        return "sucursales";
    }

    @GetMapping("/nuevo")
    public String getNewBranchOfficePage(Model model) {

        boolean allowEditing = false;

        model.addAttribute("sucursal", branchService.getBranch());
        model.addAttribute("editar", allowEditing);

        return "nueva_sucursal";
    }

    @PostMapping("/guardar")
    public ModelAndView saveBranchOfficeInformation(
            @Valid @ModelAttribute(value = "sucursal") Branch sucursalAgregar,
            BindingResult resultadoValidacion) {

        ModelAndView modelAndView = new ModelAndView("redirect:/sucursales/listado");

        if (resultadoValidacion.hasErrors()) {
            modelAndView.setViewName("nueva_sucursal");
            modelAndView.addObject("sucursal", sucursalAgregar);
            return modelAndView;
        }

        branchService.setBranchOfficeIdentifier(sucursalAgregar);
        branchService.saveNewBranchOffice(sucursalAgregar);

        modelAndView.addObject("listaSucursales",branchService.getSucursales());

        return modelAndView;
    }

    @GetMapping("/modificar/{identificador}")
    public String getModifyBranchOfficePage(
            Model model,
            @PathVariable(value = "identificador") short identificadorSucursal) {

        Branch branchFound = branchService.findBranchOfficeByIdentifier(identificadorSucursal);
        boolean allowEditing = true;

        model.addAttribute("sucursal", branchFound);
        model.addAttribute("editar", allowEditing);

        return "nueva_sucursal";
    }

    @PostMapping("/modificar")
    public ModelAndView modifyBranchOffice(
            @Valid @ModelAttribute(value = "sucursal") Branch sucursalModificar,
            BindingResult resultadoValidacion) {

        ModelAndView modelAndView = new ModelAndView("redirect:/sucursales/listado");
        boolean allowEditing = true;

        if (resultadoValidacion.hasErrors()) {
            modelAndView.setViewName("nueva_sucursal");
            modelAndView.addObject("sucursal", sucursalModificar);
            modelAndView.addObject("editar", allowEditing);
            return modelAndView;
        }

        branchService.modifyBranchOfficeByIdentifier(sucursalModificar);

        return modelAndView;
    }

    @GetMapping("/eliminar/{identificador}")
    public String deleteBranchOffice(
            @PathVariable(value = "identificador") short identificadorSucursal) {

        branchService.deleteBranchOfficeByIdentifier(identificadorSucursal);

        return ("redirect:/sucursales/listado");
    }

}
