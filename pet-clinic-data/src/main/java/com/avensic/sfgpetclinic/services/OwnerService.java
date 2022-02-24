package com.avensic.sfgpetclinic.services;

import com.avensic.sfgpetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long>{

    Owner findByLastName(String lastName);

}
