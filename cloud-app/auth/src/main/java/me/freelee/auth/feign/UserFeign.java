package me.freelee.auth.feign;

import me.freelee.commonutil.model.Role;
import me.freelee.commonutil.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Description:
 * Date:2018/11/23
 *
 * @author:Lee
 */
@FeignClient("service-provider")
public interface UserFeign {

    @GetMapping("/users/role")
    public Role getRole(@RequestParam("uid") String uid);

    @GetMapping("/users/user")
    public User selectByUserName(@RequestParam("userName") String userName);

}
