package com.hang.people_management.entity;

public class Unit {
    private Integer unitId;
    private String unitName;
    private String description;
    private Integer upperId;
    private Unit unit;

    public Integer getUnitId() {
        return unitId;
    }

    public void setUnitId(Integer unitId) {
        this.unitId = unitId;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getUpperId() {
        return upperId;
    }

    public void setUpperId(Integer upperId) {
        this.upperId = upperId;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }
}
