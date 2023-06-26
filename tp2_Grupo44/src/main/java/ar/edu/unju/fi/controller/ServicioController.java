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

import ar.edu.unju.fi.entity.Empleado;
import ar.edu.unju.fi.entity.Servicio;
import ar.edu.unju.fi.service.imp.EmpleadoServiceImp;
import ar.edu.unju.fi.service.imp.ServicioServiceImp;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/servicios")
public class ServicioController {

    @Autowired
    private Servicio unServicio;

    @Autowired
    private Empleado unEmpleado;

    @Autowired
    private ServicioServiceImp servicioServiceImp;

    @Autowired
    private EmpleadoServiceImp empleadoServiceImp;

    @GetMapping("/listado")
    public ModelAndView getServiciosPage() {

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("servicios");
        modelAndView.addObject("listaServicios", servicioServiceImp.getAllServicios());
        modelAndView.addObject("listaEmpleados", empleadoServiceImp.getAllEmpleados());

        return modelAndView;
    }

    @GetMapping("/formulario")
    public ModelAndView getNewServicioPage() {

        ModelAndView modelAndView = new ModelAndView();
        boolean allowEditing = false;

        unServicio = new Servicio();
        modelAndView.setViewName("nuevo_servicio");
        modelAndView.addObject("servicio", unServicio);
        modelAndView.addObject("listaEmpleados", empleadoServiceImp.getAllEmpleados());
        modelAndView.addObject("editar", allowEditing);

        return modelAndView;
    }

    @PostMapping("/guardar")
    public ModelAndView saveServicio(
            @Valid @ModelAttribute(value = "servicio") Servicio servicio,
            BindingResult resultadoValidacion) {

        ModelAndView modelAndView = new ModelAndView();

        if (resultadoValidacion.hasErrors()) {
            modelAndView.setViewName("nuevo_servicio");
            modelAndView.addObject("listaEmpleados", empleadoServiceImp.getAllEmpleados());
        } else {
            unEmpleado = empleadoServiceImp.findEmpleadoByIdentifier(servicio.getEmpleado().getIdentificador());
            servicio.setEmpleado(unEmpleado);
            servicioServiceImp.addServicio(servicio);

            modelAndView.setViewName("redirect:/servicios/listado");
            modelAndView.addObject("listaPaseadores", servicioServiceImp.getAllServicios());
            modelAndView.addObject("listaEmpleados", empleadoServiceImp.getAllEmpleados());
        }

        return modelAndView;
    }

    @GetMapping("/modificar/{identificador}")
    public ModelAndView getModifyServicioPage(
            @PathVariable(value = "identificador") long identificador) {

        ModelAndView modelAndView = new ModelAndView();
        boolean allowEditing = true;

        unServicio = servicioServiceImp.findServicioByIdentifier(identificador);
        modelAndView.setViewName("nuevo_servicio");
        modelAndView.addObject("servicio", unServicio);
        modelAndView.addObject("listaEmpleados", empleadoServiceImp.getAllEmpleados());
        modelAndView.addObject("editar", allowEditing);

        return modelAndView;
    }

    @GetMapping("/eliminar/{identificador}")
    public ModelAndView deleteServicio(@PathVariable(value = "identificador") long identificador) {

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("redirect:/servicios/listado");
        servicioServiceImp.deleteServicioByIdentifier(servicioServiceImp.findServicioByIdentifier(identificador));

        return modelAndView;
    }

}
