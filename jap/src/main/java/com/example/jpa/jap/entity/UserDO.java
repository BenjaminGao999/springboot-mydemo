package com.example.jpa.jap.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 用户实体类
 *
 * @author 杨高超
 * @since 2018-03-12
 */
@Entity
@Table(name = "AUTH_USER")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDO {
    @Id
    private Long id;
    @Column(length = 32)
    private String name;
    @Column(length = 32)
    private String account;
    @Column(length = 64)
    private String pwd;
    //    @Column(length = 255)
//    private String others;
    private Integer others;

}