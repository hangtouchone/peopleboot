package com.hang.people_management.controller;

import com.hang.people_management.entity.Emolument;
import com.hang.people_management.entity.Employee;
import com.hang.people_management.service.EmolumentService;
import com.hang.people_management.service.EmpService;
import com.hang.people_management.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin  //解决跨域
public class EmolumentController {

    @Autowired
    private EmolumentService emolumentService;

    /**
     * 添加薪资
     * @return
     * 可替代 @PostMapping("/emoluments")
     */
    @RequestMapping(value = "/emoluments", method = RequestMethod.POST)
    public R saveOne(@RequestBody Emolument em) {
        if(emolumentService.save(em)) {
            return R.ok();
        } else {
            return R.error();
        }
    }

    /**
     * 删除薪资
     * @param id
     * @return
     * 可替代 @DeleteMapping("/emoluments/{id}")
     */
    @RequestMapping(value = "/emoluments/{id}", method = RequestMethod.DELETE)
    public R deleteById(@PathVariable Integer id) {
        Emolument em = new Emolument();
        em.setEmId(id);
        emolumentService.removeById(em);
        return R.ok();
    }
    @RequestMapping(value = "/emoluments/{json}")
    public R deleteComplex(@PathVariable String json) {
        return R.ok();
    }

    /**
     * 修改薪资
     * @return
     * 可替代 @PutMapping("/emoluments")
     */
    @RequestMapping(value = "/emoluments/update", method = RequestMethod.POST)
    public R updateOne(@RequestBody Emolument em) {
        if(emolumentService.updateById(em)) {
            return R.ok();
        } else {
            return R.error();
        }
    }

    /**
     *  查找薪资
     * @param id
     * @return
     * 可替代 @GetMapping("/emoluments/{id}")
     */
    @RequestMapping(value = "/emoluments/{id}", method = RequestMethod.GET)
    public R getOne(@PathVariable Integer id) {
        Emolument em = emolumentService.getById(id);
        return R.ok().data("emolument", em);
    }
    @RequestMapping(value = "/emoluments", method = RequestMethod.GET)
    public R getAll() {
        List<Emolument> list = emolumentService.getList();
        return R.ok().data("items", list);
    }
    @RequestMapping(value = "/emoluments/page", method = RequestMethod.GET)
    public R getByPage(String currentPage, String pageSize) {
        List<Emolument> emoluments = emolumentService.getByPage(currentPage, pageSize);
        long total = emolumentService.getTotal();
        return R.ok().data("total", total).data("items", emoluments);
    }
}
