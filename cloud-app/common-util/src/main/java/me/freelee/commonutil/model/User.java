package me.freelee.commonutil.model;

import java.util.Date;

public class User {
    /**
     * uid,用户账号,主键
     */
    private String uid;

    /**
     * 用户名(nick_name)
     */
    private String username;

    /**
     * 密码(MD5(密码+盐))
     */
    private String password;

    /**
     * 盐
     */
    private String salt;

    /**
     * 用户真名
     */
    private String realName;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 电话号码(唯一)
     */
    private String phone;

    /**
     * 邮件地址(唯一)
     */
    private String email;

    /**
     * 性别(1.男 2.女)
     */
    private Byte sex;

    /**
     * 账户状态(1.正常 2.锁定 3.删除 4.非法)
     */
    private Byte status;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 获取uid,用户账号,主键
     *
     * @return uid - uid,用户账号,主键
     */
    public String getUid() {
        return uid;
    }

    /**
     * 设置uid,用户账号,主键
     *
     * @param uid uid,用户账号,主键
     */
    public void setUid(String uid) {
        this.uid = uid == null ? null : uid.trim();
    }

    /**
     * 获取用户名(nick_name)
     *
     * @return username - 用户名(nick_name)
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置用户名(nick_name)
     *
     * @param username 用户名(nick_name)
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * 获取密码(MD5(密码+盐))
     *
     * @return password - 密码(MD5(密码+盐))
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置密码(MD5(密码+盐))
     *
     * @param password 密码(MD5(密码+盐))
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * 获取盐
     *
     * @return salt - 盐
     */
    public String getSalt() {
        return salt;
    }

    /**
     * 设置盐
     *
     * @param salt 盐
     */
    public void setSalt(String salt) {
        this.salt = salt == null ? null : salt.trim();
    }

    /**
     * 获取用户真名
     *
     * @return real_name - 用户真名
     */
    public String getRealName() {
        return realName;
    }

    /**
     * 设置用户真名
     *
     * @param realName 用户真名
     */
    public void setRealName(String realName) {
        this.realName = realName == null ? null : realName.trim();
    }

    /**
     * 获取头像
     *
     * @return avatar - 头像
     */
    public String getAvatar() {
        return avatar;
    }

    /**
     * 设置头像
     *
     * @param avatar 头像
     */
    public void setAvatar(String avatar) {
        this.avatar = avatar == null ? null : avatar.trim();
    }

    /**
     * 获取电话号码(唯一)
     *
     * @return phone - 电话号码(唯一)
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置电话号码(唯一)
     *
     * @param phone 电话号码(唯一)
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * 获取邮件地址(唯一)
     *
     * @return email - 邮件地址(唯一)
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置邮件地址(唯一)
     *
     * @param email 邮件地址(唯一)
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * 获取性别(1.男 2.女)
     *
     * @return sex - 性别(1.男 2.女)
     */
    public Byte getSex() {
        return sex;
    }

    /**
     * 设置性别(1.男 2.女)
     *
     * @param sex 性别(1.男 2.女)
     */
    public void setSex(Byte sex) {
        this.sex = sex;
    }

    /**
     * 获取账户状态(1.正常 2.锁定 3.删除 4.非法)
     *
     * @return status - 账户状态(1.正常 2.锁定 3.删除 4.非法)
     */
    public Byte getStatus() {
        return status;
    }

    /**
     * 设置账户状态(1.正常 2.锁定 3.删除 4.非法)
     *
     * @param status 账户状态(1.正常 2.锁定 3.删除 4.非法)
     */
    public void setStatus(Byte status) {
        this.status = status;
    }

    /**
     * 获取创建时间
     *
     * @return CREATE_TIME - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取更新时间
     *
     * @return UPDATE_TIME - 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置更新时间
     *
     * @param updateTime 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}