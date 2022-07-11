package com.example.demo.controllers;

import com.example.demo.entities.Person;
import com.example.demo.repo.PersonRepo;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class PersonControllerTest {

    @Autowired
    PersonRepo personRepo;
    @Test
    @Order(1)
    void addPerson() {
        Person p = new Person();
        p.setPersonId(1);
        p.setPersonName("Testing1");
        p.setPersonCity("TestCity");
        personRepo.save(p);
        assertNotNull(personRepo.findById(1).get());
    }


    @Test
    @Order(2)
    void findAllPersons() {
        List<Person> list = personRepo.findAll();
        System.out.println(list);
        assertThat(list);
    }

    @Test
    @Order(3)
    void findPersonById() {
        Person person = personRepo.findById(1).get();
        assertEquals("Testing1",person.getPersonName());
    }

    @Test
    @Order(4)
    void updatePerson() {
        Person p = personRepo.findById(1).get();
        p.setPersonName("UpdatedNameTest");
        personRepo.save(p);
        assertNotEquals("Testing1",personRepo.findById(1).get().getPersonName());
    }

    @Test
    @Order(5)
    void deletePerson() {
        personRepo.deleteById(1);
        assertThat(personRepo.existsById(1)).isFalse();
    }
}