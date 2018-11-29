package me.freelee.serviceprovider.service;


import me.freelee.commonutil.model.Role;
import me.freelee.commonutil.model.User;

import java.util.List;

/**
 * Description:
 * Date:2018/11/17
 *
 * @author:Lee
 */
public interface UserService {

    Role getRole(String uid);

    User selectByUserName(String userName);

    void saveUser(User user);

    List<User> selectAll();
}
