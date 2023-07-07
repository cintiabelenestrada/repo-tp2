package ar.edu.unju.fi.service.imp;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Sucursal;
import ar.edu.unju.fi.repository.ISucursalRepository;
import ar.edu.unju.fi.service.ISucursalService;

@Service
public class SucursalServiceImpl implements ISucursalService {

    @Autowired
    private ISucursalRepository sucursalRepository;

    @Override
    public void addSucursal(Sucursal sucursal) {
        sucursalRepository.save(sucursal);
    }

    @Override
    public List<Sucursal> getAllSucursales() {
        return (List<Sucursal>) sucursalRepository.findAll();
    }

    @Override
    public Sucursal findSucursalByIdentifier(long identificador) {
        return sucursalRepository.findById(identificador).orElse(null);
    }

    @Override
    public void deleteSucursalByIdentifier(Sucursal sucursal) {
        sucursalRepository.delete(sucursal);
    }

    @Override
    public List<Sucursal> findSucursalesByFechaInicioAndFechaFin(LocalDate fechaInicio, LocalDate fechaFin) {
        return sucursalRepository.findByFechaAperturaBetween(fechaInicio, fechaFin);
    }
}