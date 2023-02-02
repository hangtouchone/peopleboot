package com.hang.people_management.controller;

import com.hang.people_management.entity.Train;
import com.hang.people_management.service.TrainService;
import com.hang.people_management.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class TrainController {

    @Autowired
    private TrainService trainService;

    @RequestMapping(value = "/trains", method = RequestMethod.POST)
    public R saveOne(@RequestBody Train train) {
        if(trainService.save(train)) {
            return R.ok();
        } else {
            return R.error();
        }
    }

    @RequestMapping(value = "/trains/{id}", method = RequestMethod.DELETE)
    public R deleteById(@PathVariable Integer id) {
        Train t = new Train();
        t.settId(id);
        trainService.removeById(t);
        return R.ok();
    }

    @RequestMapping(value = "/trains/update", method = RequestMethod.POST)
    public R updateOne(@RequestBody Train train) {
        if(trainService.updateById(train)) {
            return R.ok();
        } else {
            return R.error();
        }
    }

    @RequestMapping(value = "/trains", method = RequestMethod.GET)
    public R getAll() {
        List<Train> list = trainService.getList();
        return R.ok().data("items", list);
    }

    @RequestMapping(value = "/trains/{id}", method = RequestMethod.GET)
    public R getOne(@PathVariable Integer id) {
        Train t = trainService.getById(id);
        return R.ok().data("train", t);
    }

    @RequestMapping(value = "/trains/page", method = RequestMethod.GET)
    public R getByPage(String currentPage, String pageSize) {
        List<Train> trains = trainService.getByPage(currentPage, pageSize);
        long total = trainService.getTotal();
        return R.ok().data("total", total).data("items", trains);
    }
}
