package hc.springframework.hcpetclinic.repositories;

import hc.springframework.hcpetclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
}
