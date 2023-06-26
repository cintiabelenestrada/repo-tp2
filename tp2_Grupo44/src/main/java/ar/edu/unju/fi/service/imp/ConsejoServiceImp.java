package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Consejo;
import ar.edu.unju.fi.lists.ConsejoList;
import ar.edu.unju.fi.service.IConsejoService;

@Service
public class ConsejoServiceImp implements IConsejoService {

    @Autowired
    private ConsejoList listaConsejos;

    @Autowired
    private Consejo consejo;
    
    // region Methods
    @Override
    public List<Consejo> getConsejos() {
        return listaConsejos.getConsejos();
    }

    @Override
    public void saveNewHealthTip(Consejo consejoAgregar) {
        listaConsejos.getConsejos().add(consejoAgregar);
    }

    @Override
    public Consejo findHealthTipByIdentifier(short identificador) {
        
        Consejo healthTipFound = null;

        for (Consejo consejo : listaConsejos.getConsejos()) {
            if (consejo.getIdentificador() == identificador) {
                healthTipFound = consejo;
                break;
            }
        }

        return healthTipFound;
    }

    @Override
    public void modifyHealthTipByIdentifier(Consejo consejoModificar) {
        
        for (Consejo consejo : listaConsejos.getConsejos()) {
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
        
        for (Consejo consejo : listaConsejos.getConsejos()) {
            if (consejo.getIdentificador() == identificador) {
                listaConsejos.getConsejos().remove(consejo);
                break;
            }
        }

    }

    @Override
    public Consejo getHealthTip() {
        return consejo;
    }

    @Override
    public void setHealthTipIdentifier(Consejo consejo) {
        
        int listSize = listaConsejos.getConsejos().size() - 1;
        short identificadorContador = listaConsejos.getConsejos().get(listSize).getIdentificador();
		
        identificadorContador++;
        consejo.setIdentificador(identificadorContador);
    }
    // endregion

}
