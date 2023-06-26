package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.entity.Servicio;

public interface IServicioService {

    //#region Methods
    public void addServicio(Servicio servicio);

    public List<Servicio> getAllServicios();

    public Servicio findServicioByIdentifier(long identificador);

    public void deleteServicioByIdentifier(Servicio servicio);

    // public Servicio getServicio();
    //#endregion
    
}
