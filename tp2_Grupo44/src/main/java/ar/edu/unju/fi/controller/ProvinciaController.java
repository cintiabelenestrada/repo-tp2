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

import ar.edu.unju.fi.entity.Provincia;
import ar.edu.unju.fi.service.imp.ProvinciaServiceImp;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/provincias")
public class ProvinciaController {

    
    @Autowired
    private ProvinciaServiceImp provinciaServiceImp;

    @Autowired
    private Provincia provincia;

    @GetMapping("/listado")
    public ModelAndView getProvinciasPage() {

        // Aggrego la vista
        ModelAndView modelAndView = new ModelAndView("provincias");
        // Agrego la lista de provincias y la lista de provincias <-(revisar)
        modelAndView.addObject("listaProvincias", provinciaServiceImp.getProvincias());
        // Implementar al último
        // model.addAttribute("listaImagenes", commonService.getImagenes());

        return modelAndView;

    }

    @GetMapping("/formulario")
    public ModelAndView getNewProvinciaPage() {

        ModelAndView modelAndView = new ModelAndView("nueva_provincia");
        boolean allowEditing = false;
        
        modelAndView.addObject("provincia", provinciaServiceImp.getProvincia());
        modelAndView.addObject("editar", allowEditing);

        return modelAndView;

    }

    @PostMapping("/guardar")
    public ModelAndView saveNewProvincia(
            @Valid @ModelAttribute(value = "provincia") Provincia provinciaAgregar,
            BindingResult resultadoValidacion) {

        ModelAndView modelAndView = new ModelAndView("redirect:/provincias/listado");

        if (resultadoValidacion.hasErrors()) {
            modelAndView.setViewName("nueva_provincia");
            modelAndView.addObject("provincia", provinciaAgregar);
        } else {
            provinciaServiceImp.saveNewProvincia(provinciaAgregar);
            modelAndView.addObject("listaProvincias", provinciaServiceImp.getProvincias());
        }

        return modelAndView;

    }

    /*
     * @GetMapping("/modificar/{identificador}")
     * public String getModifySucursalPage(
     * Model model,
     * 
     * @PathVariable(value = "identificador") Long identificadorSucursal) {
     * 
     * Branch branchFound =
     * branchService.findBranchOfficeByIdentifier(identificadorSucursal);
     * boolean allowEditing = true;
     * 
     * model.addAttribute("sucursal", branchFound);
     * model.addAttribute("editar", allowEditing);
     * 
     * return "nueva_sucursal";
     * }
     */

    /*
     * @PostMapping("/modificar")
     * public ModelAndView modifySucursal(
     * 
     * @Valid @ModelAttribute(value = "sucursal") Branch sucursalModificar,
     * BindingResult resultadoValidacion) {
     * 
     * ModelAndView modelAndView = new ModelAndView("redirect:/provincias/listado");
     * boolean allowEditing = true;
     * 
     * if (resultadoValidacion.hasErrors()) {
     * modelAndView.setViewName("nueva_sucursal");
     * modelAndView.addObject("sucursal", sucursalModificar);
     * modelAndView.addObject("editar", allowEditing);
     * return modelAndView;
     * }
     * 
     * branchService.modifyBranchOfficeByIdentifier(sucursalModificar);
     * 
     * return modelAndView;
     * }
     */

    @GetMapping("/eliminar/{identificador}")
    public String deleteProvincia(
            @PathVariable(value = "identificador") Long identificadorProvincia) {

        // branchService.deleteBranchOfficeByIdentifier(identificadorSucursal);

        provinciaServiceImp.deleteProvinciaByIdentifier(provinciaServiceImp.findProvinciaByIdentifier(identificadorProvincia));

        return ("redirect:/provincias/listado");
    }
    
}
