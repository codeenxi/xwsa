package cn.com.xinxin.portal.web.form;

import cn.com.xinxin.portal.api.base.ToString;

/**
 * @author: zhouyang
 * @created: 13/07/2018.
 * @updater:
 * @description:
 */
public class UserRoleForm extends ToString {
    private static final long serialVersionUID = -679598670792406818L;

    private Long id;

    private String roleCode;

    private String roleName;

    private String userNo;

    private String userName;

    private String extension;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getUserNo() {
        return userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }
}
