package com.pfseven.smdb.service;

import com.pfseven.smdb.domain.Person;
import com.pfseven.smdb.domain.Occupation;

public interface PersonService extends BaseService<Person, Long> {
    Person get(String firstName, String lastName);

    Person find(String firstName, String lastName);

    void newOccupation(Person person, Occupation occupation);

    void removeOccupation(Person person, Occupation occupation);
}
