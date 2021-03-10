package uz.raximov.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import uz.raximov.demo.Entity.OutputProduct;
import uz.raximov.demo.Messages.Delete;
import uz.raximov.demo.Service.OutputProductService;
import uz.raximov.demo.payload.OutputProductDto;

@RestController
@RequestMapping("/outputproduct")
public class OutputProductController {

    @Autowired
    OutputProductService outputProductService;

    @GetMapping
    public Page<OutputProduct> page(@RequestParam Integer page){
        return outputProductService.page(page);
    }

    @GetMapping("/{id}")
    public OutputProduct getById(@PathVariable Integer id){
        return outputProductService.getById(id);
    }

    @DeleteMapping("/{id}")
    public Delete delete(@PathVariable Integer id){
        return outputProductService.delete(id);
    }

    @PostMapping
    public OutputProduct add(@RequestBody OutputProductDto outputProductDto){
        return outputProductService.add(outputProductDto);
    }

    @PutMapping("/{id}")
    public OutputProduct edit(@PathVariable Integer id, @RequestBody OutputProductDto outputProductDto){
        return outputProductService.edit(id, outputProductDto);
    }
}
