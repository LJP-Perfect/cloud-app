package me.freelee.auth.service;

import me.freelee.auth.feign.UserFeign;
import me.freelee.auth.model.JwtUser;
import me.freelee.commonutil.model.Role;
import me.freelee.commonutil.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Description:
 * Date:2018/11/17
 *
 * @author:Lee
 */
@Service
public class JwtUserService implements UserDetailsService {

    @Autowired
    UserFeign userFeign;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user=userFeign.selectByUserName(s);
        if(user==null){
            throw new UsernameNotFoundException("登录用户:"+s+"不存在");
        }
        Role role=userFeign.getRole(user.getUid());
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        String roles[]=role.getCode().split(",");
        for(String roleName:roles) {
            SimpleGrantedAuthority grant = new SimpleGrantedAuthority(roleName);
            authorities.add(grant);
        }
        JwtUser jwtUser=new JwtUser(user,authorities);
        return jwtUser;
    }
}
