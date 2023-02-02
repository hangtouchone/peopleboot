package com.hang.people_management.entity;

public class Role {
    private Integer rId;
    private String rName;
    private String func;
    private JLevel jLevel;
    private Unit unit;

    public Integer getrId() {
        return rId;
    }

    public void setrId(Integer rId) {
        this.rId = rId;
    }

    public String getrName() {
        return rName;
    }

    public void setrName(String rName) {
        this.rName = rName;
    }

    public String getFunc() {
        return func;
    }

    public void setFunc(String func) {
        this.func = func;
    }

    public JLevel getjLevel() {
        return jLevel;
    }

    public void setjLevel(JLevel jLevel) {
        this.jLevel = jLevel;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }
}
