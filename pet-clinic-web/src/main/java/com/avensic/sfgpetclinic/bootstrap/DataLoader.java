package com.avensic.sfgpetclinic.bootstrap;

import com.avensic.sfgpetclinic.model.Owner;
import com.avensic.sfgpetclinic.model.Pet;
import com.avensic.sfgpetclinic.model.PetType;
import com.avensic.sfgpetclinic.model.Vet;
import com.avensic.sfgpetclinic.services.OwnerService;
import com.avensic.sfgpetclinic.services.PetTypeService;
import com.avensic.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstName("Aaron");
        owner1.setLastName("Goenen");
        owner1.setAddress("Alfred Comte Strasse 9");
        owner1.setCity("Dietikon");
        owner1.setTelephone("+797668456");

        Pet aaronsPet = new Pet();
        aaronsPet.setPetType(savedDogPetType);
        aaronsPet.setOwner(owner1);
        aaronsPet.setBirthDate(LocalDate.now());
        aaronsPet.setName("Skip");
        owner1.getPets().add(aaronsPet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Kyra");
        owner2.setLastName("de Vries");
        owner2.setAddress("Alfred Comte Strasse 9");
        owner2.setCity("Dietikon");
        owner2.setTelephone("+791234567");

        Pet kyrasPet = new Pet();
        kyrasPet.setPetType(savedDogPetType);
        kyrasPet.setOwner(owner2);
        kyrasPet.setBirthDate(LocalDate.now());
        kyrasPet.setName("Finn");
        owner1.getPets().add(kyrasPet);

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
