package com.hang.people_management.controller;

import com.hang.people_management.entity.Performance;
import com.hang.people_management.service.PerformanceService;
import com.hang.people_management.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class PerformanceController {

    @Autowired
    private PerformanceService performanceService;

    @RequestMapping(value = "/performances", method = RequestMethod.POST)
    public R saveOne(@RequestBody Performance p) {
        if(performanceService.save(p)) {
            return R.ok();
        } else {
            return R.error();
        }
    }

    @RequestMapping(value = "/performances/{id}", method = RequestMethod.DELETE)
    public R deleteById(@PathVariable Integer id) {
        Performance p = new Performance();
        p.setpId(id);
        performanceService.removeById(p);
        return R.ok();
    }

    @RequestMapping(value = "/performances/update", method = RequestMethod.POST)
    public R updateOne(@RequestBody Performance p) {
        if(performanceService.updateById(p)) {
            return R.ok();
        } else {
            return R.error();
        }
    }

    @RequestMapping(value = "/performances", method = RequestMethod.GET)
    public R getAll() {
        List<Performance> list = performanceService.getList();
        return R.ok().data("items", list);
    }
    @RequestMapping(value = "/performances/{id}", method = RequestMethod.GET)
    public R getOne(@PathVariable Integer id) {
        Performance p = performanceService.getById(id);
        return R.ok().data("performance", p);
    }
    @RequestMapping(value = "/performances/page", method = RequestMethod.GET)
    public R getByPage(String currentPage, String pageSize) {
        List<Performance> performances = performanceService.getByPage(currentPage, pageSize);
        long total = performanceService.getTotal();
        return R.ok().data("total", total).data("items", performances);
    }
}

