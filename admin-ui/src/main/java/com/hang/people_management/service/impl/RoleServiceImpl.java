package com.hang.people_management.service.impl;

import com.hang.people_management.dao.RoleDao;
import com.hang.people_management.entity.CheckingIn;
import com.hang.people_management.entity.Role;
import com.hang.people_management.service.RoleService;
import com.hang.people_management.util.Condition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    @Override
    public boolean save(List<Role> roleList) {
        return roleDao.insert(roleList) > 0;
    }

    @Override
    public boolean save(Role role) {
        return roleDao.insert(role) > 0;
    }

    @Override
    public boolean removeById(Role role) {
        return roleDao.deleteById(role) > 0;
    }

    @Override
    public boolean updateById(Role role) {
        return roleDao.updateById(role) > 0;
    }

    @Override
    public List<Role> getList() {
        return roleDao.selectList();
    }

    @Override
    public Role getById(Integer id) {
        return roleDao.selectById(id);
    }

    @Override
    public List<Role> getByPage(String currentPage, String pageSize) {
        Condition condition = new Condition();
        int cp = Integer.parseInt(currentPage);
        int ps = Integer.parseInt(pageSize);
        cp = (cp - 1) * ps;
        condition.setCurrentPage(cp);
        condition.setPageSize(ps);
        List<Role> roles = roleDao.selectByPage(condition);
        return roles;
    }

    @Override
    public long getTotal() {
        return roleDao.selectTotal();
    }
}
