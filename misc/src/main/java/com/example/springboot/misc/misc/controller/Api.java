package com.example.springboot.misc.misc.controller;

import com.example.springboot.misc.misc.exception.MyException;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import org.apache.tomcat.util.http.ResponseUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author benjamin
 * created at 2019/8/21
 */
@RestController
@io.swagger.annotations.Api("api")
public class Api {

    @GetMapping("/exception")
    public Object exception() {

        throw  new NullPointerException("空指针异常");

//        return ResponseEntity.ok("hello");
    }


    @GetMapping
    @ApiOperation(value = "get请求")
    @ApiImplicitParam
    public String get(){

        return null;
    }
}
