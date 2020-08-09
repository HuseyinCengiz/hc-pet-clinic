package hc.springframework.hcpetclinic.services.map;

import hc.springframework.hcpetclinic.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OwnerMapServiceTest {

    OwnerMapService ownerMapService;

    @BeforeEach
    void setUp() {
        ownerMapService = new OwnerMapService(new PetTypeMapService(), new PetMapService());
        ownerMapService.save(Owner.builder().id(1L).lastName("Cengiz").build());
    }

    @Test
    void findAll() {
        Set<Owner> owners = ownerMapService.findAll();

        assertEquals(1, owners.size());
    }

    @Test
    void findById() {
        Owner owner = ownerMapService.findById(1L);

        assertEquals(1, owner.getId());
    }

    @Test
    void saveExistingId() {
        Owner savedOwner = ownerMapService.save(Owner.builder().id(2L).build());
        assertEquals(2L, savedOwner.getId());
    }

    @Test
    void saveNoId() {
        Owner savedOwner = ownerMapService.save(Owner.builder().build());

        assertNotNull(savedOwner);
        assertNotNull(savedOwner.getId());
    }

    @Test
    void delete() {
        ownerMapService.delete(ownerMapService.findById(1L));
        assertEquals(0, ownerMapService.findAll().size());
    }

    @Test
    void deleteById() {
        ownerMapService.deleteById(1L);
        assertEquals(0, ownerMapService.findAll().size());
    }

    @Test
    void findByLastName() {
        Owner cengiz = ownerMapService.findByLastName("Cengiz");
        assertNotNull(cengiz);
        assertEquals(1L, cengiz.getId());
    }

    @Test
    void findByLastNameNotFound() {
        Owner cengiz = ownerMapService.findByLastName("foo");
        assertNull(cengiz);
    }
}