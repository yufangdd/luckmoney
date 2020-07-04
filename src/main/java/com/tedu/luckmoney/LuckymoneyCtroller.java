package com.tedu.luckmoney;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
public class LuckymoneyCtroller {
        @Autowired
        private LuckymoneyRepository repository;
        @GetMapping("/luckymoneys")
        public List<Luckymoney> list(){
           return repository.findAll();
        }

        @PostMapping("/luckymoneys")
    public Luckymoney create(@RequestParam("producer") String producer,
                             @RequestParam("money")BigDecimal money){
            Luckymoney luckymoney= new Luckymoney();
            luckymoney.setConsumer(producer);
            luckymoney.setMoney(money);
            return repository.save(luckymoney);
        }

        @GetMapping("/luckymoneys/{id}")
    public Luckymoney findById(@PathVariable("id") Integer id){

            return repository.findById(id).orElse(null);
        }

        @PutMapping("/luckymoneys/{id}")
    public Luckymoney updata(@PathVariable("id") Integer id,
                             @RequestParam("consumer") String consuemer){
            Optional<Luckymoney> optional = repository.findById(id);
            if (optional.isPresent()){
                Luckymoney luckymoney = optional.get();
                luckymoney.setConsumer(consuemer);
                return repository.save(luckymoney);
            }
            return null;
        }
}
