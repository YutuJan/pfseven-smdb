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
    JpaRepository<Person, Long> getRepository() {
        return personRepository;
    }

    @Override
    public Person get(String firstName, String lastName) {
        return personRepository.getPersonByFirstNameAndLastName(firstName, lastName);
    }

    @Override
    public Person find(String firstName, String lastName) {
        return personRepository.findPersonByFirstNameAndLastName(firstName, lastName);
    }

    @Override
    public void addOccupation(Person person, Occupation occupation) {
        if (isNull(occupation) || isNull(person)) {
            return;
        }

        person.addOccupation(occupation);

        logger.debug("Occupation[{}] added to Person[{}]", occupation, person);
    }

    @Override
    public void removeOccupation(Person person, Occupation occupation) {
        if (isNull(occupation) || isNull(person)) {
            return;
        }

        person.removeOccupation(occupation);

        logger.debug("Occupation[{}] update to Person[{}]", occupation, person);
    }

    @Override
    public void updateOccupation(Person person, Occupation occupation) {
        if (isNull(occupation) || isNull(person)) {
            return;
        }

        person.updateOccupation(occupation);

        logger.debug("Occupation[{}] update to Person[{}]", occupation, person);
    }

    private boolean isNull(Object object) {
        return object == null;
    }
}
