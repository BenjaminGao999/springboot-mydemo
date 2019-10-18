package com.example.data.mongodb.mongodb.domain;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author benjamin
 * created at 2019/9/11
 */
@Data
@Accessors(chain = true)
public class Address {

    private String name;
    private String streetAddress;
    private String city;
    private String state;
    private String zipCode;


}
