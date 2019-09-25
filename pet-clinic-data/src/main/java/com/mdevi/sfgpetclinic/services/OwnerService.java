package com.mdevi.sfgpetclinic.services;

import com.mdevi.sfgpetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);

}
