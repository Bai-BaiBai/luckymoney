package com.bzh.luckymoney;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

/**
 * 测试事务代码
 */
@Service
@Transactional
public class LuckymoneyService {

    @Autowired
    private LuckyMoneyRepository repository;

    public void createTwo(){
        Luckymoney luckymoney1 = new Luckymoney();
        luckymoney1.setProducer("发送者");
        luckymoney1.setMoney(new BigDecimal("100"));
        repository.save(luckymoney1);

        Luckymoney luckymoney2 = new Luckymoney();
        luckymoney2.setProducer("发送者");
        luckymoney2.setMoney(new BigDecimal("1000"));
        repository.save(luckymoney2);
    }
}
