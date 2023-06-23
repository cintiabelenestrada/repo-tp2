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
import ar.edu.unju.fi.entity.Sucursal;
import ar.edu.unju.fi.service.imp.ProvinciaServiceImp;
import ar.edu.unju.fi.service.imp.SucursalServiceImp;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/sucursales")
public class SucursalController {

    @Autowired
    private SucursalServiceImp sucursalServiceImp;

    @Autowired
    private ProvinciaServiceImp provinciaServiceImp;

    @Autowired
    private Sucursal sucursal;

    @Autowired
    private Provincia provincia;

    // @Autowired
    // private ICommonService commonService;

    @GetMapping("/listado")
    public ModelAndView getSucursalesPage() {

        ModelAndView modelAndView = new ModelAndView("sucursales");
        modelAndView.addObject("listaSucursales", sucursalServiceImp.getSucursales());
        modelAndView.addObject("listaProvincias", provinciaServiceImp.getProvincias());
        // Implementar al último
        // model.addAttribute("listaImagenes", commonService.getImagenes());

        return modelAndView;

    }

    @GetMapping("/formulario")
    public ModelAndView getNewSucursalPage() {

        ModelAndView modelAndView = new ModelAndView("nueva_sucursal");
        boolean allowEditing = false;
        sucursal = new Sucursal();

        // modelAndView.addObject("sucursal", sucursalServiceImp.getSucursal());
        modelAndView.addObject("sucursal", sucursal);
        modelAndView.addObject("listaProvincias", provinciaServiceImp.getProvincias());
        modelAndView.addObject("editar", allowEditing);

        return modelAndView;

    }

    @PostMapping("/guardar")
    public ModelAndView saveNewSucursal(
            @Valid @ModelAttribute(value = "sucursal") Sucursal sucursalAgregar,
            BindingResult resultadoValidacion) {

        ModelAndView modelAndView = new ModelAndView("redirect:/sucursales/listado");

        if (resultadoValidacion.hasErrors()) {
            
            modelAndView.setViewName("nueva_sucursal");
            modelAndView.addObject("sucursal", sucursalAgregar);
            modelAndView.addObject("listaProvincias", provinciaServiceImp.getProvincias());

        } else {

            provincia = provinciaServiceImp.findProvinciaByIdentifier(sucursalAgregar.getProvincia().getIdentificador());
            sucursalAgregar.setProvincia(provincia);
            sucursalServiceImp.saveNewSucursal(sucursalAgregar);
            modelAndView.addObject("listaSucursales", sucursalServiceImp.getSucursales());

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
     * ModelAndView modelAndView = new ModelAndView("redirect:/sucursales/listado");
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
    public String deleteSucursal(
            @PathVariable(value = "identificador") Long identificadorSucursal) {

        // branchService.deleteBranchOfficeByIdentifier(identificadorSucursal);

        sucursalServiceImp.deleteSucursalByIdentifier(sucursalServiceImp.findSucursalByIdentifier(identificadorSucursal));

        return ("redirect:/sucursales/listado");
    }

}
