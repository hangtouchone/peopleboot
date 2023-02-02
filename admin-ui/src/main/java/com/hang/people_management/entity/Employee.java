package com.hang.people_management.entity;

import java.sql.Date;

public class Employee {
    private Integer eId; // 人员编号
    private String eName; // 人员名称
    private String email; // email
    private String ePassword; // 密码
    private String gender; // 性别
    private String pic; // 头像
    private String nation; // 民族
    private Date birthday; // 生日
    private String politicsStatus; // 政治面貌
    private String nativePlace; // 籍贯
    private String idenNum; // 身份证号
    private String phoneNum; // 手机号码
    private String archivesPlace; // 户籍地址
    private Role role; // 岗位

    public Integer geteId() {
        return eId;
    }

    public void seteId(Integer eId) {
        this.eId = eId;
    }

    public String geteName() {
        return eName;
    }

    public void seteName(String eName) {
        this.eName = eName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getePassword() {
        return ePassword;
    }

    public void setePassword(String ePassword) {
        this.ePassword = ePassword;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getPoliticsStatus() {
        return politicsStatus;
    }

    public void setPoliticsStatus(String politicsStatus) {
        this.politicsStatus = politicsStatus;
    }

    public String getNativePlace() {
        return nativePlace;
    }

    public void setNativePlace(String nativePlace) {
        this.nativePlace = nativePlace;
    }

    public String getIdenNum() {
        return idenNum;
    }

    public void setIdenNum(String idenNum) {
        this.idenNum = idenNum;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getArchivesPlace() {
        return archivesPlace;
    }

    public void setArchivesPlace(String archivesPlace) {
        this.archivesPlace = archivesPlace;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
