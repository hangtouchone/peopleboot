package com.hang.people_management.entity;

public class JLevel {
    private Integer jlevelId;

    public String getJdescription() {
        return jdescription;
    }

    public void setJdescription(String jdescription) {
        this.jdescription = jdescription;
    }

    private String jdescription;
    private String jlevelName;

    public Integer getJlevelId() {
        return jlevelId;
    }

    public void setJlevelId(Integer jlevelId) {
        this.jlevelId = jlevelId;
    }


    public String getJlevelName() {
        return jlevelName;
    }

    public void setJlevelName(String jlevelName) {
        this.jlevelName = jlevelName;
    }
}
