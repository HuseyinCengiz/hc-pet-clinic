package hc.springframework.hcpetclinic.services.jpa;

import hc.springframework.hcpetclinic.model.Owner;
import hc.springframework.hcpetclinic.repositories.OwnerRepository;
import hc.springframework.hcpetclinic.repositories.PetRepository;
import hc.springframework.hcpetclinic.repositories.PetTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;


@ExtendWith(MockitoExtension.class)
class OwnerServiceJPATest {

    @Mock
    OwnerRepository ownerRepository;
    @Mock
    PetRepository petRepository;
    @Mock
    PetTypeRepository petTypeRepository;

    @InjectMocks
    OwnerServiceJPA service;

    Owner fakeOwner;

    @BeforeEach
    void setUp() {
        fakeOwner = Owner.builder().id(1L).lastName("Cengiz").build();
    }

    @Test
    void findByLastName() {

        Mockito.when(ownerRepository.findByLastName("Cengiz")).thenReturn(fakeOwner);

        Owner cengiz = service.findByLastName("Cengiz");

        assertEquals("Cengiz", cengiz.getLastName());

        Mockito.verify(ownerRepository).findByLastName(any());
    }

    @Test
    void findAll() {
        Set<Owner> returnOwnersSet = new HashSet<>();
        returnOwnersSet.add(Owner.builder().id(1l).build());
        returnOwnersSet.add(Owner.builder().id(2l).build());

        Mockito.when(ownerRepository.findAll()).thenReturn(returnOwnersSet);

        Set<Owner> owners = service.findAll();

        assertNotNull(owners);
        assertEquals(2, owners.size());
    }

    @Test
    void findById() {
        Mockito.when(ownerRepository.findById(anyLong())).thenReturn(Optional.of(fakeOwner));

        Owner owner = service.findById(1L);

        assertNotNull(owner);
    }

    @Test
    void findByIdNotFound() {
        Mockito.when(ownerRepository.findById(anyLong())).thenReturn(Optional.empty());

        Owner owner = service.findById(1L);

        assertNull(owner);
    }


    @Test
    void save() {
        Owner ownerToSave = Owner.builder().id(1L).build();

        Mockito.when(ownerRepository.save(any())).thenReturn(fakeOwner);

        Owner savedOwner = service.save(ownerToSave);

        assertNotNull(savedOwner);

        Mockito.verify(ownerRepository).save(any());
    }

    @Test
    void delete() {
        service.delete(fakeOwner);

        //default is 1 times
        Mockito.verify(ownerRepository, Mockito.times(1)).delete(any());
    }

    @Test
    void deleteById() {
        service.deleteById(1L);

        Mockito.verify(ownerRepository).deleteById(anyLong());
    }
}