package com.hang.people_management.dao;

import com.hang.people_management.entity.Emolument;
import com.hang.people_management.entity.Employee;
import com.hang.people_management.util.Condition;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmolumentDao {
    // 增
    public int insert(List<Emolument> roleList);
    public int insert(Emolument em);
    // 删
    public int deleteById(Emolument em);
    // 改
    public int updateById(Emolument em);
    // 查全
    public List<Emolument> selectList();
    // 查一 通过id
    public Emolument selectById(Integer id);
    // 分页查找
    public List<Emolument> selectByPage(Condition condition);
    public long selectTotal();
}
