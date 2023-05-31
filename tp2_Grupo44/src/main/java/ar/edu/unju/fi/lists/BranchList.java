package ar.edu.unju.fi.lists;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unju.fi.model.Branch;

public class BranchList {

	// region Attributes
	private List<Branch> sucursales;
	private List<String> provincias = List.of(
			"Jujuy",
			"Salta");
	// endregion

	// region Constructors
	public BranchList() {

		this.sucursales = new ArrayList<Branch>();

		// Sucursales
		this.sucursales.add(
				new Branch(
						"CASA CENTRAL",
						"Necochea N°65",
						"3885557773",
						"Lunes a sábados de 9 a 20hs",
						provincias.get(0)));
		this.sucursales.add(
				new Branch(
						"SUCURSAL ALTO COMEDERO",
						"Patricias Argentinas 500",
						"3886669988",
						"Lunes a sábados de 9 a 20hs", provincias.get(0)));
		this.sucursales.add(
				new Branch(
						"SUCURSAL CHIJRA",
						"Avenida Vicuña 78",
						"3885557773",
						"Lunes a sábados de 9 a 20hs", provincias.get(0)));
		this.sucursales.add(
				new Branch(
						"CASA CENTRAL",
						"Cordoba 24",
						"38854567773",
						"Lunes a sábados de 9 a 20hs",
						provincias.get(1)));
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

}