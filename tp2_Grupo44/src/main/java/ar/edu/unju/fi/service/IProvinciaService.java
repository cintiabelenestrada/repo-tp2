package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.entity.Provincia;

public interface IProvinciaService {

    //#region Methods
    public List<Provincia> getProvincias();

    public void addProvincia(Provincia provinciaAgregar);

    public Provincia findProvinciaByIdentifier(long identificador);

    public void deleteProvinciaByIdentifier(Provincia provinciaEliminar);
    
    public Provincia getProvincia();
    //#endregion

}
