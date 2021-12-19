package com.pfseven.smdb.service;

import com.pfseven.smdb.domain.Person;
import com.pfseven.smdb.domain.Position;

public interface PersonService extends BaseService<Person, Long> {
    Person get(String firstName, String lastName);

    Person find(String firstName, String lastName);

    void newPosition(Person person, Position position);

    void removePosition(Person person, Position position);
}
