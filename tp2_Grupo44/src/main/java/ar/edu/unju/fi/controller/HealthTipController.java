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

import ar.edu.unju.fi.lists.HealthTipList;
import ar.edu.unju.fi.model.HealthTip;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/consejos_de_salud")
public class HealthTipController {

    @Autowired
    HealthTipList listaConsejos;

    @Autowired
    HealthTip consejo;

    @GetMapping("/listado")
    public String getHealthTipPage(Model model) {

        model.addAttribute(
            "listaConsejos",
            listaConsejos.getConsejos()
        );

        return "consejos_de_salud";
    }

    @GetMapping("/nuevo")
    public String getNewHealthTipPage(Model model) {

        boolean allowEditing = false;

        model.addAttribute(
                "consejo",
                consejo);

        model.addAttribute(
                "editar",
                allowEditing);

        return "nuevo_consejo_de_salud";
    }

    @PostMapping("/guardar")
    public ModelAndView saveHealthTipInformation(
            @Valid @ModelAttribute(value = "consejo") HealthTip consejoAgregar,
            BindingResult resultadoValidacion) {

        ModelAndView modelAndView = new ModelAndView(
                "redirect:/consejos_de_salud/listado");

        short identificadorContador = listaConsejos.getConsejos().get(listaConsejos.getConsejos().size() - 1).getIdentificador();
        identificadorContador++;

        if (resultadoValidacion.hasErrors()) {

            modelAndView.setViewName(
                    "nuevo_consejo_de_salud");

            modelAndView.addObject(
                    "consejo",
                    consejoAgregar);

            return modelAndView;

        }

        consejoAgregar.setIdentificador(identificadorContador);
        listaConsejos.getConsejos().add(consejoAgregar);

        modelAndView.addObject(
                "listaConsejos",
                listaConsejos.getConsejos());

        return modelAndView;
    }

    @PostMapping("/modificar")
    public ModelAndView modifyBranchOffice(
            @Valid @ModelAttribute(value = "consejo") HealthTip consejoModificar,
            BindingResult resultadoValidacion) {

        ModelAndView modelAndView = new ModelAndView(
                "redirect:/consejos_de_salud/listado");

        boolean allowEditing = true;

        if (resultadoValidacion.hasErrors()) {

            modelAndView.setViewName("nuevo_consejo_de_salud");

            modelAndView.addObject(
                    "consejo",
                    consejoModificar);

            modelAndView.addObject(
                    "editar",
                    allowEditing);

            return modelAndView;
        }

        for (HealthTip consejo : listaConsejos.getConsejos()) {
            if (consejo.getIdentificador() == consejoModificar.getIdentificador()) {
                consejo.setTitulo(consejoModificar.getTitulo());
                consejo.setContenido(consejoModificar.getContenido());
                consejo.setFechaPublicacion(consejoModificar.getFechaPublicacion());
                break;
            }
        }

        return modelAndView;
    }

    @GetMapping("/modificar/{identificador}")
    public String getModifyHealthTipPage(
            Model model,
            @PathVariable(value = "identificador") short identificadorConsejo) {

        HealthTip healthTipFound = new HealthTip();
        boolean allowEditing = true;

        for (HealthTip consejo : listaConsejos.getConsejos()) {
            if (consejo.getIdentificador() == identificadorConsejo) {
                healthTipFound = consejo;
                break;
            }
        }

        model.addAttribute("consejo", healthTipFound);
        model.addAttribute("editar", allowEditing);

        return "nuevo_consejo_de_salud";
    }

    @GetMapping("/eliminar/{identificador}")
    public String deleteBranchOffice(
            @PathVariable(value = "identificador") short identificadorConsejo) {

        for (HealthTip consejo : listaConsejos.getConsejos()) {
            if (consejo.getIdentificador() == identificadorConsejo) {
                listaConsejos.getConsejos().remove(consejo);
                break;
            }
        }

        return ("redirect:/consejos_de_salud/listado");
    }

}
