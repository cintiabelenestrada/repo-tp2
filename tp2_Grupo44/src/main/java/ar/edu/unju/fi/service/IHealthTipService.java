package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.entity.HealthTip;

public interface IHealthTipService {
    
    // region Methods
    public List<HealthTip> getConsejos();

    public void saveNewHealthTip(HealthTip consejoAgregar);
    
    public HealthTip findHealthTipByIdentifier(short identificador);

    public void modifyHealthTipByIdentifier(HealthTip consejoModificar);

    public void deleteHealthTipByIdentifier(short identificador);

	public HealthTip getHealthTip();

    public void setHealthTipIdentifier(HealthTip consejo);
    // endregion
}
