package com.example.demo.repo;

import com.example.demo.entities.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PersonRepoTest {

    @Autowired
    private PersonRepo personRepo;

//    @Test
//    void isPersonExistById() {
//        Person person = new Person(123,"Mitesh","Pune");
//        personRepo.save(person);
//        Boolean actualResult = personRepo.isPersonExistById(123);
//
//        assertThat(actualResult).isTrue();
//    }


}