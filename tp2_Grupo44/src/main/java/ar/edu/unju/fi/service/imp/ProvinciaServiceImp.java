package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Provincia;
import ar.edu.unju.fi.repository.IProvinciaRepository;
import ar.edu.unju.fi.service.IProvinciaService;

@Service
public class ProvinciaServiceImp implements IProvinciaService {

    //#region Components
    @Autowired
    private IProvinciaRepository provinciaRepository;

    @Autowired
    private Provincia provincia;
    //#endregion

    //#region Methods
    @Override
    public List<Provincia> getProvincias() {
        return provinciaRepository.findByEstado(true);
    }

    @Override
    public void saveNewProvincia(Provincia provinciaAgregar) {
        provinciaRepository.save(provinciaAgregar);
    }

    @Override
    public Provincia findProvinciaByIdentifier(long identificador) {
        return provinciaRepository.findById(identificador).get();
    }

    public void modifyProvinciaByIdentifier(Provincia provinciaModificar) {
        provinciaRepository.save(provinciaModificar);
    }

    @Override
    public void deleteProvinciaByIdentifier(Provincia provinciaEliminar) {
        provinciaEliminar.setEstado(false);
        provinciaRepository.save(provinciaEliminar);
    }

    @Override
    public Provincia getProvincia() {
        return provincia;
    }
    //#endregion

}
