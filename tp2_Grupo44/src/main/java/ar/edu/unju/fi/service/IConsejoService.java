package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.entity.Consejo;

public interface IConsejoService {
    
    // region Methods
    public List<Consejo> getConsejos();

    public void saveNewHealthTip(Consejo consejoAgregar);
    
    public Consejo findHealthTipByIdentifier(short identificador);

    public void modifyHealthTipByIdentifier(Consejo consejoModificar);

    public void deleteHealthTipByIdentifier(short identificador);

	public Consejo getHealthTip();

    public void setHealthTipIdentifier(Consejo consejo);
    // endregion
}
