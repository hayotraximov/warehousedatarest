package uz.raximov.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import uz.raximov.demo.Entity.Currency;
import uz.raximov.demo.Messages.Delete;
import uz.raximov.demo.Service.CurrencyService;

@RestController
@RequestMapping("/currency")
public class CurrencyController {
    @Autowired
    CurrencyService currencyService;

    @GetMapping
    public Page<Currency> page(@RequestParam Integer page){
        return currencyService.page(page);
    }

    @GetMapping("/{id}")
    public Currency getById(@PathVariable Integer id){
        return currencyService.getById(id);
    }

    @DeleteMapping("{id}")
    public Delete delete(@PathVariable Integer id){
        return currencyService.delete(id);
    }

    @PostMapping
    public Currency add(@RequestBody Currency currency){
        return currencyService.add(currency);
    }

    @PutMapping("/{id}")
    public Currency edit(@PathVariable Integer id, @RequestBody Currency currency){
        return currencyService.edit(id, currency);
    }
}
