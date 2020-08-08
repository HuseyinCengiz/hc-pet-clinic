package hc.springframework.hcpetclinic.repositories;

import hc.springframework.hcpetclinic.model.Speciality;
import org.springframework.data.repository.CrudRepository;

public interface SpecialtyRepository extends CrudRepository<Speciality, Long> {
}
