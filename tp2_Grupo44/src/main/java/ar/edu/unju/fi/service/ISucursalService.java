package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.entity.Sucursal;

public interface ISucursalService {
    
    //#region Methods
    public List<Sucursal> getSucursales();

    // public List<String> getProvincias();

    public void saveNewSucursal(Sucursal sucursalAgregar);

    public Sucursal findSucursalByIdentifier(Long identificador);

    // public void modifySucursalByIdentifier(Sucursal sucursalModificar);

    public void deleteSucursalByIdentifier(Sucursal sucursalEliminar);

	public Sucursal getSucursal();

    // public void setBranchOfficeIdentifier(Branch sucursal);
    //#endregion

}
