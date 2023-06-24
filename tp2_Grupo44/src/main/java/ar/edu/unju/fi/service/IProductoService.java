package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.entity.Producto;

public interface IProductoService {
    
    //#region Methods
    public List<Producto> getProductos();

    public void addProducto(Producto productoAgregar);

    public Producto findProductoByCode(long codigo);

    public void deleteProductoByCode(Producto productoEliminar);

    public Producto getProducto();
    //#endregion
}
