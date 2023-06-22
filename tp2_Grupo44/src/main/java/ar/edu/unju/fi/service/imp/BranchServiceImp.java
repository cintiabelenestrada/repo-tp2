package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Branch;
import ar.edu.unju.fi.repository.IBranchRepository;
import ar.edu.unju.fi.service.IBranchService;

@Service
public class BranchServiceImp implements IBranchService {

    // region Componentes
    @Autowired
    private IBranchRepository branchRepository;
    
    // @Autowired
    // private BranchList listaSucursales;
    
    @Autowired
    private Branch sucursal;
    // endregion

    // region Metodos
    @Override
    public List<Branch> getSucursales() {
        return branchRepository.findByEstado(true);
    }

    // @Override
    // public List<String> getProvincias() {
    //     return listaSucursales.getProvincias();
    // }

    @Override
    public void saveNewBranchOffice(Branch sucursalAgregar) {
        branchRepository.save(sucursalAgregar);
    }

    @Override
    public Branch findBranchOfficeByIdentifier(long identificador) {
        
        // Branch branchFound = null;

        // for (Branch sucursal : listaSucursales.getSucursales()) {
        //     if (sucursal.getIdentificador() == identificador) {
        //         branchFound = sucursal;
        //         break;
        //     }
        // }

        return branchRepository.findById(identificador).get();
    }

    // @Override
    // public void modifyBranchOfficeByIdentifier(Branch sucursalModificar) {
        
    //     for (Branch sucursal : listaSucursales.getSucursales()) {
    //         if (sucursal.getIdentificador() == sucursalModificar.getIdentificador()) {
    //             sucursal.setNombre(sucursalModificar.getNombre());
    //             sucursal.setDireccion(sucursalModificar.getDireccion());
    //             sucursal.setNumeroDireccion(sucursalModificar.getNumeroDireccion());
    //             sucursal.setTelefono(sucursalModificar.getTelefono());
    //             sucursal.setProvincia(sucursalModificar.getProvincia());
    //             break;
    //         }
    //     }
        // branchRepository.save(sucursalModificar);

    // }

    @Override
    public void deleteBranchOfficeByIdentifier(Branch sucursalEliminar) {
        
    //     for (Branch sucursal : listaSucursales.getSucursales()) {
    //         if (sucursal.getIdentificador() == identificador) {
    //             listaSucursales.getSucursales().remove(sucursal);
    //             break;
    //         }
    //     }
    
        sucursalEliminar.setEstado(false);
        branchRepository.save(sucursalEliminar);
    }

    @Override
    public Branch getBranch() {
        return sucursal;
    }

    // @Override
    // public void setBranchOfficeIdentifier(Branch sucursal) {
        
    //     int listSize = listaSucursales.getSucursales().size() - 1;
    //     short identificadorContador = listaSucursales.getSucursales().get(listSize).getIdentificador();
		
    //     identificadorContador++;
    //     sucursal.setIdentificador(identificadorContador);
    // }
    // endregion
    
}
