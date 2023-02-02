package com.hang.people_management.dao;

import com.hang.people_management.entity.CheckingIn;
import com.hang.people_management.entity.Emolument;
import com.hang.people_management.util.Condition;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CheckDao {
    // 增
    public int insert(CheckingIn c);
    // 删
    public int deleteById(CheckingIn c);
    // 改
    public int updateById(CheckingIn c);
    // 查
    public List<CheckingIn> selectList();
    public CheckingIn selectById(Integer id);
    // 分页查找
    public List<CheckingIn> selectByPage(Condition condition);
    public long selectTotal();
}
