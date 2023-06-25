package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.entity.Provincia;

public interface IProvinciaService {

    //#region Methods
    public void addProvincia(Provincia provincia);

    public List<Provincia> getAllProvincias();

    public Provincia findProvinciaByIdentifier(long identificador);

    public void deleteProvinciaByIdentifier(Provincia provincia);
    
    // public Provincia getProvincia();
    //#endregion

}
