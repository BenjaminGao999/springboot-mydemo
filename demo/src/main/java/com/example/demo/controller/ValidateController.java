package com.example.demo.controller;

import com.example.demo.domain.ValidatedPOJO;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotEmpty;
import java.util.Arrays;
import java.util.List;

/**
 * @author benjamin
 * created at 2019/9/18
 */
@RestController("/api/v1")
public class ValidateController {

    @PostMapping("/validated")
    public String validatedTest(@Validated @RequestBody ValidatedPOJO pojo) {
        return pojo.toString();

    }


    @DeleteMapping("/delete/ids")
    public String batchDelete(@RequestBody @NotEmpty List<Integer> ids) {
        String x = Arrays.toString(ids.toArray());
        System.out.println(x);

        return x;
    }
}
