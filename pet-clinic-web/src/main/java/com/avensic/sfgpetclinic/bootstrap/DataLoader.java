package com.avensic.sfgpetclinic.bootstrap;

import com.avensic.sfgpetclinic.model.*;
import com.avensic.sfgpetclinic.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtyService;
    private final VisitService visitService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialtyService specialtiesService, SpecialtyService specialtyService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();

        if (count == 0) {
            loadData();
        }
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Specialty radiology = new Specialty();
        radiology.setDescription("Radiology");
        Specialty savedRadiology = specialtyService.save(radiology);

        Specialty surgery = new Specialty();
        surgery.setDescription("Surgery");
        Specialty savedSurgery = specialtyService.save(surgery);

        Specialty dentistry = new Specialty();
        dentistry.setDescription("Dentistry");
        Specialty savedDentistry = specialtyService.save(dentistry);

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
        owner2.getPets().add(kyrasPet);

        ownerService.save(owner2);

        Visit dogVisit = new Visit();
        dogVisit.setPet(kyrasPet);
        dogVisit.setDate(LocalDate.now());
        dogVisit.setDescription("Running Nose");

        visitService.save(dogVisit);

        System.out.println("Loaded Owners... ");

        Vet vet1 = new Vet();
        vet1.setFirstName("Serious");
        vet1.setLastName("Doctor");
        vet1.getSpecialties().add(savedRadiology);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Funny");
        vet2.setLastName("Medic");
        vet2.getSpecialties().add(savedSurgery);

        vetService.save(vet2);

        System.out.println("Loaded Vets... ");
    }
}
