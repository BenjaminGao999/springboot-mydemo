package com.example.springbootmydemo.controller;

import com.example.springbootmydemo.domain.User;
import com.example.springbootmydemo.utils.IPAddressUtils;
import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * @author benjamin
 * created at 2019/4/28
 */
@RestController
@Api(tags = "swagger2 tags", description = "看看swagger2注解的用法")
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

    @GetMapping("/header/test")
    public Object headerTest(@RequestHeader(value = "token") String token,
                             @RequestParam(value = "name") String name) {

        System.out.println("token >>>" + token);
        System.out.println("name >>> " + name);

        return new StringBuilder().append("token:").append(token).append(',').append("name:").append(name).toString();

    }

    @GetMapping("/get01")
    public String get01(String name, Integer id) {

        String resp = "name >>> " + name + "; " + " id >>> " + id;

        return resp;

    }

    @GetMapping("/get02")
    @ApiOperation("看看")
    public String get02(User user) {

        String resp = "name >>> " + user.getName() + "; " + " id >>> " + user.getId();

        return resp;

    }

    @GetMapping("/get03")
    @ApiOperation("看看@ApiIgnore咋用的")
    public String get03(@ApiIgnore User user) {

        String resp = "name >>> " + user.getName() + "; " + " id >>> " + user.getId();

        return resp;

    }

    @GetMapping("/get04")
    @ApiOperation("看看@ApiIgnore咋用的")
    @ApiIgnore// @ApiIgnore的作用是隐藏，可以隐藏controller方法，也可以隐藏controller方法中的参数
    public String get04(User user) {

        String resp = "name >>> " + user.getName() + "; " + " id >>> " + user.getId();

        return resp;

    }

    /*

        自定义响应消息
Swagger 允许我们通过 Docket 的 globalResponseMessage() 方法全局覆盖 HTTP 方法的响应消息，但是首先我们得通过 Docket 的 useDefaultResponseMessages 方法告诉 Swagger 不使用默认的 HTTP 响应消息，假设我们现在需要覆盖所有 GET 方法的 500 和 403 错误的响应消息，我们只需要在 SwaggerConfig.java 类中的 Docket Bean 下添加如下内容：


添加如上面的代码后，如下图所示，您会发现在 SwaggerUI 页面展示的所有 GET 类型请求的 403 以及 500 错误的响应消息都变成了我们自定义的内容。



     */
    @GetMapping("/get05")
    @ApiOperation("搞一个500异常")
    public String get05() {

        return "" + 1 / 0;

    }


    @ApiOperation(value = "用户登录", notes = "手机号、密码都是必输项，年龄随便填，但必须是数字")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "mobile", value = "手机号", required = true, paramType = "form"),
            @ApiImplicitParam(name = "password", value = "密码", required = true, paramType = "form"),
            @ApiImplicitParam(name = "age", value = "年龄", required = true, paramType = "form", dataType = "int")
    })
    @PostMapping(value = "/post01", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ApiResponses({
            @ApiResponse(code = 400, message = "请求参数没填好"),
            @ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对")
    })
    public String login(@RequestParam String mobile,
                        @RequestParam String password,
                        @RequestParam Integer age, HttpServletResponse servletResponse) {
//        servletResponse.setStatus(400);
        return "mobile: " + mobile + ", password: " + password + ", age:" + age;
    }

}
