package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.entity.Sucursal;

public interface ISucursalService {
    
    //#region Methods
    public void addSucursal(Sucursal sucursal);

    public List<Sucursal> getAllSucursales();

    public Sucursal findSucursalByIdentifier(long identificador);

    public void deleteSucursalByIdentifier(Sucursal sucursal);

	// public Sucursal getSucursal();
    //#endregion

}
