package com.bzh.luckymoney;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    private LimitConfig limit;

    @GetMapping("/hello")
    public String say(@RequestParam(value = "id", required = false, defaultValue = "0") String id){
        return  limit.getDescription() + id;
    }

    @GetMapping("/hello/{id}")
    public String print(@PathVariable("id") String myid){
        return myid;
    }
}
