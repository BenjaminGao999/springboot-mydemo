package com.example.jpa.jap.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 联合主键对象
 *
 * @author 杨高超
 * @since 2018-03-12
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleUserId implements Serializable {
    private Long roleId;
    private Long userId;
}

