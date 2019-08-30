package com.example.javastreams.javastreamsdemo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author benjamin
 * created at 2019/8/29
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    private Integer id;

    private  String name;

    private Integer clazzId;


}
