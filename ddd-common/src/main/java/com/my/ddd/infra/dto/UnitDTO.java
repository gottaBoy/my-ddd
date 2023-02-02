package com.my.ddd.infra.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 单位数据
 *
 */
@Data
@NoArgsConstructor
public class UnitDTO {
    /**
     * 单位id
     */
    private Long unitId;

    /**
     * 单位名称
     */
    private String unitName;
}
