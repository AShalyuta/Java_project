package by.pms.controllers;

import by.pms.entity.Accounting;
import by.pms.repository.AccountingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
public class MainController {
    @Autowired
    private AccountingRepository accountingRepository;

    @GetMapping(path = "/")
    public String All(Model model) {
        Iterable<Accounting> acc = accountingRepository.findAll();
        model.addAttribute("acc", acc);
        return "home";
    }

    @GetMapping(path = "/addrecord")
    public String addrecord(Model model) {
        return "add_record";
    }

    @GetMapping(path = "/updaterecord")
    public String updaterecord(Model model) {
        return "update_record";
    }

    @GetMapping(path = "/delete/{id}")
    public String delete(Model model, @PathVariable Long id) {
        accountingRepository.deleteById(id);
        return "redirect:/";
    }

    @PostMapping(path = "/add")
    public String add(@RequestParam String name_dish,
                      @RequestParam int number_dish,
                      @RequestParam double price_dish,
                      @RequestParam double cost) {
        Accounting acc = new Accounting(name_dish, number_dish, price_dish, cost);
        accountingRepository.save(acc);
        accountingRepository.saveAll(accountingRepository.findAll());
        return "redirect:/";
    }

    @PostMapping(path = "/update")
    public String update(@RequestParam Long id,
                         @RequestParam String name_dish,
                         @RequestParam int number_dish,
                         @RequestParam double price_dish,
                         @RequestParam double cost) throws Exception{
        try{
            Optional<Accounting> e = accountingRepository.findById(id);
            e.get().setName_dish(name_dish);
            e.get().setNumber_dish(number_dish);
            e.get().setPrice_dish(price_dish);
            e.get().setCost(cost);
            accountingRepository.save(e.get());
        } catch (Exception e){
            return "redirect:/";
        }
        return "redirect:/";
    }
}
