package com.pfseven.smdb.service;

import com.pfseven.smdb.domain.Person;
import com.pfseven.smdb.domain.Position;
import com.pfseven.smdb.repository.BaseRepository;
import com.pfseven.smdb.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
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
    public void newPosition(Person person, Position position) {

    }

    @Override
    public void removePosition(Person person, Position position) {

    }

    @Override
    BaseRepository<Person, Long> getRepository() {
        return personRepository;
    }
}
