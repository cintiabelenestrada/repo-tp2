package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.lists.ProductList;
import ar.edu.unju.fi.model.Product;
import ar.edu.unju.fi.service.IProductService;

@Service
public class ProductServiceImp implements IProductService {

    @Autowired
	private ProductList listaProductos;

    @Autowired
	private Product producto;

    // region Methods
    @Override
    public List<Product> getProductos() {
        return listaProductos.getProductos();
    }

    @Override
    public List<String> getCategorias() {
        return listaProductos.getCategorias();
    }

    @Override
    public void saveNewProduct(Product productoAgregar) {
        listaProductos.getProductos().add(productoAgregar);
    }

    @Override
    public Product findProductByCode(short codigo) {

        Product productFound = null;

        for (Product producto : listaProductos.getProductos()) {
			if (producto.getCodigo() == codigo) {
				productFound = producto;
				break;
			}
		}

        return productFound;

    }

    @Override
    public void modifyProductByCode(Product productoModificar) {

        for (Product producto : listaProductos.getProductos()) {
			if (producto.getCodigo() == productoModificar.getCodigo()) {
                producto.setNombre(productoModificar.getNombre());
				producto.setPrecio(productoModificar.getPrecio());
				producto.setCategoria(productoModificar.getCategoria());
				producto.setDescuento(productoModificar.getDescuento());
				break;
			}
		}

    }

    @Override
    public void deleteProductByCode(short codigo) {

        for (Product producto : listaProductos.getProductos()) {
			if (producto.getCodigo() == codigo) {
                listaProductos.getProductos().remove(producto);
                break;
			}
		}

    }

    @Override
    public Product getProduct() {
        return producto;
    }
    
    public void setProductCode(Product producto) {
        
        int listSize = listaProductos.getProductos().size() - 1;
        short codigoContador = listaProductos.getProductos().get(listSize).getCodigo();
		
        codigoContador++;
        producto.setCodigo(codigoContador);

    }
    // endregion

}
