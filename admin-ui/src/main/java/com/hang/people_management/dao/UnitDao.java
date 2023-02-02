package com.hang.people_management.dao;

import com.hang.people_management.entity.Unit;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UnitDao {
    // 增
    public int insert(Unit unit);
    // 删
    public int deleteById(Unit unit);
    // 改
    public int updateById(Unit unit);
    // 查
    public List<Unit> selectList();
    public Unit selectById(Integer id);
}
