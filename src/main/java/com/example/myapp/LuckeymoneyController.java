package com.example.myapp;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/money")
public class LuckeymoneyController {

    @Autowired
    private luckymoneyRepository repository;
    /**
     * Search all luckymoney
     */
    @GetMapping("/allmoney")
    public List<Luckmoney> getAllLuckymoney(){
        return repository.findAll();
    }

    /**
     * Get luckymoney by id
     */
    @GetMapping("/{id}")
    public Luckmoney getByid(@PathVariable("id") Integer id){
        return repository.findById(id).orElse(null);
    }

    /**
     * Update luckymoney by id
     */
    @PostMapping("/updatemoney")
    public Luckmoney update(@RequestParam("id") Integer id,
                            @RequestParam("receiver") String receiver){
        Optional<Luckmoney> optional = repository.findById(id);
        if (optional.isPresent()) {
            Luckmoney luckmoney = optional.get();
            luckmoney.setId(id);
            luckmoney.setReceiver(receiver);
            return repository.save(luckmoney);
        }
        return null;
    }

    /**
     * Create luckymuney
     */
    @PostMapping("/addLuckymoney")
    public Luckmoney create(@RequestParam("sender") String sender,
                            @RequestParam("money") BigDecimal money){
        Luckmoney luckmoney = new Luckmoney();
        luckmoney.setSender(sender);
        luckmoney.setMoney(money);
        return repository.save(luckmoney);
    }
}
