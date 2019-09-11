package com.example.data.mongodb.mongodb.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;

/**
 * @author benjamin
 * created at 2019/9/11
 */
@Data
public class Person {
    @Id
    private String id;
    private String firstname;
    private String lastname;
    private Address address;


}
