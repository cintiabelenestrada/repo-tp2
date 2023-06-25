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
    private Sucursal unaSucursal;

    @Autowired
    private Provincia unaProvincia;

    @Autowired
    private SucursalServiceImp sucursalServiceImp;

    @Autowired
    private ProvinciaServiceImp provinciaServiceImp;

    @GetMapping("/listado")
    public ModelAndView getSucursalesPage() {

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("sucursales");
        modelAndView.addObject("listaSucursales", sucursalServiceImp.getAllSucursales());
        modelAndView.addObject("listaProvincias", provinciaServiceImp.getAllProvincias());

        return modelAndView;
    }

    @GetMapping("/formulario")
    public ModelAndView getNewSucursalPage() {

        ModelAndView modelAndView = new ModelAndView();
        boolean allowEditing = false;

        unaSucursal = new Sucursal();
        modelAndView.setViewName("nueva_sucursal");
        modelAndView.addObject("sucursal", unaSucursal);
        modelAndView.addObject("listaProvincias", provinciaServiceImp.getAllProvincias());
        modelAndView.addObject("editar", allowEditing);

        return modelAndView;
    }

    @PostMapping("/guardar")
    public ModelAndView saveNewSucursal(
            @Valid @ModelAttribute(value = "sucursal") Sucursal sucursal,
            BindingResult resultadoValidacion) {

        ModelAndView modelAndView = new ModelAndView();

        if (resultadoValidacion.hasErrors()) {
            modelAndView.setViewName("nueva_sucursal");
            modelAndView.addObject("listaProvincias", provinciaServiceImp.getAllProvincias());
        } else {
            unaProvincia = provinciaServiceImp.findProvinciaByIdentifier(sucursal.getProvincia().getIdentificador());
            sucursal.setProvincia(unaProvincia);
            sucursalServiceImp.addSucursal(sucursal);
            
            modelAndView.setViewName("redirect:/sucursales/listado");
            modelAndView.addObject("listaSucursales", sucursalServiceImp.getAllSucursales());
            modelAndView.addObject("listaProvincias", provinciaServiceImp.getAllProvincias());
        }

        return modelAndView;
    }

    @GetMapping("/modificar/{identificador}")
    public ModelAndView getModifySucursalPage(
            @PathVariable(value = "identificador") long identificador) {

        ModelAndView modelAndView = new ModelAndView();
        boolean allowEditing = true;

        unaSucursal = sucursalServiceImp.findSucursalByIdentifier(identificador);
        modelAndView.setViewName("nueva_sucursal");
        modelAndView.addObject("sucursal", unaSucursal);
        modelAndView.addObject("listaProvincias", provinciaServiceImp.getAllProvincias());
        modelAndView.addObject("editar", allowEditing);

        return modelAndView;
    }

    @GetMapping("/eliminar/{identificador}")
    public ModelAndView deleteSucursal(
        @PathVariable(value = "identificador") long identificador) {

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("redirect:/sucursales/listado");
        sucursalServiceImp.deleteSucursalByIdentifier(sucursalServiceImp.findSucursalByIdentifier(identificador));

        return modelAndView;
    }

}