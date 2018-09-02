package com.wanglibing.webapi.controller;

import com.wanglibing.webapi.pojo.User;
import com.wanglibing.webapi.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: iamwlb
 * @date: 2018/8/31 12:08
 */
@RestController
@RequestMapping("/user")
@Slf4j
@Api(value ="/user",description = "用户控制器")
public class UserController {
    @Autowired
    private UserService userService;


    @ApiOperation(value = "根据Id获取User")
    @ApiImplicitParam(name = "id",value = "用户ID", required = true, dataType = "Integer")
    @GetMapping("/getUser/{id}")
    public User getUser(@PathVariable Integer id){
        User user = new User();
        user.setId(id);
        user = this.userService.selectByPrimaryKey(user);
        if(user==null) {
            log.info("id:"+id+",user为null");
        }
        return user;
    }
}
