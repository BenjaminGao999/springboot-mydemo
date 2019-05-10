package com.example.springbootmydemo.controller;

import com.example.springbootmydemo.utils.IPAddressUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

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

    @GetMapping("/ip")
    public Object ip(HttpServletRequest request) {
        Map<String, String> result = new HashMap<>();

        Enumeration headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String key = (String) headerNames.nextElement();
            String value = request.getHeader(key);
            result.put(key, value);
        }

        return result;


    }
}
