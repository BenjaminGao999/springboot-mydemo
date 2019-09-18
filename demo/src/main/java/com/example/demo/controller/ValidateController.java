package com.example.demo.controller;

import com.example.demo.domain.ValidatedPOJO;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author benjamin
 * created at 2019/9/18
 */
@RestController("/api/v1")
public class ValidateController {

    @PostMapping("/validated")
    public String validatedTest(@Validated ValidatedPOJO pojo) {
        return pojo.toString();

    }
}
