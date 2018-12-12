package com.neo.dishathome.service.mapper;

import com.neo.dishathome.domain.*;
import com.neo.dishathome.service.dto.PersonDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Person and its DTO PersonDTO.
 */
@Mapper(componentModel = "spring", uses = {KitchenMapper.class})
public interface PersonMapper extends EntityMapper<PersonDTO, Person> {

    @Mapping(source = "cooker.id", target = "cookerId")
    PersonDTO toDto(Person person);

    @Mapping(source = "cookerId", target = "cooker")
    @Mapping(target = "orders", ignore = true)
    @Mapping(target = "comments", ignore = true)
    Person toEntity(PersonDTO personDTO);

    default Person fromId(Long id) {
        if (id == null) {
            return null;
        }
        Person person = new Person();
        person.setId(id);
        return person;
    }
}
