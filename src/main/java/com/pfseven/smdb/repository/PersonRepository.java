package com.pfseven.smdb.repository;

import com.pfseven.smdb.domain.Person;
import com.pfseven.smdb.domain.RoleType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PersonRepository extends JpaRepository<Person, Long> {
    Person getPersonByFirstNameAndLastName(String firstName, String lastName);

    Person findPersonByFirstNameAndLastName(String firstName, String lastName);
}
