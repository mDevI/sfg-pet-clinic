package com.mdevi.sfgpetclinic.repositories;

import com.mdevi.sfgpetclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

/**
 * Repository for Owner DB CRUD operations.
 */
public interface OwnerRepository extends CrudRepository<Owner, Long> {

}
