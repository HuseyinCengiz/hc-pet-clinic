package hc.springframework.hcpetclinic.repositories;

import hc.springframework.hcpetclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
