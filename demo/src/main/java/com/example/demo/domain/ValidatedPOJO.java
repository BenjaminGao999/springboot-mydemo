package com.example.demo.domain;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author benjamin
 * created at 2019/9/18
 */
@Data
public class ValidatedPOJO {

    @NotNull
    private Long id;

    @NotNull
    private String name;

}
