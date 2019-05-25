package com.imooc.kuckymoney.service;

import com.imooc.kuckymoney.LuckymoneyRepository;
import com.imooc.kuckymoney.domain.Luckymoneytable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
public class LuckymoneyService {
    @Autowired
    private LuckymoneyRepository repository;

    /**
     * 事务 指数据库事务
     *
     * 扣库存 > 创建订单必须在同一个事务里
     */
    @Transactional
    public void createTwo(){
        Luckymoneytable luckymoneytable = new Luckymoneytable();
        luckymoneytable.setProducer("liqiankun");
        luckymoneytable.setMoney(new BigDecimal("520"));
        repository.save(luckymoneytable);

        Luckymoneytable luckymoneytable2 = new Luckymoneytable();
        luckymoneytable2.setProducer("liqiankun");
        luckymoneytable2.setMoney(new BigDecimal("1314"));
        repository.save(luckymoneytable2);
    }
}

































