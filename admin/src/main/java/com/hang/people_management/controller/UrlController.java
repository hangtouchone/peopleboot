package com.hang.people_management.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UrlController {
    // 首页
    @RequestMapping("/")
    public String gotoIndex() {
        return "index";
    }

    // 员工页面
    @RequestMapping("/emp")
    public String gotoEmp() {
        return "employee";
    }
}
