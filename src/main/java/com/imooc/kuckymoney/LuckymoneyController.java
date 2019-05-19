package com.imooc.kuckymoney;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
public class LuckymoneyController {
    @Autowired
    private LuckymoneyRepository repository;

    @Autowired
    private LuckymoneyService service;
    /**
     * 获取红包列表
     */
    @GetMapping("/luckymoneys")
    public List<Luckymoneytable> list(){
        return repository.findAll();
    }

    /**
     *创建红包
     */
    @PostMapping("/luckymoneys")
    public Luckymoneytable create(@Valid Luckymoneytable luckymoneytable,
                                  BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            System.out.println(bindingResult.getFieldError().getDefaultMessage());
           return null;
        }
        luckymoneytable.setProducer(luckymoneytable.getProducer());
        luckymoneytable.setMoney(luckymoneytable.getMoney());
        return repository.save(luckymoneytable);

    }
    /**
     * 通过id查询红包
     */
    @GetMapping("/luckymoneys/{id}")
    public Luckymoneytable findById(@PathVariable("id") Integer id){
        return repository.findById(id).orElse(null);
    }
    /**
     * 更新红包(领红包)
     */
    @PutMapping("/luckymoneys/{id}")
    public Luckymoneytable update(@PathVariable("id") Integer id,
                                  @RequestParam("consumer") String consumer){
        Optional<Luckymoneytable> optional = repository.findById(id);
        if(optional.isPresent()){
            Luckymoneytable luckymoneytable =optional.get();
            luckymoneytable.setConsumer(consumer);
            return repository.save(luckymoneytable);
        }
        return null;
    }
    @PostMapping("/luckymoneys/two")
    public void createtwo(){
        service.createTwo();
    }
}


























