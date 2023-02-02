package com.my.ddd.infra.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 地址数据
 *
 */
@Data
@NoArgsConstructor
public class AddressDTO {
    /**
     * 省
     */
    private String province;

    /**
     * 市
     */
    private String city;

    /**
     * 区
     */
    private String county;
}
