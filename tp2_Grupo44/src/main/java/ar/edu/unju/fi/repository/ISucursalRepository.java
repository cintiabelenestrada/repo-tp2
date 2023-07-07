package ar.edu.unju.fi.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unju.fi.entity.Sucursal;

@Repository
public interface ISucursalRepository extends CrudRepository<Sucursal, Long> {

    public List<Sucursal> findByEstado(boolean estado);

	public List<Sucursal> findByFechaAperturaBetween(LocalDate fechaInicio, LocalDate fechaFin);

}
/*@Repository
public interface ISucursalRepository extends JpaRepository<Sucursal, Long> {
    List<Sucursal> findByNombre(String nombre);
}*/