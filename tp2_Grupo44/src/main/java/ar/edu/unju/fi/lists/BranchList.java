package ar.edu.unju.fi.lists;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import ar.edu.unju.fi.entity.Branch;

@Component
public class BranchList {

	// region Attributes
	private List<Branch> sucursales;
	private List<String> provincias = List.of(
			"Jujuy",
			"Salta",
			"Tucumán");
	// region Constructors

	public BranchList() {

		this.sucursales = new ArrayList<Branch>();

		// Sucursales precargadas
		this.sucursales.add(
				new Branch(
						"CASA CENTRAL",
						"Necochea",
						"65",
						"3885557773",
						LocalTime.of(9, 0),
						LocalTime.of(20, 0),
						provincias.get(1),
						(long) 1,
						true));
		this.sucursales.add(
				new Branch(
						"ALTO COMEDERO",
						"Patricias Argentinas",
						"500",
						"3886669988",
						LocalTime.of(8, 0),
						LocalTime.of(15, 0),
						provincias.get(0),
						(long) 2,
						true));
		this.sucursales.add(
				new Branch(
						"CHIJRA",
						"Avenida Vicuña",
						"78",
						"3885557773",
						LocalTime.of(9, 0),
						LocalTime.of(16, 0),
						provincias.get(0),
						(long) 3,
						true));
		this.sucursales.add(
				new Branch(
						"CASA CENTRAL",
						"Cordoba",
						"24",
						"38854567223",
						LocalTime.of(13, 0),
						LocalTime.of(20, 0),
						provincias.get(2),
						(long) 4,
						true));
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