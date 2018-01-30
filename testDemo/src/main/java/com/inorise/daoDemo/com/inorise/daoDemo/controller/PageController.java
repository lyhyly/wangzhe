package com.inorise.daoDemo.com.inorise.daoDemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

//@Controller
public class PageController {

    @GetMapping("/page/{page}")
    public String page(@PathVariable String page){
        System.out.println("请求进来了，参数是："+page);
        return page;
    }

}
