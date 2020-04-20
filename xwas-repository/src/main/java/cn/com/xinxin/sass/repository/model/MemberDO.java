package cn.com.xinxin.sass.repository.model;

import java.util.Date;

public class MemberDO {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column member.id
     *
     * @mbg.generated
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column member.org_id
     *
     * @mbg.generated
     */
    private String orgId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column member.user_id
     *
     * @mbg.generated
     */
    private String userId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column member.name
     *
     * @mbg.generated
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column member.mobile
     *
     * @mbg.generated
     */
    private String mobile;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column member.department_id_list
     *
     * @mbg.generated
     */
    private String departmentIdList;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column member.order_list
     *
     * @mbg.generated
     */
    private String orderList;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column member.position
     *
     * @mbg.generated
     */
    private String position;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column member.gender
     *
     * @mbg.generated
     */
    private Integer gender;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column member.mail
     *
     * @mbg.generated
     */
    private String mail;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column member.is_leader_in_dept
     *
     * @mbg.generated
     */
    private String isLeaderInDept;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column member.avatar
     *
     * @mbg.generated
     */
    private String avatar;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column member.thumb_avatar
     *
     * @mbg.generated
     */
    private String thumbAvatar;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column member.telephone
     *
     * @mbg.generated
     */
    private String telephone;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column member.alias
     *
     * @mbg.generated
     */
    private String alias;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column member.status
     *
     * @mbg.generated
     */
    private Integer status;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column member.ext_attr
     *
     * @mbg.generated
     */
    private String extAttr;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column member.qr_code
     *
     * @mbg.generated
     */
    private String qrCode;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column member.external_profile
     *
     * @mbg.generated
     */
    private String externalProfile;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column member.external_position
     *
     * @mbg.generated
     */
    private String externalPosition;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column member.address
     *
     * @mbg.generated
     */
    private String address;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column member.hide_mobile
     *
     * @mbg.generated
     */
    private Integer hideMobile;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column member.english_name
     *
     * @mbg.generated
     */
    private String englishName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column member.open_userid
     *
     * @mbg.generated
     */
    private String openUserid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column member.main_department
     *
     * @mbg.generated
     */
    private Long mainDepartment;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column member.member_status
     *
     * @mbg.generated
     */
    private String memberStatus;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column member.task_id
     *
     * @mbg.generated
     */
    private String taskId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column member.extension
     *
     * @mbg.generated
     */
    private String extension;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column member.gmt_created
     *
     * @mbg.generated
     */
    private Date gmtCreated;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column member.gmt_creator
     *
     * @mbg.generated
     */
    private String gmtCreator;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column member.gmt_updated
     *
     * @mbg.generated
     */
    private Date gmtUpdated;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column member.gmt_updater
     *
     * @mbg.generated
     */
    private String gmtUpdater;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column member.deleted
     *
     * @mbg.generated
     */
    private Byte deleted;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column member.id
     *
     * @return the value of member.id
     *
     * @mbg.generated
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column member.id
     *
     * @param id the value for member.id
     *
     * @mbg.generated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column member.org_id
     *
     * @return the value of member.org_id
     *
     * @mbg.generated
     */
    public String getOrgId() {
        return orgId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column member.org_id
     *
     * @param orgId the value for member.org_id
     *
     * @mbg.generated
     */
    public void setOrgId(String orgId) {
        this.orgId = orgId == null ? null : orgId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column member.user_id
     *
     * @return the value of member.user_id
     *
     * @mbg.generated
     */
    public String getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column member.user_id
     *
     * @param userId the value for member.user_id
     *
     * @mbg.generated
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column member.name
     *
     * @return the value of member.name
     *
     * @mbg.generated
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column member.name
     *
     * @param name the value for member.name
     *
     * @mbg.generated
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column member.mobile
     *
     * @return the value of member.mobile
     *
     * @mbg.generated
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column member.mobile
     *
     * @param mobile the value for member.mobile
     *
     * @mbg.generated
     */
    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column member.department_id_list
     *
     * @return the value of member.department_id_list
     *
     * @mbg.generated
     */
    public String getDepartmentIdList() {
        return departmentIdList;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column member.department_id_list
     *
     * @param departmentIdList the value for member.department_id_list
     *
     * @mbg.generated
     */
    public void setDepartmentIdList(String departmentIdList) {
        this.departmentIdList = departmentIdList == null ? null : departmentIdList.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column member.order_list
     *
     * @return the value of member.order_list
     *
     * @mbg.generated
     */
    public String getOrderList() {
        return orderList;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column member.order_list
     *
     * @param orderList the value for member.order_list
     *
     * @mbg.generated
     */
    public void setOrderList(String orderList) {
        this.orderList = orderList == null ? null : orderList.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column member.position
     *
     * @return the value of member.position
     *
     * @mbg.generated
     */
    public String getPosition() {
        return position;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column member.position
     *
     * @param position the value for member.position
     *
     * @mbg.generated
     */
    public void setPosition(String position) {
        this.position = position == null ? null : position.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column member.gender
     *
     * @return the value of member.gender
     *
     * @mbg.generated
     */
    public Integer getGender() {
        return gender;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column member.gender
     *
     * @param gender the value for member.gender
     *
     * @mbg.generated
     */
    public void setGender(Integer gender) {
        this.gender = gender;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column member.mail
     *
     * @return the value of member.mail
     *
     * @mbg.generated
     */
    public String getMail() {
        return mail;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column member.mail
     *
     * @param mail the value for member.mail
     *
     * @mbg.generated
     */
    public void setMail(String mail) {
        this.mail = mail == null ? null : mail.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column member.is_leader_in_dept
     *
     * @return the value of member.is_leader_in_dept
     *
     * @mbg.generated
     */
    public String getIsLeaderInDept() {
        return isLeaderInDept;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column member.is_leader_in_dept
     *
     * @param isLeaderInDept the value for member.is_leader_in_dept
     *
     * @mbg.generated
     */
    public void setIsLeaderInDept(String isLeaderInDept) {
        this.isLeaderInDept = isLeaderInDept == null ? null : isLeaderInDept.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column member.avatar
     *
     * @return the value of member.avatar
     *
     * @mbg.generated
     */
    public String getAvatar() {
        return avatar;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column member.avatar
     *
     * @param avatar the value for member.avatar
     *
     * @mbg.generated
     */
    public void setAvatar(String avatar) {
        this.avatar = avatar == null ? null : avatar.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column member.thumb_avatar
     *
     * @return the value of member.thumb_avatar
     *
     * @mbg.generated
     */
    public String getThumbAvatar() {
        return thumbAvatar;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column member.thumb_avatar
     *
     * @param thumbAvatar the value for member.thumb_avatar
     *
     * @mbg.generated
     */
    public void setThumbAvatar(String thumbAvatar) {
        this.thumbAvatar = thumbAvatar == null ? null : thumbAvatar.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column member.telephone
     *
     * @return the value of member.telephone
     *
     * @mbg.generated
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column member.telephone
     *
     * @param telephone the value for member.telephone
     *
     * @mbg.generated
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column member.alias
     *
     * @return the value of member.alias
     *
     * @mbg.generated
     */
    public String getAlias() {
        return alias;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column member.alias
     *
     * @param alias the value for member.alias
     *
     * @mbg.generated
     */
    public void setAlias(String alias) {
        this.alias = alias == null ? null : alias.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column member.status
     *
     * @return the value of member.status
     *
     * @mbg.generated
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column member.status
     *
     * @param status the value for member.status
     *
     * @mbg.generated
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column member.ext_attr
     *
     * @return the value of member.ext_attr
     *
     * @mbg.generated
     */
    public String getExtAttr() {
        return extAttr;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column member.ext_attr
     *
     * @param extAttr the value for member.ext_attr
     *
     * @mbg.generated
     */
    public void setExtAttr(String extAttr) {
        this.extAttr = extAttr == null ? null : extAttr.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column member.qr_code
     *
     * @return the value of member.qr_code
     *
     * @mbg.generated
     */
    public String getQrCode() {
        return qrCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column member.qr_code
     *
     * @param qrCode the value for member.qr_code
     *
     * @mbg.generated
     */
    public void setQrCode(String qrCode) {
        this.qrCode = qrCode == null ? null : qrCode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column member.external_profile
     *
     * @return the value of member.external_profile
     *
     * @mbg.generated
     */
    public String getExternalProfile() {
        return externalProfile;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column member.external_profile
     *
     * @param externalProfile the value for member.external_profile
     *
     * @mbg.generated
     */
    public void setExternalProfile(String externalProfile) {
        this.externalProfile = externalProfile == null ? null : externalProfile.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column member.external_position
     *
     * @return the value of member.external_position
     *
     * @mbg.generated
     */
    public String getExternalPosition() {
        return externalPosition;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column member.external_position
     *
     * @param externalPosition the value for member.external_position
     *
     * @mbg.generated
     */
    public void setExternalPosition(String externalPosition) {
        this.externalPosition = externalPosition == null ? null : externalPosition.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column member.address
     *
     * @return the value of member.address
     *
     * @mbg.generated
     */
    public String getAddress() {
        return address;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column member.address
     *
     * @param address the value for member.address
     *
     * @mbg.generated
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column member.hide_mobile
     *
     * @return the value of member.hide_mobile
     *
     * @mbg.generated
     */
    public Integer getHideMobile() {
        return hideMobile;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column member.hide_mobile
     *
     * @param hideMobile the value for member.hide_mobile
     *
     * @mbg.generated
     */
    public void setHideMobile(Integer hideMobile) {
        this.hideMobile = hideMobile;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column member.english_name
     *
     * @return the value of member.english_name
     *
     * @mbg.generated
     */
    public String getEnglishName() {
        return englishName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column member.english_name
     *
     * @param englishName the value for member.english_name
     *
     * @mbg.generated
     */
    public void setEnglishName(String englishName) {
        this.englishName = englishName == null ? null : englishName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column member.open_userid
     *
     * @return the value of member.open_userid
     *
     * @mbg.generated
     */
    public String getOpenUserid() {
        return openUserid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column member.open_userid
     *
     * @param openUserid the value for member.open_userid
     *
     * @mbg.generated
     */
    public void setOpenUserid(String openUserid) {
        this.openUserid = openUserid == null ? null : openUserid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column member.main_department
     *
     * @return the value of member.main_department
     *
     * @mbg.generated
     */
    public Long getMainDepartment() {
        return mainDepartment;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column member.main_department
     *
     * @param mainDepartment the value for member.main_department
     *
     * @mbg.generated
     */
    public void setMainDepartment(Long mainDepartment) {
        this.mainDepartment = mainDepartment;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column member.member_status
     *
     * @return the value of member.member_status
     *
     * @mbg.generated
     */
    public String getMemberStatus() {
        return memberStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column member.member_status
     *
     * @param memberStatus the value for member.member_status
     *
     * @mbg.generated
     */
    public void setMemberStatus(String memberStatus) {
        this.memberStatus = memberStatus == null ? null : memberStatus.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column member.task_id
     *
     * @return the value of member.task_id
     *
     * @mbg.generated
     */
    public String getTaskId() {
        return taskId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column member.task_id
     *
     * @param taskId the value for member.task_id
     *
     * @mbg.generated
     */
    public void setTaskId(String taskId) {
        this.taskId = taskId == null ? null : taskId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column member.extension
     *
     * @return the value of member.extension
     *
     * @mbg.generated
     */
    public String getExtension() {
        return extension;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column member.extension
     *
     * @param extension the value for member.extension
     *
     * @mbg.generated
     */
    public void setExtension(String extension) {
        this.extension = extension == null ? null : extension.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column member.gmt_created
     *
     * @return the value of member.gmt_created
     *
     * @mbg.generated
     */
    public Date getGmtCreated() {
        return gmtCreated;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column member.gmt_created
     *
     * @param gmtCreated the value for member.gmt_created
     *
     * @mbg.generated
     */
    public void setGmtCreated(Date gmtCreated) {
        this.gmtCreated = gmtCreated;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column member.gmt_creator
     *
     * @return the value of member.gmt_creator
     *
     * @mbg.generated
     */
    public String getGmtCreator() {
        return gmtCreator;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column member.gmt_creator
     *
     * @param gmtCreator the value for member.gmt_creator
     *
     * @mbg.generated
     */
    public void setGmtCreator(String gmtCreator) {
        this.gmtCreator = gmtCreator == null ? null : gmtCreator.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column member.gmt_updated
     *
     * @return the value of member.gmt_updated
     *
     * @mbg.generated
     */
    public Date getGmtUpdated() {
        return gmtUpdated;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column member.gmt_updated
     *
     * @param gmtUpdated the value for member.gmt_updated
     *
     * @mbg.generated
     */
    public void setGmtUpdated(Date gmtUpdated) {
        this.gmtUpdated = gmtUpdated;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column member.gmt_updater
     *
     * @return the value of member.gmt_updater
     *
     * @mbg.generated
     */
    public String getGmtUpdater() {
        return gmtUpdater;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column member.gmt_updater
     *
     * @param gmtUpdater the value for member.gmt_updater
     *
     * @mbg.generated
     */
    public void setGmtUpdater(String gmtUpdater) {
        this.gmtUpdater = gmtUpdater == null ? null : gmtUpdater.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column member.deleted
     *
     * @return the value of member.deleted
     *
     * @mbg.generated
     */
    public Byte getDeleted() {
        return deleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column member.deleted
     *
     * @param deleted the value for member.deleted
     *
     * @mbg.generated
     */
    public void setDeleted(Byte deleted) {
        this.deleted = deleted;
    }
}