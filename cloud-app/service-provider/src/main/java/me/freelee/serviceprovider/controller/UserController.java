package me.freelee.serviceprovider.controller;

import me.freelee.commonutil.model.Role;
import me.freelee.commonutil.model.User;
import me.freelee.serviceprovider.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Description:
 * Date:2018/11/18
 *
 * @author:Lee
 */
@RestController
@RequestMapping("/users")
public class UserController {

    protected Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserService userService;

    /**
     * 获取用户列表
     * @return
     */

    @GetMapping("/userList")
    public Map<String, Object> userList(){
        List<User> users = userService.selectAll();
        logger.info("users: {}", users);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("users",users);
        return map;
    }

    @GetMapping("/role")
    public Role getRole(@RequestParam("uid") String uid){
        return userService.getRole(uid);
    }

    @GetMapping("/user")
    public User selectByUserName(@RequestParam("userName") String userName){
        return userService.selectByUserName(userName);
    }

//    //@PreAuthorize("hasRole('USER')")
//    @GetMapping("/hello")
//    public String Hello(){
//        return "hello";
//    }


}
