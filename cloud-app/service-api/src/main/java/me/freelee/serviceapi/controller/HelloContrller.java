package me.freelee.serviceapi.controller;

import me.freelee.serviceapi.feign.HelloFeign;
import me.freelee.serviceapi.feign.UserFeign;
import me.freelee.commonutil.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Description:
 * Date:2018/11/10
 *
 * @author:Lee
 */
@RestController
public class HelloContrller {

    @Autowired
    HelloFeign helloFeign;

    @Autowired
    UserFeign userFeign;

    @GetMapping("/user/hello")
    public String hello(){
        return helloFeign.hello();
    }

    @GetMapping("/user/userList")
    public Map<String, Object> userList(){
        return userFeign.userList();
    }

    @GetMapping("/user/getuser")
    public User selectByUserName(@RequestParam("userName") String userName){
        return userFeign.selectByUserName(userName);
    }
}
