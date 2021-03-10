package uz.raximov.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import uz.raximov.demo.Entity.Supplier;
import uz.raximov.demo.Messages.Delete;
import uz.raximov.demo.Service.SupplierService;

@RestController
@RequestMapping("/supplier")
public class SupplierController {

    @Autowired
    SupplierService supplierService;

    @GetMapping
    public Page<Supplier> page(@RequestParam Integer page){
        return supplierService.page(page);
    }

    @GetMapping("/{id}")
    public Supplier getById(@PathVariable Integer id){
        return supplierService.getById(id);
    }

    @DeleteMapping("{id}")
    public Delete delete(@PathVariable Integer id){
        return supplierService.delete(id);
    }

    @PostMapping
    public Supplier add(@RequestBody Supplier supplier){
        return supplierService.add(supplier);
    }

    @PutMapping("/{id}")
    public Supplier edit(@PathVariable Integer id, @RequestBody Supplier supplier){
        return supplierService.edit(id, supplier);
    }
}
