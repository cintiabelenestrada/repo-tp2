package ar.edu.unju.fi.lists;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import ar.edu.unju.fi.model.Branch;

@Component
public class BranchList {

	// region Attributes
	private List<Branch> sucursales;
	private List<String> provincias = List.of(
			"Jujuy",
			"Salta",
			"Tucumán");
	// endregion

	// region Constructors

	public BranchList() {

		this.sucursales = new ArrayList<Branch>();

		// Sucursales precargadas
		this.sucursales.add(
				new Branch(
						"CASA CENTRAL",
						"Necochea",
						65,
						"3885557773",
						LocalTime.of(9, 0),
						LocalTime.of(20, 0),
						provincias.get(1),
						(short) 1));
		this.sucursales.add(
				new Branch(
						"ALTO COMEDERO",
						"Patricias Argentinas",
						500,
						"3886669988",
						LocalTime.of(8, 0),
						LocalTime.of(15, 0),
						provincias.get(0),
						(short) 2));
		this.sucursales.add(
				new Branch(
						"CHIJRA",
						"Avenida Vicuña",
						78,
						"3885557773",
						LocalTime.of(9, 0),
						LocalTime.of(16, 0),
						provincias.get(0),
						(short) 3));
		this.sucursales.add(
				new Branch(
						"CASA CENTRAL 2",
						"Cordoba",
						24,
						"38854567773",
						LocalTime.of(13, 0),
						LocalTime.of(20, 0),
						provincias.get(2),
						(short) 4));
	}
	// endregion

	// region Getters and Setters
	public List<Branch> getSucursales() {
		return sucursales;
	}

	public void setSucursales(List<Branch> sucursales) {
		this.sucursales = sucursales;
	}

	public List<String> getProvincias() {
		return provincias;
	}

	public void setProvincias(List<String> provincias) {
		this.provincias = provincias;
	}
	// endregion

	// region Methods
	// endregion

}