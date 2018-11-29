package me.freelee.cloudzuul.filter;

import com.alibaba.fastjson.JSON;
import io.jsonwebtoken.ExpiredJwtException;
import me.freelee.cloudzuul.util.JwtTokenUtil;
import me.freelee.cloudzuul.util.RedisUtil;
import me.freelee.commonutil.enums.ResultEnum;
import me.freelee.commonutil.vo.ResultVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Description:
 * Date:2018/11/22
 *
 * @author:Lee
 */
@Component
public class JWTTokenValidateFilter extends OncePerRequestFilter {

    private final Logger logger= LoggerFactory.getLogger(JWTTokenValidateFilter.class);
    @Autowired
    RedisUtil redisUtil;


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authHeader = request.getHeader("Authorization");
        logger.info("*****AuthHeader:"+authHeader);
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            String token= authHeader.substring("Bearer ".length());
            String username=null;
            String payload=token.substring(token.indexOf(".")+1,token.lastIndexOf("."));
            username=JwtTokenUtil.getInfoByPayload(payload,"sub");
            //黑名单校验
            if(redisUtil.isBlackList(token)){
                logger.info("用户：{}的token：{}在黑名单之中，拒绝访问",username,token);
                response.getWriter().write(JSON.toJSONString(ResultVO.result(ResultEnum.TOKEN_IS_BLACKLIST, false)));
                return;
            }
            try {
                JwtTokenUtil.isExpiration(token);
            }catch (ExpiredJwtException e){
                String uid=JwtTokenUtil.getInfoByPayload(payload, JwtTokenUtil.UID_CLAIMS);
                String roleStr=JwtTokenUtil.getInfoByPayload(payload,JwtTokenUtil.ROLE_CLAIMS);
                if(redisUtil.hasKey(JwtTokenUtil.APPID+"-"+uid)){
                    String newToken=JwtTokenUtil.createTokenByRoleStr(uid,username,roleStr);
                    redisUtil.hset(JwtTokenUtil.APPID+"-"+uid,"token",newToken);
                    response.setHeader("Authorization", "Bearer " + newToken);
                    //前端需要更新token ❗❗❗,返回状态码和newToken
                    logger.info("生成新token:"+newToken);
                    logger.info("旧token为:"+token);
                }else{
                    //超过有效期，不予刷新
                    logger.info("{}已超过有效期，不予刷新",token);
                    response.getWriter().write(JSON.toJSONString(ResultVO.result(ResultEnum.LOGIN_IS_OVERDUE, false)));
                    return;
                }
            }
        }
        filterChain.doFilter(request,response);
    }
}
