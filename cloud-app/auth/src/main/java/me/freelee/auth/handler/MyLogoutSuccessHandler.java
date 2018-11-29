package me.freelee.auth.handler;

import com.alibaba.fastjson.JSON;
import me.freelee.auth.util.RedisUtil;
import me.freelee.commonutil.enums.ResultEnum;
import me.freelee.commonutil.vo.ResultVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Description:
 * Date:2018/11/20
 *
 * @author:Lee
 */
@Component
public class MyLogoutSuccessHandler implements LogoutSuccessHandler {

    private Logger logger = LoggerFactory.getLogger(MyLogoutSuccessHandler.class);

    @Autowired
    RedisUtil redisUtil;

    @Override
    public void onLogoutSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        String authHeader = httpServletRequest.getHeader("Authorization");
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            final String toekn = authHeader.substring("Bearer ".length());
            //将token放入黑名单中
            redisUtil.addBlackList(toekn);
            logger.info("用户登出成功！token：{}已加入redis黑名单",toekn);
        }
        httpServletResponse.getWriter().write(JSON.toJSONString(ResultVO.result(ResultEnum.USER_LOGOUT_SUCCESS,true)));
    }
}
