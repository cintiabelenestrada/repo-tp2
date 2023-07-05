package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.entity.Empleado;

public interface IEmpleadoService {
    
    //#region Methods
    public void addEmpleado(Empleado empleado);
    
    public List<Empleado> getAllEmpleados();
    
    public Empleado findEmpleadoByIdentifier(long identificador);

    public void deleteEmpleadoByIdentifier(Empleado empleado);

    // public Empleado getEmpleado();
    //#endregion

}
