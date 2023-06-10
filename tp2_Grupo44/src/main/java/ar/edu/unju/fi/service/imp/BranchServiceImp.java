package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.lists.BranchList;
import ar.edu.unju.fi.model.Branch;
import ar.edu.unju.fi.service.IBranchService;

@Service
public class BranchServiceImp implements IBranchService {

    @Autowired
    private BranchList listaSucursales;
    
    @Autowired
    private Branch sucursal;

    @Override
    public List<Branch> getSucursales() {
        return listaSucursales.getSucursales();
    }

    // Crear clase nueva separarla de productos y vincularla mediante un identificador "nombre"
    @Override
    public List<String> getProvincias() {
        return listaSucursales.getProvincias();
    }

    @Override
    public void saveNewBranchOffice(Branch sucursalAgregar) {
        listaSucursales.getSucursales().add(sucursalAgregar);
    }

    @Override
    public Branch findBranchOfficeByIdentifier(short identificador) {
        
        Branch branchFound = null;

        for (Branch sucursal : listaSucursales.getSucursales()) {
            if (sucursal.getIdentificador() == identificador) {
                branchFound = sucursal;
                break;
            }
        }

        return branchFound;
    }

    @Override
    public void modifyBranchOfficeByIdentifier(Branch sucursalModificar) {
        
        for (Branch sucursal : listaSucursales.getSucursales()) {
            if (sucursal.getIdentificador() == sucursalModificar.getIdentificador()) {
                sucursal.setNombre(sucursalModificar.getNombre());
                sucursal.setDireccion(sucursalModificar.getDireccion());
                sucursal.setNumeroDireccion(sucursalModificar.getNumeroDireccion());
                sucursal.setTelefono(sucursalModificar.getTelefono());
                sucursal.setProvincia(sucursalModificar.getProvincia());
                break;
            }
        }

    }

    @Override
    public void deleteBranchOfficeByIdentifier(short identificador) {
        
        for (Branch sucursal : listaSucursales.getSucursales()) {
            if (sucursal.getIdentificador() == identificador) {
                listaSucursales.getSucursales().remove(sucursal);
                break;
            }
        }

    }

    @Override
    public Branch getBranch() {
        return sucursal;
    }

    @Override
    public void setBranchOfficeIdentifier(Branch sucursal) {
        
        int listSize = listaSucursales.getSucursales().size() - 1;
        short identificadorContador = listaSucursales.getSucursales().get(listSize).getIdentificador();
		
        identificadorContador++;
        sucursal.setIdentificador(identificadorContador);
    }
    // endregion
    
}
