package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.lists.HealthTipList;
import ar.edu.unju.fi.model.HealthTip;
import ar.edu.unju.fi.service.IHealthTipService;

@Service
public class HealthTipServiceImp implements IHealthTipService {

    @Autowired
    private HealthTipList listaConsejos;

    @Autowired
    private HealthTip consejo;
    
    // region Methods
    @Override
    public List<HealthTip> getConsejos() {
        return listaConsejos.getConsejos();
    }

    @Override
    public void saveNewHealthTip(HealthTip consejoAgregar) {
        listaConsejos.getConsejos().add(consejoAgregar);
    }

    @Override
    public HealthTip findHealthTipByIdentifier(short identificador) {
        
        HealthTip healthTipFound = null;

        for (HealthTip consejo : listaConsejos.getConsejos()) {
            if (consejo.getIdentificador() == identificador) {
                healthTipFound = consejo;
                break;
            }
        }

        return healthTipFound;
    }

    @Override
    public void modifyHealthTipByIdentifier(HealthTip consejoModificar) {
        
        for (HealthTip consejo : listaConsejos.getConsejos()) {
            if (consejo.getIdentificador() == consejoModificar.getIdentificador()) {
                consejo.setTitulo(consejoModificar.getTitulo());
                consejo.setContenido(consejoModificar.getContenido());
                consejo.setImagen(consejoModificar.getImagen());
                consejo.setFechaPublicacion(consejoModificar.getFechaPublicacion());
                break;
            }
        }

    }

    @Override
    public void deleteHealthTipByIdentifier(short identificador) {
        
        for (HealthTip consejo : listaConsejos.getConsejos()) {
            if (consejo.getIdentificador() == identificador) {
                listaConsejos.getConsejos().remove(consejo);
                break;
            }
        }

    }

    @Override
    public HealthTip getHealthTip() {
        return consejo;
    }

    @Override
    public void setHealthTipIdentifier(HealthTip consejo) {
        
        int listSize = listaConsejos.getConsejos().size() - 1;
        short identificadorContador = listaConsejos.getConsejos().get(listSize).getIdentificador();
		
        identificadorContador++;
        consejo.setIdentificador(identificadorContador);
    }
    // endregion

}
