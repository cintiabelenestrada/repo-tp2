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
        List<Sucursal> sucursales = sucursalRepository.findByEstado(true);
        return sucursales;
    }

    @Override
    public void saveNewSucursal(Sucursal sucursalAgregar) {
        sucursalRepository.save(sucursalAgregar);
    }

    @Override
    public Sucursal findSucursalByIdentifier(long identificador) {
        sucursal = sucursalRepository.findById(identificador).get();
        return sucursal;
    }

    @Override
    public void modifySucursalByIdentifier(Sucursal sucursalModificar) {
        sucursalRepository.save(sucursalModificar);
    }

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
