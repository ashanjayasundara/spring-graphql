package com.emapta.empowerspringboot.api;

import com.emapta.empowerspringboot.model.Person;
import com.emapta.empowerspringboot.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.lang.NonNull;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/person")
@RestController
public class PersonController {
  private final PersonService personService;

  @Autowired
  public PersonController(@Qualifier("personService") PersonService personService) {
    this.personService = personService;
  }

  @PostMapping
  public void addPerson(@RequestBody @Validated @NonNull Person person) {
    personService.addPerson(person);
  }

  @GetMapping
  public List<Person> getAllPerson() {
    return personService.getAllPerson();
  }

  @GetMapping(path = "{id}")
  public Person getPersonById(@PathVariable("id") UUID id){
    return personService.getPersonById(id).orElse(null);
  }
}
