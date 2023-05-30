package ar.edu.unju.fi.lists;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unju.fi.model.Service;

public class DogWalkerList {

	// region Attributes
	private List<Service> servicios;
	// endregion

	// region Constructors
	public DogWalkerList() {

		servicios = new ArrayList<Service>();

		servicios.add(new Service("Juan", "Tolab", "Lunes", "9 - 11"));
		servicios.add(new Service("Lucas", "Toledo", "Martes", "14 - 17"));
		servicios.add(new Service("Sofia", "Limache", "Miercoles", "11 - 12"));
		servicios.add(new Service("Rocio", "Condori", "Juves", "8 - 10"));
		servicios.add(new Service("Pablo", "Gutierrez", "Viernes", "17 - 19"));
		servicios.add(new Service("Macarena", "Castro", "Sabado", " 16 - 18"));
		servicios.add(new Service("Gabriel", "Vilte", "Domingo", " 9 - 11"));

	}
	// endregion

	// region Getters and Setters
	public List<Service> getServicios() {
		return servicios;
	}

	public void setServicios(List<Service> servicios) {
		this.servicios = servicios;
	}
	// endregion

}
