package com.hang.people_management.dao;

import com.hang.people_management.entity.Employee;
import com.hang.people_management.util.Condition;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpDao {
    // 增
    public int insert(List<Employee> roleList);
    public int insert(Employee e);
    // 删
    public int deleteById(Employee e);
    // 改
    public int updateById(Employee e);
    // 查全
    public List<Employee> selectList();
    // 查一 通过id
    public Employee selectById(Integer id);
    // 登录
    public Employee selectByEmp(Employee e);
    // 分页查找
    public List<Employee> selectByPage(Condition condition);
    public long selectTotal();
}
