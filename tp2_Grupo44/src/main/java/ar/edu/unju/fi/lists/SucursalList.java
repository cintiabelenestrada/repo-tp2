package ar.edu.unju.fi.lists;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unju.fi.model.Sucursal;

public class SucursalList {

	private List<Sucursal> sucursales;
	private List<String> provincias = List.of(
			"Jujuy",
			"Salta");

	public SucursalList() {
		this.sucursales = new ArrayList<Sucursal>();
		// Sucursales
		this.sucursales.add(new Sucursal("CASA CENTRAL", "Necochea N°65", "3885557773", "Lunes a sábados de 9 a 20hs",provincias.get(0)));
		this.sucursales.add(new Sucursal("SUCURSAL ALTO COMEDERO","Patricias Argentinas 500","3886669988", "Lunes a sábados de 9 a 20hs", provincias.get(0)));
		this.sucursales.add(new Sucursal("SUCURSAL CHIJRA", "Avenida Vicuña 78", "3885557773","Lunes a sábados de 9 a 20hs", provincias.get(0)));
		this.sucursales.add(new Sucursal("CASA CENTRAL", "Cordoba 24", "38854567773", "Lunes a sábados de 9 a 20hs",provincias.get(1)));
	}

	// Getters and Setters
	public List<Sucursal> getSucursales() {
		return sucursales;
	}

	public void setSucursales(List<Sucursal> sucursales) {
		this.sucursales = sucursales;
	}

	public List<String> getProvincias() {
		return provincias;
	}

	public void setProvincias(List<String> provincias) {
		this.provincias = provincias;
	}
}