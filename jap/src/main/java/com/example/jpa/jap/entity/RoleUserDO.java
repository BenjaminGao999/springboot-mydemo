package com.example.jpa.jap.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * 角色用户关系实体类
 *
 * @author 杨高超
 * @since 2018-03-12
 */
@Entity
@IdClass(RoleUserId.class)
@Table(name = "AUTH_ROLE_USER")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleUserDO {
    @Id
    private Long roleId;
    @Id
    private Long userId;


}

