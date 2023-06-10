package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.lists.DogWalkerList;
import ar.edu.unju.fi.model.DogWalker;
import ar.edu.unju.fi.service.IDogWalkerService;

@Service
public class DogWalkerServiceImp implements IDogWalkerService {

    @Autowired
    private DogWalkerList listaPaseadores;

    @Autowired
    private DogWalker paseador;

    @Override
    public List<DogWalker> getPaseadores() {
        return listaPaseadores.getPaseadores();
    }

    @Override
    public List<String> getProvincias() {
        return listaPaseadores.getProvincias();
    }

    @Override
    public void saveNewDogWalker(DogWalker paseadorAgregar) {
        listaPaseadores.getPaseadores().add(paseadorAgregar);
    }

    @Override
    public DogWalker findDogWalkerByIdentifier(short identificador) {
        
        DogWalker dogWalkerFound = null;

        for (DogWalker paseador : listaPaseadores.getPaseadores()) {
            if (paseador.getIdentificador() == identificador) {
                dogWalkerFound = paseador;
                break;
            }
        }

        return dogWalkerFound;
    }

    @Override
    public void modifyDogWalkerByIdentifier(DogWalker paseadorModificar) {
        
        for (DogWalker paseador : listaPaseadores.getPaseadores()) {
            if (paseador.getIdentificador() == paseadorModificar.getIdentificador()) {
                paseador.setNombre(paseadorModificar.getNombre());
                paseador.setApellido(paseadorModificar.getApellido());
                paseador.setDiaDisponible(paseadorModificar.getDiaDisponible());
                paseador.setHorarioDisponibleDesde(paseadorModificar.getHorarioDisponibleDesde());
                paseador.setHorarioDisponibleHasta(paseadorModificar.getHorarioDisponibleHasta());
                paseador.setProvincia(paseadorModificar.getProvincia());
                break;
            }
        }

    }

    @Override
    public void deleteDogWalkerByIdentifier(short identificador) {
        
        for (DogWalker paseador : listaPaseadores.getPaseadores()) {
            if (paseador.getIdentificador() == identificador) {
                listaPaseadores.getPaseadores().remove(paseador);
                break;
            }
        }

    }

    @Override
    public DogWalker getDogWalker() {
        return paseador;
    }

    @Override
    public void setDogWalkerIdentifier(DogWalker paseador) {
        
        int listSize = listaPaseadores.getPaseadores().size() - 1;
        short identificadorContador = listaPaseadores.getPaseadores().get(listSize).getIdentificador();
		
        identificadorContador++;
        paseador.setIdentificador(identificadorContador);

    }
    
}
