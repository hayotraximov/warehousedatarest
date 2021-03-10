package uz.raximov.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import uz.raximov.demo.Entity.Input;
import uz.raximov.demo.Messages.Delete;
import uz.raximov.demo.Service.InputService;
import uz.raximov.demo.payload.InputDTO;

@RestController
@RequestMapping("/input")
public class InputController {

    @Autowired
    InputService inputService;


    @GetMapping
    public Page<Input> page(@RequestParam Integer page){
        return inputService.page(page);
    }

    @GetMapping("/{id}")
    public Input getById(@PathVariable Integer id){
        return inputService.getById(id);
    }

    @DeleteMapping("/{id}")
    public Delete delete(@PathVariable Integer id){
        return inputService.delete(id);
    }

    @PostMapping
    public Input add(@RequestBody InputDTO inputDTO){
        return inputService.add(inputDTO);
    }

    @PutMapping("/{id}")
    public Input edit(@PathVariable Integer id, @RequestBody InputDTO inputDTO){
        return inputService.edit(id, inputDTO);
    }
}
