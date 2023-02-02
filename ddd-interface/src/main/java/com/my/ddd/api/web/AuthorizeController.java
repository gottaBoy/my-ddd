package com.my.ddd.api.web;

import com.my.ddd.api.converter.AuthorizeConverter;
import com.my.ddd.api.model.req.AuthorizeCreateReq;
import com.my.ddd.api.model.req.AuthorizeUpdateReq;
import com.my.ddd.api.model.vo.UserAuthorizeVO;
import com.my.ddd.applicaiton.dto.UserRoleDTO;
import com.my.ddd.applicaiton.service.AuthrizeApplicationService;
import com.my.ddd.common.result.BaseResult;
import com.my.ddd.common.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 用户管理web接口
 *
 */
@RestController
@RequestMapping("/api/user")
public class AuthorizeController {

    @Autowired
    private AuthorizeConverter authorizeConverter;

    @Autowired
    private AuthrizeApplicationService authrizeApplicationService;

    @GetMapping("/query")
    public Result<UserAuthorizeVO> query(@RequestParam("userId") Long userId){
        UserRoleDTO userRoleDTO = authrizeApplicationService.queryUserAuthorize(userId);
        Result<UserAuthorizeVO> result = new Result<>();
        result.setData(authorizeConverter.toVO(userRoleDTO));
        result.setCode(BaseResult.CODE_SUCCESS);
        return result;
    }

    @PostMapping("/save")
    public Result<Object> create(@RequestBody AuthorizeCreateReq authorizeCreateReq){
        authrizeApplicationService.createUserAuthorize(authorizeConverter.toDTO(authorizeCreateReq));
        return Result.ok(BaseResult.INSERT_SUCCESS);
    }

    @PostMapping("/delete")
    public Result<Object> delete(@RequestParam("userId") Long userId){
        authrizeApplicationService.deleteUserAuthorize(userId);
        return Result.ok(BaseResult.DELETE_SUCCESS);
    }

    @PostMapping("/update")
    public Result<Object> update(@RequestBody AuthorizeUpdateReq authorizeUpdateReq){
        authrizeApplicationService.updateUserAuthorize(authorizeConverter.toDTO(authorizeUpdateReq));
        return Result.ok(BaseResult.UPDATE_SUCCESS);
    }
}
