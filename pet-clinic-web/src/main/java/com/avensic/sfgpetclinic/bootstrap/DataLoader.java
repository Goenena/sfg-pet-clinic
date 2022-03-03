package com.avensic.sfgpetclinic.bootstrap;

import com.avensic.sfgpetclinic.model.Owner;
import com.avensic.sfgpetclinic.model.Vet;
import com.avensic.sfgpetclinic.services.OwnerService;
import com.avensic.sfgpetclinic.services.VetService;
import com.avensic.sfgpetclinic.services.map.OwnerServiceMap;
import com.avensic.sfgpetclinic.services.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader() {
        ownerService = new OwnerServiceMap();
        vetService = new VetServiceMap();
    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Aaron");
        owner1.setFirstName("Goenen");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner1.setId(2L);
        owner1.setFirstName("Kyra");
        owner1.setFirstName("de Vries");

        ownerService.save(owner2);

        System.out.println("Loaded Owners... ");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet1.setId(2L);
        vet1.setFirstName("Jessie");
        vet1.setLastName("Porter");

        vetService.save(vet2);

        System.out.println("Loaded Vets... ");

    }
}
