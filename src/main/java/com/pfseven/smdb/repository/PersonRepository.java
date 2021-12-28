package com.pfseven.smdb.repository;

import com.pfseven.smdb.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
    Person getPersonByFirstNameAndLastName(String firstName, String lastName);

    Person findPersonByFirstNameAndLastName(String firstName, String lastName);
}
