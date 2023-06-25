package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Provincia;
import ar.edu.unju.fi.repository.IProvinciaRepository;
import ar.edu.unju.fi.service.IProvinciaService;

@Service("provinciaServiceImp")
public class ProvinciaServiceImp implements IProvinciaService {

    @Autowired
    private IProvinciaRepository provinciaRepository;

    @Autowired
    private Provincia provincia;

    //#region Methods
    @Override
    public void addProvincia(Provincia provincia) {
        provinciaRepository.save(provincia);
    }

    @Override
    public List<Provincia> getAllProvincias() {
        List<Provincia> provincias = provinciaRepository.findByEstado(true);
        return provincias;
    }

    @Override
    public Provincia findProvinciaByIdentifier(long identificador) {
        provincia = provinciaRepository.findById(identificador).get();
        return provincia;
    }

    @Override
    public void deleteProvinciaByIdentifier(Provincia provincia) {
        provincia.setEstado(false);
        provinciaRepository.save(provincia);
    }

    // @Override
    // public Provincia getProvincia() {
    //     return provincia;
    // }
    //#endregion

}
