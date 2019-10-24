package com.mdevi.sfgpetclinic.controllers;

import com.mdevi.sfgpetclinic.model.Owner;
import com.mdevi.sfgpetclinic.model.PetType;
import com.mdevi.sfgpetclinic.services.OwnerService;
import com.mdevi.sfgpetclinic.services.PetService;
import com.mdevi.sfgpetclinic.services.PetTypeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Set;

@Controller
@RequestMapping("/owners/{ownerId}")
public class PetController {

    public static final String VIEWS_PETS_CREATE_OR_UPDATE_FORM = "pets/createOrUpdatePetForm";

    private final PetTypeService petTypeService;
    private final OwnerService ownerService;
    private final PetService petService;


    public PetController(PetTypeService petTypeService, OwnerService ownerService, PetService petService) {
        this.petTypeService = petTypeService;
        this.ownerService = ownerService;
        this.petService = petService;
    }

    @InitBinder("owner")
    public void initOwnerBinder(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }

    @ModelAttribute("types")
    public Set<PetType> populatePetTypes() {
        return petTypeService.findAll();
    }

    @ModelAttribute("owner")
    public Owner findOwner(@PathVariable String ownerId) {
        return ownerService.findById(Long.valueOf(ownerId));
    }


}
