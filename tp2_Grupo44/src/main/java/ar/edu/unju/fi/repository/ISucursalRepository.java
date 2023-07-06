package ar.edu.unju.fi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unju.fi.entity.Sucursal;

/*@Repository
public interface ISucursalRepository extends CrudRepository<Sucursal, Long> {

    public List<Sucursal> findByEstado(boolean estado);

	public List<Sucursal> findByFechaInicioBetweenAndFechaFinBetween(String fechaInicio, String fechaFin);

}*/
@Repository
public interface ISucursalRepository extends JpaRepository<Sucursal, Long> {
	
	List<Sucursal> findByEstado(boolean estado);

	List<Sucursal> findByFechaApertura(String fechaApertura);
	
    List<Sucursal> findByNombre(String nombre);
}