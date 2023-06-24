package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Categoria;
import ar.edu.unju.fi.repository.ICategoriaRepository;
import ar.edu.unju.fi.service.ICategoriaService;

@Service
public class CategoriaServiceImp implements ICategoriaService {

    //#region Components
    @Autowired
    private ICategoriaRepository categoriaRepository;

    @Autowired
    private Categoria categoria;
    //#endregion

    //#region Methods
    @Override
    public List<Categoria> getCategorias() {
        return categoriaRepository.findByEstado(true);
    }

    @Override
    public void addCategoria(Categoria categoriaAgregar) {
        categoriaRepository.save(categoriaAgregar);
    }

    @Override
    public Categoria findCategoriaByIdentifier(long identificador) {
        return categoriaRepository.findById(identificador).get();
    }

    @Override
    public void deleteCategoriaByIdentifier(Categoria categoriaEliminar) {
        categoriaEliminar.setEstado(false);
        categoriaRepository.save(categoriaEliminar);
    }

    @Override
    public Categoria getCategoria() {
        return categoria;
    }
    //#endregion
    
}
