package com.polaris.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("test")
public class TestController {
    @RequestMapping("test")
    public String test() {
        System.out.println("11");
        return "success";
    }
}
