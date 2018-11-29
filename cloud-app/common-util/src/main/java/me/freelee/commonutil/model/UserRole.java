package me.freelee.commonutil.model;

import java.util.Date;

public class UserRole {
    /**
     * 用户角色关联表主键
     */
    private Integer id;

    /**
     * 用户UID
     */
    private String userId;

    /**
     * 角色ID
     */
    private Integer roleId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 获取用户角色关联表主键
     *
     * @return ID - 用户角色关联表主键
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置用户角色关联表主键
     *
     * @param id 用户角色关联表主键
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取用户UID
     *
     * @return USER_ID - 用户UID
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 设置用户UID
     *
     * @param userId 用户UID
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /**
     * 获取角色ID
     *
     * @return ROLE_ID - 角色ID
     */
    public Integer getRoleId() {
        return roleId;
    }

    /**
     * 设置角色ID
     *
     * @param roleId 角色ID
     */
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
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