package se.lexicon.pet_clinic.repository;


import org.springframework.data.repository.CrudRepository;
import se.lexicon.pet_clinic.entity.Owner;
import se.lexicon.pet_clinic.entity.Pet;
import se.lexicon.pet_clinic.entity.PetType;

import java.util.List;

public interface PetRepository extends CrudRepository<Pet, String> {
    List<Pet> findByNameIgnoreCase(String name);

    List<Pet> findByPetTypeName (String name);

    List<Pet> findByOwnerFirstNameAndOwnerLastName(String firstName, String lastName);

    List<Pet> findByOwnerTelephone(String telephone);

    // todo: implement basic CRUD

    //todo: select pet by name
    //todo: select pet by pet type name
    //todo: select pet by owner first name and last name
    //todo: select pet by owner telephone

}
