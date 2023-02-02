package com.hang.people_management.dao;

import com.hang.people_management.entity.CheckingIn;
import com.hang.people_management.entity.Role;
import com.hang.people_management.util.Condition;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleDao {
    // 增
    public int insert(List<Role> roleList);
    public int insert(Role role);
    // 删
    public int deleteById(Role role);
    // 改
    public int updateById(Role role);
    // 查全
    public List<Role> selectList();
    // 查一 通过id
    public Role selectById(Integer id);
    // 分页查找
    public List<Role> selectByPage(Condition condition);
    public long selectTotal();
}
