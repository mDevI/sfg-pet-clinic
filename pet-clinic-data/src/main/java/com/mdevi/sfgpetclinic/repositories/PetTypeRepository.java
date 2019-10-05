package com.mdevi.sfgpetclinic.repositories;

import com.mdevi.sfgpetclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
