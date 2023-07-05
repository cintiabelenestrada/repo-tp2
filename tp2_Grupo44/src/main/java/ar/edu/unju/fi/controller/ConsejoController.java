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

import ar.edu.unju.fi.entity.Consejo;
import ar.edu.unju.fi.service.IConsejoService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/consejos_de_salud")
public class ConsejoController {

    @Autowired
    private IConsejoService healthTipService;

    @GetMapping("/listado")
    public String getHealthTipPage(Model model) {

        model.addAttribute("listaConsejos", healthTipService.getConsejos());

        return "consejos_de_salud";
    }

    @GetMapping("/nuevo")
    public String getNewHealthTipPage(Model model) {

        boolean allowEditing = false;

        model.addAttribute("consejo", healthTipService.getHealthTip());
        model.addAttribute("editar", allowEditing);

        return "nuevo_consejo_de_salud";
    }

    @PostMapping("/guardar")
    public ModelAndView saveHealthTipInformation(
            @Valid @ModelAttribute(value = "consejo") Consejo consejoAgregar,
            BindingResult resultadoValidacion) {

        ModelAndView modelAndView = new ModelAndView("redirect:/consejos_de_salud/listado");

        if (resultadoValidacion.hasErrors()) {
            modelAndView.setViewName("nuevo_consejo_de_salud");
            modelAndView.addObject("consejo", consejoAgregar);
            return modelAndView;
        }

        healthTipService.setHealthTipIdentifier(consejoAgregar);
        healthTipService.saveNewHealthTip(consejoAgregar);

        modelAndView.addObject("listaConsejos",healthTipService.getConsejos());

        return modelAndView;
    }

    @GetMapping("/modificar/{identificador}")
    public String getModifyHealthTipPage(
            Model model,
            @PathVariable(value = "identificador") short identificadorConsejo) {

        Consejo healthTipFound = healthTipService.findHealthTipByIdentifier(identificadorConsejo);
        boolean allowEditing = true;

        model.addAttribute("consejo", healthTipFound);
        model.addAttribute("editar", allowEditing);

        return "nuevo_consejo_de_salud";
    }

    @PostMapping("/modificar")
    public ModelAndView modifyHealthTip(
            @Valid @ModelAttribute(value = "consejo") Consejo consejoModificar,
            BindingResult resultadoValidacion) {

        ModelAndView modelAndView = new ModelAndView("redirect:/consejos_de_salud/listado");
        boolean allowEditing = true;

        if (resultadoValidacion.hasErrors()) {
            modelAndView.setViewName("nuevo_consejo_de_salud");
            modelAndView.addObject("consejo", consejoModificar);
            modelAndView.addObject("editar", allowEditing);
            return modelAndView;
        }

        healthTipService.modifyHealthTipByIdentifier(consejoModificar);

        return modelAndView;
    }

    @GetMapping("/eliminar/{identificador}")
    public String deleteHealthTip(
            @PathVariable(value = "identificador") short identificadorConsejo) {

        healthTipService.deleteHealthTipByIdentifier(identificadorConsejo);

        return ("redirect:/consejos_de_salud/listado");
    }

}