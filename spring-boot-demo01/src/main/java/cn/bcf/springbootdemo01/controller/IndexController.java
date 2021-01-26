package cn.bcf.springbootdemo01.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @RequestMapping("/demo01")
    public String demo01() {
        return "demo01";
    }

    @PostMapping("/demo02")
    public String demo02(String var0) {
        return var0;
    }
}
