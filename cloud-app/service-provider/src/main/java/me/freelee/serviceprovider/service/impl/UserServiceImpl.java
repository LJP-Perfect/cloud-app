package me.freelee.serviceprovider.service.impl;

import me.freelee.serviceprovider.dao.RoleMapper;
import me.freelee.serviceprovider.dao.UserMapper;
import me.freelee.serviceprovider.dao.UserRoleMapper;
import me.freelee.commonutil.model.Role;
import me.freelee.commonutil.model.User;
import me.freelee.commonutil.model.UserRole;
import me.freelee.serviceprovider.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Description:
 * Date:2018/11/17
 *
 * @author:Lee
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    RoleMapper roleMapper;
    @Autowired
    UserRoleMapper userRoleMapper;
    @Autowired
    UserMapper userMapper;

    @Override
    public Role getRole(String uid) {
        UserRole userRoleExample=new UserRole();
        userRoleExample.setUserId(uid);
        UserRole userRole= (UserRole) userRoleMapper.selectOne(userRoleExample);
        Role roleExample=new Role();
        roleExample.setId(userRole.getRoleId());
        return (Role) roleMapper.selectOne(roleExample);
    }

    @Override
    public User selectByUserName(String userName) {
        User user=new User();
        user.setUsername(userName);
        return userMapper.selectOne(user);
    }

    @Override
    public void saveUser(User user) {
        userMapper.insertSelective(user);
    }

    @Override
    public List<User> selectAll() {
        return userMapper.selectAll();
    }


}
