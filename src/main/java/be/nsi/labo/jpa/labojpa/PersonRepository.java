package be.nsi.labo.jpa.labojpa;

import org.springframework.data.repository.Repository;

import java.util.Optional;

interface PersonRepository extends Repository<Person, Long> {

  Person save(Person person);

  Optional<Person> findById(long id);
}