package com.my.ddd.applicaiton.converter;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.my.ddd.applicaiton.dto.RoleInfoDTO;
import com.my.ddd.applicaiton.dto.UserRoleDTO;
import com.my.ddd.infra.domain.AuthorizeDO;
import com.my.ddd.infra.dto.AddressDTO;
import com.my.ddd.infra.dto.RoleDTO;
import com.my.ddd.infra.dto.UnitDTO;
import org.mapstruct.Mapper;

import java.util.ArrayList;
import java.util.List;

/**
 * UserDo转换器
 *
 */
@Mapper(componentModel = "spring")
public interface UserApplicationConverter {

    RoleDTO toRoleDTO(RoleInfoDTO roleDTO);

    RoleInfoDTO toRoleInfoDTO(RoleDTO roleDTO);

    default AuthorizeDO toAuthorizeDo(UserRoleDTO userRoleDTO) {
        AuthorizeDO authorizeDO = new AuthorizeDO();

        authorizeDO.setUserId(userRoleDTO.getUserId());
        authorizeDO.setUserName(userRoleDTO.getUserName());
        authorizeDO.setRealName(userRoleDTO.getRealName());
        authorizeDO.setPhone(userRoleDTO.getPhone());
        authorizeDO.setPassword(userRoleDTO.getPassword());

        UnitDTO unitDTO = new UnitDTO();
        unitDTO.setUnitId(userRoleDTO.getUnitId());
        unitDTO.setUnitName(userRoleDTO.getUnitName());

        AddressDTO addressDTO = new AddressDTO();
        addressDTO.setCity(userRoleDTO.getCity());
        addressDTO.setCounty(userRoleDTO.getCounty());
        addressDTO.setProvince(userRoleDTO.getProvince());

        authorizeDO.setUnit(unitDTO);
        authorizeDO.setAddress(addressDTO);

        List<RoleDTO> roleDTOList = new ArrayList<>();
        if (!CollectionUtils.isEmpty(userRoleDTO.getRoles())) {
            userRoleDTO.getRoles().parallelStream().forEach(roleInfoDTO -> {
                roleDTOList.add(toRoleDTO(roleInfoDTO));
            });
        }
        authorizeDO.setRoles(roleDTOList);
        return authorizeDO;
    }

    default UserRoleDTO toAuthorizeDTO(AuthorizeDO authorizeDO) {
        UserRoleDTO userRoleDTO = new UserRoleDTO();
        userRoleDTO.setUserId(authorizeDO.getUserId());
        userRoleDTO.setUserName(authorizeDO.getUserName());
        userRoleDTO.setRealName(authorizeDO.getRealName());
        userRoleDTO.setPhone(authorizeDO.getPhone());
        userRoleDTO.setPassword(authorizeDO.getPassword());
        userRoleDTO.setUnitId(authorizeDO.getUnit().getUnitId());
        userRoleDTO.setUnitName(authorizeDO.getUnit().getUnitName());
        userRoleDTO.setCity(authorizeDO.getAddress().getCity());
        userRoleDTO.setCounty(authorizeDO.getAddress().getCounty());
        userRoleDTO.setProvince(authorizeDO.getAddress().getProvince());

        List<RoleInfoDTO> roleInfoDTOList = new ArrayList<>();
        authorizeDO.getRoles().parallelStream().forEach(roleDTO -> {
            roleInfoDTOList.add(toRoleInfoDTO(roleDTO));
        });
        userRoleDTO.setRoles(roleInfoDTOList);
        return userRoleDTO;
    }

}
