package com.my.ddd.infra.repository;

import com.my.ddd.infra.domain.AuthorizeDO;

/**
 * 用户领域仓储
 *
 */
public interface UserRepository {

    /**
     * 删除
     *
     * @param userId
     */
    void delete(Long userId);

    /**
     * 查询
     *
     * @param userId
     * @return
     */
    AuthorizeDO query(Long userId);

    /**
     * 保存
     *
     * @param user
     * @return
     */
    AuthorizeDO save(AuthorizeDO user);
}
