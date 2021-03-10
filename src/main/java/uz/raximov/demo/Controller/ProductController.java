package uz.raximov.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import uz.raximov.demo.Entity.Product;
import uz.raximov.demo.Messages.Delete;
import uz.raximov.demo.Service.ProductService;
import uz.raximov.demo.payload.ProductDTO;

import java.io.IOException;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping
    public Page<Product> getAll(@RequestParam Integer page){
        return productService.getAll(page);
    }

    @GetMapping("/{id}")
    public Product getById(@PathVariable Integer id){
        return productService.getAllById(id);
    }

    @DeleteMapping("/{id}")
    public Delete delete(@PathVariable Integer id){
        return productService.delete(id);
    }

    @PostMapping
    public Product add(@RequestBody ProductDTO productDTO) throws IOException {
        return productService.add(productDTO);
    }

    @PutMapping("/{id}")
    public Product edit(@RequestBody ProductDTO productDTO, @PathVariable Integer id) throws IOException {
        return productService.edit(id,productDTO);
    }

}
