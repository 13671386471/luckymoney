package com.imooc.kuckymoney.controller;

import com.imooc.kuckymoney.LuckymoneyRepository;
import com.imooc.kuckymoney.service.LuckymoneyService;
import com.imooc.kuckymoney.domain.Luckymoneytable;
import com.imooc.kuckymoney.domain.Result;
import com.imooc.kuckymoney.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class LuckymoneyController {
    public final static Logger logger = LoggerFactory.getLogger(Luckymoneytable.class);
    @Autowired
    private LuckymoneyRepository repository;

    @Autowired
    private LuckymoneyService service;
    /**
     * 获取红包列表
     */
    @GetMapping("/luckymoneys")
    public List<Luckymoneytable> list(){
        logger.info("innerrrrr");
        System.out.println("innerr");
        return repository.findAll();
    }

    /**
     *创建红包
     */
    @PostMapping("/luckymoneys")
    public Result<Luckymoneytable> create(@Valid Luckymoneytable luckymoneytable,
                                          BindingResult bindingResult){
        if(bindingResult.hasErrors()){
//            Result result = new Result();
//            result.setCode(1);
//            result.setMsg(bindingResult.getFieldError().getDefaultMessage());
//            return result;
            return ResultUtil.error(1, bindingResult.getFieldError().getDefaultMessage());
        }
        luckymoneytable.setProducer(luckymoneytable.getProducer());
        luckymoneytable.setMoney(luckymoneytable.getMoney());
//        Result result = new Result();
//        result.setCode(0);
//        result.setMsg("成功");
//        result.setData(repository.save(luckymoneytable));
//        return result;
        return ResultUtil.success(repository.save(luckymoneytable));

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


























