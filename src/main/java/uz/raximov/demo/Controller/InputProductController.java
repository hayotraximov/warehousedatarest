package uz.raximov.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import uz.raximov.demo.Entity.InputProduct;
import uz.raximov.demo.Service.InputProductService;
import uz.raximov.demo.Messages.Delete;
import uz.raximov.demo.payload.InputProductDto;

@RestController
@RequestMapping("/inputproduct")
public class InputProductController {

    @Autowired
    InputProductService inputProductService;

    @GetMapping
    public Page<InputProduct> page(@RequestParam Integer page){
        return inputProductService.page(page);
    }

    @GetMapping("/{id}")
    public InputProduct getById(@PathVariable Integer id){
        return inputProductService.getById(id);
    }

    @DeleteMapping("/{id}")
    public Delete delete(@PathVariable Integer id){
        return inputProductService.delete(id);
    }

    @PostMapping
    public InputProduct add(@RequestBody InputProductDto inputProductDto){
        return inputProductService.add(inputProductDto);
    }

    @PutMapping("/{id}")
    public InputProduct edit(@PathVariable Integer id, @RequestBody InputProductDto inputProductDto){
        return inputProductService.edit(id, inputProductDto);
    }
}
