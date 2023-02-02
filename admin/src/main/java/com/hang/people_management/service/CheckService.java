package com.hang.people_management.service;

import com.hang.people_management.entity.CheckingIn;
import com.hang.people_management.entity.Emolument;

import java.util.List;

public interface CheckService {
    // 增
    public boolean save(CheckingIn c);
    // 删
    public boolean removeById(CheckingIn c);
    // 改
    public boolean updateById(CheckingIn c);
    // 查
    public List<CheckingIn> getList();
    public CheckingIn getById(Integer id);
    public List<CheckingIn> getByPage(String currentPage, String pageSize);
    public long getTotal();
}
