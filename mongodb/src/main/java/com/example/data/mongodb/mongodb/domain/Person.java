package com.example.data.mongodb.mongodb.domain;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author benjamin
 * created at 2019/9/11
 */
@Data
@Document(value = "person")
@Accessors(chain = true)
public class Person {
    @Id
    private String id;
    private String firstname;
    private String lastname;
    private Address address;


}
