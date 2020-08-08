package hc.springframework.hcpetclinic.repositories;

import hc.springframework.hcpetclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
