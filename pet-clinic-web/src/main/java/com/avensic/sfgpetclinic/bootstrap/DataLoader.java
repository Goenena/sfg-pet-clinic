package com.avensic.sfgpetclinic.bootstrap;

import com.avensic.sfgpetclinic.model.Owner;
import com.avensic.sfgpetclinic.model.Vet;
import com.avensic.sfgpetclinic.services.OwnerService;
import com.avensic.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner1 = new Owner();
        owner1.setFirstName("Aaron");
        owner1.setLastName("Goenen");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Kyra");
        owner2.setLastName("de Vries");

        ownerService.save(owner2);

        System.out.println("Loaded Owners... ");

        Vet vet1 = new Vet();
        vet1.setFirstName("Serious");
        vet1.setLastName("Doctor");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Funny");
        vet2.setLastName("Medic");

        vetService.save(vet2);

        System.out.println("Loaded Vets... ");

    }
}
