package com.hang.people_management.service;

import com.hang.people_management.entity.Train;

import java.util.List;

public interface TrainService {
    // 增
    public boolean save(Train train);
    // 删
    public boolean removeById(Train train);
    // 改
    public boolean updateById(Train train);
    // 查
    public List<Train> getList();
    public Train getById(Integer id);
    public List<Train> getByPage(String currentPage, String pageSize);
    public long getTotal();
}
