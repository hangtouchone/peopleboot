package com.hang.people_management.dao;

import com.hang.people_management.entity.CheckingIn;
import com.hang.people_management.entity.Performance;
import com.hang.people_management.util.Condition;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PerformanceDao {
    // 增
    public int insert(Performance p);
    // 删
    public int deleteById(Performance p);
    // 改
    public int updateById(Performance p);
    // 查
    public List<Performance> selectList();
    public Performance selectById(Integer id);
    // 分页查找
    public List<Performance> selectByPage(Condition condition);
    public long selectTotal();
}
