package cn.bcf.springbootdemo01.controller;

import cn.bcf.springbootdemo01.third.Page;
import cn.bcf.springbootdemo01.third.RongLianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description：TODO
 * @Author：bichengfei
 * @Date：2021/5/14 11:24 上午
 */
@RestController
public class FeignController {

    @Autowired
    RongLianService rongLianService;

    @RequestMapping("/ronglian/productList")
    public String rongLian(){
        Page page = new Page(1, 10);
        String res = rongLianService.productList(page);
        System.out.println(res);
        return res;
    }

}
