package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/person")
@CrossOrigin(origins = "*")
public class PersonController {

    private final PersonRepository repository;

    public PersonController(PersonRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public ResponseEntity<Person> save(@RequestBody Person person) {
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(person));
    }

    @GetMapping
    public ResponseEntity<List<Person>> get() {
        List<Person> list = repository.findAll();
        return ResponseEntity.status(list.size() > 0 ? HttpStatus.OK : HttpStatus.NO_CONTENT).body(list);
    }
}
