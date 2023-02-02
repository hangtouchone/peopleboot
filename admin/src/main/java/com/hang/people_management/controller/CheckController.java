package com.hang.people_management.controller;

import com.hang.people_management.entity.CheckingIn;
import com.hang.people_management.entity.Emolument;
import com.hang.people_management.entity.Employee;
import com.hang.people_management.service.CheckService;
import com.hang.people_management.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class CheckController {

    @Autowired
    private CheckService checkService;

    // 增
    @RequestMapping(value = "/checks", method = RequestMethod.POST)
    public R saveOne(@RequestBody CheckingIn c) {
        if(checkService.save(c)) {
            return R.ok();
        } else {
            return R.error();
        }
    }
    // 删
    @RequestMapping(value = "/checks/{id}", method = RequestMethod.DELETE)
    public R deleteById(@PathVariable Integer id) {
        CheckingIn c = new CheckingIn();
        c.setcId(id);
        checkService.removeById(c);
        return R.ok();
    }
    // 改
    @RequestMapping(value = "/checks/update", method = RequestMethod.POST)
    public R updateOne(@RequestBody CheckingIn c) {
        if(checkService.updateById(c)) {
            return R.ok();
        } else {
            return R.error();
        }
    }
    // 查
    @RequestMapping(value = "/checks", method = RequestMethod.GET)
    public R getAll() {
        List<CheckingIn> list = checkService.getList();
        return R.ok().data("items", list);
    }
    @RequestMapping(value = "/checks/{id}", method = RequestMethod.GET)
    public R getOne(@PathVariable Integer id) {
        CheckingIn c = checkService.getById(id);
        return R.ok().data("check", c);
    }

    @RequestMapping(value = "/checks/page", method = RequestMethod.GET)
    public R getByPage(String currentPage, String pageSize) {
        List<CheckingIn> checks = checkService.getByPage(currentPage, pageSize);
        long total = checkService.getTotal();
        return R.ok().data("total", total).data("items", checks);
    }
}
