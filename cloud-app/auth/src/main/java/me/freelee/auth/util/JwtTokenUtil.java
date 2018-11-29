package me.freelee.auth.util;

import com.alibaba.fastjson.JSON;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.*;

/**
 * Description:
 * Date:2018/11/19
 *
 * @author:Lee
 */
public class JwtTokenUtil {

    public static final String APPID="freelee-app";
    public static final String TOKEN_HEADER = "Authorization";
    public static final String TOKEN_PREFIX = "Bearer ";
    private static final String SECRET = "freelee-spring-security-jwt";
    private static final String ISS = "freelee";

    // 角色的key
    public static final String ROLE_CLAIMS = "role";
    public static final String UID_CLAIMS="uid";

    // 过期时间是3600秒，既是1个小时
    public static final long EXPIRATION = 7200L;

    // 刷新时间
    public static final long EXPIRATION_REFRESH=604800L;

    // 创建token
    public static String createToken(String uid, String username, Collection<? extends GrantedAuthority> authorities) {
        HashMap<String, Object> map = new HashMap<>();
        // 定义存放角色集合的对象
        String role = "";
        for (GrantedAuthority grantedAuthority : authorities) {
            role+=grantedAuthority.getAuthority()+",";
        }
        if(role!=""){
            role=role.substring(0,role.length()-1);
        }
        map.put(ROLE_CLAIMS, role);
        map.put("uid",uid);
        return Jwts.builder()
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .setClaims(map)
                .setIssuer(ISS)
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis()+EXPIRATION*1000))
                .compact();
    }

    public static String createTokenByRoleStr(String uid,String username, String role) {
        HashMap<String, Object> map = new HashMap<>();
        map.put(ROLE_CLAIMS, role);
        map.put(UID_CLAIMS,uid);
        return Jwts.builder()
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .setClaims(map)
                .setIssuer(ISS)
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis()+EXPIRATION*1000))
                .compact();
    }

    // 从token中获取用户名
    public static String getUsername(String token){
        return getTokenBody(token).getSubject();
    }

    // 获取用户角色
    public static ArrayList<GrantedAuthority> getUserRole(String token){
        String role=(String) getTokenBody(token).get(ROLE_CLAIMS);
        String[] roles=role.split(",");
        ArrayList<GrantedAuthority> authorities = new ArrayList<>();
        for (String roleName:roles) {
            authorities.add(new SimpleGrantedAuthority(roleName));
        }
        return authorities;
    }


    // 是否已过期
    public static boolean isExpiration(String token){
        return getTokenBody(token).getExpiration().before(new Date());
    }

    private static Claims getTokenBody(String token){
        return Jwts.parser()
                .setSigningKey(SECRET)
                .parseClaimsJws(token)
                .getBody();
    }

    public static String getInfoByPayload(String payload,String itemName){
        return (String) JSON.parseObject(new String(Base64.getDecoder().decode(payload.getBytes()))).get(itemName);
    }
}
