package ar.edu.unju.fi.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unju.fi.entity.Branch;


/**
 * CustomerRepository extends the CrudRepository interface.
 * The type of entity and ID that it works with, Branch and Long,
 * are specified in the generic parameters on CrudRepository.
 */
@Repository
public interface IBranchRepository extends CrudRepository<Branch, Long> {

    public List<Branch> findByEstado(boolean estado);

}
