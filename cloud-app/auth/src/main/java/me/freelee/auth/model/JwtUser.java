package me.freelee.auth.model;

import me.freelee.commonutil.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.Instant;
import java.util.Collection;

/**
 * Description:
 * Date:2018/11/17
 *
 * @author:Lee
 */
public class JwtUser implements UserDetails {


    private String uid;
    private String username;
    private String password;
    //账号是否过期
    private Boolean isAccountNonExpired;
    //账户是否锁定
    private Boolean isAccountNonLocked;
    //密码是否过期
    private Boolean isCredentialsNonExpired;
    //是否激活
    private Boolean enabled;
    //上次密码重置时间
    private Instant lastPasswordResetDate;
    private Collection<? extends GrantedAuthority> authorities;

    public JwtUser() {
    }

    public JwtUser(User user, Collection<? extends GrantedAuthority> authorities) {
        uid = user.getUid();
        username = user.getUsername();
        password = user.getPassword();
        this.authorities = authorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }


    @Override
    public String toString() {
        return "JwtUser{" +
                ", uid='" + uid + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", isAccountNonExpired=" + isAccountNonExpired +
                ", isAccountNonLocked=" + isAccountNonLocked +
                ", isCredentialsNonExpired=" + isCredentialsNonExpired +
                ", enabled=" + enabled +
                ", lastPasswordResetDate=" + lastPasswordResetDate +
                ", authorities=" + authorities +
                '}';
    }
}
