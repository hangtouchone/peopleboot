package com.hang.people_management.entity;

import java.sql.Date;

public class CheckingIn {
    private Integer cId;
    private Employee employee;
    private Date startTime;
    private Date closeTime;
    private String status;
    private String description;

    public Integer getcId() {
        return cId;
    }

    public void setcId(Integer cId) {
        this.cId = cId;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(Date closeTime) {
        this.closeTime = closeTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
