package ar.edu.unju.fi.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unju.fi.entity.Branch;

@Repository
public interface IBranchRepository extends CrudRepository<Branch, Long> {

    public List<Branch> findByEstado(boolean estado);

}
