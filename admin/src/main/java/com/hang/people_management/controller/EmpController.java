package com.hang.people_management.controller;

import com.hang.people_management.entity.Employee;
import com.hang.people_management.service.EmpService;
import com.hang.people_management.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@CrossOrigin  //解决跨域
public class EmpController {

    @Autowired
    private EmpService empService;

    /**
     * 添加员工
     * @return
     * 可替代 @PostMapping("/employees")
     */
    @RequestMapping(value = "/employees", method = RequestMethod.POST)
    public R saveOne(@RequestBody Employee employee) {
        if(empService.save(employee)) {
            return R.ok();
        } else {
            return R.error();
        }
    }

    /**
     * 删除员工
     * @param id
     * @return
     * 可替代 @DeleteMapping("/employees/{id}")
     */
    @RequestMapping(value = "/employees/{id}", method = RequestMethod.DELETE)
    public R deleteById(@PathVariable Integer id) {
        Employee e = new Employee();
        e.seteId(id);
        empService.removeById(e);
        return R.ok();
    }
    @RequestMapping(value = "/employees/{json}")
    public R deleteComplex(@PathVariable String json) {
        return R.ok();
    }

    /**
     * 修改员工
     * @return
     * 可替代 @PutMapping("/employees")
     */
    @RequestMapping(value = "/employees/update", method = RequestMethod.POST)
    public R updateOne(@RequestBody Employee employee) {
        if(empService.updateById(employee)) {
            return R.ok();
        } else {
            return R.error();
        }
    }



    @RequestMapping(value = "/employees/login", method = RequestMethod.POST)
    public R getByAccount(String eName, String ePassword) {
        // 通过员工名和密码登录系统
        Employee employee = new Employee();
        employee.seteName(eName);
        employee.setePassword(ePassword);
        if(empService.getByEmp(employee) != null) {
            return R.ok().data("token","employee").data("err", 2).data("data", empService.getByEmp(employee));
        } else {
            return R.error();
        }
    }

    /**
     *  查找员工
     * @param id
     * @return
     * 可替代 @GetMapping("/employees/{id}")
     */
    @RequestMapping(value = "/employees/{id}", method = RequestMethod.GET)
    public R getOne(@PathVariable Integer id) {
        Employee e = empService.getById(id);
        return R.ok().data("employee", e);
    }
    @RequestMapping(value = "/employees", method = RequestMethod.GET)
    public R getAll() {
        List<Employee> list = empService.getList();
        return R.ok().data("items", list);
    }
    @RequestMapping(value = "/employees/page", method = RequestMethod.GET)
    public R getByPage(String currentPage, String pageSize) {
        List<Employee> employees = empService.getByPage(currentPage, pageSize);
        long total = empService.getTotal();
        return R.ok().data("total", total).data("items", employees);
    }
}
