package com.hang.people_management.service.impl;

import com.hang.people_management.dao.CheckDao;
import com.hang.people_management.entity.CheckingIn;
import com.hang.people_management.entity.Emolument;
import com.hang.people_management.service.CheckService;
import com.hang.people_management.util.Condition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CheckServiceImpl implements CheckService {

    @Autowired
    private CheckDao checkDao;

    @Override
    public boolean save(CheckingIn c) {
        return checkDao.insert(c) > 0;
    }

    @Override
    public boolean removeById(CheckingIn c) {
        return checkDao.deleteById(c) > 0;
    }

    @Override
    public boolean updateById(CheckingIn c) {
        return checkDao.updateById(c) > 0;
    }

    @Override
    public List<CheckingIn> getList() {
        return checkDao.selectList();
    }

    @Override
    public CheckingIn getById(Integer id) {
        return checkDao.selectById(id);
    }

    @Override
    public List<CheckingIn> getByPage(String currentPage, String pageSize) {
        Condition condition = new Condition();
        int cp = Integer.parseInt(currentPage);
        int ps = Integer.parseInt(pageSize);
        cp = (cp - 1) * ps;
        condition.setCurrentPage(cp);
        condition.setPageSize(ps);
        List<CheckingIn> checks = checkDao.selectByPage(condition);
        return checks;
    }

    @Override
    public long getTotal() {
        return checkDao.selectTotal();
    }
}
