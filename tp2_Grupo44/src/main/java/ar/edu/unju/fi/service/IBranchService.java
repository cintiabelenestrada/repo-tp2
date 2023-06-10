package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.model.Branch;

public interface IBranchService {
    
    // region Methods
    public List<Branch> getSucursales();

    public List<String> getProvincias();

    public void saveNewBranchOffice(Branch sucursalAgregar);
    
    public Branch findBranchOfficeByIdentifier(short identificador);

    public void modifyBranchOfficeByIdentifier(Branch sucursalModificar);

    public void deleteBranchOfficeByIdentifier(short identificador);

	public Branch getBranch();

    public void setBranchOfficeIdentifier(Branch sucursal);
    // endregion

}
