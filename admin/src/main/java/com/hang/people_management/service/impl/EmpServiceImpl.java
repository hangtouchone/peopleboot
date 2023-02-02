package com.hang.people_management.service.impl;

import com.hang.people_management.dao.EmpDao;
import com.hang.people_management.entity.Employee;
import com.hang.people_management.service.EmpService;
import com.hang.people_management.util.Condition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpDao empDao;

    @Override
    public boolean save(List<Employee> list) {
        return empDao.insert(list) > 0;
    }

    @Override
    public boolean save(Employee e) {
        return empDao.insert(e) > 0;
    }

    @Override
    public boolean removeById(Employee e) {
        return empDao.deleteById(e) > 0;
    }

    @Override
    public boolean updateById(Employee e) {
        return empDao.updateById(e) > 0;
    }

    @Override
    public List<Employee> getList() {
        return empDao.selectList();
    }

    @Override
    public Employee getById(Integer id) {
        return empDao.selectById(id);
    }

    @Override
    public Employee getByEmp(Employee e) {
        return empDao.selectByEmp(e);
    }

    @Override
    public List<Employee> getByPage(String currentPage, String pageSize) {
        Condition condition = new Condition();
        int cp = Integer.parseInt(currentPage);
        int ps = Integer.parseInt(pageSize);
        cp = (cp - 1) * ps;
        condition.setCurrentPage(cp);
        condition.setPageSize(ps);
        List<Employee> employees = empDao.selectByPage(condition);
        return employees;
    }

    @Override
    public long getTotal() {
        return empDao.selectTotal();
    }


}
