package com.mdevi.sfgpetclinic.bootstrap;

import com.mdevi.sfgpetclinic.map.OwnerServiceMap;
import com.mdevi.sfgpetclinic.map.VetServiceMap;
import com.mdevi.sfgpetclinic.model.Owner;
import com.mdevi.sfgpetclinic.model.Vet;
import com.mdevi.sfgpetclinic.services.OwnerService;
import com.mdevi.sfgpetclinic.services.VetService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private static final Logger LOG = LoggerFactory.getLogger(DataLoader.class);

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader() {
        this.ownerService = new OwnerServiceMap();
        this.vetService = new VetServiceMap();
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Fiona");
        owner2.setLastName("Glenanne");

        ownerService.save(owner2);

        System.out.println("Loaded Owners...");
        LOG.info("Owners data loaded...");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Sam");
        vet2.setLastName("Axe");

        vetService.save(vet2);

        System.out.println("Loaded Vets...");
        LOG.info("Vets data loaded...");
    }
}
