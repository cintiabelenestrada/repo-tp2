package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Producto;
import ar.edu.unju.fi.repository.IProductoRepository;
import ar.edu.unju.fi.service.IProductoService;

@Service("productoServiceImp")
public class ProductoServiceImp implements IProductoService {

    @Autowired
	private IProductoRepository productoRepository;

    @Autowired
	private Producto producto;

    //#region Methods
    @Override
    public void addProducto(Producto producto) {
        productoRepository.save(producto);
    }

    @Override
    public List<Producto> getAllProductos() {
        List<Producto> productos = productoRepository.findByEstado(true);
        return productos;
    }

    @Override
    public Producto findProductoByCode(long codigo) {
        producto = productoRepository.findById(codigo).get();
        return producto;
    }

    @Override
    public void deleteProductoByCode(Producto producto) {
        producto.setEstado(false);
        productoRepository.save(producto);
    }

    // @Override
    // public Producto getProducto() {
    //     return producto;
    // }
    //#endregion

}