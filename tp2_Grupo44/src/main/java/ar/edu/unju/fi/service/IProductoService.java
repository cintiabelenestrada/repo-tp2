package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.entity.Producto;

public interface IProductoService {
    
    //#region Methods
    public void addProducto(Producto producto);

    public List<Producto> getAllProductos();

    public Producto findProductoByCodigo(long codigo);

    public void deleteProductoByCodigo(Producto producto);

    // public Producto getProducto();
    //#endregion
}
