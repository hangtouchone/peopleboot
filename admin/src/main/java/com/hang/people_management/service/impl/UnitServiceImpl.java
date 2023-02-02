package com.hang.people_management.service.impl;

import com.hang.people_management.dao.UnitDao;
import com.hang.people_management.entity.Unit;
import com.hang.people_management.service.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UnitServiceImpl implements UnitService {

    @Autowired
    private UnitDao unitDao;

    @Override
    public boolean save(Unit unit) {
        return unitDao.insert(unit) > 0;
    }

    @Override
    public boolean removeById(Unit unit) {
        return unitDao.deleteById(unit) > 0;
    }

    @Override
    public boolean updateById(Unit unit) {
        return unitDao.updateById(unit) > 0;
    }

    @Override
    public List<Unit> getList() {
        return unitDao.selectList();
    }

    @Override
    public Unit getById(Integer id) {
        return unitDao.selectById(id);
    }
}
