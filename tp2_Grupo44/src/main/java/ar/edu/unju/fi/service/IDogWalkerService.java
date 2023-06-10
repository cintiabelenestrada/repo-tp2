package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.model.DogWalker;

public interface IDogWalkerService {
    
    // region Methods
    public List<DogWalker> getPaseadores();

    public List<String> getProvincias();

    public void saveNewDogWalker(DogWalker paseadorAgregar);
    
    public DogWalker findDogWalkerByIdentifier(short identificador);

    public void modifyDogWalkerByIdentifier(DogWalker paseadorModificar);

    public void deleteDogWalkerByIdentifier(short identificador);

	public DogWalker getDogWalker();

    public void setDogWalkerIdentifier(DogWalker paseador);
    // endregion

}
