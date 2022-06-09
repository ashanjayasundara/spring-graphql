package com.emapta.empowerspringboot.dao;

import com.emapta.empowerspringboot.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("personDao")
public class PersonDaoImpl implements PersonDao {
  private static List<Person> DB = new ArrayList<>();

  @Override
  public int insertPerson(UUID id, Person person) {
    DB.add(person);
    return 1;
  }

  @Override
  public int deletePerson(UUID id) {
    return 0;
  }

  @Override
  public int updatePerson(UUID id, Person person) {
    return 0;
  }

  @Override
  public List<Person> selectAllPerson() {
    return DB;
  }

  @Override
  public Optional<Person> selectPersonById(UUID id) {
    return DB.stream()
      .filter(person -> person.getId().equals(id))
      .findFirst();
  }
}
