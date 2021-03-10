package uz.raximov.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import uz.raximov.demo.Entity.Output;
import uz.raximov.demo.Messages.Delete;
import uz.raximov.demo.Service.OutputService;
import uz.raximov.demo.payload.OutputDTO;

@RestController
@RequestMapping("/output")
public class OutputController {

    @Autowired
    OutputService outputService;


    @GetMapping
    public Page<Output> page(@RequestParam Integer page){
        return outputService.page(page);
    }

    @GetMapping("/{id}")
    public Output getById(@PathVariable Integer id){
        return outputService.getById(id);
    }

    @DeleteMapping("/{id}")
    public Delete delete(@PathVariable Integer id){
        return outputService.delete(id);
    }

    @PostMapping
    public Output add(@RequestBody OutputDTO outputDTO){
        return outputService.add(outputDTO);
    }

    @PutMapping("/{id}")
    public Output edit(@PathVariable Integer id, @RequestBody OutputDTO outputDTO){
        return outputService.edit(id, outputDTO);
    }
}
