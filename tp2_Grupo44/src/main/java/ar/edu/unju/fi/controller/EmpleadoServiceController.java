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
import ar.edu.unju.fi.service.imp.EmpleadoServiceImp;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/empleados")
public class EmpleadoServiceController {
    
    @Autowired
    private EmpleadoServiceImp empleadoServiceImp;
    
    @Autowired
    private Empleado unEmpleado;

    @GetMapping("/listado")
    public ModelAndView getEmpleadosPage() {

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("empleados");
        modelAndView.addObject("listaEmpleados", empleadoServiceImp.getAllEmpleados());

        return modelAndView;
    }

    @GetMapping("/formulario")
    public ModelAndView getNewEmpleadoPage() {

        ModelAndView modelAndView = new ModelAndView();
        boolean allowEditing = false;

        unEmpleado = new Empleado();
        modelAndView.setViewName("nuevo_empleado");
        modelAndView.addObject("empleado", unEmpleado);
        modelAndView.addObject("editar", allowEditing);

        return modelAndView;
    }

    @PostMapping("/guardar")
    public ModelAndView saveNewEmpleado(
            @Valid @ModelAttribute(value = "empleado") Empleado empleado,
            BindingResult resultadoValidacion) {

        ModelAndView modelAndView = new ModelAndView();

        if (resultadoValidacion.hasErrors()) {
            modelAndView.setViewName("nuevo_empleado");
        } else {
            empleadoServiceImp.addEmpleado(empleado);

            modelAndView.setViewName("redirect:/empleados/listado");
            modelAndView.addObject("listaEmpleados", empleadoServiceImp.getAllEmpleados());
        }

        return modelAndView;
    }

    @GetMapping("/modificar/{identificador}")
    public ModelAndView getModifyEmpleadoPage(
            @PathVariable(value = "identificador") long identificador) {

        ModelAndView modelAndView = new ModelAndView();
        boolean allowEditing = true;

        unEmpleado = empleadoServiceImp.findEmpleadoByIdentifier(identificador);
        modelAndView.setViewName("nuevo_empleado");
        modelAndView.addObject("empleado", unEmpleado);
        modelAndView.addObject("editar", allowEditing);

        return modelAndView;
    }

    @GetMapping("/eliminar/{identificador}")
    public ModelAndView deleteEmpleado(
            @PathVariable(value = "identificador") long identificador) {
            
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("redirect:/empleados/listado");
        empleadoServiceImp.deleteEmpleadoByIdentifier(empleadoServiceImp.findEmpleadoByIdentifier(identificador));

        return modelAndView;
    }

}
