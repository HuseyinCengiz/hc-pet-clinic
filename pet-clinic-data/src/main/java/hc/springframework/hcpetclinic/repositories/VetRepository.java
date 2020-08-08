package hc.springframework.hcpetclinic.repositories;

import hc.springframework.hcpetclinic.model.Vet;
import org.springframework.data.repository.CrudRepository;

public interface VetRepository extends CrudRepository<Vet, Long> {
}
