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

import ar.edu.unju.fi.lists.DogWalkerList;
import ar.edu.unju.fi.lists.ImageList;
import ar.edu.unju.fi.model.DogWalker;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/servicio_de_paseos")
public class DogWalkingServiceController {

    @Autowired
    DogWalkerList listaPaseadores;

    @Autowired
    ImageList listaImagenes;

    @Autowired
    DogWalker paseador;

    @GetMapping("/listado")
    public String getDogWalkingServicePage(Model model) {

        model.addAttribute(
                "listaPaseadores",
                listaPaseadores.getPaseadores());

        model.addAttribute(
                "listaProvincias",
                listaPaseadores.getProvincias());

        model.addAttribute(
                "listaImagenes",
                listaImagenes.getImagenes());

        return "servicio_de_paseos";
    }

    @GetMapping("/nuevo")
    public String getNewDogWalkerPage(Model model) {

        boolean allowEditing = false;

        model.addAttribute(
                "paseador",
                paseador);

        model.addAttribute(
                "editar",
                allowEditing);

        return "nuevo_paseador";
    }

    @PostMapping("/guardar")
    public ModelAndView saveDogWalkerInformation(
            @Valid @ModelAttribute(value = "paseador") DogWalker paseadorAgregar,
            BindingResult resultadoValidacion) {

        ModelAndView modelAndView = new ModelAndView(
                "redirect:/servicio_de_paseos/listado");

        short identificadorContador = listaPaseadores.getPaseadores().get(listaPaseadores.getPaseadores().size() - 1)
                .getIdentificador();
        identificadorContador++;

        if (resultadoValidacion.hasErrors()) {

            modelAndView.setViewName(
                    "nuevo_paseador");

            modelAndView.addObject(
                    "paseador",
                    paseadorAgregar);

            return modelAndView;

        }

        paseadorAgregar.setIdentificador(identificadorContador);
        listaPaseadores.getPaseadores().add(paseadorAgregar);

        modelAndView.addObject(
                "listaPaseadores",
                listaPaseadores.getPaseadores());

        return modelAndView;
    }

    @GetMapping("/modificar/{identificador}")
    public String getModifyDogWalkerPage(
            Model model,
            @PathVariable(value = "identificador") short identificadorPaseador) {

        DogWalker DogWalkerFound = new DogWalker();
        boolean allowEditing = true;

        for (DogWalker paseador : listaPaseadores.getPaseadores()) {
            if (paseador.getIdentificador() == identificadorPaseador) {
                DogWalkerFound = paseador;
                break;
            }
        }

        model.addAttribute("paseador", DogWalkerFound);
        model.addAttribute("editar", allowEditing);

        return "nuevo_paseador";
    }

    @PostMapping("/modificar")
    public ModelAndView modifyDogWalker(
            @Valid @ModelAttribute(value = "paseador") DogWalker paseadorModificar,
            BindingResult resultadoValidacion) {

        ModelAndView modelAndView = new ModelAndView(
                "redirect:/servicio_de_paseos/listado");

        boolean allowEditing = true;

        if (resultadoValidacion.hasErrors()) {

            modelAndView.setViewName("nuevo_paseador");

            modelAndView.addObject(
                    "paseador",
                    paseadorModificar);

            modelAndView.addObject(
                    "editar",
                    allowEditing);

            return modelAndView;
        }

        for (DogWalker paseador : listaPaseadores.getPaseadores()) {
            if (paseador.getIdentificador() == paseadorModificar.getIdentificador()) {
                paseador.setNombre(paseadorModificar.getNombre());
                paseador.setApellido(paseadorModificar.getApellido());
                paseador.setDiaDisponible(paseadorModificar.getDiaDisponible());
                paseador.setHorarioDisponibleDesde(paseadorModificar.getHorarioDisponibleDesde());
                paseador.setHorarioDisponibleHasta(paseadorModificar.getHorarioDisponibleHasta());
                paseador.setProvincia(paseadorModificar.getProvincia());
                break;
            }
        }

        return modelAndView;
    }

    @GetMapping("/eliminar/{identificador}")
    public String deleteDogWalker(
            @PathVariable(value = "identificador") short identificadorPaseador) {

        for (DogWalker paseador : listaPaseadores.getPaseadores()) {
            if (paseador.getIdentificador() == identificadorPaseador) {
                listaPaseadores.getPaseadores().remove(paseador);
                break;
            }
        }

        return ("redirect:/servicio_de_paseos/listado");
    }

}
