package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.entity.Branch;

public interface IBranchService {
    
    //#region Methods
    public List<Branch> getSucursales();
    // public List<String> getProvincias();
    public void saveNewBranchOffice(Branch sucursalAgregar);
    public Branch findBranchOfficeByIdentifier(long identificador);
    // public void modifyBranchOfficeByIdentifier(Branch sucursalModificar);
    public void deleteBranchOfficeByIdentifier(Branch sucursalEliminar);
	public Branch getBranch();
    // public void setBranchOfficeIdentifier(Branch sucursal);
    //#endregion

}
