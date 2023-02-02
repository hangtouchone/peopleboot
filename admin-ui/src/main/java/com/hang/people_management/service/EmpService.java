package com.hang.people_management.service;

import com.hang.people_management.entity.Employee;

import java.util.List;

public interface EmpService {
    // 增
    public boolean save(List<Employee> list);
    public boolean save(Employee e);
    // 删
    public boolean removeById(Employee e);
    // 改
    public boolean updateById(Employee e);
    // 查
    public List<Employee> getList();
    // 登录
    public Employee getById(Integer id);
    public Employee getByEmp(Employee e);
    public List<Employee> getByPage(String currentPage, String pageSize);
    public long getTotal();
}
