package ar.edu.unju.fi;

//import java.time.LocalDate;
//import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

//import ar.edu.unju.fi.entity.Sucursal;
//import ar.edu.unju.fi.service.ISucursalService;

@SpringBootTest
class TpGrupo44ApplicationTests {

	// @Autowired
	// private IBranchService branchService;

	// @Autowired
	// private IProvinceService provinceService;

	// Sucursal sucursal;
	// Provincia provincia;
	@Autowired
//	private ISucursalService sucursalService;
	@Test
	void contextLoads() {
	}

	// @Test
	// void guardarSucursal() {

	// 	sucursal = new Sucursal();
	// 	provincia = new Provincia();
	// 	sucursal.setDireccion("asdf");
	// 	// sucursal.setEstado(false);
	// 	sucursal.setHorarioApertura(LocalTime.of(1, 2, 3));
	// 	sucursal.setHorarioCierre(LocalTime.of(5, 4, 8));
	// 	sucursal.setNombre("cosito");
	// 	sucursal.setNumeroDireccion("5");
	// 	sucursal.setTelefono("65432189");
		
	// 	provincia.setNombre("Jujuy");

	// 	sucursal.setProvincia(provincia);

	// 	branchService.saveNewBranchOffice(sucursal);

	// }

	// @Test
	// void eliminarSucursal() {
	// 	sucursal = branchService.findBranchOfficeByIdentifier(2);
	// 	branchService.deleteBranchOfficeByIdentifier(sucursal);
	// }
	/*
		@Test 
		void listarsucursalentrefechas(){
			List<Sucursal> sucursales = sucursalService.findSucursalesByFechaInicioAndFechaFin(LocalDate.of(2014, 4, 1),LocalDate.of(2014, 4, 20));
			for(Sucursal sucu:sucursales) {
				System.out.println(sucu.getNombre());
			}
		}
		*/
}
