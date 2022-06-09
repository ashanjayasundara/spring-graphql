package com.emapta.empowerspringboot.dao;

import com.emapta.empowerspringboot.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("postgresql")
public class PersonDataAccessService implements PersonDao {
  private final JdbcTemplate jdbcTemplate;

  @Autowired
  public PersonDataAccessService(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  @Override
  public int insertPerson(UUID id, Person person) {
    return 0;
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
  public Optional<Person> selectPersonById(UUID id) {
    return Optional.empty();
  }

  @Override
  public List<Person> selectAllPerson() {
    final String sql = "SELECT id,name FROM person";
    List<Person> personList = jdbcTemplate.query(sql, (resultSet, i) -> {
      return new Person(
        UUID.fromString(resultSet.getString("id")),
        resultSet.getString("name")
      );
    });
    return personList;

  }
}
