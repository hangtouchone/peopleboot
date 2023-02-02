package com.hang.people_management.service.impl;

import com.hang.people_management.dao.TrainDao;
import com.hang.people_management.entity.Employee;
import com.hang.people_management.entity.Train;
import com.hang.people_management.service.TrainService;
import com.hang.people_management.util.Condition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainServiceImpl implements TrainService {

    @Autowired
    private TrainDao trainDao;

    @Override
    public boolean save(Train train) {
        return trainDao.insert(train) > 0;
    }

    @Override
    public boolean removeById(Train train) {
        return trainDao.deleteById(train) > 0;
    }

    @Override
    public boolean updateById(Train train) {
        return trainDao.updateById(train) > 0;
    }

    @Override
    public List<Train> getList() {
        return trainDao.selectList();
    }

    @Override
    public Train getById(Integer id) {
        return trainDao.selectById(id);
    }

    @Override
    public List<Train> getByPage(String currentPage, String pageSize) {
        Condition condition = new Condition();
        int cp = Integer.parseInt(currentPage);
        int ps = Integer.parseInt(pageSize);
        cp = (cp - 1) * ps;
        condition.setCurrentPage(cp);
        condition.setPageSize(ps);
        List<Train> trains = trainDao.selectByPage(condition);
        return trains;
    }

    @Override
    public long getTotal() {
        return trainDao.selectTotal();
    }
}
