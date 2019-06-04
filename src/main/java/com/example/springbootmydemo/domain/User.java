package com.example.springbootmydemo.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author benjamin
 * created at 2019/6/3
 */
@ApiModel("user")
public class User {

    @ApiModelProperty("name名字")
    private String name;

    @ApiModelProperty("id唯一标识")
    private Integer id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
