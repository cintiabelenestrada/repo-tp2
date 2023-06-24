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

        ModelAndView modelAndView = new ModelAndView("provincias");
        modelAndView.addObject("listaProvincias", provinciaServiceImp.getProvincias());

        return modelAndView;
    }

    @GetMapping("/formulario")
    public ModelAndView getNewProvinciaPage() {

        ModelAndView modelAndView = new ModelAndView();
        boolean allowEditing = false;

        modelAndView.setViewName("nueva_provincia");
        modelAndView.addObject("provincia", provinciaServiceImp.getProvincia());
        modelAndView.addObject("editar", allowEditing);

        return modelAndView;
    }

    @PostMapping("/guardar")
    public ModelAndView saveNewProvincia(
            @Valid @ModelAttribute(value = "provincia") Provincia provinciaAgregar,
            BindingResult resultadoValidacion) {

        ModelAndView modelAndView = new ModelAndView();

        if (resultadoValidacion.hasErrors()) {
            modelAndView.setViewName("nueva_provincia");
            // modelAndView.addObject("provincia", provinciaAgregar);
        } else {
            modelAndView.setViewName("redirect:/provincias/listado");
            provinciaServiceImp.saveNewProvincia(provinciaAgregar);
            modelAndView.addObject("listaProvincias", provinciaServiceImp.getProvincias());
        }

        return modelAndView;

    }

    @GetMapping("/modificar/{identificador}")
    public ModelAndView getModifySucursalPage(
            @PathVariable(value = "identificador") long identificadorSucursal) {

        ModelAndView modelAndView = new ModelAndView();
        boolean allowEditing = true;

        provincia = provinciaServiceImp.findProvinciaByIdentifier(identificadorSucursal);

        modelAndView.setViewName("nueva_provincia");
        modelAndView.addObject("provincia", provincia);
        modelAndView.addObject("editar", allowEditing);

        return modelAndView;
    }

    @GetMapping("/eliminar/{identificador}")
    public ModelAndView deleteProvincia(
            @PathVariable(value = "identificador") long identificadorProvincia) {
            
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("redirect:/provincias/listado");
        provinciaServiceImp.deleteProvinciaByIdentifier(provinciaServiceImp.findProvinciaByIdentifier(identificadorProvincia));

        return modelAndView;
    }

}