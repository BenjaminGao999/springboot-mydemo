package com.example.springbootmydemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

/**
 * @author benjamin
 * created at 2019/6/3
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {

    @Bean
    public Docket api() {
        ArrayList<ResponseMessage> messageArrayList = new ArrayList<>();
        ResponseMessage error500 = new ResponseMessageBuilder()
                .code(500)
                .message("服务器发生异常")
                .responseModel(new ModelRef("Erroe"))
                .build();
        messageArrayList.add(error500);
        ResponseMessage error403 = new ResponseMessageBuilder()
                .code(403)
                .message("资源不可用")
                .build();
        messageArrayList.add(error403);


        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .useDefaultResponseMessages(false)
                .globalResponseMessage(RequestMethod.GET, messageArrayList);


    }

}
