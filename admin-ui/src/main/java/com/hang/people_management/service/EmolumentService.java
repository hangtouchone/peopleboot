package com.hang.people_management.service;

import com.hang.people_management.entity.Emolument;
import com.hang.people_management.entity.Employee;

import java.util.List;

public interface EmolumentService {
    // 增
    public boolean save(List<Emolument> list);
    public boolean save(Emolument em);
    // 删
    public boolean removeById(Emolument em);
    // 改
    public boolean updateById(Emolument em);
    // 查
    public List<Emolument> getList();
    public Emolument getById(Integer id);
    public List<Emolument> getByPage(String currentPage, String pageSize);
    public long getTotal();
}
