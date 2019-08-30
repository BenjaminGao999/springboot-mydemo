package com.example.jpa.jap.repositories;


import com.example.jpa.jap.entity.UserDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 用户服务数据接口类
 *
 * @author 杨高超
 * @since 2018-03-12
 */

@Repository
public interface UserDao extends JpaRepository<UserDO, Long> {
    UserDO findByAccount(String account);

    UserDO findByAccountAndPwd(String account, String pwd);


    List<UserDO> findAllByIdGreaterThan(Long id);

    // 单张表
    @Query(nativeQuery = true, value = "SELECT * FROM AUTH_USER WHERE name = :name1  OR name = :name2 ")
    List<UserDO> findSQL(@Param("name1") String name1, @Param("name2") String name2);


    // 两张表
    @Query(nativeQuery = true, value = "SELECT U.* FROM AUTH_USER U ,AUTH_ROLE_USER RU WHERE U.id = RU.user_id AND RU.role_id = :roleId")
    List<UserDO> findUsersByRole(@Param("roleId") Long roleId);

}