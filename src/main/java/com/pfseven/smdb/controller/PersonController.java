package com.pfseven.smdb.controller;

import com.pfseven.smdb.domain.Occupation;
import com.pfseven.smdb.domain.Person;
import com.pfseven.smdb.service.BaseService;
import com.pfseven.smdb.service.PersonService;
import com.pfseven.smdb.transfer.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/people")
public class PersonController extends AbstractController<Person> {
    private final PersonService personService;

    @GetMapping(params = {"fn", "ln"})
    public ResponseEntity<ApiResponse<Person>> find(@RequestParam("fn") String firstName,
                                                    @RequestParam("ln") String lastName) {
        return ResponseEntity.ok(ApiResponse.<Person>builder().data(personService.find(firstName, lastName)).build());
    }

    @GetMapping(params = {"fn", "ln"})
    public ResponseEntity<ApiResponse<Person>> get(@RequestParam("fn") String firstName,
                                                   @RequestParam("ln") String lastName) {
        return ResponseEntity.ok(ApiResponse.<Person>builder().data(personService.get(firstName, lastName)).build());
    }

    @Override
    protected BaseService<Person, Long> getService() {
        return personService;
    }
}
