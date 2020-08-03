package hc.springframework.hcpetclinic.services;

import hc.springframework.hcpetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {
    Owner findByLastName(String lastName);
}
