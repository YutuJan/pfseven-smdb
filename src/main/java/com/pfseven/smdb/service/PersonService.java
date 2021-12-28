package com.pfseven.smdb.service;

import com.pfseven.smdb.domain.Person;
import com.pfseven.smdb.domain.Occupation;
import com.pfseven.smdb.domain.VideoEntertainment;

public interface PersonService extends BaseService<Person, Long> {
    Person get(String firstName, String lastName);

    Person find(String firstName, String lastName);

    void addOccupation(Person person, Occupation occupation);

    void removeOccupation(Person person, Occupation occupation);

    void updateOccupation(Person person, Occupation occupation);
}
