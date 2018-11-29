package me.freelee.cloudzuul.config;

import me.freelee.cloudzuul.filter.JWTAuthenticationFilter;
import me.freelee.cloudzuul.filter.JWTTokenValidateFilter;
import me.freelee.cloudzuul.handler.MyAccessDeniedHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

/**
 * Description:
 * Date:2018/11/17
 *
 * @author:Lee
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    private static final String[] AUTH_WHITELIST = {
            // -- register url
            "/users/signup",
            "/user-service/user/hello",
            "/routes",
            "/trace",
            "/login",
            "/logout"
            // -- swagger ui
//            "/v2/api-docs",
//            "/swagger-resources",
//            "/swagger-resources/**",
//            "/configuration/ui",
//            "/configuration/security",
//            "/swagger-ui.html",
//            "/webjars/**"
            // other public endpoints of your API may be appended to this array
    };



    @Autowired
    JWTTokenValidateFilter jwtTokenValidateFilter;

    @Autowired
    MyAccessDeniedHandler myAccessDeniedHandler;


    // 设置 HTTP 验证规则
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                .exceptionHandling()
                .accessDeniedHandler(myAccessDeniedHandler)
                .and()
                .authorizeRequests()
                .antMatchers(AUTH_WHITELIST).permitAll()
                .antMatchers("/user-service/user/userList").hasRole("ADMIN")
                .antMatchers("/user-service/user/getuser").hasRole("USER")
                .anyRequest().authenticated();

        http.addFilter(new JWTAuthenticationFilter(authenticationManager()));
        http.addFilterBefore(jwtTokenValidateFilter, JWTAuthenticationFilter.class);
    }


}
