package uz.raximov.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import uz.raximov.demo.Entity.Warehouse;
import uz.raximov.demo.Messages.Delete;
import uz.raximov.demo.Repository.WareHouseRepository;
import uz.raximov.demo.Service.WareHouseService;

import java.util.List;

@RestController
@RequestMapping("/warehouse")
public class WareHouseController {

    @Autowired
    WareHouseService wareHouseService;

    @Autowired
    WareHouseRepository wareHouseRepository;

    @GetMapping
    public Page<Warehouse> page(@RequestParam Integer page) {
        return wareHouseService.page(page);
    }


    @GetMapping("/all")
    public List<Warehouse> getAll() {
        return wareHouseRepository.findAll();
    }

    @GetMapping("/{id}")
    public Warehouse getById(@PathVariable Integer id) {
        return wareHouseService.getById(id);
    }

    @DeleteMapping("{id}")
    public Delete delete(@PathVariable Integer id) {
        return wareHouseService.delete(id);
    }

    @PostMapping
    public Warehouse add(@RequestBody Warehouse warehouse) {
        return wareHouseService.add(warehouse);
    }

    @PutMapping("/{id}")
    public Warehouse edit(@PathVariable Integer id, @RequestBody Warehouse warehouse) {
        return wareHouseService.edit(id, warehouse);
    }
}
