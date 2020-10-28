package com.lc.controller;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Service
public class MyController {

    @GetMapping ("/save")
    public String save(){
        System.out.println("你是猪");
        return "你好...";
    }

}
