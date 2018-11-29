package me.freelee.auth.handler;

import me.freelee.auth.model.JwtUser;
import me.freelee.auth.util.JwtTokenUtil;
import me.freelee.auth.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;

/**
 * Description:
 * Date:2018/11/20
 *
 * @author:Lee
 */
@Component("myAuthenticationSuccessHandler")
public class MyAuthenticationSuccessHandler implements AuthenticationSuccessHandler {


    @Autowired
    RedisUtil redisUtil;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication auth) throws IOException, ServletException {

        JwtUser jwtUser = (JwtUser) auth.getPrincipal();
        String token = null;
        //boolean isRemember = rememberMe.get() == 1;
        try {
            Collection<? extends GrantedAuthority> authorities = jwtUser.getAuthorities();

            token = JwtTokenUtil.createToken(jwtUser.getUid(),jwtUser.getUsername(),authorities);

            redisUtil.hset(JwtTokenUtil.APPID+"-"+jwtUser.getUid(),"token", token,JwtTokenUtil.EXPIRATION_REFRESH);
            // 登录成功后，返回token到header里面
            httpServletResponse.addHeader(JwtTokenUtil.TOKEN_HEADER, JwtTokenUtil.TOKEN_PREFIX + token);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
