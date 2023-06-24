package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Producto;
import ar.edu.unju.fi.repository.IProductoRepository;
import ar.edu.unju.fi.service.IProductoService;

@Service
public class ProductoServiceImp implements IProductoService {

    //#region Components
    @Autowired
	private IProductoRepository productoRepository;

    @Autowired
	private Producto producto;
    //#endregion

    //#region Methods
    @Override
    public List<Producto> getProductos() {
        return productoRepository.findByEstado(true);
    }

    @Override
    public void addProducto(Producto productoAgregar) {
        productoRepository.save(productoAgregar);
    }

    @Override
    public Producto findProductoByCode(long codigo) {
        return productoRepository.findById(codigo).get();
    }

    @Override
    public void deleteProductoByCode(Producto productoEliminar) {
        productoEliminar.setEstado(false);
        productoRepository.save(productoEliminar);
    }

    @Override
    public Producto getProducto() {
        return producto;
    }
    //#endregion

}