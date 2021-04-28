package se.lexicon.pet_clinic.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.lexicon.pet_clinic.dto.PetDto;
import se.lexicon.pet_clinic.entity.Pet;
import se.lexicon.pet_clinic.repository.PetRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PetServiceImpl implements PetService {
    PetRepository petRepository;
    ModelMapper modelMapper;

    @Autowired
    public void setPetRepository(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    @Autowired
    public void setModelMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }


    @Override
    public PetDto save(PetDto dto) {
        if (dto == null) throw new IllegalArgumentException("");
        if (dto.getId() != null) throw new IllegalArgumentException("");
        Pet petEntity = modelMapper.map(dto, Pet.class);
        Pet savedPet = petRepository.save(petEntity);
        PetDto converted = modelMapper.map(savedPet, PetDto.class);
        return converted;
    }

    @Override
    public PetDto update(PetDto dto) {
        if (dto == null) throw new IllegalArgumentException("");
        if (dto.getId() == null) throw new IllegalArgumentException("");
        Optional<Pet> optionalPet = petRepository.findById(dto.getId());
        if (optionalPet.isPresent()) {
            return modelMapper.map(petRepository.save(modelMapper.map(dto, Pet.class)), PetDto.class);
        }
        return null;
    }

    @Override
    public void deleteById(String id) {
        if (id == null) throw new IllegalArgumentException("");
        Optional<Pet> optionalPet = petRepository.findById(id);
        if (optionalPet.isPresent())
            petRepository.deleteById(id);
    }

    @Override
    public List<PetDto> getAll() {
        List<Pet> petList = new ArrayList<>();
        petRepository.findAll().iterator().forEachRemaining(petList::add);
        List<PetDto> petDtoList = petList.stream().map(pet -> modelMapper.map(pet, PetDto.class)).collect(Collectors.toList());
        return petDtoList;
    }

    @Override
    public PetDto findById(String id) {
        if (id == null) throw new IllegalArgumentException("");
        Optional<Pet> optionalPet = petRepository.findById(id);
        if (optionalPet.isPresent()) {
            PetDto converted = modelMapper.map(optionalPet.get(), PetDto.class);
            return converted;
        }
        return null;
    }

    @Override
    public List<PetDto> findByName(String name) {
        return petRepository.findByNameIgnoreCase(name).stream()
                .map(pet -> modelMapper.map(pet, PetDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<PetDto> findByPetTypeName(String name) {

        return petRepository.findByPetTypeName(name).stream()
                .map(pet -> modelMapper.map(pet, PetDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<PetDto> findByOwnerFirstNameAndLastName(String firstName, String lastName) {
        return petRepository.findByOwnerFirstNameAndOwnerLastName(firstName, lastName).stream()
                .map(pet -> modelMapper.map(pet, PetDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<PetDto> findByOwnerTelephone(String telephone) {

        return petRepository.findByOwnerTelephone(telephone).stream().map(pet -> modelMapper
                .map(pet, PetDto.class)).collect(Collectors.toList());
    }
    // todo: implement PetService Interface
}
