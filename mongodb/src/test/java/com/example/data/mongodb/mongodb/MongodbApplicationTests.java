package com.example.data.mongodb.mongodb;

import com.example.data.mongodb.mongodb.dao.PersonRepository;
import com.example.data.mongodb.mongodb.domain.Address;
import com.example.data.mongodb.mongodb.domain.Person;
import com.example.data.mongodb.mongodb.domain.Person1;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit4.SpringRunner;


import org.springframework.data.mongodb.core.query.Query;

import javax.annotation.Resource;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static org.springframework.data.mongodb.core.query.Criteria.where;


@RunWith(SpringRunner.class)
@SpringBootTest
public class MongodbApplicationTests {

    private static final Logger logger = LoggerFactory.getLogger(MongodbApplicationTests.class);

    @Resource
    MongoTemplate mongoOps;

    @Test
    public void contextLoads() {

//        MongoOperations mongoOps = new MongoTemplate(new MongoClient(), "database");
        Person1 joe = new Person1("Joe", 34);
        mongoOps.insert(joe);
        // 会写id
        logger.info(joe.toString());
        Person1 person1 = mongoOps.findOne(new Query(where("name").is("Joe")), Person1.class);
        logger.info(person1.toString());
        mongoOps.dropCollection("person1");

    }

    @Resource
    PersonRepository repository;

    @Before
    public void addPerson() {
        repository.deleteAll();

        for (int i = 0; i < 11; i++) {
            Address address = new Address();
            address.setName("凯城金座");
            address.setStreetAddress("余杭区五常大道");
            address.setCity("杭州");
            address.setState("浙江");
            Person person = new Person();
            person.setAddress(address);
            person.setFirstname("高");
            person.setLastname("大海");
            repository.save(person);

        }

    }

    @Test
    public void readsFirstPageCorrectly() {

        Page<Person> persons = repository.findAll(PageRequest.of(0, 10));
        List<Person> list = persons.stream().collect(Collectors.toList());
        list.forEach(person -> System.out.println(person));
    }


    @Test
    public void findByThePersonsFirstname() {

        List<Person> list = repository.findByThePersonsFirstname("高");

        list.forEach(System.out::println);
    }

    @After
    public void deleteAll() {
        repository.deleteAll();
    }

}
