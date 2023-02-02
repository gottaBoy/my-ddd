package com.my.ddd.domain.event;

import com.my.ddd.infra.domain.AuthorizeDO;

/**
 * 用户修改领域事件
 *
 * @author louzai
 * @since 2021/11/20
 */
public class UserUpdateEvent extends BaseDomainEvent<AuthorizeDO> {
    public UserUpdateEvent(AuthorizeDO user) {
        super(user);
    }
}

