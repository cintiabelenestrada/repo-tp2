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
    public void addSucursal(Sucursal sucursalAgregar) {
        sucursalRepository.save(sucursalAgregar);
    }

    @Override
    public Sucursal findSucursalByIdentifier(long identificador) {
        return sucursalRepository.findById(identificador).get();
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
