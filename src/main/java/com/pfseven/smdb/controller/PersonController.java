package com.pfseven.smdb.controller;

import com.pfseven.smdb.domain.Person;
import com.pfseven.smdb.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/people")
public class PersonController {
    private final PersonService personService;

    @GetMapping
    public List<Person> findAll() {
        return personService.findAll();
    }

    @GetMapping("/{id}")
    public Person find(@PathVariable Long id) {
        return personService.find(id);
    }

    @GetMapping(params = {"fn", "ln"})
    public Person find(@RequestParam("fn") String firstName, @RequestParam("ln") String lastName) {
        return personService.find(firstName, lastName);
    }

    @PostMapping
    public Person create(@Valid @RequestBody Person person) {
        return personService.create(person);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@Valid @RequestBody Person person) {
        personService.update(person);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) {
        personService.deleteById(id);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@Valid @RequestBody Person person) {
        personService.delete(person);
    }
}
