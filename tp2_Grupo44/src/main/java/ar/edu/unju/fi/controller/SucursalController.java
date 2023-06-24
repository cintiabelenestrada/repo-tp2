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
    private Sucursal unaSucursal;

    @Autowired
    private Provincia unaProvincia;

    @GetMapping("/listado")
    public ModelAndView getSucursalesPage() {

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("sucursales");
        modelAndView.addObject("listaSucursales", sucursalServiceImp.getSucursales());
        modelAndView.addObject("listaProvincias", provinciaServiceImp.getProvincias());

        return modelAndView;
    }

    @GetMapping("/formulario")
    public ModelAndView getNewSucursalPage() {

        ModelAndView modelAndView = new ModelAndView();
        boolean allowEditing = false;

        unaSucursal = new Sucursal();
        modelAndView.setViewName("nueva_sucursal");
        modelAndView.addObject("sucursal", unaSucursal);
        modelAndView.addObject("listaProvincias", provinciaServiceImp.getProvincias());
        modelAndView.addObject("editar", allowEditing);

        return modelAndView;
    }

    @PostMapping("/guardar")
    public ModelAndView saveNewSucursal(
            @Valid @ModelAttribute(value = "sucursal") Sucursal sucursalAgregar,
            BindingResult resultadoValidacion) {

        ModelAndView modelAndView = new ModelAndView();

        if (resultadoValidacion.hasErrors()) {
            modelAndView.setViewName("nueva_sucursal");
            // modelAndView.addObject("sucursal", sucursalAgregar);
            modelAndView.addObject("listaProvincias", provinciaServiceImp.getProvincias());
        }

        unaProvincia = provinciaServiceImp.findProvinciaByIdentifier(sucursalAgregar.getProvincia().getIdentificador());
        sucursalAgregar.setProvincia(unaProvincia);
        sucursalServiceImp.addSucursal(sucursalAgregar);
        modelAndView.setViewName("redirect:/sucursales/listado");
        modelAndView.addObject("listaSucursales", sucursalServiceImp.getSucursales());
        modelAndView.addObject("listaProvincias", provinciaServiceImp.getProvincias());

        return modelAndView;
    }

    @GetMapping("/modificar/{identificador}")
    public ModelAndView getModifySucursalPage(
            @PathVariable(value = "identificador") long identificadorSucursal) {

        ModelAndView modelAndView = new ModelAndView();
        boolean allowEditing = true;

        unaSucursal = sucursalServiceImp.findSucursalByIdentifier(identificadorSucursal);
        modelAndView.setViewName("nueva_sucursal");
        modelAndView.addObject("sucursal", unaSucursal);
        modelAndView.addObject("listaProvincias", provinciaServiceImp.getProvincias());
        modelAndView.addObject("editar", allowEditing);

        return modelAndView;
    }

    @GetMapping("/eliminar/{identificador}")
    public ModelAndView deleteSucursal(@PathVariable(value = "identificador") long identificadorSucursal) {

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("redirect:/sucursales/listado");
        sucursalServiceImp.deleteSucursalByIdentifier(sucursalServiceImp.findSucursalByIdentifier(identificadorSucursal));

        return modelAndView;
    }

}