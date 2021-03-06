package com.imooc.kuckymoney.controller;
import com.imooc.kuckymoney.LimitConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.parsers.SAXParser;
import java.math.BigDecimal;

@RestController
public class HelloController {

    @Autowired
    private LimitConfig limitConfig;
    @GetMapping("/hello")
    public String say(){
        return "学习Spring"+limitConfig.getDescription();
    }
}
