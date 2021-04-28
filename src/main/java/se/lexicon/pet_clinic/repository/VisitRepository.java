package se.lexicon.pet_clinic.repository;

import org.springframework.data.repository.CrudRepository;
import se.lexicon.pet_clinic.entity.Pet;
import se.lexicon.pet_clinic.entity.PetType;
import se.lexicon.pet_clinic.entity.Visit;

import java.util.List;

public interface VisitRepository extends CrudRepository<Visit, String> {
    // todo: implement basic CRUD
    List<Visit> findByPetName (String name);
    List<Visit> findByPet_PetTypeName (String name);


    //todo: select visit by pet name
    //todo: select visit by pet type name
}
