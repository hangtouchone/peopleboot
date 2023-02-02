package com.hang.people_management.controller;

import com.hang.people_management.util.R;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
@CrossOrigin
public class LoginController {

    @PostMapping("login")
    public R login() {
        return R.ok().data("token","admin");
    }

    @GetMapping("info")
    public R info() {
        return R.ok()
                .data("roles","[admin]")
                .data("name","admin")
                .data("avatar","https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fimg.zcool.cn%2Fcommunity%2F0175755f60441711013f1a64904410.gif&refer=http%3A%2F%2Fimg.zcool.cn&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=auto?sec=1671352709&t=f5c9e778425fc02d361e5e0b10afb665");
    }

    @PostMapping("logout")
    public R logout() {
        return R.ok().data("token", "admin");
    }
}
