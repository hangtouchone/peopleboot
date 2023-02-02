package com.hang.people_management.service;

import com.hang.people_management.entity.JLevel;

import java.util.List;

public interface JLevelService {
    // 增
    public boolean save(JLevel j);
    // 删
    public boolean removeById(JLevel j);
    // 改
    public boolean updateById(JLevel j);
    // 查
    public List<JLevel> getList();
    public JLevel getById(Integer id);
}
