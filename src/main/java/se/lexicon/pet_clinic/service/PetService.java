package se.lexicon.pet_clinic.service;

import se.lexicon.pet_clinic.dto.PetDto;

import java.util.List;

public interface PetService {

    // todo: define SAVE, UPDATE, DELETE, Find All, FIND BY ID, find By Name, find By PetTypeName, find By OwnerFirstNameAndLastName, find By OwnerTelephone

    PetDto save(PetDto dto);

    PetDto update(PetDto dto);

    void deleteById(String id);

    List<PetDto> getAll();

    PetDto findById(String id);

    List<PetDto> findByName(String name);

    List<PetDto> findByPetTypeName(String name);

    List<PetDto> findByOwnerFirstNameAndLastName(String firstName, String lastName);

    List<PetDto> findByOwnerTelephone(String telephone);
}
