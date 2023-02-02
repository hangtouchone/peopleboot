package com.hang.people_management.service.impl;

import com.hang.people_management.dao.EmolumentDao;
import com.hang.people_management.entity.Emolument;
import com.hang.people_management.entity.Employee;
import com.hang.people_management.service.EmolumentService;
import com.hang.people_management.util.Condition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmolumentServiceImpl implements EmolumentService {

    @Autowired
    private EmolumentDao emolumentDao;

    @Override
    public boolean save(List<Emolument> list) {
        return emolumentDao.insert(list) > 0;
    }

    @Override
    public boolean save(Emolument em) {
        return emolumentDao.insert(em) > 0;
    }

    @Override
    public boolean removeById(Emolument em) {
        return emolumentDao.deleteById(em) > 0;
    }

    @Override
    public boolean updateById(Emolument em) {
        return emolumentDao.updateById(em) > 0;
    }

    @Override
    public List<Emolument> getList() {
        return emolumentDao.selectList();
    }

    @Override
    public Emolument getById(Integer id) {
        return emolumentDao.selectById(id);
    }

    @Override
    public List<Emolument> getByPage(String currentPage, String pageSize) {
        Condition condition = new Condition();
        int cp = Integer.parseInt(currentPage);
        int ps = Integer.parseInt(pageSize);
        cp = (cp - 1) * ps;
        condition.setCurrentPage(cp);
        condition.setPageSize(ps);
        List<Emolument> emoluments = emolumentDao.selectByPage(condition);
        return emoluments;
    }

    @Override
    public long getTotal() {
        return emolumentDao.selectTotal();
    }
}
