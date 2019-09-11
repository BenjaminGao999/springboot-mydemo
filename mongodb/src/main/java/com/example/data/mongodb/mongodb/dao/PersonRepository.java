package com.example.data.mongodb.mongodb.dao;

import com.example.data.mongodb.mongodb.domain.Person;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author benjamin
 * created at 2019/9/11
 */
@Repository
public interface PersonRepository extends PagingAndSortingRepository<Person, String> {

    @Query("{ 'firstname' : ?0 }")
    List<Person> findByThePersonsFirstname(String firstname);


}
