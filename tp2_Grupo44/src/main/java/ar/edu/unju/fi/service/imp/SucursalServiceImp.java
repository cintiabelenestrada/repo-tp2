package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Sucursal;
import ar.edu.unju.fi.repository.ISucursalRepository;
import ar.edu.unju.fi.service.ISucursalService;

@Service("sucursalServiceImp")
public class SucursalServiceImp implements ISucursalService {

    @Autowired
    private ISucursalRepository sucursalRepository;
    
    @Autowired
    private Sucursal sucursal;

    //#region Methods
    @Override
    public void addSucursal(Sucursal sucursal) {
        sucursalRepository.save(sucursal);
    }

    @Override
    public List<Sucursal> getAllSucursales() {
        List<Sucursal> sucursales = sucursalRepository.findByEstado(true);
        return sucursales;
    }

    @Override
    public Sucursal findSucursalByIdentifier(long identificador) {
        sucursal = sucursalRepository.findById(identificador).get();
        return sucursal;
    }

    @Override
    public void deleteSucursalByIdentifier(Sucursal sucursal) {
        sucursal.setEstado(false);
        sucursalRepository.save(sucursal);
    }

    // @Override
    // public Sucursal getSucursal() {
    //     return sucursal;
    // }
    //#endregion

}
