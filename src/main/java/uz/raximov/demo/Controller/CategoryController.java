package uz.raximov.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import uz.raximov.demo.Entity.Category;
import uz.raximov.demo.Messages.Delete;
import uz.raximov.demo.Service.CategoryService;
import uz.raximov.demo.payload.CategoryDTO;

@RestController
@RequestMapping("/categpry")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping
    public Page<Category> page(@RequestParam Integer page){
        return categoryService.page(page);
    }

    @GetMapping("/{id}")
    public Category getById(@PathVariable Integer id){
        return categoryService.getById(id);
    }

    @DeleteMapping("{id}")
    public Delete delete(@PathVariable Integer id){
        return categoryService.delete(id);
    }

    @PostMapping
    public Category add(@RequestBody CategoryDTO categoryDTO){
        return categoryService.add(categoryDTO);
    }

    @PutMapping("/{id}")
    public Category edit(@PathVariable Integer id, @RequestBody CategoryDTO categoryDTO){
        return categoryService.edit(id, categoryDTO);
    }
}
