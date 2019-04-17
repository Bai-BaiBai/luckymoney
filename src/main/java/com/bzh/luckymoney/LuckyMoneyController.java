package com.bzh.luckymoney;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
public class LuckyMoneyController {

    @Autowired
    private LuckyMoneyRepository repository;

    @Autowired
    private LuckymoneyService service;

    /**
     * 获取红包列表
     */
    @GetMapping("/luckymoneys")
    public List<Luckymoney> list(){
        return repository.findAll();
    }

    /**
     * 创建红包
     */
    @PostMapping("/luckymoney")
    public Luckymoney create(@RequestParam("producer") String producer,
                             @RequestParam("money")BigDecimal money){
        Luckymoney luckymoney = new Luckymoney();
        luckymoney.setProducer(producer);
        luckymoney.setMoney(money);
        return repository.save(luckymoney);
    }

    /**
     * 通过id查询红包
     */
    @GetMapping("luckymoney/{id}")
    public Luckymoney selectById(@PathVariable("id") Integer id){
        return repository.findById(id).orElse(null);
    }

    /**
     * 更新红包（领红包）
     */
    @PutMapping("/luckymoney/{id}")
    public Luckymoney update(@PathVariable("id") Integer id,
                             @RequestParam("consumer") String consumer){
        Optional<Luckymoney> optional = repository.findById(id);
        if(optional.isPresent()){ //有内容再更新，否则返回null
            Luckymoney luckymoney = optional.get();
            luckymoney.setId(id);
            luckymoney.setConsumer(consumer);
            return repository.save(luckymoney);
        }

        return null;
    }

    @PostMapping("/luckymoneys/two")
    public void createTwo(){
        service.createTwo();
    }
}
