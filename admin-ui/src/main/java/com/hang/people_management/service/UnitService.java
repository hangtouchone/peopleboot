package com.hang.people_management.service;

import com.hang.people_management.entity.CheckingIn;
import com.hang.people_management.entity.Unit;

import java.util.List;

public interface UnitService {
    // 增
    public boolean save(Unit unit);
    // 删
    public boolean removeById(Unit unit);
    // 改
    public boolean updateById(Unit unit);
    // 查
    public List<Unit> getList();
    public Unit getById(Integer id);
}
