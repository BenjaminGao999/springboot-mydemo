package com.example.jpa.jap.repositories;

import com.example.jpa.jap.entity.RoleUserDO;
import com.example.jpa.jap.entity.RoleUserId;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author benjamin
 * created at 2019/8/24
 */
public interface RoleUserDao extends JpaRepository<RoleUserDO,RoleUserId> {

}
