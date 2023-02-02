package com.hang.people_management.service.impl;

import com.hang.people_management.dao.JLevelDao;
import com.hang.people_management.entity.JLevel;
import com.hang.people_management.service.JLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JLevelServiceImpl implements JLevelService {

    @Autowired
    private JLevelDao jLevelDao;

    @Override
    public boolean save(JLevel j) {
        return jLevelDao.insert(j) > 0;
    }

    @Override
    public boolean removeById(JLevel j) {
        return jLevelDao.deleteById(j) > 0;
    }

    @Override
    public boolean updateById(JLevel j) {
        return jLevelDao.deleteById(j) > 0;
    }

    @Override
    public List<JLevel> getList() {
        return jLevelDao.selectList();
    }

    @Override
    public JLevel getById(Integer id) {
        return jLevelDao.selectById(id);
    }
}
