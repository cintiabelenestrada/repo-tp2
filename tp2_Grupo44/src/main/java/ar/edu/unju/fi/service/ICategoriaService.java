package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.entity.Categoria;

public interface ICategoriaService {
    
    //#region Methods
    public List<Categoria> getCategorias();

    public void addCategoria(Categoria categoriaAgregar);

    public Categoria findCategoriaByIdentifier(long identificador);

    public void deleteCategoriaByIdentifier(Categoria categoriaEliminar);

    public Categoria getCategoria();
    //#endregion
}
