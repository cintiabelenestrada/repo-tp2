package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Sucursal;
import ar.edu.unju.fi.repository.ISucursalRepository;
import ar.edu.unju.fi.service.ISucursalService;

@Service
public class SucursalServiceImp implements ISucursalService {

    //#region Components
    @Autowired
    private ISucursalRepository sucursalRepository;
    
    @Autowired
    private Sucursal sucursal;
    //#endregion

    //#region Methods
    @Override
    public List<Sucursal> getSucursales() {
        return sucursalRepository.findByEstado(true);
    }

    @Override
    public void saveNewSucursal(Sucursal sucursalAgregar) {
        sucursalRepository.save(sucursalAgregar);
    }

    @Override
    public Sucursal findSucursalByIdentifier(Long identificador) {
        /*
         * ID no debe ser null
         * Retorna un Optional#empty() si no encuentra el ID
         * Pero en este caso el ID siempre existira
         */
        return sucursalRepository.findById(identificador).orElse(null);
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
    public void deleteSucursalByIdentifier(Sucursal sucursalEliminar) {
    
        sucursalEliminar.setEstado(false);
        sucursalRepository.save(sucursalEliminar);
    }

    @Override
    public Sucursal getSucursal() {
        return sucursal;
    }
    //#endregion

}
