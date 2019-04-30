package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

    @RequestMapping("/")
    public ModelAndView login(){
        ModelAndView view = new ModelAndView();
        //view.setViewName("/son");
        view.setViewName("/first/son");
        return view;
    }
}
