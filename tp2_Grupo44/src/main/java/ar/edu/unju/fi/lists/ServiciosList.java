package ar.edu.unju.fi.lists;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unju.fi.model.Servicios;


public class ServiciosList {
	
	private List<Servicios> servicios;
	
	public ServiciosList() {
		
		servicios = new ArrayList<Servicios>();
		
		servicios.add(new Servicios("Juan", "Tolab", "Lunes", "9 - 11"));
		servicios.add(new Servicios("Lucas", "Toledo", "Martes", "14 - 17"));
		servicios.add(new Servicios("Sofia", "Limache", "Miercoles", "11 - 12"));
		servicios.add(new Servicios("Rocio", "Condori", "Juves", "8 - 10"));
		servicios.add(new Servicios("Pablo", "Gutierrez", "Viernes", "17 - 19"));
		servicios.add(new Servicios("Macarena", "Castro", "Sabado", " 16 - 18"));
		servicios.add(new Servicios("Gabriel", "Vilte", "Domingo", " 9 - 11"));
		
	}
	
	
	public List<Servicios> getServicios(){
		return servicios;
	}
	
	public void setServicios(List<Servicios>servicios) {
		
		this.servicios = servicios;
	}

}
