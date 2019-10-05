package com.mdevi.sfgpetclinic.repositories;

import com.mdevi.sfgpetclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
