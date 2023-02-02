package com.hang.people_management.dao;

import com.hang.people_management.entity.CheckingIn;
import com.hang.people_management.entity.Employee;
import com.hang.people_management.entity.Train;
import com.hang.people_management.util.Condition;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrainDao {
    // 增
    public int insert(Train train);
    // 删
    public int deleteById(Train train);
    // 改
    public int updateById(Train train);
    // 查
    public List<Train> selectList();
    public Train selectById(Integer id);
    // 分页查找
    public List<Train> selectByPage(Condition condition);
    public long selectTotal();
}
