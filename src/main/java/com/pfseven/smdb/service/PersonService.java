package com.pfseven.smdb.service;

import com.pfseven.smdb.domain.Person;
import com.pfseven.smdb.domain.Occupation;

public interface PersonService extends BaseService<Person, Long> {

    Person findByName(String firstName, String lastName);
}
