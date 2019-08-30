package com.example.jpa.jap.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 角色实体类
 *
 * @author 杨高超
 * @since 2018-03-12
 */
@Entity
@Table(name = "AUTH_ROLE")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoleDO {
    @Id
    private Long id;
    @Column(length = 32)
    private String name;
    @Column(length = 64)
    private String note;


}

