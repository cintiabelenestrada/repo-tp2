package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Empleado;
import ar.edu.unju.fi.repository.IEmpleadoRepository;
import ar.edu.unju.fi.service.IEmpleadoService;

@Service("empleadoServiceImp")
public class EmpleadoServiceImp implements IEmpleadoService {

    @Autowired
    private Empleado empleado;

    @Autowired
    private IEmpleadoRepository empleadoRepository;

    //#region Methods
    @Override
    public void addEmpleado(Empleado empleado) {
        empleadoRepository.save(empleado);
    }

    @Override
    public List<Empleado> getAllEmpleados() {
        List<Empleado> empleados = empleadoRepository.findByEstado(true);
        return empleados;
    }

    @Override
    public Empleado findEmpleadoByIdentifier(long identificador) {
        empleado = empleadoRepository.findById(identificador).get();
        return empleado;
    }

    @Override
    public void deleteEmpleadoByIdentifier(Empleado empleado) {
        empleado.setEstado(false);
        empleadoRepository.save(empleado);
    }

    // @Override
    // public Empleado getEmpleado() {
    //     return empleado;
    // }
    //#endregion
    
}
