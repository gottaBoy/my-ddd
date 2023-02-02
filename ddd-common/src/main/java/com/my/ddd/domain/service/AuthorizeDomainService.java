package com.my.ddd.domain.service;

import com.my.ddd.infra.domain.AuthorizeDO;

/**
 * 用户授权 领域能力
 *
 */
public interface AuthorizeDomainService {
    /**
     * 设置单位信息
     *
     * @param user
     */
    void associatedUnit(AuthorizeDO user);
}
