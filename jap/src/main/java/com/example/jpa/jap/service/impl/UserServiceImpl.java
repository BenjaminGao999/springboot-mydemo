package com.example.jpa.jap.service.impl;

import com.example.jpa.jap.entity.UserDO;
import com.example.jpa.jap.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author benjamin
 * created at 2019/8/25
 */
@Service
public class UserServiceImpl  implements UserService {

    @Transactional
    @Override
    public void saveUser(UserDO userDO) {

    }
}
