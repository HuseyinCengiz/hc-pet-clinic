package hc.springframework.hcpetclinic.repositories;

import hc.springframework.hcpetclinic.model.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
