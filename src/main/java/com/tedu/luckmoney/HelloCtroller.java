package com.tedu.luckmoney;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/hello")
public class HelloCtroller {
    @Autowired
    private LimitConfig limitConfig;
    @GetMapping("/say")
    public String say(@RequestParam(value = "id",required = false,defaultValue = "0") Integer myId) {
           return "说明："+ limitConfig.getDescription()+"id:"+myId;
    }
}
