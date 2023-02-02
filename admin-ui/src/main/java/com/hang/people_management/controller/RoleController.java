package com.hang.people_management.controller;

import com.hang.people_management.entity.CheckingIn;
import com.hang.people_management.entity.Role;
import com.hang.people_management.service.CheckService;
import com.hang.people_management.service.RoleService;
import com.hang.people_management.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class RoleController {

    @Autowired
    private RoleService roleService;

    // 增
    @RequestMapping(value = "/roles", method = RequestMethod.POST)
    public R saveOne(@RequestBody Role r) {
        if(roleService.save(r)) {
            return R.ok();
        } else {
            return R.error();
        }
    }
    // 删
    @RequestMapping(value = "/roles/{id}", method = RequestMethod.DELETE)
    public R deleteById(@PathVariable Integer id) {
        Role role = new Role();
        role.setrId(id);
        roleService.removeById(role);
        return R.ok();
    }
    // 改
    @RequestMapping(value = "/roles/update", method = RequestMethod.POST)
    public R updateOne(@RequestBody Role role) {
        if(roleService.updateById(role)) {
            return R.ok();
        } else {
            return R.error();
        }
    }
    // 查
    @RequestMapping(value = "/roles", method = RequestMethod.GET)
    public R getAll() {
        List<Role> list = roleService.getList();
        return R.ok().data("items", list);
    }
    @RequestMapping(value = "/roles/{id}", method = RequestMethod.GET)
    public R getOne(@PathVariable Integer id) {
        Role role = roleService.getById(id);
        return R.ok().data("role", role);
    }

    @RequestMapping(value = "/roles/page", method = RequestMethod.GET)
    public R getByPage(String currentPage, String pageSize) {
        List<Role> roles = roleService.getByPage(currentPage, pageSize);
        long total = roleService.getTotal();
        return R.ok().data("total", total).data("items", roles);
    }
}
