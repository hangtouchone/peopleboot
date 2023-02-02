package com.hang.people_management.controller;

import com.hang.people_management.entity.Unit;
import com.hang.people_management.service.UnitService;
import com.hang.people_management.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class UnitController {
    @Autowired
    private UnitService unitService;

    @RequestMapping(value = "/units", method = RequestMethod.POST)
    public R saveOne(@RequestBody Unit unit) {
        if(unitService.save(unit)) {
            return R.ok();
        } else {
            return R.error();
        }
    }

    @RequestMapping(value = "/units/{id}", method = RequestMethod.DELETE)
    public R deleteById(@PathVariable Integer id) {
        Unit unit = new Unit();
        unit.setUnitId(id);
        unitService.removeById(unit);
        return R.ok();
    }

    @RequestMapping(value = "/units/update", method = RequestMethod.POST)
    public R updateOne(@RequestBody Unit unit) {
        if(unitService.updateById(unit)) {
            return R.ok();
        } else {
            return R.error();
        }
    }

    @RequestMapping(value = "/units", method = RequestMethod.GET)
    public R getAll() {
        List<Unit> list = unitService.getList();
        return R.ok().data("items", list);
    }

    @RequestMapping(value = "/units/{id}", method = RequestMethod.GET)
    public R getOne(@PathVariable Integer id) {
        Unit u = unitService.getById(id);
        return R.ok().data("unit", u);
    }
}
