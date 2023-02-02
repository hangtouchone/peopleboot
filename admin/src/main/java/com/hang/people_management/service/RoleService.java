package com.hang.people_management.service;

import com.hang.people_management.entity.Role;

import java.util.List;

public interface RoleService {
    // 增
    public boolean save(List<Role> roleList);
    public boolean save(Role role);
    // 删
    public boolean removeById(Role role);
    // 改
    public boolean updateById(Role role);
    // 查
    public List<Role> getList();
    public Role getById(Integer id);
    public List<Role> getByPage(String currentPage, String pageSize);
    public long getTotal();
}
