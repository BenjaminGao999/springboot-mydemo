package com.example.springbootmydemo.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author benjamin
 * created at 2019/4/28
 */
@RestController
public class MvcController {

    /**
     * benjamin
     * 25
     * name=benjamin
     * {"name":"benjamin","age":25}
     */
    @PostMapping("/mvc")
    public String mvc(@RequestParam(required = true) String name, HttpServletRequest request, @RequestBody String body) {
        try {
            System.out.println(name);
            String age = request.getHeader("age");
            System.out.println(age);
            System.out.println(request.getQueryString());

            System.out.println(body);
            return "";
        } finally {

            System.out.println("finally");
        }
    }
}
