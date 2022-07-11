package com.example.demo.services;

import com.example.demo.entities.Person;
import com.example.demo.repo.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {
    @Autowired
    private PersonRepo repo;

    public PersonService(PersonRepo personRepo) {
    }

    public List<Person> getAllPerson() {
        return this.repo.findAll();
    }

    public Person savePerson(Person person)
    {
        return repo.save(person);
    }
    public List<Person> savePersons(List<Person> persons)
    {
        return  repo.saveAll(persons);
    }
    public List<Person> getPersons(){
        return  repo.findAll();
    }
    public Person getPersonById(int id){
        return repo.findById(id).orElse(null);
    }
//    public Person getPersonByName(String name){
//        return repo.findByName(name);
//    }
    public String deletePerson(int id){
        repo.deleteById(id);
        return "Person removed!"+id;
    }
    public Person updatePerson(Person person){
        Person existingPerson = repo.findById(person.getPersonId()).orElse(null);
        existingPerson.setPersonName(person.getPersonName());
        existingPerson.setPersonCity(person.getPersonCity());
        return repo.save(existingPerson);
    }
}
