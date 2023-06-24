package ar.edu.unju.fi.lists;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import ar.edu.unju.fi.entity.DogWalker;

@Component
public class DogWalkerList {

	// region Attributes
	private List<DogWalker> paseadores;
	private List<String> provincias = List.of(
			"Jujuy",
			"Salta",
			"Tucumán");
	// endregion

	// region Constructors
	public DogWalkerList() {

		paseadores = new ArrayList<DogWalker>();

		paseadores.add(new DogWalker(
				"Juan",
				"Tolaba",
				"Lunes",
				LocalTime.of(9, 0),
				LocalTime.of(14, 0),
				provincias.get(0),
				(short) 0));

		paseadores.add(
				new DogWalker(
						"Lucas",
						"Toledo",
						"Martes",
						LocalTime.of(14, 0),
						LocalTime.of(17, 30),
						provincias.get(1),
						(short) 1));

		paseadores.add(
				new DogWalker(
						"Sofia",
						"Limache",
						"Miercoles",
						LocalTime.of(11, 10),
						LocalTime.of(13, 40),
						provincias.get(2),
						(short) 2));

		paseadores.add(
				new DogWalker(
						"Rocio",
						"Condori",
						"Juves",
						LocalTime.of(8, 15),
						LocalTime.of(10, 0),
						provincias.get(0),
						(short) 3));

		paseadores.add(
				new DogWalker(
						"Pablo",
						"Gutierrez",
						"Viernes",
						LocalTime.of(17, 0),
						LocalTime.of(19, 0),
						provincias.get(1),
						(short) 4));

		paseadores.add(
				new DogWalker(
						"Macarena",
						"Castro",
						"Sabado",
						LocalTime.of(16, 0),
						LocalTime.of(18, 20),
						provincias.get(2),
						(short) 5));

		paseadores.add(
				new DogWalker(
						"Gabriel",
						"Vilte",
						"Domingo",
						LocalTime.of(9, 0),
						LocalTime.of(11, 15),
						provincias.get(0),
						(short) 6));

	}
	// endregion

	// region Getters and Setters
	public List<DogWalker> getPaseadores() {
		return paseadores;
	}

	public void setPaseadores(List<DogWalker> paseadores) {
		this.paseadores = paseadores;
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
