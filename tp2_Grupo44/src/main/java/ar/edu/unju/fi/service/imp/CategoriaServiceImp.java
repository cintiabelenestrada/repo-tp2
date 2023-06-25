package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Categoria;
import ar.edu.unju.fi.repository.ICategoriaRepository;
import ar.edu.unju.fi.service.ICategoriaService;

@Service("categoriaServiceImp")
public class CategoriaServiceImp implements ICategoriaService {

    @Autowired
    private ICategoriaRepository categoriaRepository;

    @Autowired
    private Categoria categoria;

    //#region Methods
    @Override
    public void addCategoria(Categoria categoria) {
        categoriaRepository.save(categoria);
    }

    @Override
    public List<Categoria> getAllCategorias() {
        List<Categoria> categorias = categoriaRepository.findByEstado(true);
        return categorias;
    }

    @Override
    public Categoria findCategoriaByIdentifier(long identificador) {
        categoria = categoriaRepository.findById(identificador).get();
        return categoria;
    }

    @Override
    public void deleteCategoriaByIdentifier(Categoria categoria) {
        categoria.setEstado(false);
        categoriaRepository.save(categoria);
    }

    // @Override
    // public Categoria getCategoria() {
    //     return categoria;
    // }
    //#endregion
    
}
