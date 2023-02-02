package com.my.ddd.infra.repository.mybatis.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

/**
 * 用户表
 *
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName(value = "t_role", autoResultMap = true)
public class RolePO extends BaseUuidEntity {

    /** 角色名称 */
    private String name;

    /** 角色code */
    private String code;
}
