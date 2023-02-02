package com.hang.people_management.controller;

import com.hang.people_management.entity.JLevel;
import com.hang.people_management.service.JLevelService;
import com.hang.people_management.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class JLevelController {

    @Autowired
    private JLevelService jLevelService;

    // 增
    @RequestMapping(value = "/jlevels", method = RequestMethod.POST)
    public R saveOne(@RequestBody JLevel j) {
        if(jLevelService.save(j)) {
            return R.ok();
        } else {
            return R.error();
        }
    }
    // 删
    @RequestMapping(value = "/jlevels/{id}", method = RequestMethod.DELETE)
    public R deleteById(@PathVariable Integer id) {
        JLevel j = new JLevel();
        j.setJlevelId(id);
        jLevelService.removeById(j);
        return R.ok();
    }
    // 改
    @RequestMapping(value = "/jlevels/update", method = RequestMethod.POST)
    public R updateOne(@RequestBody JLevel j) {
        if(jLevelService.updateById(j)) {
            return R.ok();
        } else {
            return R.error();
        }
    }
    // 查
    @RequestMapping(value = "/jlevels", method = RequestMethod.GET)
    public R getAll() {
        List<JLevel> list = jLevelService.getList();
        return R.ok().data("items", list);
    }
    @RequestMapping(value = "/jlevels/{id}", method = RequestMethod.GET)
    public R getOne(@PathVariable Integer id) {
        JLevel jLevel = jLevelService.getById(id);
        return R.ok().data("jlevel", jLevel);
    }
}
