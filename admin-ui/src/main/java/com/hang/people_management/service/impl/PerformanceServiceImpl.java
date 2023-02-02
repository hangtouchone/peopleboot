package com.hang.people_management.service.impl;

import com.hang.people_management.dao.PerformanceDao;
import com.hang.people_management.entity.CheckingIn;
import com.hang.people_management.entity.Performance;
import com.hang.people_management.service.PerformanceService;
import com.hang.people_management.util.Condition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PerformanceServiceImpl implements PerformanceService {

    @Autowired
    private PerformanceDao performanceDao;

    @Override
    public boolean save(Performance p) {
        return performanceDao.insert(p) > 0;
    }

    @Override
    public boolean removeById(Performance p) {
        return performanceDao.deleteById(p) > 0;
    }

    @Override
    public boolean updateById(Performance p) {
        return performanceDao.updateById(p) > 0;
    }

    @Override
    public List<Performance> getList() {
        return performanceDao.selectList();
    }

    @Override
    public Performance getById(Integer id) {
        return performanceDao.selectById(id);
    }

    @Override
    public List<Performance> getByPage(String currentPage, String pageSize) {
        Condition condition = new Condition();
        int cp = Integer.parseInt(currentPage);
        int ps = Integer.parseInt(pageSize);
        cp = (cp - 1) * ps;
        condition.setCurrentPage(cp);
        condition.setPageSize(ps);
        List<Performance> performances = performanceDao.selectByPage(condition);
        return performances;
    }

    @Override
    public long getTotal() {
        return performanceDao.selectTotal();
    }
}
