package com.example.demo.controllers;

import com.example.demo.entities.Person;
import com.example.demo.repo.PersonRepo;
import com.example.demo.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {

    @Autowired
    private PersonService personService;

    @Autowired
    private PersonRepo personRepo;

    @PostMapping("/addPerson")
    public Person addPerson(@RequestBody Person person){
        return personService.savePerson(person);
    }
//    @PostMapping("/addPersons")
//    public List<Person> addPersons(@RequestBody List<Person> persons)
//    {
//        return personService.savePersons(persons);
//    }
    @GetMapping("/persons")
    public List<Person> findAllPersons(){
        return personService.getPersons();
    }
    @GetMapping("/person/{id}")
    public Person findPersonById(@PathVariable  int id){
        return personService.getPersonById(id);
    }
//    @GetMapping("/person/{name}")
//    public Person findPersonByName(@PathVariable String name){
//        return personService.getPersonByName(name);
//    }

    @PutMapping("/update")
    public Person updatePerson(@RequestBody Person person){
        return personService.updatePerson(person);
    }
    @DeleteMapping("/delete/{id}")
    public String deletePerson(@PathVariable int id){
        return personService.deletePerson(id);
    }
}
