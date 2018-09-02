package com.wanglibing.webapi;

import com.github.pagehelper.PageInfo;
import com.wanglibing.webapi.pojo.User;
import com.wanglibing.webapi.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class WebapiApplicationTests {

    @Autowired
    private UserService userService;

    @Test
    public void contextLoads() {

    }

    @Test
    public void addUser(){
        User user = new User();
        user.setUsername("test1");
        user.setEmail("email1");
        user.setPhone("18034466599");
        user.setPassword("pass1");
        userService.insert(user);
    }

    @Test
    public void getUserByPrimaryKey(){
        User user = new User();
        user.setId(28);
        user = userService.selectByPrimaryKey(user);
        if (user==null){
            log.info("user为null");
        }
        else{
            log.info("username:"+user.getUsername());
        }
    }

    @Test
    public void deleteUser(){
        User user = new User();
        user.setId(30);
        userService.deleteByPrimaryKey(user);
    }

    @Test
    public void selectAll(){
        List<User> users = userService.selectAll();
        if (users!=null){
            log.info("users的数量是："+users.size());
        }
    }

    @Test
    public void updateUSer(){
        User user = new User();
        user.setId(32);
        user.setEmail("iamwanglibing@qq.com");
        userService.updateNotNull(user);
    }

    @Test
    public void getPage(){
        PageInfo<User> users = userService.selectByPages(2,5);
        if (users!=null) {
            log.info("users分页的数量是"+users.getSize());
        }
    }

}
