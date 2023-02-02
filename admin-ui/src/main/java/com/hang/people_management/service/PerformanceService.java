package com.hang.people_management.service;

import com.hang.people_management.entity.Performance;

import java.util.List;

public interface PerformanceService {
    // 增
    public boolean save(Performance p);
    // 删
    public boolean removeById(Performance p);
    // 改
    public boolean updateById(Performance p);
    // 查
    public List<Performance> getList();
    public Performance getById(Integer id);
    public List<Performance> getByPage(String currentPage, String pageSize);
    public long getTotal();
}
