package com.mdevi.sfgpetclinic.services.map;

import com.mdevi.sfgpetclinic.model.Pet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class PetMapServiceTest {

    final Long petId = 1L;
    final String name = "Dolly";
    PetMapService petMapService;

    @BeforeEach
    void setUp() {
        petMapService = new PetMapService();
        petMapService.save(Pet.builder().id(petId).name(name).build());
    }

    @Test
    void findById() {
        Pet pet = petMapService.findById(petId);
        assertEquals(petId, pet.getId());
    }

    @Test
    void save() {
        Pet savedPet = petMapService.save(Pet.builder().id(petId).name(name).build());
        assertNotNull(savedPet);
        assertNotNull(savedPet.getId());
    }

    @Test
    void findAll() {
        Set<Pet> pets = petMapService.findAll();
        assertEquals(1, pets.size());
    }


    @Test
    void deleteById() {
        petMapService.deleteById(petId);
        assertTrue(petMapService.findAll().isEmpty());
    }

    @Test
    void delete() {
        petMapService.delete(petMapService.findById(petId));
        assertTrue(petMapService.findAll().isEmpty());
        assertEquals(0, petMapService.findAll().size());
    }
}