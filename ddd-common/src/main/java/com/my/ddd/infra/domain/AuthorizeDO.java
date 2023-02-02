package com.my.ddd.infra.domain;

import com.my.ddd.infra.dto.AddressDTO;
import com.my.ddd.infra.dto.RoleDTO;
import com.my.ddd.infra.dto.UnitDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 对身份授权(assign) 领域对象.
 *
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthorizeDO {

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 真是姓名
     */
    private String realName;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 密码
     */
    private String password;

    /**
     * 用户单位
     */
    private UnitDTO unit;

    /**
     * 用户地址
     */
    private AddressDTO address;

    /**
     * 用户角色
     */
    private List<RoleDTO> roles;
}
