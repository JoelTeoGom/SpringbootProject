package com.springboot.sringboot.dao;

import com.springboot.sringboot.model.Person;

import java.util.Optional;
import java.util.UUID;
import java.util.List;

public interface PersonDao {
    int insertPerson(UUID id, Person person);
    default int insertPerson(Person person) {
        UUID id = UUID.randomUUID();
        return insertPerson(id, person);
    }

    List<Person> selectAllPeople();

    int deletePersonById(UUID id);
    int updatePersonById(UUID id, Person person);
    Optional<Person> selectPersonById(UUID id);

}
