package ar.edu.unju.fi;

import java.time.LocalTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import ar.edu.unju.fi.entity.Branch;
import ar.edu.unju.fi.entity.Province;
import ar.edu.unju.fi.service.IBranchService;

@SpringBootTest
class TpGrupo44ApplicationTests {

	@Autowired
	private IBranchService branchService;

	// @Autowired
	// private IProvinceService provinceService;

	Branch sucursal;
	Province provincia;

	@Test
	void contextLoads() {
	}

	@Test
	void guardarSucursal() {

		sucursal = new Branch();
		provincia = new Province();
		sucursal.setDireccion("asdf");
		sucursal.setEstado(false);
		sucursal.setHorarioApertura(LocalTime.of(1, 2, 3));
		sucursal.setHorarioCierre(LocalTime.of(5, 4, 8));
		sucursal.setNombre("cosito");
		sucursal.setNumeroDireccion("5");
		sucursal.setTelefono("65432189");
		
		provincia.setNombre("Jujuy");

		sucursal.setProvincia(provincia);

		branchService.saveNewBranchOffice(sucursal);

	}

	// @Test
	// void eliminarSucursal() {
	// 	sucursal = branchService.findBranchOfficeByIdentifier(2);
	// 	branchService.deleteBranchOfficeByIdentifier(sucursal);
	// }

}
