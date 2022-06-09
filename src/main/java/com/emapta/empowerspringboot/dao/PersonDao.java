package com.emapta.empowerspringboot.dao;

import com.emapta.empowerspringboot.model.Person;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PersonDao {
  int insertPerson(UUID id, Person person);

  int deletePerson(UUID id);

  int updatePerson(UUID id, Person person);

  Optional<Person> selectPersonById(UUID id);

  default int insertPerson(Person person) {
    UUID uuid = UUID.randomUUID();
    return insertPerson(uuid, person);
  }

  List<Person> selectAllPerson();
}
