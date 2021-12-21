package com.pfseven.smdb.service;

import com.pfseven.smdb.domain.Person;
import com.pfseven.smdb.domain.Occupation;
import com.pfseven.smdb.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl extends BaseServiceImpl<Person> implements PersonService {
    private final PersonRepository personRepository;

    @Override
    public Person get(String firstName, String lastName) {
        return null;
    }

    @Override
    public Person find(String firstName, String lastName) {
        return null;
    }

    @Override
    public void newOccupation(Person person, Occupation occupation) {

    }

    @Override
    public void removeOccupation(Person person, Occupation occupation) {

    }

    @Override
    JpaRepository<Person, Long> getRepository() {
        return personRepository;
    }
}
