package me.freelee.serviceapi.feign;

import me.freelee.commonutil.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * Description:
 * Date:2018/11/23
 *
 * @author:Lee
 */
@FeignClient("service-provider")
public interface UserFeign {
    @GetMapping("/users/userList")
    public Map<String, Object> userList();

    @GetMapping("/users/user")
    public User selectByUserName(@RequestParam("userName") String userName);
}
