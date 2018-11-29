package me.freelee.commonutil.model;

import java.util.Date;

public class Resource {
    /**
     * 资源ID
     */
    private Integer id;

    /**
     * 资源名称
     */
    private String code;

    /**
     * 资源描述
     */
    private String name;

    /**
     * 父资源编码->菜单
     */
    private Integer parentId;

    /**
     * 访问地址URL
     */
    private String uri;

    /**
     * 类型 1:菜单menu 2:资源element(rest-api) 3:资源分类
     */
    private Short type;

    /**
     * 访问方式 GET POST PUT DELETE PATCH
     */
    private String method;

    /**
     * 图标
     */
    private String icon;

    /**
     * 状态   1:正常、9：禁用
     */
    private Short status;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 获取资源ID
     *
     * @return ID - 资源ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置资源ID
     *
     * @param id 资源ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取资源名称
     *
     * @return CODE - 资源名称
     */
    public String getCode() {
        return code;
    }

    /**
     * 设置资源名称
     *
     * @param code 资源名称
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**
     * 获取资源描述
     *
     * @return NAME - 资源描述
     */
    public String getName() {
        return name;
    }

    /**
     * 设置资源描述
     *
     * @param name 资源描述
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取父资源编码->菜单
     *
     * @return PARENT_ID - 父资源编码->菜单
     */
    public Integer getParentId() {
        return parentId;
    }

    /**
     * 设置父资源编码->菜单
     *
     * @param parentId 父资源编码->菜单
     */
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    /**
     * 获取访问地址URL
     *
     * @return URI - 访问地址URL
     */
    public String getUri() {
        return uri;
    }

    /**
     * 设置访问地址URL
     *
     * @param uri 访问地址URL
     */
    public void setUri(String uri) {
        this.uri = uri == null ? null : uri.trim();
    }

    /**
     * 获取类型 1:菜单menu 2:资源element(rest-api) 3:资源分类
     *
     * @return TYPE - 类型 1:菜单menu 2:资源element(rest-api) 3:资源分类
     */
    public Short getType() {
        return type;
    }

    /**
     * 设置类型 1:菜单menu 2:资源element(rest-api) 3:资源分类
     *
     * @param type 类型 1:菜单menu 2:资源element(rest-api) 3:资源分类
     */
    public void setType(Short type) {
        this.type = type;
    }

    /**
     * 获取访问方式 GET POST PUT DELETE PATCH
     *
     * @return METHOD - 访问方式 GET POST PUT DELETE PATCH
     */
    public String getMethod() {
        return method;
    }

    /**
     * 设置访问方式 GET POST PUT DELETE PATCH
     *
     * @param method 访问方式 GET POST PUT DELETE PATCH
     */
    public void setMethod(String method) {
        this.method = method == null ? null : method.trim();
    }

    /**
     * 获取图标
     *
     * @return ICON - 图标
     */
    public String getIcon() {
        return icon;
    }

    /**
     * 设置图标
     *
     * @param icon 图标
     */
    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }

    /**
     * 获取状态   1:正常、9：禁用
     *
     * @return STATUS - 状态   1:正常、9：禁用
     */
    public Short getStatus() {
        return status;
    }

    /**
     * 设置状态   1:正常、9：禁用
     *
     * @param status 状态   1:正常、9：禁用
     */
    public void setStatus(Short status) {
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