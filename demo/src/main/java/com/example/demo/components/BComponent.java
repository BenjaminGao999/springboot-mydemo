package com.example.demo.components;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author benjamin
 * created at 2019/11/20
 */
@Component
@Getter
public class BComponent {
    @Autowired
    private AComponent aComponent;

}
