package com.hang.people_management.dao;

import com.hang.people_management.entity.JLevel;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JLevelDao {
    // 增
    public int insert(JLevel j);
    // 删
    public int deleteById(JLevel j);
    // 改
    public int updateById(JLevel j);
    // 查
    public List<JLevel> selectList();
    public JLevel selectById(Integer id);
}