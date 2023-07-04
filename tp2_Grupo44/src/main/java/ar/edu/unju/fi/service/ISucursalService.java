package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.entity.Sucursal;

public interface ISucursalService {
    
    void addSucursal(Sucursal sucursal);

    List<Sucursal> getAllSucursales();

    Sucursal findSucursalByIdentifier(long identificador);

    void deleteSucursalByIdentifier(Sucursal sucursal);

    List<Sucursal> findSucursalesByFechaInicioAndFechaFin(String fechaInicio, String fechaFin);
}

