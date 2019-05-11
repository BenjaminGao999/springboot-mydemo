package com.example.springboot.mydemo.demolib.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;


/**
 * @author benjamin
 * created at 2019/5/11
 */
@Configuration
@ComponentScan(basePackages = {
        "com.example.springboot.mydemo.demolib",
})
@PropertySource("classpath:application-lib.properties")
@Profile("default")
public class LibAppConfigDefault {
    @Value("${demo-lib-key}")
    private String lib_demo_key;

    /*

   springbootApplication的外部属性（external properties）加载优先级

   优先级从低到高排序：

   lib 的 application-lib.properties
   （要想让lib引用自己的外部属性文件，必须要在lib中显示的执行其要加载的外部文件，并且不能与application的外部属性文件同名）

   SpringbootApplication的 application.properties

   如果lib的application.properties和SpringBootApplication的application.properties同名，
   则lib的外部属性文件会被覆盖点（直接丢弃）

     */


    /*

    lib怎么分dev和prod

@PropertySource("application-lib.properties")
目前是不支持区分不同profile的


     */
}
