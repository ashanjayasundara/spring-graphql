package com.emapta.empowerspringboot.service;

import com.emapta.empowerspringboot.dao.PersonDao;
import com.emapta.empowerspringboot.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service("personService")
public class PersonService {
  private final PersonDao personDao;

  @Autowired
  public PersonService(@Qualifier("postgresql") PersonDao personDao) {
    this.personDao = personDao;
  }

  public int addPerson(Person person) {
    return personDao.insertPerson(person);
  }

  public List<Person> getAllPerson() {
    return personDao.selectAllPerson();
  }

  public Optional<Person> getPersonById(UUID id){
    return personDao.selectPersonById(id);
  }
}
