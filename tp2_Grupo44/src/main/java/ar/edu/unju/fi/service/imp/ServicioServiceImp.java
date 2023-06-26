package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Servicio;
import ar.edu.unju.fi.repository.IServicioRepository;
import ar.edu.unju.fi.service.IServicioService;

@Service("servicioServiceImp")
public class ServicioServiceImp implements IServicioService {

    @Autowired
    private IServicioRepository servicioRepository;

    @Autowired
    private Servicio servicio;

    @Override
    public void addServicio(Servicio servicio) {
        servicioRepository.save(servicio);
    }

    @Override
    public List<Servicio> getAllServicios() {
        List<Servicio> servicios = servicioRepository.findByEstado(true);
        return servicios;
        
    }

    @Override
    public Servicio findServicioByIdentifier(long identificador) {
        servicio = servicioRepository.findById(identificador).get();
        return servicio;
    }

    @Override
    public void deleteServicioByIdentifier(Servicio servicio) {
        servicio.setEstado(false);
        servicioRepository.save(servicio);
    }

    // @Override
    // public Servicio getServicio() {
    //     return servicio;
    // }
    
}
