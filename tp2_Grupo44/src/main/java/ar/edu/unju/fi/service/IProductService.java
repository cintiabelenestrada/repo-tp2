package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.entity.Product;

public interface IProductService {
    
    // region Methods
    public List<Product> getProductos();

    public List<String> getCategorias();

    public void saveNewProduct(Product productoAgregar);
    
    public Product findProductByCode(short codigo);

    public void modifyProductByCode(Product productoModificar);

    public void deleteProductByCode(short codigo);

	public Product getProduct();

    public void setProductCode(Product producto);
    // endregion
}
