package com.example.jpa.jap.repositories;

import com.example.jpa.jap.entity.RoleDO;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author benjamin
 * created at 2019/8/24
 */
public interface RoleDao extends JpaRepository<RoleDO,Long> {

}
