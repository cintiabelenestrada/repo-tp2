package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.entity.Categoria;

public interface ICategoriaService {
    
    //#region Methods
    public void addCategoria(Categoria categoria);

    public List<Categoria> getAllCategorias();

    public Categoria findCategoriaByIdentifier(long identificador);

    public void deleteCategoriaByIdentifier(Categoria categoria);

    // public Categoria getCategoria();
    //#endregion
}
