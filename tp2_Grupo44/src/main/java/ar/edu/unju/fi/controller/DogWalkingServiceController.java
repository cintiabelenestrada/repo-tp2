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

import ar.edu.unju.fi.model.DogWalker;
import ar.edu.unju.fi.service.ICommonService;
import ar.edu.unju.fi.service.IDogWalkerService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/servicio_de_paseos")
public class DogWalkingServiceController {

    @Autowired
    private IDogWalkerService dogWalkerService;
    
    @Autowired
    private ICommonService commonService;

    @GetMapping("/listado")
    public String getDogWalkingServicePage(Model model) {

        model.addAttribute("listaPaseadores", dogWalkerService.getPaseadores());
        model.addAttribute("listaProvincias", dogWalkerService.getProvincias());
        model.addAttribute("listaImagenes", commonService.getImagenes());

        return "servicio_de_paseos";
    }

    @GetMapping("/nuevo")
    public String getNewDogWalkerPage(Model model) {

        boolean allowEditing = false;

        model.addAttribute("paseador", dogWalkerService.getDogWalker());
        model.addAttribute("editar", allowEditing);

        return "nuevo_paseador";
    }

    @PostMapping("/guardar")
    public ModelAndView saveDogWalkerInformation(
            @Valid @ModelAttribute(value = "paseador") DogWalker paseadorAgregar,
            BindingResult resultadoValidacion) {

        ModelAndView modelAndView = new ModelAndView("redirect:/servicio_de_paseos/listado");

        if (resultadoValidacion.hasErrors()) {
            modelAndView.setViewName("nuevo_paseador");
            modelAndView.addObject("paseador", paseadorAgregar);
            return modelAndView;
        }

        dogWalkerService.setDogWalkerIdentifier(paseadorAgregar);
        dogWalkerService.saveNewDogWalker(paseadorAgregar);

        modelAndView.addObject("listaPaseadores", dogWalkerService.getPaseadores());

        return modelAndView;
    }

    @GetMapping("/modificar/{identificador}")
    public String getModifyDogWalkerPage(
            Model model,
            @PathVariable(value = "identificador") short identificadorPaseador) {

        DogWalker DogWalkerFound = dogWalkerService.findDogWalkerByIdentifier(identificadorPaseador);
        boolean allowEditing = true;

        model.addAttribute("paseador", DogWalkerFound);
        model.addAttribute("editar", allowEditing);

        return "nuevo_paseador";
    }

    @PostMapping("/modificar")
    public ModelAndView modifyDogWalker(
            @Valid @ModelAttribute(value = "paseador") DogWalker paseadorModificar,
            BindingResult resultadoValidacion) {

        ModelAndView modelAndView = new ModelAndView("redirect:/servicio_de_paseos/listado");
        boolean allowEditing = true;

        if (resultadoValidacion.hasErrors()) {
            modelAndView.setViewName("nuevo_paseador");
            modelAndView.addObject("paseador", paseadorModificar);
            modelAndView.addObject("editar", allowEditing);
            return modelAndView;
        }

        dogWalkerService.modifyDogWalkerByIdentifier(paseadorModificar);

        return modelAndView;
    }

    @GetMapping("/eliminar/{identificador}")
    public String deleteDogWalker(
            @PathVariable(value = "identificador") short identificadorPaseador) {

        dogWalkerService.deleteDogWalkerByIdentifier(identificadorPaseador);

        return ("redirect:/servicio_de_paseos/listado");
    }

}
