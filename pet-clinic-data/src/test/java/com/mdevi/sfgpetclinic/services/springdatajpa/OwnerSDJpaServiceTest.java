package com.mdevi.sfgpetclinic.services.springdatajpa;

import com.mdevi.sfgpetclinic.model.Owner;
import com.mdevi.sfgpetclinic.repositories.OwnerRepository;
import com.mdevi.sfgpetclinic.repositories.PetRepository;
import com.mdevi.sfgpetclinic.repositories.PetTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {

    public static final String LAST_NAME = "Smith";
    @Mock
    OwnerRepository ownerRepository;
    @Mock
    PetRepository petRepository;
    @Mock
    PetTypeRepository petTypeRepository;
    @InjectMocks
    OwnerSDJpaService service;

    Owner returnedOwner;

    @BeforeEach
    void setUp() {
        returnedOwner = Owner.builder().id(1L).lastName(LAST_NAME).build();
    }

    @Test
    void findByLastName() {
        // given
        Owner returnedOwner = Owner.builder().id(1L).lastName(LAST_NAME).build();
        when(ownerRepository.findByLastName(any())).thenReturn(returnedOwner);
        // when
        Owner smith = service.findByLastName(LAST_NAME);
        // then
        assertEquals(LAST_NAME, smith.getLastName());
        verify(ownerRepository).findByLastName(any());
    }

    @Test
    void findById() {
        // given
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.of(returnedOwner));
        // when
        Owner owner = service.findById(1L);
        // then
        assertNotNull(owner);
    }

    @Test
    void findByIdNotFound() {
        // given
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.empty());
        // when
        Owner owner = service.findById(1L);
        // then
        assertNull(owner);
    }

    @Test
    void save() {
        // given
        Owner ownerToSave = Owner.builder().id(1L).build();
        when(ownerRepository.save(any())).thenReturn(returnedOwner);
        // when
        Owner savedOwner = service.save(ownerToSave);
        //then
        assertNotNull(savedOwner);
        verify(ownerRepository).save(any());
    }

    @Test
    void findAll() {
        // given
        Set<Owner> returnOwnersSet = new HashSet<>();
        returnOwnersSet.add(Owner.builder().id(1L).build());
        returnOwnersSet.add(Owner.builder().id(2L).build());

        when(ownerRepository.findAll()).thenReturn(returnOwnersSet);
        // when
        Set<Owner> owners = service.findAll();
        // then
        assertNotNull(owners);
        assertEquals(2, owners.size());
    }

    @Test
    void delete() {
        service.delete(returnedOwner);
        verify(ownerRepository, times(1)).delete(any());
    }

    @Test
    void deleteById() {
        service.deleteById(1L);
        verify(ownerRepository).deleteById(anyLong());
    }
}